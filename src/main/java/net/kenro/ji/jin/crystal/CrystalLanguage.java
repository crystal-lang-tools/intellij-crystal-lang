package net.kenro.ji.jin.crystal;

import com.intellij.lang.Language;

public class CrystalLanguage extends Language {
    public static final CrystalLanguage INSTANCE = new CrystalLanguage();

    private CrystalLanguage() {
        super("Crystal", "text/crystal", "text/x-crystal", "application/x-crystal");
    }
}
