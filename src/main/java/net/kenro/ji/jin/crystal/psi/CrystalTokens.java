package net.kenro.ji.jin.crystal.psi;

import com.intellij.psi.tree.TokenSet;

public interface CrystalTokens {
    CrystalElementType ERROR = new CrystalElementType("error");
    CrystalElementType UNICODE = new CrystalElementType("unicode");
    CrystalElementType WS = new CrystalElementType("whitespace");
    CrystalElementType MLCOMMENT = new CrystalElementType("block comment");
    CrystalElementType SLCOMMENT = new CrystalElementType("line comment");

    CrystalElementType LEFT_BRACE = new CrystalElementType("{");
    CrystalElementType RIGHT_BRACE = new CrystalElementType("}");
    CrystalElementType LEFT_PAREN = new CrystalElementType("(");
    CrystalElementType RIGHT_PAREN = new CrystalElementType(")");
    CrystalElementType LEFT_BRACKET = new CrystalElementType("[");
    CrystalElementType RIGHT_BRACKET = new CrystalElementType("]");
    CrystalElementType DOT = new CrystalElementType(".");
    CrystalElementType PIPE = new CrystalElementType("|");
    CrystalElementType COMMA = new CrystalElementType(",");
    CrystalElementType EQUAL = new CrystalElementType("=");
    CrystalElementType EQUAL_EQUAL = new CrystalElementType("==");
    CrystalElementType EQUAL_EQUAL_EQUAL = new CrystalElementType("===");
    CrystalElementType BACKSLASH = new CrystalElementType("\\");
    CrystalElementType RIGHT_ARROW = new CrystalElementType("=>");
    CrystalElementType APROX_ARROW = new CrystalElementType("=~");
    CrystalElementType NOT_EQUAL = new CrystalElementType("!=");
    CrystalElementType NOT_APROX = new CrystalElementType("!~");
    CrystalElementType NOT = new CrystalElementType("!");
    CrystalElementType LEFT_RIGHT_ARROW = new CrystalElementType("<=>");
    CrystalElementType LEFT_ARROW = new CrystalElementType("<=");
    CrystalElementType LEFT_LEFT_ARROW = new CrystalElementType("<<=");
    CrystalElementType INSERT = new CrystalElementType("<<");
    CrystalElementType LESS = new CrystalElementType("<");
    CrystalElementType GREATER_EQUAL = new CrystalElementType(">=");
    CrystalElementType GREATER_GREATER_EQUAL = new CrystalElementType(">>=");
    CrystalElementType GREATER_GREATER = new CrystalElementType(">>");
    CrystalElementType GREATER = new CrystalElementType(">");
    CrystalElementType PLUS = new CrystalElementType("+");
    CrystalElementType PLUS_EQUAL = new CrystalElementType("+=");
    CrystalElementType MINUS_EQUAL = new CrystalElementType("-=");
    CrystalElementType MINUS_GREATER = new CrystalElementType("->");
    CrystalElementType MINUS = new CrystalElementType("-");
    CrystalElementType TIMES_EQUAL = new CrystalElementType("*=");
    CrystalElementType TIMES_TIMES_EQUAL = new CrystalElementType("**=");
    CrystalElementType TIMES_TIMES = new CrystalElementType("**");
    CrystalElementType TIMES = new CrystalElementType("*");
    CrystalElementType DIVIDE_EQUAL = new CrystalElementType("/=");
    CrystalElementType DIVIDE = new CrystalElementType("/");
    CrystalElementType MODULO_EQUAL = new CrystalElementType("%=");

    CrystalElementType MODULE = new CrystalElementType("module");

