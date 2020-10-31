@Test
Feature: creating a project with an automated test suite


Scenario: Check output window is displayed for the user
Given user is on the web page
When user clicks run button
Then output window with Hello World text is displayed



Scenario Outline: Check output window is displayed for the user2
Given user is on the web page
When user first name "<firstName>" starts with any of the characters "<characters>"
Then the appropriate web UI actions will be appeared
Examples:
|firstName|characters|
#|Andrew|A-B-C-D-E|
#|Fan|F-G-H-I-J-K|
#|LIN|L-M-N-O-P|
|SUDHEER|Q-R-S-T-U|
#|VIN|V-W-X-Y-Z|

#uncomment the other examples to test the functionality for firstnames starting with different characters