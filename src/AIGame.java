import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Andhy Gomez & Matthew Montada
 * St. Thomas University
 * 
 * Description: Demo of inheritance, creating an
 * AIGame abstract base class with two derived classes, Sudoku and LoShu
 * 
 * ***NOTE***
 * -> files to be read can NOT be in src folder
 * 
 * @param
 */
public abstract class AIGame 
{
	public String version;
	protected static int[][] grid;
	
	// Will be overridden by either LoShu or Sudoku
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{}
	
	/**
	 * Description: Loads the file into the grid
	 * 
	 * @param filePath path to the file as a string
	 */
	public AIGame(String filePath) throws FileNotFoundException, IOException 
	{}
	
	protected int[][] solve()
	{
		return grid;
	}
	
	/**
	 * Description: Returns true if the grid solution is valid, false otherwise
	 * 
	 * @return true or false depending on validity of solution
	 */
	public boolean isValid()
	{
		return false;
	}
	
	/**
	 * Description: Displays matrix as a string
	 * 
	 * @return 2D array as a string
	 */
	public String toString()
	{
		return version;

	}
	
}
