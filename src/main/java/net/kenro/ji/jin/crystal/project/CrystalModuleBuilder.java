package net.kenro.ji.jin.crystal.project;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.util.PathUtil;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class CrystalModuleBuilder extends ModuleBuilder {

    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        Project p = modifiableRootModel.getProject();
        File baseDir = new File(PathUtil.getParentPath(modifiableRootModel.getModule().getModuleFilePath()));
        String crystalExec = "crystal"; // TODO make this suppliable in project setup
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
        ContentEntry module = modifiableRootModel.addContentEntry(baseDir.getAbsolutePath());
        module.addSourceFolder(new File(baseDir, "src").getAbsolutePath(), false);
        module.addSourceFolder(new File(baseDir, "spec").getAbsolutePath(), true);
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

}
