import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoShu extends AIGame
{	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		int size;

		//Check needs to be added to test for no arguments, or too many arguments.
		// Variable to hold name of file
		String fileName = args[0];
		
		System.out.println(fileName);

		//Get size and initialize grid to size.
		size = getMatrixSize(fileName);
		
		grid = new int[size] [size];
		
		// Create a new instance of a LoShu puzzle
		LoShu puzzle = new LoShu(fileName);

		System.out.println(size);
		
		//grid = new int[size][size];
		
		puzzle.readPuzzle(fileName);
		
		// Print out solved puzzle
		System.out.println(puzzle.toString());
		//puzzle.displayMatrix(grid);
	}
	
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
	
	
	public static int getMatrixSize(String filePath) throws FileNotFoundException, IOException
	{
		int size;
		
		//Initialize a new scanner object to the file, read a line from the file, split it and pass the size of the array
		//as the size of the grid.
		size = (new Scanner(new File(filePath))).nextLine().split(" ").length;

		return size;
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
		File inputFile = new File(filePath);
		if(inputFile.exists()) {
			// Create scanner buffered reader and file reader to read desired file
			Scanner thisFile = new Scanner(inputFile);

			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (thisFile.hasNextInt()) {
						grid[row][col] = thisFile.nextInt();
					}
				}
			}

			thisFile.close();
		}// Close the file
		
		return grid;
	}
	
	/**
	 * Description: Calculates the sum of a desired row in a 2D array
	 * 
	 * @param array a two-dimensional array
	 * @param row the index of the row you would like to add
	 * @return int value for sum of desired row
	 */
	public int sumRow(int[][] array, int row)
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


	/**
	 * Description: Displays matrix as a string
	 * 
	 * @return 2D array as a string
	 */
	public String toString()
	{
		String arrayString = "";
		
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				arrayString += (grid[row][col] + " ");
			
				if(col == (grid.length - 1))
				{
					arrayString += "\n";
				}
			}			
		}
	
		return arrayString;	
	}
}

