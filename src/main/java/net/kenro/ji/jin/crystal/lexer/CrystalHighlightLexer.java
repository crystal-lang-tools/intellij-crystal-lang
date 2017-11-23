package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;

import java.io.Reader;

public final class CrystalHighlightLexer extends LookAheadLexer {
    public CrystalHighlightLexer() {
        super(new MergingLexerAdapter(new FlexAdapter(new net.kenro.ji.jin.crystal.lexer._CrystalLexer((Reader) null)), TokenSet.create(CrystalTokens.WS, CrystalTokens.STRING)), 10);
    }
}


