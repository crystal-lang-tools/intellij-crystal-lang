package net.kenro.ji.jin.crystal.lexer;

public class CrystalLexerTest extends CrystalLexerTestBase {

    public CrystalLexerTest() {
        super("lexer");
    }

    // keywords
    public void testkeyword_break() { doTest(true, true); }
    public void testkeyword_case() { doTest(true, true); }
    public void testkeyword_class() { doTest(true, true); }
    public void testkeyword_def() { doTest(true, true); }
    public void testkeyword_do() { doTest(true, true); }
    public void testkeyword_else() { doTest(true, true); }
    public void testkeyword_elsif() { doTest(true, true); }
    public void testkeyword_end() { doTest(true, true); }
    public void testkeyword_false() { doTest(true, true); }
    public void testkeyword_if() { doTest(true, true); }
    public void testkeyword_module() { doTest(true, true); }
    public void testkeyword_next() { doTest(true, true); }
    public void testkeyword_nil() { doTest(true, true); }
    public void testkeyword_of() { doTest(true, true); }
    public void testkeyword_raise() { doTest(true, true); }
    public void testkeyword_require() { doTest(true, true); }
    public void testkeyword_true() { doTest(true, true); }
    public void testkeyword_unless() { doTest(true, true); }
    public void testkeyword_until() { doTest(true, true); }
    public void testkeyword_while() { doTest(true, true); }
    public void testkeyword_yield() { doTest(true, true); }

}
