package net.kenro.ji.jin.crystal.features;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalPairedBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(CrystalTokens.LEFT_BRACE, CrystalTokens.RIGHT_BRACE, true),
            new BracePair(CrystalTokens.LEFT_BRACKET, CrystalTokens.RIGHT_BRACKET, true),
            new BracePair(CrystalTokens.LEFT_PAREN, CrystalTokens.RIGHT_PAREN, false)
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return contextType == null
                || contextType == CrystalTokens.WS;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}

