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

public class CrystalStatementImpl extends ASTWrapperPsiElement implements CrystalStatement {

  public CrystalStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CrystalVisitor) accept((CrystalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CrystalBlockVariable getBlockVariable() {
    return findChildByClass(CrystalBlockVariable.class);
  }

  @Override
  @Nullable
  public CrystalCall getCall() {
    return findChildByClass(CrystalCall.class);
  }

  @Override
  @Nullable
  public CrystalCommand getCommand() {
    return findChildByClass(CrystalCommand.class);
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
  public CrystalLhs getLhs() {
    return findChildByClass(CrystalLhs.class);
  }

}
