package net.kenro.ji.jin.crystal.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Combinators {
    @NotNull
    private static HashSet<String> strings(String... names) {
        HashSet<String> result = new LinkedHashSet<String>();
        for (String name : names) {
            result.add(name);
        }
        return result;
    }

    @NotNull
    private static HashSet<String> strings(HashSet<String>... names) {
        HashSet<String> result = new LinkedHashSet<String>();
        for (HashSet<String> name : names) {
            result.addAll(name);
        }
        return result;
    }

    @NotNull
    static Parsec token(@NotNull final IElementType tokenType) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                if (context.eat(tokenType)) {
                    return new ParserInfo(context.getPosition(), this, true);
                }
                return new ParserInfo(context.getPosition(), this, false);
            }

            @NotNull
            @Override
            public String calcName() {
                return tokenType.toString();
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return strings(tokenType.toString());
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return type == tokenType;
            }

            @Override
            public boolean calcCanBeEmpty() {
                return false;
            }
        };
    }

    @NotNull
    static Parsec token(@NotNull final String token) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                if (context.text().equals(token)) {
                    context.advance();
                    return new ParserInfo(context.getPosition(), this, true);
                }
                return new ParserInfo(context.getPosition(), this, false);
            }

            @NotNull
            @Override
            public String calcName() {
                return "\"" + token + "\"";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return strings("\"" + token + "\"");
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return true;
            }

            @Override
            public boolean calcCanBeEmpty() {
                return false;
            }
        };
    }

    @NotNull
    static Parsec lexeme(@NotNull final String text) {
        return lexeme(token(text));
    }

    @NotNull
    static Parsec lexeme(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                ParserInfo info = p.parse(context);
                if (info.success) {
                    context.whiteSpace();
                }
                return info;
            }

            @NotNull
            @Override
            public String calcName() {
                return p.getName() + " ws*";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    static Parsec lexeme(@NotNull final IElementType type) {
        return lexeme(token(type));
    }

    @NotNull
    static Parsec reserved(@NotNull final Parsec p) {
        return attempt(lexeme(p));
    }

    static Parsec reserved(@NotNull final String content) {
        return attempt(lexeme(content));
    }

    @NotNull
    static Parsec reserved(@NotNull final IElementType tokenType) {
        return attempt(lexeme(token(tokenType)));
    }

    @NotNull
    static Parsec keyword(@NotNull final IElementType tokenType, @NotNull final String content) {
        return reserved(content).as(tokenType);
    }

    @NotNull
    static Parsec seq(@NotNull final Parsec p1, @NotNull final Parsec p2) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                ParserInfo info = p1.parse(context);
                if (info.success) {
                    ParserInfo info2 = p2.parse(context);
                    return ParserInfo.merge(info, info2, info2.success);
                }
                return info;
            }

            @NotNull
            @Override
            public String calcName() {
                String name1 = p1.getName();
                String name2 = p2.getName();
                return name1 + " " + name2;
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                if (p1.canBeEmpty()) { return strings(p1.getExpectedName(), p2.getExpectedName()); }
                return p1.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                if (p1.canBeEmpty()) { return p1.canStartWith(type) || p2.canStartWith(type); }
                return p1.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p1.canBeEmpty() && p2.canBeEmpty();
            }
        };
    }

    @NotNull
    static Parsec choice(@NotNull final Parsec head, @NotNull final Parsec... tail) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                int position = context.getPosition();
                ParserInfo info;
                if (head.canBeEmpty() || head.canStartWith(context.peek())) {
                    info = head.parse(context);
                } else {
                    info = new ParserInfo(position, head, false);
                }

                if (context.getPosition() > position || info.success) {
                    return info;
                }
                for (Parsec p2 : tail) {
                    ParserInfo info2;
                    if (p2.canBeEmpty() || p2.canStartWith(context.peek())) {
                        info2 = p2.parse(context);
                    } else {
                        info2 = new ParserInfo(position, p2, false);
                    }
                    info = ParserInfo.merge(info, info2, info2.success);

                    if (context.getPosition() > position || info.success) {
                        return info;
                    }
                }
                return info;
            }

            @NotNull
            @Override
            public String calcName() {
                // TODO: avoid unnecessary parentheses.
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(head.getName()).append(")");
                for (Parsec parsec : tail) {
                    sb.append(" | (").append(parsec.getName()).append(")");
                }
                return sb.toString();
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                HashSet<String> result = new LinkedHashSet<String>();
                result.addAll(head.getExpectedName());
                for (Parsec parsec : tail) {
                    result.addAll(parsec.getExpectedName());
                }
                return result;
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                if (head.canStartWith(type)) { return true; }
                for (Parsec parsec : tail) {
                    if (parsec.canStartWith(type)) { return true; }
                }
                return false;
            }

            @Override
            public boolean calcCanBeEmpty() {
                if (!head.canBeEmpty()) { return false; }
                for (Parsec parsec : tail) {
                    if (!parsec.canBeEmpty()) { return false; }
                }
                return true;
            }
        };
    }

    @NotNull
    static Parsec many(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                ParserInfo info = new ParserInfo(context.getPosition(), p, true);
                while (!context.eof()) {
                    int position = context.getPosition();
                    info = p.parse(context);
                    if (info.success) {
                        if (position == context.getPosition()) {
                            // TODO: this should not be allowed.
                            return ParserInfo.merge(info, new ParserInfo(context.getPosition(), info, false), false);
                        }
                    } else if (position == context.getPosition()) {
                        return ParserInfo.merge(info, new ParserInfo(context.getPosition(), info, true), true);
                    } else {
                        return info;
                    }
                }
                return info;
            }

            @NotNull
            @Override
            public String calcName() {
                return "(" + p.getName() + ")*";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return true;
            }
        };
    }

    @NotNull
    static Parsec many1(@NotNull final Parsec p) {
        return p.then(many(p));
    }

    @NotNull
    static Parsec optional(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                try {
                    context.enterOptional();
                    int position = context.getPosition();
                    ParserInfo info1 = p.parse(context);
                    if (info1.success) {
                        return info1;
                    }
                    return new ParserInfo(info1.position, info1, context.getPosition() == position);
                } finally {
                    context.exitOptional();
                }
            }

            @NotNull
            @Override
            public String calcName() {
                // TODO: avoid unnecessary parentheses.
                return "(" + p.getName() + ")?";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return true;
            }
        };
    }

    @NotNull
    static Parsec attempt(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                if (!p.canBeEmpty() && !p.canStartWith(context.peek())) {
                    return new ParserInfo(context.getPosition(), p, false);
                }
                int start = context.getPosition();
                PsiBuilder.Marker pack = context.start();
                boolean inAttempt = context.isInAttempt();
                context.setInAttempt(true);
                ParserInfo info = p.parse(context);
                context.setInAttempt(inAttempt);
                if (info.success) {
                    pack.drop();
                    return info;
                }
                pack.rollbackTo();
                return new ParserInfo(start, info, false);
            }

            @NotNull
            @Override
            public String calcName() {
                // TODO: avoid unnecessary parentheses.
                return "try(" + p.getName() + ")";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    public static Parsec parens(@NotNull Parsec p) {
        p = until(p, CrystalTokens.RIGHT_PAREN);
        return lexeme(CrystalTokens.LEFT_PAREN).then(indented(p)).then(indented(lexeme(CrystalTokens.RIGHT_PAREN)));
    }

    @NotNull
    public static Parsec squares(@NotNull Parsec p) {
        p = until(p, CrystalTokens.RIGHT_PAREN);
        return lexeme(CrystalTokens.LEFT_BRACKET).then(indented(p)).then(indented(lexeme(CrystalTokens.RIGHT_BRACKET)));
    }

    @NotNull
    public static Parsec braces(@NotNull Parsec p) {
        p = until(p, CrystalTokens.RIGHT_PAREN);
        return lexeme(CrystalTokens.LEFT_BRACE).then(indented(p)).then(indented(lexeme(CrystalTokens.RIGHT_BRACE)));
    }

    @NotNull
    public static Parsec indented(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                if (context.getColumn() > context.getIndentationLevel()) {
                    return p.parse(context);
                }
                return new ParserInfo(context.getPosition(), this, false);
            }

            @NotNull
            @Override
            public String calcName() {
                return "indented (" + p.getName() + ")";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    public static Parsec same(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                if (context.getColumn() == context.getIndentationLevel()) {
                    return p.parse(context);
                }
                return new ParserInfo(context.getPosition(), this, false);
            }

            @NotNull
            @Override
            public String calcName() {
                return "not indented (" + p.getName() + ")";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    public static Parsec mark(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                context.pushIndentationLevel();
                try {
                    return p.parse(context);
                } finally {
                    context.popIndentationLevel();
                }
            }

            @NotNull
            @Override
            public String calcName() {
                return "not indented (" + p.getName() + ")";
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    static Parsec sepBy1(@NotNull Parsec p, @NotNull final IElementType sep) {
        p = until(p, sep);
        return p.then(attempt(many(lexeme(sep).then(p))));
    }

    @NotNull
    static Parsec commaSep1(@NotNull final Parsec p) {
        return sepBy1(p, CrystalTokens.COMMA);
    }

    @NotNull
    static Parsec sepBy(@NotNull final Parsec p, @NotNull final Parsec sep) {
        return optional(p.then(many(sep.then(p))));
    }

    @NotNull
    static Parsec commaSep(@NotNull final Parsec p) {
        return sepBy(p, lexeme(CrystalTokens.COMMA));
    }

    @NotNull
    static ParsecRef ref() {
        return new ParsecRef();
    }

    @NotNull
    static Parsec until(@NotNull final Parsec p, @NotNull final IElementType token) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                int startPosition = context.getPosition();
                boolean inAttempt = context.isInAttempt();
                context.addUntilToken(token);
                context.setInAttempt(false);
                ParserInfo info = p.parse(context);
                context.setInAttempt(inAttempt);
                if (info.success) {
                    return info;
                }
                PsiBuilder.Marker start = context.start();
                while (!context.eof()) {
                    if (context.isUntilToken(context.peek())) {
                        break;
                    }
                    context.advance();
                }
                context.removeUntilToken(token);
                if (!context.isInOptional() || startPosition != context.getPosition()) {
                    start.error(info.toString());
                } else {
                    start.drop();
                }
                return new ParserInfo(info.position, info, !inAttempt);
            }

            @NotNull
            @Override
            public String calcName() {
                return p.getName();
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    @NotNull
    static Parsec untilSame(@NotNull final Parsec p) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                int position = context.getPosition();
                ParserInfo info = p.parse(context);
                if (info.success || position == context.getPosition()) {
                    return info;
                }
                context.whiteSpace();
                if (context.getColumn() <= context.getLastIndentationLevel()) {
                    return info;
                }
                PsiBuilder.Marker start = context.start();
                while (!context.eof()) {
                    if (context.getColumn() == context.getIndentationLevel()) {
                        break;
                    }
                    context.advance();
                }
                start.error(info.toString());
                return new ParserInfo(context.getPosition(), info, true);
            }

            @NotNull
            @Override
            public String calcName() {
                return p.getName();
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }

    interface Predicate<T> {
        boolean test(T content);
    }

    @NotNull
    static Parsec guard(@NotNull final Parsec p,
                        final Predicate<String> predicate,
                        @NotNull final String errorMessage) {
        return new Parsec() {
            @NotNull
            @Override
            public ParserInfo parse(@NotNull ParserContext context) {
                PsiBuilder.Marker pack = context.start();
                int start = context.getPosition();
                ParserInfo info1 = p.parse(context);
                if (info1.success) {
                    int end = context.getPosition();
                    String text = context.getText(start, end);
                    if (!predicate.test(text)) {
                        return new ParserInfo(context.getPosition(), errorMessage, false);
                    }
                    pack.drop();
                    return info1;
                }
                pack.rollbackTo();
                return info1;
            }

            @NotNull
            @Override
            public String calcName() {
                return p.getName();
            }

            @NotNull
            @Override
            protected HashSet<String> calcExpectedName() {
                return p.getExpectedName();
            }

            @Override
            public boolean canStartWith(@NotNull IElementType type) {
                return p.canStartWith(type);
            }

            @Override
            public boolean calcCanBeEmpty() {
                return p.canBeEmpty();
            }
        };
    }
}
