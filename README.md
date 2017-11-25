# Crystal plugin for the IntelliJ Platform


[![Build Status](https://travis-ci.org/intellij-crystal/intellij-crystal.svg?branch=master)](https://travis-ci.org/intellij-crystal/intellij-crystal)
[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)


## Status

This plugin is still in the **early stages of development** so only has a handful of features. But over time things will stabilize and more features will be added. Currently 
only the lexer and some very basic syntax highlighting are done - see screenshot below.
 
 
## Usage

Visit [intellij-crystal.github.io] to find documentation about installation and features.

* Initial syntax highlighting

![example](https://github.com/intellij-crystal/intellij-crystal/raw/master/.README/ex1.png)

* Initial AST tree for parser / grammar

![example](https://github.com/intellij-crystal/intellij-crystal/raw/master/.README/ast1.png)

## Roadmap

To track the progress [see the agile board here](https://tzatziki.io/b/zbcwdZLjAZa8wQdxX/intellij-crystal)

The following features will evolve over the next few months:

* full lexer - with tests
* full grammar parser - with tests
* default syntax highlighting color scheme - based on Atom light theme
* darcula syntax highlighting color scheme - based on Atom dark theme
* working commenter
* Go to definition
* jump to implementation
* refactor - rename

Features for later on:

* crystal intellij project type
* compiler support and run configurations
* code formatting
* code auto completion

## Releases

* An initial alpha release with just the lexer and basic syntax highlighting is in the [Jetbrains plugin repo](https://plugins.jetbrains.com/plugin/10213-crystal-language-plugin)
* Hopefully there will be a release every few months going forward 

## FAQ

coming soon 

## Compatible Jetbrains Products

| IntelliJ                  |
|---------------------------|
| 2017.2                    |


## Contributing
 
coming soon 

### Dev

1. clone the repo
2. ./gradlew idea
3. ./gradlew build
4. open in intellij

### Testing notes

* to regenerate the parser and lexer run: ./regenerate.sh 

for the parser:

* checkout the crystal source code

```
git clone https://github.com/crystal-lang/crystal.git
```

* copy all the cr files into a new dir

```
 cd crystal
 mkdir cr_code
 find . -name \*.cr -exec cp {} cr_code \;
 mv cr_code/*.cr path/to/intellij-crystal/src/test/resources/gold/parser/
``` 
