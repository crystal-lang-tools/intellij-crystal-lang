package net.kenro.ji.jin.crystal.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import net.kenro.ji.jin.crystal.icons.CrystalIcons;
import net.kenro.ji.jin.crystal.CrystalLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class CrystalFileType extends LanguageFileType {

    public static final CrystalFileType INSTANCE = new CrystalFileType();
    public static final String DEFAULT_EXTENSION = "cr";

    private CrystalFileType() {
        super(CrystalLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crystal file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Crystal file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CrystalIcons.FILE;
    }
}
