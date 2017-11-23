package net.kenro.ji.jin.crystal.psi.cst;

import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class CrystalStringManipulator extends AbstractElementManipulator<CrystalASTWrapperElement> {
    @Override
    public CrystalASTWrapperElement handleContentChange(@NotNull CrystalASTWrapperElement psi, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        final String oldText = psi.getText();
        final String newText = oldText.substring(0, range.getStartOffset()) + newContent + oldText.substring(range.getEndOffset());
        return psi.updateText(newText);
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull CrystalASTWrapperElement element) {
        return pairToTextRange(element.isBlockString() ? getRangeForBlockString(element) : getRangeForString(element));
    }

    private static Pair<Integer, Integer> getRangeForBlockString(@NotNull CrystalASTWrapperElement element) {
        final String text = element.getStringText();
        final int start = text.indexOf("\"\"\"") + 3;
        final int end = text.lastIndexOf("\"\"\"") - start;
        return new Pair<Integer, Integer>(start, end);
    }

    private static Pair<Integer, Integer> getRangeForString(@NotNull CrystalASTWrapperElement element) {
        final String text = element.getStringText();
        final int start = text.indexOf("\"") + 1;
        final int end = text.lastIndexOf("\"") - start;
        return new Pair<Integer, Integer>(start, end);
    }

    private static TextRange pairToTextRange(Pair<Integer, Integer> pair) {
        final int start = Math.max(pair.first, 0);
        final int end = Math.max(pair.second, start);
        return TextRange.from(start, end);
    }
}

