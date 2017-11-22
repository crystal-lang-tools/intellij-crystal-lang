#!/bin/sh

rm -rf build
rm -rf src/main/gen

GRAMMAR_KIT="grammar-kit.jar"
LIB="/Applications/IntelliJ IDEA.app/Contents/lib/"
GEN_DIR=src/main/gen
BNF_FILE=src/main/java/net/kenro/ji/jin/purescript/grammar/Purescript.bnf
java -cp "$GRAMMAR_KIT:$LIB/*:src" org.intellij.grammar.Main $GEN_DIR $BNF_FILE

JFLEX="jflex-1.7.0-SNAPSHOT.jar"
FLEX_FILE=/Users/hendrkin/dev/projects/purity-intellij/src/main/java/net/kenro/ji/jin/purescript/lexer/Purescript.flex
SKEL_FILE=idea-flex.skeleton
java -cp "$JFLEX" -jar $JFLEX -d $GEN_DIR --skel $SKEL_FILE $FLEX_FILE
