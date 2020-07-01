package Algorithm;

public class Skyscraper {
  	/*private static int[] clues =
  	 0 0  0  2  2  0  0  0  0  6  3  0 0  4  0  0  0  0  4  4  0  3  0  0
  	 0 3 0 5 3 4  0  0  0  0  0  1 0  3  0  3  2  3  3 2  0  3  1  0
  	 3 2  2  3  2  1  1  2  3  3  2  2 5  1  2  2  4  3  3  2  1  2  2  4
	   
	   */
   
   
	private boolean[][] columnUsedNumbers;
	private boolean[][] rowUsedNumbers;
	private int[][] rows;
	private int[][] columns;
	private int[][] splittedClues;
	private final int SIZE = 6;
	
	public int[][] solution = null;
	
	public Skyscraper(int[] clues) {
		columnUsedNumbers = new boolean[SIZE][SIZE];
		rowUsedNumbers = new boolean[SIZE][SIZE];
		rows = new int[SIZE][SIZE];
		columns = new int[SIZE][SIZE];
		splittedClues = splitClues(clues);
		
		solution = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				solution[i][j] =-1;
				rows[i][j] = -1;
				columns[i][j] = -1;
			}
		}
	}

	public String solvedMessage = "";
	public void solve() {
		if (solveRecursive(0, 0, solution)) {
			solvedMessage = getSolution();
		} else solvedMessage = "Can't be solved with these clues";
	}
	/*	TÃ¬m hÃ ng, cá»™t cá»§a má»™t Ã´ chÆ°a Ä‘Æ°á»£c gÃ¡n
	Náº¿u khÃ´ng cÃ³, tráº£ vá»� true
	Cho cÃ¡c chá»¯ sá»‘ tá»« 1 Ä‘áº¿n 6
    -Náº¿u thá»�a mÃ£n vá»� chá»¯ sá»‘ á»Ÿ hÃ ng, cá»™t gÃ¡n chá»¯ sá»‘ cho hÃ ng, cá»™t vÃ  Ä‘á»‡ quy thá»­ Ä‘iá»�n vÃ o pháº§n cÃ²n láº¡i cá»§a cÃ¡c Ã´ vuÃ´ng trong lÆ°á»›i
   - Náº¿u Ä‘á»‡ quy thÃ nh cÃ´ng, tráº£ vá»� Ä‘Ãºng.
    KhÃ¡c, loáº¡i bá»� chá»¯ sá»‘ vÃ  thá»­ cÃ¡i khÃ¡c
	Náº¿u táº¥t cáº£ cÃ¡c chá»¯ sá»‘ Ä‘Ã£ Ä‘Æ°á»£c thá»­ vÃ  khÃ´ng cÃ³ gÃ¬ hoáº¡t Ä‘á»™ng, tráº£ vá»� false  */
	 
	private boolean solveRecursive(int i, int j, int[][] solution) 
	{
		if (j == solution[i].length) 
		{
			if(i == solution.length - 1)
				return true;

			j = 0;
			i++;
		}

		boolean solved = false;
		int number = 1;
		int arrNumber;

		do {
			arrNumber = number -1;
			if((!rowUsedNumbers[i][arrNumber] && !columnUsedNumbers[j][arrNumber])) {
				solution[i][j] = number;
				rows[i][j] = number;
				columns[j][i] = number;
				rowUsedNumbers[i][arrNumber] = true;
				columnUsedNumbers[j][arrNumber] = true;

				solved = validateClues(splittedClues, i, j) && solveRecursive(i, j + 1, solution);

				if (!solved) {
					solution[i][j] = -1;
					rows[i][j] = -1;
					columns[j][i] = -1;
					rowUsedNumbers[i][number - 1] = false;
					columnUsedNumbers[j][number - 1] = false;
				}
			}
			number++;
		} while (!solved && number <= SIZE);

		return solved;
	}
      // chia clues thÃ nh 4 máº£ng 1 chiá»�u 
	private int[][] splitClues(int[] clues) {
		int[][] splittedClues = new int[4][SIZE];
		for (int i = 0; i < clues.length; i++) {
			splittedClues[i / SIZE][i % SIZE] = clues[i];
		}
		splittedClues[2] = Reverse(splittedClues[2]);
		splittedClues[3] = Reverse(splittedClues[3]);
		return splittedClues;
	}

	private boolean validateClue(int clue, int[] values, boolean reverse) 
	{
		if(reverse)
			values = Reverse(values);

		// Not enough values
		if(values[0] == -1)
			return true;

		int evalLength = 0;
		int max = 0;
		int count = 0;
		for (int value : values) {
			if(value != -1) {
				evalLength++;
				if (value > max) {
					count++;
					max = value;
				}
			}
		}

		if(evalLength < clue || (count < clue && max != SIZE))
			return true;

		return count == clue && max == SIZE;
	}
   
	private boolean validateClues(int[][] clues, int r, int c) {
		// Top to bottom
		if (clues[0][c] != 0 && !validateClue(clues[0][c], columns[c], false))
			return false;

		// Right to left
		if (clues[1][r] != 0 && !validateClue(clues[1][r], rows[r], true))
			return false;

		// Bottom to top
		if (clues[2][c] != 0 && !validateClue(clues[2][c], columns[c], true))
			return false;

		// Left to right
		return clues[3][r] == 0 || validateClue(clues[3][r], rows[r], false);

	}
    // Ä‘áº£o ngÆ°á»£c 
	private int[] Reverse(int[] arr) {
		int[] newArr = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			newArr[j] = arr[i];
			j++;
		}
		return newArr;
	}
	
	private String getSolution() {
		String sol = "";
		for (int j = 0; j < solution.length; j++) {
			sol += ("     ");
			for (int k = 0; k < 3; k++) {
				sol += ("     ");
			}
		}
		sol += "\r\n";

		for (int[] ints : solution) {
			sol += ("     ");
			for (int j = 0; j < solution.length; j++) {
				sol += (ints[j] + "     " + (j == solution.length - 1 ? "" : "     "));
			}
			sol += "\r\n\n";
		}
		sol += "\r\n\n";
		
		return sol;
	}
}
