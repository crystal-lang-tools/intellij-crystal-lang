// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.kenro.ji.jin.crystal.psi.CrystalElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.kenro.ji.jin.crystal.psi.*;

public class CrystalAssocArrayImpl extends ASTWrapperPsiElement implements CrystalAssocArray {

  public CrystalAssocArrayImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitAssocArray(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CrystalAssoc getAssoc() {
    return findNotNullChildByClass(CrystalAssoc.class);
  }

}
