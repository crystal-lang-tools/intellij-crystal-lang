package net.kenro.ji.jin.crystal.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static net.kenro.ji.jin.crystal.psi.CrystalTokens.*;

%%

%unicode
%class _PSLexer
%implements FlexLexer
%function advance
%type IElementType

%eof{

return;

%eof}

whitespace = [ \t\f\r\n]
opChars = [\:\!#\$%&*+./<=>?@\\\^|\-~]
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

"data"                         { return DATA; }
"type"                         { return TYPE; }
"newtype"                      { return NEWTYPE; }
"foreign"                      { return FOREIGN; }
"import"                       { return IMPORT; }
"infixl"                       { return INFIXL; }
"infixr"                       { return INFIXR; }
"infix"                        { return INFIX; }
"class"                        { return CLASS; }
"instance"                     { return INSTANCE; }
"derive"                       { return DERIVE; }
"module"                       { return MODULE; }
"case"                         { return CASE; }
"of"                           { return OF; }
"if"                           { return IF; }
"then"                         { return THEN; }
"else"                         { return ELSE; }
"do"                           { return DO; }
"let"                          { return LET; }
"true"                         { return TRUE; }
"false"                        { return FALSE; }
"in"                           { return IN; }
"where"                        { return WHERE; }
"∀"                            { return FORALL; }
"forall"                       { return FORALL; }
"\\u2200"                      { return FORALL; }
"\u2200"                       { return FORALL; }
"qualified"                    { return QUALIFIED; }
"hiding"                       { return HIDING; }
"as"                           { return AS; }

"=>"                           { return DARROW; }
"\\u21D2"                      { return DARROW; }
"\u21D2"                       { return DARROW; }
"<="                           { return LDARROW; }
"\\u21D0"                      { return LDARROW; }
"\u21D0"                       { return LDARROW; }
"->"                           { return ARROW; }
"\\u2192"                      { return ARROW; }
"\u2192"                       { return ARROW; }
"<-"                           { return LARROW; }
"\\u2190"                      { return LARROW; }
"\u2190"                       { return LARROW; }
"="                            { return EQ; }
"."                            { return DOT; }
"\\"                           { return BACKSLASH; }

";"                            { return SEMI; }
"::"                           { return DCOLON; }
"∷"                            { return DCOLON; }
"`"                            { return TICK; }
"|"                            { return PIPE; }

","                            { return COMMA; }
"("                            { return LPAREN; }
")"                            { return RPAREN; }
"["                            { return LBRACK; }
"]"                            { return RBRACK; }
"{"                            { return LCURLY; }
"}"                            { return RCURLY; }
".."                           { return DDOT; }

"~>"                           {return OPTIMISTIC; }

"0"({hexadecimal}|{octal}|{decimal})|{decimal} { return NATURAL; }
{decimal}{fractExponent}       { return FLOAT; }
"\"\"\""                       { yybegin(BLOCK_STRINGS); return STRING; }
"\""                           { yybegin(STRINGS); return STRING; }

{identStart}{identLetter}*     { return IDENT; }
{properName}                   { return PROPER_NAME; }
{uniCode}+                     { return OPERATOR; }
{opChars}+                     { return OPERATOR; }

.                              { return ERROR; }
}