import java.util.Scanner;

public class MagicSquare {

	private int[][] magicsquare; // is the matrix that represents all the elements of the magic square
	private int[] totals; // an array of 8 that represents the totals
								// 0 - 2 are rows 0-2
								// 3 - 5 are columns 0-2
								// 6 is diagonal left top to right bottom
								// 7 is diagonal right top to left bottom
	
	public MagicSquare() { // creates a magic square
		initializeMS();
		setTotals();
	}
	
	public MagicSquare(int[][] array) throws Exception { // checks to see if the given is the correct size 
														//throws an exception if it isnt
										// creates a magic square from given input then sets total
		if(array.length != 3) {throw new Exception("Not Correct size");}
		for(int i = 0; i <3; i++) {
			if(array[i].length != 3) {throw new Exception("Not correct size");}	
		}
		this.magicsquare = array;
		setTotals();
	}
	
	// getters and setters
	
	public int[][] getMS(){
		return this.getMS();
	}
	
	public int[] getTotals() {
		return this.totals;
	}
	
	public void setMS(int[][] array) {
		this.magicsquare = array;
		setTotals();
	}
	
	public void setTotals() { // creates the totals attribute based off of the magicsquare attribute
		int[] result = new int[8];
		result[0] = magicsquare[0][0] + magicsquare[0][1] + magicsquare[0][2];
		result[1] = magicsquare[1][0] + magicsquare[1][1] + magicsquare[1][2];
		result[2] = magicsquare[2][0] + magicsquare[2][1] + magicsquare[2][2];
		result[3] = magicsquare[0][0] + magicsquare[1][0] + magicsquare[2][0];
		result[4] = magicsquare[0][1] + magicsquare[1][1] + magicsquare[2][1];
		result[5] = magicsquare[0][2] + magicsquare[1][2] + magicsquare[2][2];
		result[6] = magicsquare[0][0] + magicsquare[1][1] + magicsquare[2][2];
		result[7] = magicsquare[0][2] + magicsquare[1][1] + magicsquare[2][0];
		this.totals = result;
	}
	
	// other methods
	
	public void initializeMS() { // If the magic square is not given, it creates a scanner and prompts user for input
		// also checks to make sure the inputs are correct according to magic square rules
		Scanner scan = new Scanner(System.in);
		int[][] array = new int[3][3];
		boolean test = true;
		while(test) {
			System.out.println("Please enter your magic square");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					array[i][j] = scan.nextInt();
				}
			}
			if(checkSquare(array)) {
				test = false;
			}
			else {
				System.out.println("One element out of context, only int inclusive between 1-9 are allowed.");
			}
		}
		scan.close();
		this.magicsquare = array;
	}
	
	
	public static boolean checkSquare(int[][] array) { // checks to make sure every element in the square is 1-9 inclusive
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(array[i][j] < 1) {return false;}
				if(array[i][j] > 9) {return false;}
			}
		}
		return true;
	}
	
	
	public String totals2String() { // pushes the total from MagicSquare to a string
		StringBuilder result = new StringBuilder();
		result.append("totals: ");
		for(int i = 0; i < 8; i++) {
			result.append(this.totals[i]);
			if(i < 7) {result.append(", ");}
		}
		return result.toString();
	}
	
	public int makeChange(int row, int col, int value) {
		// makes a change for a specific element in the MS,
			// if row, col, or value are out of bounds returns 0 and makes no change
			// bounds are INCLUSIVE as follows...
					// row -> 0 - 2
					// col -> 0 - 2
					// value -> 1 - 9
		// return variable is the cost of making the change, i.e. absolute difference between element and value
		int cost = 0;
		if(row < 0 || row > 2) {return cost;}
		else if(col < 0 || col > 2) {return cost;}
		else if(value < 1 || value > 9) {return cost;}
		else {
			cost = Math.abs(magicsquare[row][col] - value);
			magicsquare[row][col] = value;
			setTotals();
		}
		return cost;
	}
	
	@Override
	public String toString() { // overrode the toString method
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				result.append(this.magicsquare[i][j] + " ");
			}
			result.append("\n");
		}
		return result.toString() + "\n" + totals2String();
	}
	
	public static void main(String[] args) throws Exception {
		int[][] array = {{5,5,5},{5,5,5},{5,5,4}};
		MagicSquare ms = new MagicSquare(array);
		System.out.println(ms);
		
		ms.makeChange(0, 1, 8);
		System.out.println(ms);
	}
}
