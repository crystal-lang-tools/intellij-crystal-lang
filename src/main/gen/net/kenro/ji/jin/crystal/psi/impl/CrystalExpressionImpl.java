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

public class CrystalExpressionImpl extends ASTWrapperPsiElement implements CrystalExpression {

  public CrystalExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CrystalVisitor visitor) {
    visitor.visitExpression(this);
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
  public CrystalCallArgs getCallArgs() {
    return findChildByClass(CrystalCallArgs.class);
  }

  @Override
  @Nullable
  public CrystalCommand getCommand() {
    return findChildByClass(CrystalCommand.class);
  }

  @Override
  @Nullable
  public CrystalExpression getExpression() {
    return findChildByClass(CrystalExpression.class);
  }

  @Override
  @Nullable
  public CrystalMlhs getMlhs() {
    return findChildByClass(CrystalMlhs.class);
  }

  @Override
  @Nullable
  public CrystalMrhs getMrhs() {
    return findChildByClass(CrystalMrhs.class);
  }

}
