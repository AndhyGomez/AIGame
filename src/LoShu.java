package aiGame;
import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



public class LoShu extends AIGame

{

	private static final int ROWSCOLS = 0;

	// Initialize variables

	static int matrixRows;

	static int matrixCols = matrixRows;

	

	/**

	 * Description: Create a constructor that initializes the puzzle

	 * 

	 * @param filePath

	 * @throws FileNotFoundException

	 * @throws IOException

	 */

	public LoShu(String filePath) throws FileNotFoundException, IOException 

	{

		super(filePath);

		readPuzzle(filePath);

	}



	/**

	 * @param args

	 */

	public static void main(String[] args) 

	{
		Scanner userInput = new Scanner(System.in);//A scanner for user input

		int[][] userSquare = new int[3][3];//Defining the Magic Square's array
		
		System.out.print("\nEnter \"start\" to begin\n>");//Prompt

		if(userInput.nextLine().toLowerCase().equals("start")){//I would have preferred to do just a menu to select game modes, but this was required

			

			System.out.println("Menu (1/2/3)");//I added this menu for debugging, but i think it is a useful function

			System.out.println("1. Enter a Magic Square");

			System.out.println("2. Generate a Magic Square");

			System.out.println("3. Exit");

			switch(userInput.nextInt()){//The menu switch

			case 1:

				userSquare = enterSquare(userSquare);//Get the user Square

				if (isMagicSquare(userSquare)){

					System.out.println("Congrats! You made a Magic Square");//Square works

					System.out.println("You entered: ");

					displayMagicSquare(userSquare);//Display user square

				} else {

					System.out.println("I'm sorry, you did not make a Magic Square");//Square dosn't work

					System.out.println("You entered: ");

					displayMagicSquare(userSquare);//Display user square

				}

				break;

			case 2:

				do{

				userSquare = fillMatrix();

				}while(!isMagicSquare(userSquare));//Keep generating matrix's until they work

				

				System.out.println("Congrats! You discovered a new Magic Square");

				System.out.println("We generated: ");

				displayMagicSquare(userSquare);//Display the new square

				break;

			case 3:

				System.out.println("GoodBye then");//User exit

				break;

			default:

				System.out.println("Error, Invalid Input.\nAborting");//Invalid input

				break;

			}

		}else{

			System.out.println("Goodbye");//end

		}

		userInput.close();
	}



	public int getMatrixSize()

	{

		// Need file to see how to get size 

		

		return matrixRows;

	}

	

	/**

	 * Description: Reads puzzle from filePath

	 * 

	 * @param filePath name of file to be read as a String data type

	 * @return 2D array read from file

	 * @throws IOException

	 * @throws FileNotFoundException

	 */

	int[][] readPuzzle(String filePath) throws IOException, FileNotFoundException

	{	

		// Create scanner buffered reader and file reader to read desired file

		Scanner thisFile = new Scanner(new File(filePath));

		for(int row = 0; row < ROWSCOLS; row++)

		{

			for(int col = 0; col < ROWSCOLS; col++)

			{

				if(thisFile.hasNextInt())

				{

					grid[row][col] = thisFile.nextInt();				

				}

			}	

		}

		thisFile.close(); // Close the file

		

		return grid;

	}

	

	/**

	 * Description: Calculates the sum of a desired row in a 2D array

	 * 

	 * @param array a two-dimensional array

	 * @param row the index of the row you would like to add

	 * @return int value for sum of desired row

	 */

	public static int sumRow(int[][] array, int row)

	{

		int rowSum = 0;

		

		for(int col = 0; col < array[0].length; col++)

		{

			rowSum += array[row][col];

		}

		

		return rowSum;

	}

	

	/**

	 * Description: Calculates the sum of a desired column in a 2D array

	 * 

	 * @param array a two-dimensional array

	 * @param col the index of the column you would like add

	 * @return int value for sum of desired column

	 */

	public static int sumCol(int[][] array, int col)

	{

		int colSum = 0;

		

		for(int row = 0; row < array.length; row++)

		{

			colSum += array[row][col];

		}

		

		return colSum;

	}

	

