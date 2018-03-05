
//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 03.04.18
//Assignment: Arrays

//ArrayProgram: Main File

/*
 *This program stores 10 integers into an array, and then 
 *displays the array elements, then in reverse order,
 *then a sum total, then all values less than a limiting 
 *argument, and finally all values higher than the average.
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayProgram
{
	
	public static void main(String[] args)
	{
		int[] intArray = new int[10];
		//randomizing elements in array
		for(int i = 0; i < 9; i++)
			intArray[i] = (int )(Math.random() * 10 + 0);
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		int selection;
        String rawInput;
		
        while(!exit)
        {
            System.out.print(
                    "\n------Main Menu------\n"+
                    "1: Display All\n"+
                    "2: Display All in Reverse\n"+
                    "3: Display Sum of All\n"+
                    "4: Display Less Than\n"+
					"5: Display Higher Than Average\n"+
					"6: Exit\n"+
                    "\n->");
            rawInput = scanner.nextLine();
            if (tryParseInt(rawInput))
            {
                selection = Integer.parseInt(rawInput);
                switch (selection)
                { 
                    case 1:
						displayAll(intArray);
						break;
					case 2:
						displayAllReverse(intArray);
						break;
					case 3:
						displaySum(intArray);
						break;
					case 4:
						displayLessThan(intArray);
						break;
					case 5:
						displayMoreThanAverage(intArray);
						break;
					case 5:
						System.out.print("\nGoodbye!");
                        exit = true;
						break;
					default:
						System.out.print("\nThat was an invalid selection....  Please select again\n");
                        break;
				}
			}
			else
                System.out.print("Invalid Input!");
		}
	}
	
	public static void displayAll(int[] intArray)
	{
		System.out.print("\n------Display All Elements------\n\n");
		for (int i = 0; i < intArray.length; i ++)
			System.out.println("Element #" + (i+1) + ": " + intArray[i]);
	}
	
	public static void displayAllReverse(int[] intArray)
	{
		System.out.print("\n------Display All Elements in Reverse------\n\n");
		for (int i = intArray.length - 1; i >=             0; i--)
			System.out.println("Element #" + (i+1) + ": " + intArray[i]);
	}
	
	public static void displaySum(int[] intArray)
	{
		System.out.print("\n------Display Sum of All Elements------\n\n");
		int sum = 0;
		for (int i = 0; i < intArray.length; i ++)
			sum += intArray[i];
		System.out.println("Sum of all Elements: " + sum);
	}
	
	public static void displayLessThan(int[] intArray)
	{
		System.out.print("\n------Display All Elements Less Than------\n\nPlease enter a limit\n->");
		Scanner scanner = new Scanner(System.in);
		String rawInput = scanner.nextLine();
		if (tryParseInt(rawInput))
        {
			int input = Integer.parseInt(rawInput);
			for (int i = 0; i < intArray.length; i ++)
				if (intArray[i] < input)
					System.out.println("Element #" + (i+1) + ": " + intArray[i]);
		}
		else
                System.out.print("\nInvalid Input!\n");
	}
	
	public static void displayMoreThanAverage(int[] intArray)
	{
		System.out.print("\n------Display All Elements More Than Average------\n\n");
		int sum = 0;
		for (int i = 0; i < intArray.length; i ++)
			sum += intArray[i];
		int average = sum / intArray.length;
		for (int i = 0; i < intArray.length; i ++)
				if (intArray[i] > average)
					System.out.println("Element #" + (i+1) + ": " + intArray[i]);
		
	}
	
	public static boolean tryParseInt(String value) 
    {  
        try 
        {  
            Integer.parseInt(value);  
            return true;  
         } 
        catch (NumberFormatException e) 
        {  
            return false;  
        }  
    }
}
