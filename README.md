# A basic guide to LeagueScript
# Note Boolean variables will cause bugs!!
## Introduction
LeagueScript is a WIP language developed in Java. It is based off of the popular videogame League of Legends
and is designed to be a lightweight and easy to use scripting language.
> - All leaguescript files have the file extension `.lols`

## Installation

WIP

## Syntax
> All tokens must have spaces separating them

### Comments
> Comments start with a ? and can only be one line long
#### Example:
```
? Hello this is a comment
? Hello this makes this comment 2 lines
```
---
### Variables
>  - Variables are defined with the `item` keyword
>  - Initialize variables with `$` before the variable name.
>  - Variables can be accessed with their variable names.
> - Variables can also store calculations.
> - All variables must have their types defined after the last character Ex: `item $var1 10:int`, `item $var1 hello:str` and `item $var1 true:bool`.
#### Examples:
```
item $var1 10:int
item $var2 5 + $var1:int
```
---
### Printing
> - The keyword for printing is `openchat`.
#### Example:
```
openchat 10
```
> - this would print out the number 10.
---
### User input
> - User input is defined by using the `teamfight` keyword.
> - User input must be of type `str` and be initialized into a variable.
#### Examples:
```
item $var teamfight:str
```
> This would instantiate user input for the variable `$var`
---
### If Statements
> - In leaguescript all if statements have the keyword `facecheck`.
> - All if statements must have a boolean operator after them, and must be in the form arg1 operator arg2 where arg1 and arg2 are data types or variables, and an operator is a valid operator from `==` `<=` `>=` `!=` `>` and `<`.
> - if statement arguments can vary in length.
> - if an if statement argument contains more than 3 inputs, the fourth input must be a logical operator from `&&` or `||`.
> - the keyword `endcheck` acts as a closing bracket to an if statement
#### Examples
```
facecheck -1 < 0 || 7 > 7
openchat $lol
endcheck
```
> Here the value stored in `$lol` would be printed out since the if statement is `true`.
```
facecheck -1 == 0 || 7 > 7
openchat $lol
endcheck
```
> Here, nothing would be printed out since the if statement is `false`.
---

## Code example
> - An example file can be found in `script.lols`.
---
# This project is being developed by Neil Hommes (CygnusX-26)
> - Pull requests are appreciated!!


