package net.kenro.ji.jin.crystal.parser;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.impl.DebugUtil;
import com.intellij.testFramework.PsiTestCase;
import com.intellij.util.Processor;
import net.kenro.ji.jin.crystal.file.CrystalFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class CrystalExamplesTest extends PsiTestCase {

    private Processor<File> processor(final boolean passing) {
        return new Processor<File>() {
            @Override
            public boolean process(File file) {
                if (file.isFile()) {
                    try {
                        if (file.getName().endsWith(".cr")) {
                            testExample(file, passing);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        fail("Failed to read file " + file.getAbsolutePath());
                    }
                }
                return true;
            }
        };
    }

    public void testExamples() {
        String testDataPath = "src/test/resources/gold/parser";
        FileUtil.processFilesRecursively(new File(testDataPath + "/current"), processor(true));
//        FileUtil.processFilesRecursively(new File(testDataPath + "/passing"), processor(true));

    }

    public static String readFile(File file) throws IOException {
        String content = new String(FileUtil.loadFileText(file.getCanonicalFile()));
        assertNotNull(content);
        return content;
    }

    private void testExample(@NotNull File fileName, final boolean passing) throws Exception {
        CrystalFile file = (CrystalFile) createFile(fileName.getName(), readFile(fileName));

        String psiTree = DebugUtil.psiToString(file, false);
        File expectedFile = new File(fileName.getAbsolutePath() + ".psi");
        if (expectedFile.isFile()) {
            String expectedTree = FileUtil.loadFile(expectedFile);
            //if (passing) {
            assertEquals(fileName.getName() + " failed.", expectedTree, psiTree);
            //}
        } else {
//            assert false;  // Only manually.
            FileUtil.writeToFile(new File(fileName.getAbsolutePath() + ".psi"), psiTree);
        }

        if (passing) {
            assertEquals(fileName.getName() + " failed.", true, !psiTree.contains("PsiErrorElement"));
        } else {
            // TODO: type checker.
            // assertEquals(fileName.getName() + " failed.", true, psiTree.contains("PsiErrorElement"));
        }
    }
}

