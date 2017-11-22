#!/bin/sh

GEN_DIR=src/main/gen
JFLEX="jflex-1.7.0-SNAPSHOT.jar"
FLEX_FILE=src/main/java/net/kenro/ji/jin/purescript/lexer/Purescript.flex
SKEL_FILE=idea-flex.skeleton
java -cp "$JFLEX" -jar $JFLEX -d $GEN_DIR --skel $SKEL_FILE $FLEX_FILE
