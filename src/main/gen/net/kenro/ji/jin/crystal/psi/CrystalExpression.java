// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalExpression extends PsiElement {

  @Nullable
  CrystalArg getArg();

  @Nullable
  CrystalCallArgs getCallArgs();

  @Nullable
  CrystalCommand getCommand();

  @Nullable
  CrystalExpression getExpression();

  @Nullable
  CrystalMlhs getMlhs();

  @Nullable
  CrystalMrhs getMrhs();

}
