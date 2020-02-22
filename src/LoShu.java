import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoShu extends AIGame
{
	// Initialize variables
	int matrixRows;
	int matrixCols = matrixRows;
	
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
		// TODO Auto-generated method stub

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
		/*
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
		*/
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

}
