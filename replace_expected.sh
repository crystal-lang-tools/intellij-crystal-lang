#!/bin/sh

rm -rf src/test/resources/gold/lexer/expected/*
cp build/resources/test/gold/lexer/expected/* src/test/resources/gold/lexer/expected

rm -rf src/test/resources/gold/parser/current/*.psi
cp build/resources/test/gold/parser/current/*.psi src/test/resources/gold/parser/current