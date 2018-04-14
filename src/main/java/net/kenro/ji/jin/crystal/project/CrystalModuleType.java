package net.kenro.ji.jin.crystal.project;

import com.intellij.openapi.module.ModuleType;
import net.kenro.ji.jin.crystal.icons.CrystalIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CrystalModuleType extends ModuleType<CrystalModuleBuilder> {

    public CrystalModuleType() {
        super("CRYSTAL_MODULE");
    }

    @NotNull
    @Override
    public CrystalModuleBuilder createModuleBuilder() {
        return new CrystalModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "Crystal Module";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Crystal module";
    }

    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return CrystalIcons.PROJECT;
    }

}
