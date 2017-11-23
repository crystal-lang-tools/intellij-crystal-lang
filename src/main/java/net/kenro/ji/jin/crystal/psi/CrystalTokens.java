package net.kenro.ji.jin.crystal.psi;

import com.intellij.psi.tree.TokenSet;

public interface CrystalTokens {
    CrystalElementType ERROR = new CrystalElementType("error");
    CrystalElementType UNICODE = new CrystalElementType("unicode");
    CrystalElementType WS = new CrystalElementType("whitespace");
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
    CrystalElementType MACRO_BLOCK_CLOSE = new CrystalElementType("%}");
    CrystalElementType MACRO_BLOCK_OPEN = new CrystalElementType("%");
    CrystalElementType MACRO_STATEMENT_OPEN = new CrystalElementType("{{");
    CrystalElementType MACRO_STATEMENT_CLOSE = new CrystalElementType("}}");
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
    CrystalElementType AT = new CrystalElementType("@");
    CrystalElementType DOLLAR_TILDE = new CrystalElementType("$~");
    CrystalElementType DOLLAR_QUESTION = new CrystalElementType("$?");

    CrystalElementType MODULE = new CrystalElementType("module");
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
    CrystalElementType INCLUDE = new CrystalElementType("include");
    CrystalElementType EXTEND = new CrystalElementType("extend");
    CrystalElementType RETURN = new CrystalElementType("return");
    CrystalElementType BEGIN = new CrystalElementType("begin");
    CrystalElementType LIB = new CrystalElementType("lib");
    CrystalElementType FUN = new CrystalElementType("fun");
    CrystalElementType TYPE = new CrystalElementType("type");
    CrystalElementType STRUCT = new CrystalElementType("struct");
    CrystalElementType UNION = new CrystalElementType("union");
    CrystalElementType ENUM = new CrystalElementType("enum");
    CrystalElementType MACRO = new CrystalElementType("macro");
    CrystalElementType OUT = new CrystalElementType("out");
    CrystalElementType AS = new CrystalElementType("as");
    CrystalElementType AS_QUESTION = new CrystalElementType("as?");
    CrystalElementType TYPEOF = new CrystalElementType("typeof");
    CrystalElementType FOR = new CrystalElementType("for");
    CrystalElementType SELECT = new CrystalElementType("select");
    CrystalElementType THEN = new CrystalElementType("then");
    CrystalElementType RESCUE = new CrystalElementType("rescue");
    CrystalElementType ENSURE = new CrystalElementType("ensure");
    CrystalElementType IS_A_QUESTION = new CrystalElementType("is_a?");
    CrystalElementType ALIAS = new CrystalElementType("alias");
    CrystalElementType SIZEOF = new CrystalElementType("sizeof");
    CrystalElementType NIL_QUESTION = new CrystalElementType("nil?");
    CrystalElementType IN = new CrystalElementType("in");
    CrystalElementType WITH = new CrystalElementType("with");
    CrystalElementType SELF = new CrystalElementType("self");
    CrystalElementType SUPER = new CrystalElementType("super");
    CrystalElementType PRIVATE = new CrystalElementType("private");
    CrystalElementType ASM = new CrystalElementType("asm");
    CrystalElementType PROTECTED = new CrystalElementType("protected");
    CrystalElementType UNINITIALIZED = new CrystalElementType("uninitialized");
    CrystalElementType INSTANCE_SIZEOF = new CrystalElementType("instance_sizeof");
    CrystalElementType ABSTRACT = new CrystalElementType("abstract");
    CrystalElementType POINTEROF = new CrystalElementType("pointerof");

    CrystalElementType INITIALIZE = new CrystalElementType("initialize");
    CrystalElementType NEW = new CrystalElementType("new");
    CrystalElementType LOOP = new CrystalElementType("loop");
    CrystalElementType PREPEND = new CrystalElementType("prepend");
    CrystalElementType FAIL = new CrystalElementType("fail");
    CrystalElementType GETTER = new CrystalElementType("getter");
    CrystalElementType SETTER = new CrystalElementType("setter");
    CrystalElementType PROPERTY = new CrystalElementType("property");
    CrystalElementType CATCH = new CrystalElementType("catch");
    CrystalElementType THROW = new CrystalElementType("throw");
    CrystalElementType ABORT = new CrystalElementType("abort");
    CrystalElementType AT_EXIT = new CrystalElementType("at_exit");
    CrystalElementType AUTOLOAD = new CrystalElementType("autoload");
    CrystalElementType BINDING = new CrystalElementType("binding");
    CrystalElementType CALLCC = new CrystalElementType("callcc");
    CrystalElementType CALLER = new CrystalElementType("caller");
    CrystalElementType CALLER_LOCATIONS = new CrystalElementType("caller_locations");
    CrystalElementType CHOMP = new CrystalElementType("chomp");
    CrystalElementType CHOP = new CrystalElementType("chop");
    CrystalElementType EVAL = new CrystalElementType("eval");
    CrystalElementType EXEC = new CrystalElementType("exec");
    CrystalElementType EXIT = new CrystalElementType("exit");
    CrystalElementType EXIT_BANG = new CrystalElementType("exit!");
    CrystalElementType FORK = new CrystalElementType("fork");
    CrystalElementType FORMAT = new CrystalElementType("format");
    CrystalElementType GETS = new CrystalElementType("gets");
    CrystalElementType GLOBAL_VARIABLES = new CrystalElementType("global_variables");
    CrystalElementType GSUB = new CrystalElementType("gsub");
    CrystalElementType ITERATOR = new CrystalElementType("iterator");
    CrystalElementType LAMBDA = new CrystalElementType("lambda");
    CrystalElementType LOAD = new CrystalElementType("load");
    CrystalElementType LOCAL_VARIABLES = new CrystalElementType("local_variables");
    CrystalElementType OPEN = new CrystalElementType("open");
    CrystalElementType P = new CrystalElementType("p");
    CrystalElementType PRINT = new CrystalElementType("print");
    CrystalElementType PRINTF = new CrystalElementType("printf");
    CrystalElementType PROC = new CrystalElementType("proc");
    CrystalElementType PUTC = new CrystalElementType("putc");
    CrystalElementType PUTS = new CrystalElementType("puts");
    CrystalElementType RAND = new CrystalElementType("rand");
    CrystalElementType READLINE = new CrystalElementType("readline");
    CrystalElementType READLINES = new CrystalElementType("readlines");
    CrystalElementType SET_TRACE_FUNC = new CrystalElementType("set_trace_func");
    CrystalElementType SLEEP = new CrystalElementType("sleep");
    CrystalElementType SPAWN = new CrystalElementType("spawn");
    CrystalElementType SPRINTF = new CrystalElementType("sprintf");
    CrystalElementType SRAND = new CrystalElementType("srand");
    CrystalElementType SUB = new CrystalElementType("sub");
    CrystalElementType SYSCALL = new CrystalElementType("syscall");
    CrystalElementType SYSTEM = new CrystalElementType("system");
    CrystalElementType TEST = new CrystalElementType("test");
    CrystalElementType TRACE_VAR = new CrystalElementType("trace_var");
    CrystalElementType TRAP = new CrystalElementType("trap");
    CrystalElementType UNTRACE_VAR = new CrystalElementType("untrace_var");
    CrystalElementType WARN = new CrystalElementType("warn");
    CrystalElementType BREAK = new CrystalElementType("break");

