/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: This is an easier version of problem 67. The same solution was used for problem 67. 
*/

import java.io.*;

public class Eighteen 
{	
	int _answer; 
	int _size; 
	int [][]_triangle;
	public Eighteen() 
	{
		ReadInput("triangle.txt"); 
		CalculateMaximum(); 
	}

	private void ReadInput(String src)
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			
			int count=0; 
			while(br.readLine() != null){  	
				count++;
			}
			_size = count;                       
			br.close();
        
			System.out.println(" num of lines " + count); 
			
			_triangle = new int[count][count];
			BufferedReader br2=new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			
			int i = 0; 
			String[] words;
			while (true){
				String line = br2.readLine(); 
				if (line == null)
					break;
				words = line.split(" ");
				for (int j = 0; j < words.length; j++)
				{
					_triangle[i][j] = Integer.parseInt(words[j]);
					//System.out.print(_triangle[i][j] + " "); 
				}
				//System.out.print("\n"); 
				i++; 
			}
        br2.close();
		}
		catch(Exception e){
			System.err.println("Error: Target File Cannot Be Read");
		}
	}
	
	public void CalculateMaximum(){
		_triangle[1][0] += _triangle[0][0];
		_triangle[1][1] += _triangle[0][0];
		
		for (int i = 2; i < _size; i++)
		{
			for (int j = 0; j <= i ; j++){
				if (j == 0)				
					_triangle[i][j] += _triangle[i-1][j]; 
				else if (j == i)
					_triangle[i][j] += _triangle[i-1][j-1];
				else{
					_triangle[i][j] += _triangle[i-1][j-1]>_triangle[i-1][j]?_triangle[i-1][j-1]:_triangle[i-1][j];
				}
			}
		}
		
		//for (int i = 0; i < _size; i++){
		//	for (int j = 0; j <= i ; j++)
		//		System.out.print(_triangle[i][j] + " "); 
		//	System.out.print("\n"); 
		//}
		
		_answer = 0; 
		for (int k = 0; k < _size; k++)
			_answer =_triangle[_size-1][k] > _answer?_triangle[_size-1][k]:_answer;
	}
	
	public int getAnswer(){
		return _answer; 
	}

	public static void main(String args[]){
		Eighteen s = new Eighteen();
		
		System.out.println("\nThe answer is " + s.getAnswer()+".");
	}
}

