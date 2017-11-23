package net.kenro.ji.jin.crystal.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import net.kenro.ji.jin.crystal.lexer.CrystalHighlightLexer;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class CrystalSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final Map<IElementType, TextAttributesKey> keys = new HashMap<IElementType, TextAttributesKey>();

    public static final TextAttributesKey LINE_COMMENT = createKey("CRYSTAL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey KEYWORD = createKey("CRYSTAL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey STRING = createKey("CRYSTAL_STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey NUMBER = createKey("CRYSTAL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey CRYSTAL_BRACKETS = createKey("CRYSTAL_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

    public static final TextAttributesKey OPERATOR = createKey("CRYSTAL_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey VARIABLE = createKey("CRYSTAL_VARIABLE", CodeInsightColors.INSTANCE_FIELD_ATTRIBUTES);

    public static final TextAttributesKey METHOD_DECLARATION = createKey("CRYSTAL_METHOD_DECLARATION", CodeInsightColors.METHOD_CALL_ATTRIBUTES);

    public static final TextAttributesKey CRYSTAL_COMMA = createKey("CRYSTAL_COMMA", DefaultLanguageHighlighterColors.COMMA);

    static {
        fillMap(keys, TokenSet.create(CrystalTokens.SLCOMMENT), LINE_COMMENT);
        fillMap(keys, CrystalTokens.keyWords, KEYWORD);
        fillMap(keys, TokenSet.create(CrystalTokens.NUMBER), NUMBER);
        fillMap(keys, TokenSet.create(CrystalTokens.STRING), STRING);
        fillMap(keys, CrystalTokens.brackets, CRYSTAL_BRACKETS);
        fillMap(keys, CrystalTokens.operators, OPERATOR);
        fillMap(keys, TokenSet.create(CrystalTokens.IDENT), VARIABLE);
        fillMap(keys, TokenSet.create(CrystalTokens.PROPER_NAME), METHOD_DECLARATION);
        fillMap(keys, TokenSet.create(CrystalTokens.STRING_ESCAPED), KEYWORD);
        fillMap(keys, TokenSet.create(CrystalTokens.STRING_ERROR), CodeInsightColors.ERRORS_ATTRIBUTES);
        fillMap(keys, TokenSet.create(CrystalTokens.ERROR), CodeInsightColors.ERRORS_ATTRIBUTES);
        keys.put(CrystalTokens.COMMA, CRYSTAL_COMMA);
        keys.put(CrystalTokens.FLOAT, NUMBER);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CrystalHighlightLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(keys.get(tokenType));
    }

    private static TextAttributesKey createKey(String externalName, TextAttributesKey fallbackAttrs) {
        return createTextAttributesKey(externalName, fallbackAttrs);
    }

}