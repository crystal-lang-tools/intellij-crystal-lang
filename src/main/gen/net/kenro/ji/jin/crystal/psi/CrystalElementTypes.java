// This is a generated file. Not intended for manual editing.
package net.kenro.ji.jin.crystal.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import net.kenro.ji.jin.crystal.psi.impl.*;

public interface CrystalElementTypes {

  IElementType ARG = new CrystalElementType("ARG");
  IElementType ARGS = new CrystalElementType("ARGS");
  IElementType ARG_DECL = new CrystalElementType("ARG_DECL");
  IElementType ARG_LIST = new CrystalElementType("ARG_LIST");
  IElementType ASSOC = new CrystalElementType("ASSOC");
  IElementType ASSOCS = new CrystalElementType("ASSOCS");
  IElementType BLOCK_VARIABLE = new CrystalElementType("BLOCK_VARIABLE");
  IElementType CALL = new CrystalElementType("CALL");
  IElementType CALL_ARGS = new CrystalElementType("CALL_ARGS");
  IElementType COMMAND = new CrystalElementType("COMMAND");
  IElementType COMPOSITE_STATEMENT = new CrystalElementType("COMPOSITE_STATEMENT");
  IElementType EXPRESSION = new CrystalElementType("EXPRESSION");
  IElementType EXPRESSIONS = new CrystalElementType("EXPRESSIONS");
  IElementType FNAME = new CrystalElementType("FNAME");
  IElementType FUNCTION = new CrystalElementType("FUNCTION");
  IElementType GLOBAL = new CrystalElementType("GLOBAL");
  IElementType LHS = new CrystalElementType("LHS");
  IElementType LITERAL = new CrystalElementType("LITERAL");
  IElementType MLHS = new CrystalElementType("MLHS");
  IElementType MLHS_ITEM = new CrystalElementType("MLHS_ITEM");
  IElementType MRHS = new CrystalElementType("MRHS");
  IElementType OPERATION = new CrystalElementType("OPERATION");
  IElementType OP_ASGN = new CrystalElementType("OP_ASGN");
  IElementType PRIMARY = new CrystalElementType("PRIMARY");
  IElementType SINGLETON = new CrystalElementType("SINGLETON");
  IElementType STATEMENT = new CrystalElementType("STATEMENT");
  IElementType STATEMENTS = new CrystalElementType("STATEMENTS");
  IElementType SYMBOL = new CrystalElementType("SYMBOL");
  IElementType VARIABLE = new CrystalElementType("VARIABLE");
  IElementType VAR_NAME = new CrystalElementType("VAR_NAME");
  IElementType WHEN_ARGS = new CrystalElementType("WHEN_ARGS");