    CrystalElementType STRING = new CrystalElementType("string");
    CrystalElementType STRING_ESCAPED = new CrystalElementType("string escaping");
    CrystalElementType STRING_GAP = new CrystalElementType("string escaping");
    CrystalElementType STRING_ERROR = new CrystalElementType("string escaping error");
    CrystalElementType NUMBER = new CrystalElementType("number");
    CrystalElementType FLOAT = new CrystalElementType("float");

    CrystalElementType IDENT = new CrystalElementType("identifier");
    CrystalElementType PROPER_NAME = new CrystalElementType("proper name");

    TokenSet keyWords = TokenSet.create(CASE, CLASS, DEF, DO, ELSE, END, IF, NIL, OF, REQUIRE, WHEN, YIELD, UNTIL, ELSIF, TRUE, FALSE, RAISE,
            INCLUDE, EXTEND, RETURN, BEGIN, LIB, FUN, TYPE, STRUCT, UNION, ENUM, MACRO, OUT, AS, AS_QUESTION, TYPEOF, FOR, SELECT, THEN,
            RESCUE, ENSURE, IS_A_QUESTION, ALIAS, SIZEOF, NIL_QUESTION, IN, WITH, SELF, SUPER, PRIVATE, ASM, PROTECTED, UNINITIALIZED,
            INSTANCE_SIZEOF, ABSTRACT, POINTEROF, INITIALIZE, NEW, LOOP, PREPEND, FAIL, GETTER, SETTER, PROPERTY, CATCH, THROW, ABORT, AT_EXIT,
            AUTOLOAD, BINDING, CALLCC, CALLER, CALLER_LOCATIONS, CHOMP, CHOP, EVAL, EXEC, EXIT, EXIT_BANG, FORK, FORMAT, GETS, GLOBAL_VARIABLES,
            GSUB, ITERATOR, LAMBDA, LOAD, LOCAL_VARIABLES, OPEN, P, PRINT, PRINTF, PROC, PUTC, PUTS, RAND, READLINE, READLINES, SET_TRACE_FUNC,
            SLEEP, SPAWN, SPRINTF, SRAND, SUB, SYSCALL, SYSTEM, TEST, TRACE_VAR, TRAP, UNTRACE_VAR, WARN, BREAK, MODULE);

    TokenSet brackets = TokenSet.create(LEFT_BRACE, RIGHT_BRACE, LEFT_PAREN, RIGHT_PAREN, LEFT_BRACKET, RIGHT_BRACKET);

    TokenSet operators = TokenSet.create(DOT, PIPE, COMMA, EQUAL, EQUAL_EQUAL, EQUAL_EQUAL_EQUAL, BACKSLASH, RIGHT_ARROW, APROX_ARROW, NOT_EQUAL,
            NOT_APROX, NOT, LEFT_RIGHT_ARROW, LEFT_ARROW, LEFT_LEFT_ARROW, INSERT, LESS, GREATER_EQUAL, GREATER_GREATER_EQUAL, GREATER_GREATER, GREATER,
            PLUS, PLUS_EQUAL, MINUS_EQUAL, MINUS_GREATER, MINUS, TIMES_EQUAL, TIMES_TIMES_EQUAL, TIMES_TIMES, TIMES, DIVIDE, DIVIDE_EQUAL, MODULO_EQUAL,
            MACRO_BLOCK_CLOSE, MACRO_BLOCK_OPEN, MACRO_STATEMENT_OPEN, MACRO_STATEMENT_CLOSE, ARRAY_EQUAL, ARRAY_BOOL, ARRAY, QUESTION, SEMICOLON,
            NAMESPACE, COLON, TILDE, DOT_DOT, DOT_DOT_DOT, AND, AND_AND, AND_AND_EQUAL, AND_EQUAL, OR_OR, OR_EQUAL, OR_OR_EQUAL, CAROT, CAROT_EQUAL,
            AT_BRACKET, AT, DOLLAR_TILDE, DOLLAR_QUESTION);

    TokenSet strings = TokenSet.create(STRING);

    CrystalElementType EOF = new CrystalElementType("<<eof>>");
}

