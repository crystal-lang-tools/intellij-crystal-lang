package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;

import java.io.Reader;

public final class CrystalLexer extends LookAheadLexer {
    public CrystalLexer() {
        super(new MergedPureLexer(), 64);
    }

    private static final class MergedPureLexer extends MergingLexerAdapterBase {
        public MergedPureLexer() {
            super(new FlexAdapter(new _PSLexer((Reader) null)));
        }

        private static final MergeFunction mergeFunction = new MergeFunction() {
            @Override
            public IElementType merge(IElementType type, Lexer originalLexer) {
                if (type == CrystalTokens.STRING) {
                    while (true) {
                        final IElementType tokenType = originalLexer.getTokenType();
                        if (tokenType != CrystalTokens.STRING && tokenType != CrystalTokens.STRING_ESCAPED && tokenType != CrystalTokens.STRING_GAP)
                            break;
                        originalLexer.advance();
                    }
                } else if (type == CrystalTokens.MLCOMMENT || type == CrystalTokens.SLCOMMENT || type == CrystalTokens.WS) {
                    while (true) {
                        type = originalLexer.getTokenType();
                        if (type == CrystalTokens.MLCOMMENT || type == CrystalTokens.SLCOMMENT || type == CrystalTokens.WS) {
                            originalLexer.advance();
                        } else {
                            break;
                        }
                    }
                    type = CrystalTokens.WS;
                }
                return type;
            }
        };

        @Override
        public MergeFunction getMergeFunction() {
            return mergeFunction;
        }
    }
}

