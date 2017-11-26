// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalPrimary extends PsiElement {

  @Nullable
  CrystalArg getArg();

  @Nullable
  CrystalArgs getArgs();

  @Nullable
  CrystalAssocs getAssocs();

  @Nullable
  CrystalBlockVariable getBlockVariable();

  @Nullable
  CrystalCallArgs getCallArgs();

  @Nullable
  CrystalCompositeStatement getCompositeStatement();

  @NotNull
  List<CrystalExpression> getExpressionList();

  @Nullable
  CrystalFunction getFunction();

  @Nullable
  CrystalLiteral getLiteral();

  @Nullable
  CrystalOperation getOperation();

  @Nullable
  CrystalVariable getVariable();

  @NotNull
  List<CrystalWhenArgs> getWhenArgsList();

}