	/**

	 * Description: Calculates the sum of the primary diagonal in a 2D array

	 * 

	 * @param array a two-dimensional array

	 * @return sum of the first diagonal in a square matrix

	 */

	public static int sumPrimaryDiagonal(int[][] array)

	{

		int diagonalSum1 = 0;

		

		for(int row = 0; row < array.length; row++)

		{

			for(int col = 0; col < array[0].length; col++)

			{

				if(row == col) // row must equal column to be a diagonal

				{

					diagonalSum1 += array[row][col];

				}

			}

		}

		

		return diagonalSum1;

	}

	

	/**

	 * Description: Calculates the sum of the secondary diagonal in a 2D array

	 * 

	 * @param array a two-dimensional array

	 * @return sum of the second diagonal in a square matrix

	 */

	public static int sumSecondDiagonal(int[][] array)

	{

		int diagonalSum1 = 0;

		

		for(int row = 0; row < array.length; row++)

		{

			for(int col = 0; col < array[0].length; col++)

			{

				// row must be equal to the number of rows - column - 1 to be diagonal

				if(row == array.length - col - 1) 

				{

					diagonalSum1 += array[row][col];

				}

			}

		}

		

		return diagonalSum1;

	}
	
	public static int[][] enterSquare(int[][] userArray){

		Scanner userInput = new Scanner(System.in);//A scanner for user input

		

		for(int i = 0; i < userArray.length; i++){//Get all the values

			for(int p = 0; p < userArray[0].length; p++){

				System.out.println("Please enter row " + i + " column " + p);

				userArray[i][p] = userInput.nextInt();

			}

		}

		

		userInput.close();

		return userArray;

	}
	
	public static boolean isUnique(int [][] userArray, int value){//Checks if num exists in the array, if it returns false (Why false? Why not true?)

		for(int i = 0; i < userArray.length; i++){

			for(int p = 0; p < userArray[0].length; p++){

				if (userArray[i][p] == value){

					return false;//match

				}

			}

		}

		return true;//No match

	}

	

	public static void displayMagicSquare(int [][] userArray){//Prints the square

		for(int i = 0; i < userArray.length; i++){

			for(int p = 0; p < userArray[0].length; p++){

				System.out.print(String.format("%1$4s",userArray[i][p]));//Print, with added white space

			}

			System.out.println();//Return line for formatting

		}

	}

	

	public static int[][]  fillMatrix(){//Randomly fills the array

		Random r = new Random();//Our random generator

		int[][] userArray = {{9,1,2},{3,4,5},{6,7,8}};//The base user array

		int[] index1 = {0,0}, index2 = {0,0};//The index numbers

		int temp;//temp int Storage

		

		for(int i = 0; i < 50; i++){//Shuffle 50 times

			index1[0] = r.nextInt(3);//Generate location 1 x

			index1[1] = r.nextInt(3);//Generate location 1 y

			index2[0] = r.nextInt(3);//Generate location 2 x

			index2[1] = r.nextInt(3);//Generate location 2 y

			

			//Rotating the ints

			temp = userArray[index1[0]][index1[1]];

			userArray[index1[0]][index1[1]] = userArray[index2[0]][index2[1]];

			userArray[index2[0]][index2[1]] = temp;

		}

		

		/*

		 * 	Doing it the shuffle way makes sure we get a matrix without repeating numbers.

		 *  This saves us time when finding squares 

		 */

		

		return userArray;//Returned the random matrix

	}

	

	public static Boolean isMagicSquare(int [][]userArray){//Returns true if it is a magic square

		if (sumRow(userArray, matrixCols) != -1 && sumRow(userArray, matrixCols) == sumCol(userArray, matrixCols) && sumPrimaryDiagonal(userArray) == sumSecondDiagonal(userArray)){//Checks to see if they work

			for (int i = 1; i < 9; i++){

				if(isUnique(userArray, i)){

					return false;//What will be printed if they fail the test

				}

			}

			return true;//What will be printed if they pass both tests

		}

		return false;//What will be printed if they fail the column, diagonal, and row tests

	}


}
