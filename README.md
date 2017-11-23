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

## FAQ

coming soon 

## Compatible Jetbrains Products

| IntelliJ                  |
|---------------------------|
| 2017.1.2                  |
| 2017.1.1                  | 
| 2017.1                    | 
| Latest EAP                | 


## Contributing
 
coming soon 

### Dev

1. clone the repo
2. ./gradlew idea
3. ./generate_parser.sh
4. ./gradlew build
5. open in intellij

### Testing notes

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
