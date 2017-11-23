package net.kenro.ji.jin.crystal.psi;

import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.CrystalLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CrystalElementType extends IElementType {
    public CrystalElementType(@NotNull @NonNls String debugName) {
        super(debugName, CrystalLanguage.INSTANCE);
    }
}
