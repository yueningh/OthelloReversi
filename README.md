# OthelloReversi
**Table of Contents**
<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [OthelloReversi](#OthelloReversi)
	- [Introduction](#Introduction)
  - [Features](#Features)
  - [Rules](#Rules)
  - [Valid Moves](#Valid-Moves)

<!-- /TOC -->


## Introduction

Othello, a specific variant of Reversi, is a two-player strategy game played on an 8x8 board using discs that are colored white on one side and black. 
One player plays the black disc while his opponent plays the white disc.

## Features
- Select custum board size of N by N. 
- Can be played against the computer or among 2 players. 


## Rules

The game alternates between white and black until:
- one player can not make a valid move to outflank the opponent.
- both players have no valid moves.

When a player has no valid moves, he pass his turn and the opponent continues.
A player can not voluntarily forfeit his turn.

At the end of the game, the player with the most pieces on the board wins.


## Valid Moves
> Black always moves first.
>
> A move is made by placing a disc of the player's color on the board in a position that "out-flanks" one or more of the opponent's discs.
>
> A disc or row of discs is outflanked when it is surrounded at the ends by discs of the opposite color.
>
> A disc may outflank any number of discs in one or more rows in any direction (horizontal, vertical, diagonal).
>
> Discs may only be outflanked as a direct result of a move and must fall in the direct line of the disc being played.
> 
> If you can't outflank and flip at least one opposing disc, you must pass your turn. However, if a move is available to you, you can't forfeit your turn.
>
> Once a disc has been placed on a square, it can never be moved to another square later in the game. 
>
[Source](https://www.ultraboardgames.com/othello/game-rules.php)

