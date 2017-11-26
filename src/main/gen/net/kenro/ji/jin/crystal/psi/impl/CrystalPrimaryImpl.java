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

public class CrystalPrimaryImpl extends ASTWrapperPsiElement implements CrystalPrimary {

  public CrystalPrimaryImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitPrimary(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CrystalArg getArg() {
    return findChildByClass(CrystalArg.class);
  }

  @Override
  @Nullable
  public CrystalArgs getArgs() {
    return findChildByClass(CrystalArgs.class);
  }

  @Override
  @Nullable
  public CrystalAssocs getAssocs() {
    return findChildByClass(CrystalAssocs.class);
  }

  @Override
  @Nullable
  public CrystalBlockVariable getBlockVariable() {
    return findChildByClass(CrystalBlockVariable.class);
  }

  @Override
  @Nullable
  public CrystalCallArgs getCallArgs() {
    return findChildByClass(CrystalCallArgs.class);
  }

  @Override
  @Nullable
  public CrystalCompositeStatement getCompositeStatement() {
    return findChildByClass(CrystalCompositeStatement.class);
  }

  @Override
  @NotNull
  public List<CrystalExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalExpression.class);
  }

  @Override
  @Nullable
  public CrystalFunction getFunction() {
    return findChildByClass(CrystalFunction.class);
  }

  @Override
  @Nullable
  public CrystalLiteral getLiteral() {
    return findChildByClass(CrystalLiteral.class);
  }

  @Override
  @Nullable
  public CrystalOperation getOperation() {
    return findChildByClass(CrystalOperation.class);
  }

  @Override
  @Nullable
  public CrystalVariable getVariable() {
    return findChildByClass(CrystalVariable.class);
  }

  @Override
  @NotNull
  public List<CrystalWhenArgs> getWhenArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalWhenArgs.class);
  }

}
