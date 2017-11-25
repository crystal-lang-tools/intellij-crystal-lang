// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalStatement extends PsiElement {

  @Nullable
  CrystalBlockVariable getBlockVariable();

  @Nullable
  CrystalCall getCall();

  @Nullable
  CrystalCommand getCommand();

  @Nullable
  CrystalCompositeStatement getCompositeStatement();

  @Nullable
  CrystalExpression getExpression();

  @Nullable
  CrystalFname getFname();

  @Nullable
  CrystalLhs getLhs();

}
