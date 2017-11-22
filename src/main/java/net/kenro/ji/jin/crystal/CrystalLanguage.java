package net.kenro.ji.jin.crystal;

import com.intellij.lang.Language;

public class PSLanguage extends Language {
    public static final PSLanguage INSTANCE = new PSLanguage();

    private PSLanguage() {
        super("Purescript", "text/purescript", "text/x-purescript", "application/x-purescript");
    }
}
