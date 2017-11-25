// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalPrimary extends PsiElement {

  @Nullable
  CrystalCompositeStatement getCompositeStatement();

  @NotNull
  List<CrystalExpression> getExpressionList();

  @Nullable
  CrystalLiteral getLiteral();

  @Nullable
  CrystalVariable getVariable();

}
