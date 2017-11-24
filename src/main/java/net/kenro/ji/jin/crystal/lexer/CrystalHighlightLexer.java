package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.FlexAdapter;
import net.kenro.ji.jin.crystal.parser._CrystalLexer;

public class CrystalHighlightLexer extends FlexAdapter {
    public CrystalHighlightLexer() {
        super(new _CrystalLexer(null));
    }
}


