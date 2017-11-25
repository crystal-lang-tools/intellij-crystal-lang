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

public class CrystalFunctionImpl extends ASTWrapperPsiElement implements CrystalFunction {

  public CrystalFunctionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitFunction(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CrystalArgDecl getArgDecl() {
    return findChildByClass(CrystalArgDecl.class);
  }

  @Override
  @Nullable
  public CrystalArgs getArgs() {
    return findChildByClass(CrystalArgs.class);
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
  @Nullable
  public CrystalExpression getExpression() {
    return findChildByClass(CrystalExpression.class);
  }

  @Override
  @Nullable
  public CrystalFname getFname() {
    return findChildByClass(CrystalFname.class);
  }

  @Override
  @Nullable
  public CrystalOperation getOperation() {
    return findChildByClass(CrystalOperation.class);
  }

  @Override
  @Nullable
  public CrystalPrimary getPrimary() {
    return findChildByClass(CrystalPrimary.class);
  }

  @Override
  @Nullable
  public CrystalSingleton getSingleton() {
    return findChildByClass(CrystalSingleton.class);
  }

}
