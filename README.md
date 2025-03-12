## CONNECT 4

The actual "strategy" is actually rather complex and involves exhaustive search at points to deal with tactics, so it's not practical to use by hand.

On the other hand, the strategic insights and some general-purpose rules are easy to use for a human, and will probably make you a relatively good player.

**Background**

Let's start by quickly reviewing connect-4. The game is played on a 6 × 7 board; we can label each row with a number and each gcolumn with a letter:

![](https://qph.cf2.quoracdn.net/main-qimg-b812b227ce84ac42c596f5d62661aea5)

Each player takes turns to choose a column; their stone is placed at the bottom-most open cell in the column. We can write a game using just the columns; for example, if both players play the central column we can write `dd`. This would lead to the following board:

![](https://qph.cf2.quoracdn.net/main-qimg-30f34a00d25eca5eb3276fa9ac3edba4)

(By convention, player 1 will be blue and player 2 red.)

A game can be won by connecting four pieces of your color horizontally, vertically or diagonally:

![](https://qph.cf2.quoracdn.net/main-qimg-644ba0651119e56e9c713d6662d8911b)

One last useful notion is a threat, which is just three pieces in a row with the fourth square open (but not necessarily accessible). Here, blue has a threat in a diagonal:

![](https://qph.cf2.quoracdn.net/main-qimg-9c58d93d6581bf7832c9f90526d4da32)

**Strategy**

The game is solved: the first player (blue) can always force a win. The core ideas behind the winning strategy are pretty simple: controlling zugzwang and controlling odd/even rows.

**Zugzwang**

"Zugzwang" as a term means losing because you have to make a move. A simple illustration would be having two threats on top of each other. Here's an example of blue forcing a win on column c with red to move:

![](https://qph.cf2.quoracdn.net/main-qimg-1465d6ab750a4d3e8f8da09d7679fd84)

However, double threats like this are reasonably easy to recognize ahead of time and counter. In practice, a much more useful form of Zugzwang involves just waiting until the entire board is filled and there is only one possible move left. Consider the simple example where red wins on the left, with the actual force only happening after a bunch of moves:

![](https://qph.cf2.quoracdn.net/main-qimg-f6308488d3e4083f88e9e171ed6e1153)

**Even/Odd Threats**

Whoever has a threat that will inexorably be filled will win in the end. As we saw in the previous example, red can win with a threat in an even row. By contrast, blue needs an odd threat to win: this is where the asymmetry in the game emerges.

An odd threat "caps off" a column and essentially flips who can get which row when filling up the entire board. In particular, this means that a valid odd threat is "stronger" than a valid even threat: if blue has an odd threat in one column and red an even threat in another, blue will still win. Here's an example (blue to play):

![](https://qph.cf2.quoracdn.net/main-qimg-a0947d92e30462b671ea9af092a0b69c)

From this position, we can fill repeatedly until we get to a position where red has to play `c` because `g` (which has an odd number of pieces in it) would result in blue winning. This lets the `c` column fill up until red is forced to lose:

![](https://qph.cf2.quoracdn.net/main-qimg-dfa731632130a8e12f78dca5f846828a)

The odd threat "works" because it caps off a single column to have an odd number of positions—effectively turning the board from having an even number of squares (42) to an odd number, which flips the dynamics of the game. This also means that if both red and blue have independent odd threats, they cancel out: having two odd columns brings the total back to being even.

More generally, the odd/even distinction gives us a notion of control: red normally controls the game, but blue can gain control by establishing an odd threat. In practice, control means being able to play any even squares or, as an option, play an odd square but let your opponent play an even square in return.

**Tactics**

The odd/even distinction lets us play "strategically"—a bunch of moves ahead, at any rate. To actually win consistently, we have to combine our knowledge about long-term strategy with sound tactical short-term moves. We have to keep little traps like this in mind:

![](https://qph.cf2.quoracdn.net/main-qimg-bee1a7f6a6f94c6853c4bf94f04037e3)

**Rules**

The actual winning strategy for the game comes down to a set of nine rules based on the strategic principles covered earlier and tactics. The rules were developed by Victor Allis in 1988—I think he was the first person to solve the game.

The rules can't always find the optimal solution: sometimes, you would have to do an actual search through possibilities, largely to deal with tactical concerns.

Here are what I think are the most important rules, with the names Allis gave them. There are a few more rules, but they are either for special cases or just combinations of previous rules; you can read about all the rules in the actual thesis: [A Knowledge-based Approach of Connect Four](http://www.informatik.uni-trier.de/~fernau/DSL0607/Masterthesis-Viergewinnt.pdf "www.informatik.uni-trier.de").

* **baseinverse**: you can always claim one of two accessible squares when your opponent claims the other, so you can always block a four-in-a-row that needs two squares like that. For example, red can always play one of the green squares after blue plays the other:

![](https://qph.cf2.quoracdn.net/main-qimg-c339abda810cfee70d9953f2b39706fb)

* **vertical**: you can always block a vertical four-in-a-row by playing one of the two squares directly above each other. Red can always block the vertical four-in-a-row on `d` by playing one of the highlighted squares:

![](https://qph.cf2.quoracdn.net/main-qimg-a79bd6e91645df2421d0c8ede6b02c3e)

* **claimeven**: whoever has control of the game (ie red unless blue has an odd threat) can play a square in an even row (as long as that square isn't immediately playable). This rule embodies the basic odd/even strategy.
* **aftereven**: if you have control and have a threat in an even row, you will be able to play that row via claimeven. This means that any threats in the same column above that one are blocked. For example, here blue will not be able to play `b3` since red has a threat on `b2`:

![](https://qph.cf2.quoracdn.net/main-qimg-e87b30c61000e58f447ea65c050c9c06)

* **lowinverse**: if there are two columns with an odd number of open squares, the result is even. If there are two odd squares in such columns that are not directly playable, whoever controls the game will be able to play at least one of them. This can also apply to squares that are far from being playable and not next to each other. In these two simple examples, red can get at least one of the two highlighted squares:

![](https://qph.cf2.quoracdn.net/main-qimg-4b3e7d29abcba72706b6cf40f3cc263b)

**Winning**

The game was actually solved through a combination of these rules and some exhaustive searching—the rules by themselves are unfortunately not enough.

Many of the rules depend on having control of the game. Since red has control initially, blue cannot use many of the rules until they manage to establish an odd threat. Blue can establish an odd threat by using some of the rules that do not depend on having control or just tactical thinking like combining groups of two pieces to guarantee an odd threat in the future.

It turns out the first player can do this against optimal play as long as the first move is `d1`. This means the first player can always win. The search that actually established this is also detailed in the thesis.

For human players, this sort of logic is hard to work with. Happily, somebody else found a set of good openings which you can generally use: [Expert Play in Connect-Four](http://www.pomakis.com/c4/expert_play.html "www.pomakis.com").
