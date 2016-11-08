Fallout 4 terminal hacking helper
=================================
Fallout 4 is an action role-playing video game developed by Bethesda Game Studios
This little console Java app helps with an ingame task "hacking" terminals.

Description
-----------
"Hacking terminals" is basically a mini-game within the game, where the player has to guess the right password from a pool of potential passwords.
Every time the user guess fails the user gets a feedback. The user has 4 guesses.

* User has to input all potential passwords to this console app from Fallout 4
* If all potential passwords are entered in this app the user can start guessing by pressing ENTER on an empty input
* The games provides a feedback in the form of a "Likeliness"  for each failed guess
* This feedback is a number from 0 -> word length-1
* This app uses this feedback provided by the game to cross out passwords that cannot be the solution

Notes
-----
Based on my experience the in-game task is so simple that it can always be solved by correctly understanding what "Likeliness" is. This is what my app does

Likeliness
----------
Likeliness is an integer measure of char-by-char exact similarity of a proposed password and the actual password

If the password is: FOOBAR, (length = 6)
Then the similarity of the following words are:
FOOBAR 6
RFOOBA 1
BOOFAR 4