  IElementType ABORT = new CrystalTokenType("abort");
  IElementType ABSTRACT = new CrystalTokenType("abstract");
  IElementType ALIAS = new CrystalTokenType("alias");
  IElementType AND = new CrystalTokenType("&");
  IElementType AND_AND = new CrystalTokenType("&&");
  IElementType AND_AND_EQUAL = new CrystalTokenType("&&=");
  IElementType AND_EQUAL = new CrystalTokenType("&=");
  IElementType APROX_ARROW = new CrystalTokenType("=~");
  IElementType ARRAY = new CrystalTokenType("[]");
  IElementType ARRAY_BOOL = new CrystalTokenType("[]?");
  IElementType ARRAY_EQUAL = new CrystalTokenType("[]=");
  IElementType AS = new CrystalTokenType("as");
  IElementType ASM = new CrystalTokenType("asm");
  IElementType AS_QUESTION = new CrystalTokenType("as?");
  IElementType AT = new CrystalTokenType("@");
  IElementType AT_BRACKET = new CrystalTokenType("@[");
  IElementType AT_EXIT = new CrystalTokenType("at_exit");
  IElementType AUTOLOAD = new CrystalTokenType("autoload");
  IElementType BACKSLASH = new CrystalTokenType("\\\\");
  IElementType BEGIN = new CrystalTokenType("begin");
  IElementType BINDING = new CrystalTokenType("binding");
  IElementType BREAK = new CrystalTokenType("break");
  IElementType CALLCC = new CrystalTokenType("callcc");
  IElementType CALLER = new CrystalTokenType("caller");
  IElementType CALLER_LOCATIONS = new CrystalTokenType("caller_locations");
  IElementType CAROT = new CrystalTokenType("^");
  IElementType CAROT_EQUAL = new CrystalTokenType("^=");
  IElementType CASE = new CrystalTokenType("case");
  IElementType CATCH = new CrystalTokenType("catch");
  IElementType CHAR_LITERAL = new CrystalTokenType("CHAR_LITERAL");
  IElementType CHOMP = new CrystalTokenType("chomp");
  IElementType CHOP = new CrystalTokenType("chop");
  IElementType CLASS = new CrystalTokenType("class");
  IElementType COLON = new CrystalTokenType(":");
  IElementType COMMA = new CrystalTokenType(",");
  IElementType DEF = new CrystalTokenType("def");
  IElementType DIVIDENTE = new CrystalTokenType("/");
  IElementType DIVIDENTE_EQUAL = new CrystalTokenType("/=");
  IElementType DO = new CrystalTokenType("do");
  IElementType DOLLAR_QUESTION = new CrystalTokenType("$?");
  IElementType DOLLAR_TILDE = new CrystalTokenType("$~");
  IElementType DOT = new CrystalTokenType(".");
  IElementType DOT_DOT = new CrystalTokenType("..");
  IElementType DOT_DOT_DOT = new CrystalTokenType("...");
  IElementType ELSE = new CrystalTokenType("else");
  IElementType ELSIF = new CrystalTokenType("elsif");
  IElementType END = new CrystalTokenType("end");
  IElementType ENSURE = new CrystalTokenType("ensure");
  IElementType ENUM = new CrystalTokenType("enum");
  IElementType EQUAL = new CrystalTokenType("=");
  IElementType EQUAL_EQUAL = new CrystalTokenType("==");
  IElementType EQUAL_EQUAL_EQUAL = new CrystalTokenType("===");
  IElementType EVAL = new CrystalTokenType("eval");
  IElementType EXEC = new CrystalTokenType("exec");
  IElementType EXIT = new CrystalTokenType("exit");
  IElementType EXIT_BANG = new CrystalTokenType("exit!");
  IElementType EXTEND = new CrystalTokenType("extend");
  IElementType FAIL = new CrystalTokenType("fail");
  IElementType FALSE = new CrystalTokenType("false");
  IElementType FOR = new CrystalTokenType("for");
  IElementType FORK = new CrystalTokenType("fork");
  IElementType FORMAT = new CrystalTokenType("format");
  IElementType FUN = new CrystalTokenType("fun");
  IElementType GETS = new CrystalTokenType("gets");
  IElementType GETTER = new CrystalTokenType("getter");
  IElementType GLOBAL_VARIABLES = new CrystalTokenType("global_variables");
  IElementType GREATER = new CrystalTokenType(">");
  IElementType GREATER_EQUAL = new CrystalTokenType(">=");
  IElementType GREATER_GREATER = new CrystalTokenType(">>");
  IElementType GREATER_GREATER_EQUAL = new CrystalTokenType(">>=");
  IElementType GSUB = new CrystalTokenType("gsub");
  IElementType IDENT = new CrystalTokenType("IDENT");
  IElementType IF = new CrystalTokenType("if");
  IElementType IN = new CrystalTokenType("in");
  IElementType INCLUDE = new CrystalTokenType("include");
  IElementType INITIALIZE = new CrystalTokenType("initialize");
  IElementType INSERT = new CrystalTokenType("<<");
  IElementType INSTANCE_SIZEOF = new CrystalTokenType("instance_sizeof");
  IElementType IS_A_QUESTION = new CrystalTokenType("is_a?");
  IElementType ITERATOR = new CrystalTokenType("iterator");
  IElementType LAMBDA = new CrystalTokenType("lambda");
  IElementType LEFT_ARROW = new CrystalTokenType("<=");
  IElementType LEFT_BRACE = new CrystalTokenType("{");
  IElementType LEFT_BRACKET = new CrystalTokenType("[");
  IElementType LEFT_LEFT_ARROW = new CrystalTokenType("<<=");
  IElementType LEFT_PAREN = new CrystalTokenType("(");
  IElementType LEFT_RIGHT_ARROW = new CrystalTokenType("<=>");
  IElementType LESS = new CrystalTokenType("<");
  IElementType LIB = new CrystalTokenType("lib");
  IElementType LINE_COMMENT = new CrystalTokenType("line_comment");
  IElementType LOAD = new CrystalTokenType("load");
  IElementType LOCAL_VARIABLES = new CrystalTokenType("local_variables");
  IElementType LOOP = new CrystalTokenType("loop");
  IElementType MACRO = new CrystalTokenType("macro");
  IElementType MACRO_BLOCK_CLOSE = new CrystalTokenType("%}");
  IElementType MACRO_BLOCK_OPEN = new CrystalTokenType("{%");
  IElementType MACRO_STATEMENT_CLOSE = new CrystalTokenType("}}");
  IElementType MACRO_STATEMENT_OPEN = new CrystalTokenType("{{");
  IElementType MINUS = new CrystalTokenType("-");
  IElementType MINUS_EQUAL = new CrystalTokenType("-=");
  IElementType MINUS_GREATER = new CrystalTokenType("->");
  IElementType MODULE = new CrystalTokenType("module");
  IElementType MODULO_EQUAL = new CrystalTokenType("%=");
  IElementType NAMESPACE = new CrystalTokenType("::");
  IElementType NEW = new CrystalTokenType("new");
  IElementType NIL = new CrystalTokenType("nil");
  IElementType NIL_QUESTION = new CrystalTokenType("nil?");
  IElementType NOT = new CrystalTokenType("!");
  IElementType NOT_APROX = new CrystalTokenType("!~");
  IElementType NOT_EQUAL = new CrystalTokenType("!=");
  IElementType NUMBER_LITERAL = new CrystalTokenType("NUMBER_LITERAL");
  IElementType OF = new CrystalTokenType("of");
  IElementType OPEN = new CrystalTokenType("open");
  IElementType OR_EQUAL = new CrystalTokenType("|=");
  IElementType OR_OR = new CrystalTokenType("||");
  IElementType OR_OR_EQUAL = new CrystalTokenType("||=");
  IElementType OUT = new CrystalTokenType("out");
  IElementType P = new CrystalTokenType("p");
  IElementType PIPE = new CrystalTokenType("|");
  IElementType PLUS = new CrystalTokenType("+");
  IElementType PLUS_EQUAL = new CrystalTokenType("+=");
  IElementType POINTEROF = new CrystalTokenType("pointerof");
  IElementType PREPEND = new CrystalTokenType("prepend");
  IElementType PRINT = new CrystalTokenType("print");
  IElementType PRINTF = new CrystalTokenType("printf");
  IElementType PRIVATE = new CrystalTokenType("private");
  IElementType PROC = new CrystalTokenType("proc");
  IElementType PROPERTY = new CrystalTokenType("property");
  IElementType PROTECTED = new CrystalTokenType("protected");
  IElementType PUTC = new CrystalTokenType("putc");
  IElementType PUTS = new CrystalTokenType("puts");
  IElementType QUESTION = new CrystalTokenType("?");
  IElementType RAISE = new CrystalTokenType("raise");
  IElementType RAND = new CrystalTokenType("rand");
  IElementType READLINE = new CrystalTokenType("readline");
  IElementType READLINES = new CrystalTokenType("readlines");
  IElementType REQUIRE = new CrystalTokenType("require");
  IElementType RESCUE = new CrystalTokenType("rescue");
  IElementType RETURN = new CrystalTokenType("return");
  IElementType RIGHT_ARROW = new CrystalTokenType("=>");
  IElementType RIGHT_BRACE = new CrystalTokenType("}");
  IElementType RIGHT_BRACKET = new CrystalTokenType("]");
  IElementType RIGHT_PAREN = new CrystalTokenType(")");
  IElementType SELECT = new CrystalTokenType("select");
  IElementType SELF = new CrystalTokenType("self");
  IElementType SEMICOLON = new CrystalTokenType(";");
  IElementType SETTER = new CrystalTokenType("setter");
  IElementType SET_TRACE_FUNC = new CrystalTokenType("set_trace_func");
  IElementType SIZEOF = new CrystalTokenType("sizeof");
  IElementType SLEEP = new CrystalTokenType("sleep");
  IElementType SPAWN = new CrystalTokenType("spawn");
  IElementType SPRINTF = new CrystalTokenType("sprintf");
  IElementType SRAND = new CrystalTokenType("srand");
  IElementType STRING_LITERAL = new CrystalTokenType("STRING_LITERAL");
  IElementType STRUCT = new CrystalTokenType("struct");
  IElementType SUB = new CrystalTokenType("sub");
  IElementType SUPER = new CrystalTokenType("super");
  IElementType SYSCALL = new CrystalTokenType("syscall");
  IElementType SYSTEM = new CrystalTokenType("system");
  IElementType TEST = new CrystalTokenType("test");
  IElementType THEN = new CrystalTokenType("then");
  IElementType THROW = new CrystalTokenType("throw");
  IElementType TILDE = new CrystalTokenType("~");
  IElementType TIMES = new CrystalTokenType("*");
  IElementType TIMES_EQUAL = new CrystalTokenType("*=");
  IElementType TIMES_TIMES = new CrystalTokenType("**");
  IElementType TIMES_TIMES_EQUAL = new CrystalTokenType("**=");
  IElementType TRACE_VAR = new CrystalTokenType("trace_var");
  IElementType TRAP = new CrystalTokenType("trap");
  IElementType TRUE = new CrystalTokenType("true");
  IElementType TYPE = new CrystalTokenType("type");
  IElementType TYPEOF = new CrystalTokenType("typeof");
  IElementType UNINITIALIZED = new CrystalTokenType("uninitialized");
  IElementType UNION = new CrystalTokenType("union");
  IElementType UNTIL = new CrystalTokenType("until");
  IElementType UNTRACE_VAR = new CrystalTokenType("untrace_var");
  IElementType WARN = new CrystalTokenType("warn");
  IElementType WHEN = new CrystalTokenType("when");
  IElementType WITH = new CrystalTokenType("with");
  IElementType YIELD = new CrystalTokenType("yield");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARG) {
        return new CrystalArgImpl(node);
      }
      else if (type == ARGS) {
        return new CrystalArgsImpl(node);
      }
      else if (type == ARG_DECL) {
        return new CrystalArgDeclImpl(node);
      }
      else if (type == ARG_LIST) {
        return new CrystalArgListImpl(node);
      }
      else if (type == ASSOC) {
        return new CrystalAssocImpl(node);
      }
      else if (type == ASSOCS) {
        return new CrystalAssocsImpl(node);
      }
      else if (type == BLOCK_VARIABLE) {
        return new CrystalBlockVariableImpl(node);
      }
      else if (type == CALL) {
        return new CrystalCallImpl(node);
      }
      else if (type == CALL_ARGS) {
        return new CrystalCallArgsImpl(node);
      }
      else if (type == COMMAND) {
        return new CrystalCommandImpl(node);
      }
      else if (type == COMPOSITE_STATEMENT) {
        return new CrystalCompositeStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new CrystalExpressionImpl(node);
      }
      else if (type == EXPRESSIONS) {
        return new CrystalExpressionsImpl(node);
      }
      else if (type == FNAME) {
        return new CrystalFnameImpl(node);
      }
      else if (type == FUNCTION) {
        return new CrystalFunctionImpl(node);
      }
      else if (type == GLOBAL) {
        return new CrystalGlobalImpl(node);
      }
      else if (type == LHS) {
        return new CrystalLhsImpl(node);
      }
      else if (type == LITERAL) {
        return new CrystalLiteralImpl(node);
      }
      else if (type == MLHS) {
        return new CrystalMlhsImpl(node);
      }
      else if (type == MLHS_ITEM) {
        return new CrystalMlhsItemImpl(node);
      }
      else if (type == MRHS) {
        return new CrystalMrhsImpl(node);
      }
      else if (type == OPERATION) {
        return new CrystalOperationImpl(node);
      }
      else if (type == OP_ASGN) {
        return new CrystalOpAsgnImpl(node);
      }
      else if (type == PRIMARY) {
        return new CrystalPrimaryImpl(node);
      }
      else if (type == SINGLETON) {
        return new CrystalSingletonImpl(node);
      }
      else if (type == STATEMENT) {
        return new CrystalStatementImpl(node);
      }
      else if (type == STATEMENTS) {
        return new CrystalStatementsImpl(node);
      }
      else if (type == SYMBOL) {
        return new CrystalSymbolImpl(node);
      }
      else if (type == VARIABLE) {
        return new CrystalVariableImpl(node);
      }
      else if (type == VAR_NAME) {
        return new CrystalVarNameImpl(node);
      }
      else if (type == WHEN_ARGS) {
        return new CrystalWhenArgsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
