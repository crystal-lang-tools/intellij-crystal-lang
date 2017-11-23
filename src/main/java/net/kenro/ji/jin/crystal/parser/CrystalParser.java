package net.kenro.ji.jin.crystal.parser;


import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static net.kenro.ji.jin.crystal.parser.Combinators.attempt;
import static net.kenro.ji.jin.crystal.parser.Combinators.lexeme;
import static net.kenro.ji.jin.crystal.parser.Combinators.optional;
import static net.kenro.ji.jin.crystal.parser.Combinators.reserved;
import static net.kenro.ji.jin.crystal.parser.Combinators.token;
import static net.kenro.ji.jin.crystal.parser.Combinators.Predicate;
import static net.kenro.ji.jin.crystal.parser.Combinators.attempt;
import static net.kenro.ji.jin.crystal.parser.Combinators.braces;
import static net.kenro.ji.jin.crystal.parser.Combinators.choice;
import static net.kenro.ji.jin.crystal.parser.Combinators.commaSep;
import static net.kenro.ji.jin.crystal.parser.Combinators.commaSep1;
import static net.kenro.ji.jin.crystal.parser.Combinators.guard;
import static net.kenro.ji.jin.crystal.parser.Combinators.indented;
import static net.kenro.ji.jin.crystal.parser.Combinators.keyword;
import static net.kenro.ji.jin.crystal.parser.Combinators.lexeme;
import static net.kenro.ji.jin.crystal.parser.Combinators.many;
import static net.kenro.ji.jin.crystal.parser.Combinators.many1;
import static net.kenro.ji.jin.crystal.parser.Combinators.mark;
import static net.kenro.ji.jin.crystal.parser.Combinators.optional;
import static net.kenro.ji.jin.crystal.parser.Combinators.parens;
import static net.kenro.ji.jin.crystal.parser.Combinators.ref;
import static net.kenro.ji.jin.crystal.parser.Combinators.reserved;
import static net.kenro.ji.jin.crystal.parser.Combinators.same;
import static net.kenro.ji.jin.crystal.parser.Combinators.sepBy1;
import static net.kenro.ji.jin.crystal.parser.Combinators.squares;
import static net.kenro.ji.jin.crystal.parser.Combinators.token;
import static net.kenro.ji.jin.crystal.parser.Combinators.untilSame;

import net.kenro.ji.jin.crystal.psi.CrystalElements;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;

import org.jetbrains.annotations.NotNull;

public class CrystalParser implements PsiParser, CrystalTokens, CrystalElements {
    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        // builder.setDebugMode(true);
        ParserContext context = new ParserContext(builder);
        PsiBuilder.Marker mark = context.start();
        context.whiteSpace();
        // Creating a new instance here allows hot swapping while debugging.
        ParserInfo info = new PureParsecParser().program.parse(context);
        IElementType nextType = null;
        if (!context.eof()) {
            PsiBuilder.Marker errorMarker = null;
            while (!context.eof()) {
                if (context.getPosition() >= info.position && errorMarker == null) {
                    errorMarker = context.start();
                    nextType = builder.getTokenType();
                }
                context.advance();
            }
            if (errorMarker != null) {
                if (nextType != null)
                    errorMarker.error("Unexpected " + nextType.toString() + ". " + info.toString());
                else
                    errorMarker.error(info.toString());
            }
        }
        mark.done(root);
        return builder.getTreeBuilt();
    }

    public final static class PureParsecParser {
        private PureParsecParser() {
        }

        // Helpers
        private final Parsec properName = lexeme(PROPER_NAME).as(ProperName);


        // 2 Module
        private final Parsec parseModule
                = optional(reserved(MODULE)
                .then((properName).as(programModule))
                .then(reserved(END))
                .as(Module));


        // 1. ENTRY POINT
        private final Parsec program = indentedList(parseModule).as(Program);


        @NotNull
        private Parsec indentedList(@NotNull final Parsec p) {
            return mark(many(untilSame(same(p))));
        }

    }
}
