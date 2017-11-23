package net.kenro.ji.jin.crystal.psi.cst;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.psi.CrystalElements;
import org.jetbrains.annotations.NotNull;

public class CrystalASTWrapperElement extends ASTWrapperPsiElement implements PsiLanguageInjectionHost {
    public CrystalASTWrapperElement(ASTNode astNode) {
        super(astNode);
    }

    public boolean isString() {
        final IElementType type = getNode().getElementType();
        return type.equals(CrystalElements.StringLiteral);
    }

    public boolean isBlockString() {
        return getStringText().startsWith("\"\"\"");
    }

    public boolean isMultilineString() {
        return getStringText().indexOf('\n') != -1;
    }

    /**
     * Returns the text of a string element, including its quotes.
     */
    @NotNull
    public String getStringText() {
        return isString() ? getNode().getFirstChildNode().getText() : "";
    }

    @Override
    public boolean isValidHost() {
        // Only supports block-strings or single-line strings.
        return isString() && (isBlockString() || !isMultilineString());
    }

    @Override
    public CrystalASTWrapperElement updateText(@NotNull String s) {
        final ASTNode valueNode = getNode().getFirstChildNode();
        assert valueNode instanceof LeafElement;
        ((LeafElement)valueNode).replaceWithText(s);
        return this;
    }

    @NotNull
    @Override
    public CrystalStringLiteralEscaper createLiteralTextEscaper() {
        return new CrystalStringLiteralEscaper(this);
    }
}
