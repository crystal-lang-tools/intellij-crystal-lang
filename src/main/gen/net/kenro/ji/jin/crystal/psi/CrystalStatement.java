// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CrystalStatement extends PsiElement {

  @NotNull
  List<CrystalAssoc> getAssocList();

  @NotNull
  List<CrystalAssocArray> getAssocArrayList();

  @Nullable
  CrystalBlockVariable getBlockVariable();

  @Nullable
  CrystalCall getCall();

  @NotNull
  List<CrystalExpression> getExpressionList();

  @Nullable
  CrystalFname getFname();

  @NotNull
  List<CrystalFunction> getFunctionList();

  @NotNull
  List<CrystalLhs> getLhsList();

  @NotNull
  List<CrystalLiteral> getLiteralList();

  @NotNull
  List<CrystalOpAsgn> getOpAsgnList();

  @NotNull
  List<CrystalStatement> getStatementList();

  @NotNull
  List<CrystalTuple> getTupleList();

  @NotNull
  List<CrystalVariable> getVariableList();

  @NotNull
  List<CrystalWhenArgs> getWhenArgsList();

}
