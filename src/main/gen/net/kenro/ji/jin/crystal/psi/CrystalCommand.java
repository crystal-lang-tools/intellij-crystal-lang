// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalCommand extends PsiElement {

  @NotNull
  CrystalCallArgs getCallArgs();

  @Nullable
  CrystalOperation getOperation();

  @Nullable
  CrystalPrimaries getPrimaries();

}
