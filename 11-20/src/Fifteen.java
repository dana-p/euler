/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
*/

public class Fifteen 
{	
	private long _paths; 
	private int _matrixSize; 
	public Fifteen(int graphSize)
	{
		_matrixSize = graphSize+1; 
		// A 20x20 graph can be represented by a 21x21 matrix
		// Where each value represents the number of possible paths to that "node"
		
		long [][] matrix = new long[_matrixSize][_matrixSize];
		_paths = FillInMatrix(matrix); 
		
	}
	
	private long FillInMatrix(long [][] matrix)
	{
		// Fill in initial values 
		for (int a = 0; a < _matrixSize; a++){
			matrix[0][a] = 1; 
			matrix[a][0] = 1; 
		}
		for (int i = 1; i < _matrixSize; i++){
			for (int j = 1; j < _matrixSize; j++) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]; 
			}
		}
		
		for (int i = 0; i < _matrixSize; i++){
			for (int j = 0; j < _matrixSize; j++) {
					System.out.print(matrix[i][j]);
					System.out.print(" "); 
			}
			System.out.print("\n"); 
		}
		
		return matrix[_matrixSize-1][_matrixSize-1]; 
	}
	public long getAnswer(){
		return _paths; 
	}
	
	
	public static void main(String args[]){
		int graphSize = 20; 
		Fifteen f = new Fifteen(graphSize);
		
		System.out.println("The number of paths in a "+graphSize+"x"+graphSize+" graph is " + f.getAnswer()+".");
	}
}

