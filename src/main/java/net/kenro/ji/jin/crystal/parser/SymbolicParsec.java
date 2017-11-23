package net.kenro.ji.jin.crystal.parser;


import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class SymbolicParsec extends Parsec {
    @NotNull
    private final Parsec ref;
    @NotNull
    private final IElementType node;

    public SymbolicParsec(@NotNull Parsec ref, @NotNull IElementType node) {
        this.ref = ref;
        this.node = node;
    }

    @NotNull
    @Override
    public ParserInfo parse(@NotNull ParserContext context) {
        int startPosition = context.getPosition();
        PsiBuilder.Marker pack = context.start();
        ParserInfo info = ref.parse(context);
        if (info.success) {
            pack.done(node);
        } else {
            pack.drop();
        }
        if (startPosition == info.position) {
            info = new ParserInfo(info.position, this, info.success);
        }
        return info;
    }

    @NotNull
    @Override
    public String calcName() {
        return node.toString();
    }

    @NotNull
    @Override
    protected HashSet<String> calcExpectedName() {
        HashSet<String> result = new HashSet<String>();
        result.add(node.toString());
        return result;
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
