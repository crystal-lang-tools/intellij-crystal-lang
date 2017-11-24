package net.kenro.ji.jin.crystal.features;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.psi.CrystalElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalPairedBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(CrystalElementTypes.LEFT_BRACE, CrystalElementTypes.RIGHT_BRACE, true),
            new BracePair(CrystalElementTypes.LEFT_BRACKET, CrystalElementTypes.RIGHT_BRACKET, true),
            new BracePair(CrystalElementTypes.LEFT_PAREN, CrystalElementTypes.RIGHT_PAREN, false)
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return contextType == null
                || contextType == TokenType.WHITE_SPACE;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}

