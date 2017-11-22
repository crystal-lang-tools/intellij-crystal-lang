package net.kenro.ji.jin.crystal.file;

import com.intellij.psi.tree.IStubFileElementType;
import net.kenro.ji.jin.crystal.PSLanguage;

public class PSFileStubType extends IStubFileElementType {
    public static final PSFileStubType INSTANCE = new PSFileStubType();

    private PSFileStubType() {
        super(PSLanguage.INSTANCE);
    }
}

