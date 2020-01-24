import java.util.Scanner;
import java.util.ArrayList;
/*
 * @Author: Marcelo Sanchez
 * @Version: 1/23/20
 * @CSCI 333: Algorithms & Data Structures
 * @TrinarySearch function
 */
public class Recursion {
	
	private static Scanner scan;
	private static int length;
	private static int[] array;
	private static String userChoice;

	public static void main(String[] args) {
			
		scan = new Scanner(System.in);	
		System.out.println("---------------------------------TRINARY SEARCH---------------------------------");
		System.out.println();
		System.out.println("Would you like to perform a Trinary Search? (y/n)");
		userChoice = scan.nextLine();
		while(userChoice.equals("y")) {						
			System.out.println("----------------------TODO: Enter the length of the array-----------------------");
			length = scan.nextInt();
			array = new int[length];
			System.out.println("Enter one int at a time. (Array must be sorted)");
						for(int i = 0; i < array.length; i++) {
							array[i] = scan.nextInt();
						}
			
			System.out.print("You entered:");
			System.out.print("[");
						for(int i = 0; i < array.length; i++) {
							
							System.out.print(array[i] + ", ");
						}
			System.out.println("]");
			
			System.out.println("Enter a target to perform a trinary search on.");
			int userTarget = scan.nextInt();
			int executeSearch = TrinarySearch(array, userTarget, 0, array.length -1);
			if(executeSearch == -1) {
				System.out.println("Target does not exist. " + executeSearch);
			}
			System.out.println(executeSearch);
			Scanner scanny = new Scanner(System.in);
			System.out.println("Do another search? (y/n)");
			userChoice = scanny.nextLine();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println();
		}
		System.out.println("Cool, bye!");
	}
	
	
	private static int TrinarySearch(int[] array, int target, int borderOne, int borderTwo) {
			
			if(borderOne < borderTwo) {
				int initialIndex = borderOne;
				int arraySize = (borderTwo - borderOne);				
				int oneThird = (((borderTwo - borderOne)/3));
				int twoThird = borderOne + (oneThird + oneThird);
				
				//------------for debugging--------------------//
//				System.out.println("initialIndex " + initialIndex);							
//				System.out.println("borderOne " + borderOne);
//				System.out.println("borderTwo " + borderTwo);
//				System.out.println("arraySize " + arraySize);
//				System.out.println("oneThird " + oneThird);
//				System.out.println("twoThird " + twoThird);			
//				System.out.println("________________________");	
				
				if(target == array[oneThird]) {
					System.out.println("Leftmost occurrence of " + target + " @ index [" + oneThird + "]");
					//System.out.println("Recursing the first 1/3...");
					//------debugging
					//return oneThird;
					return TrinarySearch(array, target, (initialIndex) + 1, oneThird);
				}
				if(target == array[twoThird]) {
					System.out.println("Leftmost occurrence of " + target + " @ index [" + twoThird + "]");
					//System.out.println("Recursing the first 2/3...");
					//--------debugging
					//return twoThird;
					return TrinarySearch(array, target, (initialIndex) + 1, twoThird);
				}
				if(target == array[borderOne]) {
					return borderOne;
				}
				if(target == array[borderTwo]) {
					//return borderTwo;
					System.out.println("Leftmost occurrence of " + target + " @ index @ [" + borderTwo + "]");
//					System.out.println("Recursing the array from the beginning");
					return TrinarySearch(array, target, (initialIndex) + 1, (borderTwo - 1));
				}									
						if(target < array[oneThird]) {
						//	System.out.println("less than 1/3");
							return TrinarySearch(array, target, (initialIndex) + 1, oneThird);
						}
						
						if(array[oneThird] < target & target < array[twoThird]) {
						//	System.out.println("1/3 < target < 2/3");
							return TrinarySearch(array, target, (initialIndex) + 1, twoThird);
						}
						
						if(target > array[twoThird]) {
						//	System.out.println("more than 2/3");
							return TrinarySearch(array, target, (twoThird) + 1, (arraySize));
						}	
			}
		return -1;
	}
	
}
	
