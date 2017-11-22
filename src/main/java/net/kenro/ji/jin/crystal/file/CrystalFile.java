package net.kenro.ji.jin.crystal.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import net.kenro.ji.jin.crystal.CrystalLanguage;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;

public class CrystalFile extends PsiFileBase {
    public CrystalFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CrystalLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CrystalFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Crystal File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }


}
