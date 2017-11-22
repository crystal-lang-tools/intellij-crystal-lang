package net.kenro.ji.jin.crystal.file;

import com.intellij.psi.tree.IStubFileElementType;
import net.kenro.ji.jin.crystal.CrystalLanguage;

public class CrystalFileStubType extends IStubFileElementType {
    public static final CrystalFileStubType INSTANCE = new CrystalFileStubType();

    private CrystalFileStubType() {
        super(CrystalLanguage.INSTANCE);
    }
}

