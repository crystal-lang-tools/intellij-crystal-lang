package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static net.kenro.ji.jin.crystal.psi.CrystalTokens.*;

%%

%unicode
%class _CrystalLexer
%implements FlexLexer
%function advance
%type IElementType

%eof{

return;

%eof}

whitespace = [ \t\f\r\n]
identStart = [:lowercase:]|"_"
identLetter = [:letter:]|[:digit:]|[_\']
properStart = [:uppercase:]
properLetter = [:letter:]|[:digit:]|[\']|[_]
properName = {properStart}{properLetter}*

// http://www.regular-expressions.info/unicode.html#prop
uniCode = \p{S}

decimal = [0-9]+
hexadecimal = [xX][0-9a-zA-Z]+
octal = [oO][0-7]+
stringChar = [^\"\\\0-\u001A]
fractExponent = {fraction} {exponent}? | {exponent}
fraction = "." {decimal}
exponent = [eE] [+\-]? {decimal}
escapeEmpty = "&"
escapeGap = {whitespace}*"\\"
escapeCode = {charEsc} | {charNum} | {charAscii} | {charControl}
charEsc = [abfnrtv\\\"\']
charNum = {decimal} | "x" [0-9a-zA-Z]+ | "o" [0-7]+
charAscii = "BS"|"HT"|"LF"|"VT"|"FF"|"CR"|"SO"|"SI"|"EM"|"FS"|"GS"|"RS"|"US"|"SP"|"NUL"|"SOH"|"STX"|"ETX"|"EOT"|"ENQ"|"ACK"|"BEL"|"DLE"|"DC1"|"DC2"|"DC3"|"DC4"|"NAK"|"SYN"|"ETB"|"CAN"|"SUB"|"ESC"|"DEL"
charControl = "^" [:uppercase:]

%x COMMENT, STRINGS, BLOCK_STRINGS

%{
   int comment_nesting = 0;
   int yyline = 0;
   int yycolumn = 0;
%}

%%

<COMMENT> {

"{-"                           { comment_nesting++; return MLCOMMENT; }
"-}"                           { comment_nesting--; if (comment_nesting == 0) yybegin(YYINITIAL); return MLCOMMENT; }
[^]                            { return MLCOMMENT; }

}

<STRINGS> {
"\""                           { yybegin(YYINITIAL); return STRING; }
{stringChar}                   { return STRING; }
"\\" {escapeCode}              { return STRING_ESCAPED; }
"\\" {escapeEmpty}             { return STRING_GAP; }
"\\" {escapeGap}               { return STRING_GAP; }
"\\"                           { return STRING_ERROR; }
[^]                            { return ERROR; }
}

<BLOCK_STRINGS> {
"\"\"\""                       { yybegin(YYINITIAL); return STRING; }
[^]                            { return STRING; }
}

<YYINITIAL> {

{whitespace}+                  { return WS; }

"{-"                           { yybegin(COMMENT); comment_nesting = 1; return MLCOMMENT; }
"--" [^\n]*                    { return SLCOMMENT; }


  "{"                { return LEFT_BRACE; }
  "}"                { return RIGHT_BRACE; }
  "("                { return LEFT_PAREN; }
  ")"                { return RIGHT_PAREN; }
  "["                { return LEFT_BRACKET; }
  "]"                { return RIGHT_BRACKET; }
  "|"                { return PIPE; }
  "."                { return DOT; }
  ","                { return COMMA; }
  "="                { return EQUAL; }
  "=="               { return EQUAL_EQUAL; }
  "==="              { return EQUAL_EQUAL_EQUAL; }
  "\\"               { return BACKSLASH; }
  "=>"               { return RIGHT_ARROW; }
  "=~"               { return APROX_ARROW; }
  "!="               { return NOT_EQUAL; }
  "!~"               { return NOT_APROX; }
  "!"                { return NOT; }
  "<=>"              { return LEFT_RIGHT_ARROW; }
  "<="               { return LEFT_ARROW; }
  "<<="              { return LEFT_LEFT_ARROW; }
  "<<"               { return INSERT; }
  "<"                { return LESS; }
  ">="               { return GREATER_EQUAL; }
  ">>="              { return GREATER_GREATER_EQUAL; }
  ">>"               { return GREATER_GREATER; }
  ">"                { return GREATER; }
  "+="               { return PLUS_EQUAL; }
  "+"                { return PLUS; }
  "-="               { return MINUS_EQUAL; }
  "->"               { return MINUS_GREATER; }
  "-"                { return MINUS; }
  "*="               { return TIMES_EQUAL; }
  "**="              { return TIMES_TIMES_EQUAL; }
  "**"               { return TIMES_TIMES; }
  "*"                { return TIMES; }
  "/="               { return DIVIDE_EQUAL; }
  "/"                { return DIVIDE; }
  "%="               { return MODULO_EQUAL; }
  "module"           { return MODULE; }
  "%}"               { return MACRO_BLOCK_CLOSE; }
  "{%"               { return MACRO_BLOCK_OPEN; }
  "{{"               { return MACRO_STATEMENT_OPEN; }
  "[]="              { return ARRAY_EQUAL; }
  "[]?"              { return ARRAY_BOOL; }
  "[]"               { return ARRAY; }
  "?"                { return QUESTION; }
  ";"                { return SEMICOLON; }
  "::"               { return NAMESPACE; }
  ":"                { return COLON; }
  "~"                { return TILDE; }
  "..."              { return DOT_DOT_DOT; }
  ".."               { return DOT_DOT; }
  "&&="              { return AND_AND_EQUAL; }
  "&&"               { return AND_AND; }
  "&="               { return AND_EQUAL; }
  "&"                { return AND; }
  "||="              { return OR_OR_EQUAL; }
  "||"               { return OR_OR; }
  "|="               { return OR_EQUAL; }
  "^="               { return CAROT_EQUAL; }
  "^"                { return CAROT; }
  "@["               { return AT_BRACKET; }
  "$~"               { return DOLLAR_TILDE; }
  "$?"               { return DOLLAR_QUESTION; }
  "case"             { return CASE; }
  "class"            { return CLASS; }
  "def"              { return DEF; }
  "do"               { return DO; }
  "else"             { return ELSE; }
  "end"              { return END; }
  "if"               { return IF; }
  "nil"              { return NIL; }
  "of"               { return OF; }
  "require"          { return REQUIRE; }
  "when"             { return WHEN; }
  "yield"            { return YIELD; }
  "until"            { return UNTIL; }
  "elsif"            { return ELSIF; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "raise"            { return RAISE; }

"0"({hexadecimal}|{octal}|{decimal})|{decimal} { return NUMBER; }
{decimal}{fractExponent}       { return FLOAT; }
"\"\"\""                       { yybegin(BLOCK_STRINGS); return STRING; }
"\""                           { yybegin(STRINGS); return STRING; }

{identStart}{identLetter}*     { return IDENT; }
{properName}                   { return PROPER_NAME; }
{uniCode}+                     { return UNICODE; }

.                              { return ERROR; }
}