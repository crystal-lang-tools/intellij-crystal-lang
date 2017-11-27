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

public class CrystalWhenArgsImpl extends ASTWrapperPsiElement implements CrystalWhenArgs {

  public CrystalWhenArgsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitWhenArgs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CrystalAssoc> getAssocList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalAssoc.class);
  }

  @Override
  @NotNull
  public List<CrystalAssocArray> getAssocArrayList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalAssocArray.class);
  }

  @Override
  @NotNull
  public List<CrystalBlockVariable> getBlockVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalBlockVariable.class);
  }

  @Override
  @NotNull
  public List<CrystalExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalExpression.class);
  }

  @Override
  @NotNull
  public List<CrystalFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalFunction.class);
  }

  @Override
  @NotNull
  public List<CrystalLhs> getLhsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalLhs.class);
  }

  @Override
  @NotNull
  public List<CrystalLiteral> getLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalLiteral.class);
  }

  @Override
  @NotNull
  public List<CrystalOpAsgn> getOpAsgnList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalOpAsgn.class);
  }

  @Override
  @NotNull
  public List<CrystalStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalStatement.class);
  }

  @Override
  @NotNull
  public List<CrystalTuple> getTupleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalTuple.class);
  }

  @Override
  @NotNull
  public List<CrystalVariable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalVariable.class);
  }

  @Override
  @NotNull
  public List<CrystalWhenArgs> getWhenArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CrystalWhenArgs.class);
  }

}
