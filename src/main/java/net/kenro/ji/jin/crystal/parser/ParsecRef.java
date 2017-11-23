package net.kenro.ji.jin.crystal.parser;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public final class ParsecRef extends Parsec {
    private Parsec ref;

    public void setRef(@NotNull Parsec ref) {
        this.ref = ref;
    }

    @NotNull
    @Override
    public ParserInfo parse(@NotNull ParserContext context) {
        return ref.parse(context);
    }

    @NotNull
    @Override
    public String calcName() {
        return ref.getName();
    }

    @NotNull
    @Override
    protected HashSet<String> calcExpectedName() {
        return ref.getExpectedName();
    }

    @Override
    public boolean canStartWith(@NotNull IElementType type) {
        return ref.canStartWith(type);
    }

    @Override
    public boolean calcCanBeEmpty() {
        return ref.canBeEmpty();
    }
}

