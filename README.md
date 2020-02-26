# AIGame
Demo of inheritance, creating an AIGame abstract base class with two derived classes, Sudoku and LoShu

![JFrameSS](https://user-images.githubusercontent.com/47075449/75302413-b69f5000-580b-11ea-84b4-ae37b6619e53.png)

## Steps to Compile: (From command line)
#### **REQUIRES JAVA TO ALREADY BE INSTALLED ON YOUR MACHINE**
1. Download project as zip 
2. A) Windows 
     * Extract AIGame-Master folder
     * Copy path to within src folder
     
   B) MacOs
     * Copy path to within src folder 
3. A) Windows
     * Open Command Prompt
     * cd ctrl + v (Redirects you to src folder.)
     * javac Sudoku.java or LoShu.java (Depending on which you'd like to run.)
     * java Sudoku/LoShu *../fileName* (Whichever was chosen from the above step)
     
   B) MacOs
     * Open Terminal
     * cd cmd + v (Redirects you to src folder.)
     * javac AIGame.java and javac Sudoku.java or LoShu.java (Depending on which you'd like to run.)
     * java Sudoku/LoShu *../fileName* (Whichever was chosen from the above step)
 
## Files: 
### AIGame-Master/
* s01a.txt
* s02a.txt
* s03a.txt
* s04a.txt
* s05a.txt
* loshu1.txt
* loshu2.txt

### src/
* AIGame.java 
  * Abstract base class
  
* Sudoku.java 
  * Contains logic/algorithms for the sudoku game 
  
* LoShu.java 
  * Contains logic/algorithms for the LoShu game 

## Note: 
1. File to be read must be outside of src folder and must have the format seen below. (Both for Sudoku and LoShu)

0 4 0 0 0 0 1 7 9 

0 0 2 0 0 8 0 5 4 

0 0 6 0 0 5 0 0 8 

0 8 0 0 7 0 9 1 0 

0 5 0 0 9 0 0 3 0 

0 1 9 0 6 0 0 4 0 

3 0 0 4 0 0 7 0 0 

5 7 0 1 0 0 2 0 0 

9 2 8 0 0 0 0 6 0

**LoShu can be N x N size, Sudoku must be 9 x 9.**

2. Change the fileName to the name of whichever file you would like to read, it is passed as an argument to whichever game you choose to run.
