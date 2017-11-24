package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.FlexAdapter;

public class CrystalHighlightLexer extends FlexAdapter {
    public CrystalHighlightLexer() {
        super(new net.kenro.ji.jin.crystal.lexer._CrystalLexer(null));
    }
}


