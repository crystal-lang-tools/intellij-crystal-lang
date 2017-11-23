package net.kenro.ji.jin.crystal.lexer;

public class CrystalLexerTest extends CrystalLexerTestBase {

    public CrystalLexerTest() {
        super("lexer");
    }

    // keywords
    public void testkeyword_if() { doTest(true, true); }

}