    CrystalElementType MACRO_BLOCK_CLOSE = new CrystalElementType("%}");
    CrystalElementType MACRO_BLOCK_OPEN = new CrystalElementType("%");
    CrystalElementType MACRO_STATEMENT_OPEN = new CrystalElementType("{{");
    CrystalElementType ARRAY_EQUAL = new CrystalElementType("[]=");
    CrystalElementType ARRAY_BOOL = new CrystalElementType("[]?");
    CrystalElementType ARRAY = new CrystalElementType("[]");
    CrystalElementType QUESTION = new CrystalElementType("?");
    CrystalElementType SEMICOLON = new CrystalElementType(";");
    CrystalElementType NAMESPACE = new CrystalElementType("::");
    CrystalElementType COLON = new CrystalElementType(":");
    CrystalElementType TILDE = new CrystalElementType("~");
    CrystalElementType DOT_DOT_DOT = new CrystalElementType("...");
    CrystalElementType DOT_DOT = new CrystalElementType("..");
    CrystalElementType AND_AND_EQUAL = new CrystalElementType("&&=");
    CrystalElementType AND_AND = new CrystalElementType("&&");
    CrystalElementType AND_EQUAL = new CrystalElementType("&=");
    CrystalElementType AND = new CrystalElementType("&");
    CrystalElementType OR_OR_EQUAL = new CrystalElementType("||=");
    CrystalElementType OR_OR = new CrystalElementType("||");
    CrystalElementType OR_EQUAL = new CrystalElementType("|=");
    CrystalElementType CAROT_EQUAL = new CrystalElementType("^=");
    CrystalElementType CAROT = new CrystalElementType("^");
    CrystalElementType AT_BRACKET = new CrystalElementType("@[");
    CrystalElementType DOLLAR_TILDE = new CrystalElementType("$~");
    CrystalElementType DOLLAR_QUESTION = new CrystalElementType("$?");

    CrystalElementType CASE = new CrystalElementType("case");
    CrystalElementType CLASS = new CrystalElementType("class");
    CrystalElementType DEF = new CrystalElementType("def");
    CrystalElementType DO = new CrystalElementType("do");
    CrystalElementType ELSE = new CrystalElementType("else");
    CrystalElementType END = new CrystalElementType("end");
    CrystalElementType IF = new CrystalElementType("if");
    CrystalElementType NIL = new CrystalElementType("nil");
    CrystalElementType OF = new CrystalElementType("of");
    CrystalElementType REQUIRE = new CrystalElementType("require");
    CrystalElementType WHEN = new CrystalElementType("when");
    CrystalElementType YIELD = new CrystalElementType("yield");
    CrystalElementType UNTIL = new CrystalElementType("until");
    CrystalElementType ELSIF = new CrystalElementType("elsif");
    CrystalElementType TRUE = new CrystalElementType("true");
    CrystalElementType FALSE = new CrystalElementType("false");
    CrystalElementType RAISE = new CrystalElementType("raise");

    CrystalElementType STRING = new CrystalElementType("string");
    CrystalElementType STRING_ESCAPED = new CrystalElementType("string escaping");
    CrystalElementType STRING_GAP = new CrystalElementType("string escaping");
    CrystalElementType STRING_ERROR = new CrystalElementType("string escaping error");
    CrystalElementType NUMBER = new CrystalElementType("number");
    CrystalElementType FLOAT = new CrystalElementType("float");

    CrystalElementType IDENT = new CrystalElementType("identifier");
    CrystalElementType PROPER_NAME = new CrystalElementType("proper name");

//    TokenSet kKeywords = TokenSet.create(DATA, NEWTYPE, TYPE, FOREIGN, IMPORT, INFIXL, INFIXR, INFIX, CLASS, DERIVE ,INSTANCE,
//            MODULE, CASE, OF, IF, THEN, ELSE, DO, LET, TRUE, FALSE, IN, WHERE, FORALL, QUALIFIED, HIDING, AS, START,
//            BANG);
//    TokenSet kStrings = TokenSet.create(STRING);
//    TokenSet kOperators = TokenSet.create(DARROW, LDARROW, ARROW, EQ, DOT, OPTIMISTIC, OPERATOR);

    CrystalElementType EOF = new CrystalElementType("<<eof>>");
}

