package net.kenro.ji.jin.crystal.project;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.ide.util.projectWizard.WizardInputField;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.util.PathUtil;
import org.codehaus.plexus.util.FileUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CrystalModuleBuilder extends ModuleBuilder {

    private String crystalPath = "/usr/bin/crystal";

    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        Project p = modifiableRootModel.getProject();
        File baseDir = new File(PathUtil.getParentPath(modifiableRootModel.getModule().getModuleFilePath()));
        String crystalExec = crystalPath;
        File workDir;
        try {
            File tempDir = Files.createTempDirectory(p.getName() + Long.toString(System.nanoTime())).toFile();
            workDir = new File(tempDir, p.getName());
        } catch (IOException e) {
            workDir = new File(p.getBaseDir().getParent().getPath(), p.getName() + Long.toString(System.nanoTime()));
        }
        ProcessBuilder pb = new ProcessBuilder(crystalExec, "init", "app", modifiableRootModel.getModule().getName(), workDir.getAbsolutePath());
        pb.inheritIO();
        try {
            pb.start().waitFor();
            moveDirectory(workDir, baseDir);
            workDir.delete();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        ContentEntry module = modifiableRootModel.addContentEntry("file://" + baseDir.getAbsolutePath());
        module.addSourceFolder("file://" + new File(baseDir, "src").getAbsolutePath(), false);
        module.addSourceFolder("file://" + new File(baseDir, "spec").getAbsolutePath(), true);
    }

    @Override
    public ModuleType getModuleType() {
        return new CrystalModuleType();
    }

    public void moveDirectory(File dir1, File dir2) {
        Arrays.stream(dir1.listFiles()).forEach(f -> {
            if(f.isDirectory()) {
                File newDir = new File(dir2, f.getName());
                newDir.mkdirs();
                moveDirectory(f, newDir);
            } else {
                try {
                    Files.move(f.toPath(), new File(dir2, f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected List<WizardInputField> getAdditionalFields() {
        return Collections.singletonList(new WizardInputField("crystal_path", "/usr/bin/crystal") {

            private JTextField jtf = new JTextField(getDefaultValue());

            @Override
            public String getLabel() {
                return "Crystal Path";
            }

            @Override
            public JComponent getComponent() {
                return jtf;
            }

            @Override
            public String getValue() {
                return jtf.getText();
            }

        });
    }

    public String getCrystalPath() {
        return crystalPath;
    }

    public void setCrystalPath(String crystalPath) {
        this.crystalPath = crystalPath;
    }

}
