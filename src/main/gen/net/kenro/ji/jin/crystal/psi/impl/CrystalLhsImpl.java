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

public class CrystalLhsImpl extends ASTWrapperPsiElement implements CrystalLhs {

  public CrystalLhsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitLhs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CrystalArgs getArgs() {
    return findChildByClass(CrystalArgs.class);
  }

  @Override
  @Nullable
  public CrystalPrimary getPrimary() {
    return findChildByClass(CrystalPrimary.class);
  }

  @Override
  @Nullable
  public CrystalVariable getVariable() {
    return findChildByClass(CrystalVariable.class);
  }

}
