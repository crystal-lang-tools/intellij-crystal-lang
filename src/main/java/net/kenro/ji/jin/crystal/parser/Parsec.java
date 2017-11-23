package net.kenro.ji.jin.crystal.parser;


import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

public abstract class Parsec {
    @Nullable
    private String name;
    @Nullable
    private HashSet<String> expectedName;
    @Nullable
    private Boolean canBeEmpty;

    @NotNull
    public abstract ParserInfo parse(@NotNull ParserContext context);

    @NotNull
    public final String getName() {
        if (name == null) {
            name = calcName();
        }
        return name;
    }

    @NotNull
    protected abstract String calcName();

    @NotNull
    public final HashSet<String> getExpectedName() {
        if (expectedName == null) {
            expectedName = calcExpectedName();
        }
        return expectedName;
    }

    @NotNull
    protected abstract HashSet<String> calcExpectedName();

    @NotNull
    public Parsec then(@NotNull Parsec next) {
        return Combinators.seq(this, next);
    }

    @NotNull
    public Parsec lexeme(@NotNull IElementType type) {
        return then(Combinators.lexeme(Combinators.token(type)));
    }

    @NotNull
    public Parsec or(@NotNull Parsec next) {
        return Combinators.choice(this, next);
    }

    @NotNull
    public SymbolicParsec as(@NotNull final IElementType node) {
        return new SymbolicParsec(this, node);
    }

    public abstract boolean canStartWith(@NotNull IElementType type);

    public final boolean canBeEmpty() {
        if (canBeEmpty == null) {
            canBeEmpty = calcCanBeEmpty();
        }
        return canBeEmpty;
    }

    protected abstract boolean calcCanBeEmpty();
}