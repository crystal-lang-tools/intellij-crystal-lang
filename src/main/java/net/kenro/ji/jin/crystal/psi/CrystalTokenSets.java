package net.kenro.ji.jin.crystal.psi;

import com.intellij.psi.tree.TokenSet;

import static net.kenro.ji.jin.crystal.psi.CrystalElementTypes.*;

public interface CrystalTokenSets {

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
            PLUS, PLUS_EQUAL, MINUS_EQUAL, MINUS_GREATER, MINUS, TIMES_EQUAL, TIMES_TIMES_EQUAL, TIMES_TIMES, TIMES, DIVIDENTE, DIVIDENTE_EQUAL, MODULO_EQUAL,
            MACRO_BLOCK_CLOSE, MACRO_BLOCK_OPEN, ARRAY_EQUAL, ARRAY_BOOL, ARRAY, QUESTION, SEMICOLON,
            NAMESPACE, COLON, TILDE, DOT_DOT, DOT_DOT_DOT, AND, AND_AND, AND_AND_EQUAL, AND_EQUAL, OR_OR, OR_EQUAL, OR_OR_EQUAL, CAROT, CAROT_EQUAL,
            AT_BRACKET, AT, DOLLAR_TILDE, DOLLAR_QUESTION);

    TokenSet strings = TokenSet.create(STRING_LITERAL);

}
