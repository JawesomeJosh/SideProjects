import java.util.Scanner;

public class MagicSquare {

	private int[][] magicsquare;
	private int[] totals;
	
	public MagicSquare() {
		initializeMS();
		this.totals = getTotals();
	}
	
	public MagicSquare(int[][] array) {
		this.magicsquare = array;
		this.totals = getTotals();
	}
	
	public void initializeMS() {
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
		this.magicsquare = array;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				result.append(this.magicsquare[i][j] + " ");
			}
			result.append("\n");
		}
		return result.toString() + "\n" + totals2String();
	}
	
	public static boolean checkSquare(int[][] array) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(array[i][j] < 1) {return false;}
				if(array[i][j] > 9) {return false;}
			}
		}
		return true;
	}
	
	public int[] getTotals() {
		int[] result = new int[8];
		result[0] = magicsquare[0][0] + magicsquare[0][1] + magicsquare[0][2];
		result[1] = magicsquare[1][0] + magicsquare[1][1] + magicsquare[1][2];
		result[2] = magicsquare[2][0] + magicsquare[2][1] + magicsquare[2][2];
		result[3] = magicsquare[0][0] + magicsquare[1][0] + magicsquare[2][0];
		result[4] = magicsquare[0][1] + magicsquare[1][1] + magicsquare[2][1];
		result[5] = magicsquare[0][2] + magicsquare[1][2] + magicsquare[2][2];
		result[6] = magicsquare[0][0] + magicsquare[1][1] + magicsquare[2][2];
		result[7] = magicsquare[0][2] + magicsquare[1][1] + magicsquare[2][0];
		return result;
	}
	
	public String totals2String() {
		StringBuilder result = new StringBuilder();
		result.append("totals: ");
		for(int i = 0; i < 8; i++) {
			result.append(this.totals[i]);
			if(i < 7) {result.append(", ");}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		int[][] array = {{5,5,5},{5,5,5},{5,5,4}};
		MagicSquare ms = new MagicSquare(array);
		System.out.println(ms);
	}
}
