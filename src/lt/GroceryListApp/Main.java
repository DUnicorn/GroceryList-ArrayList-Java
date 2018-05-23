package lt.GroceryListApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();

	public static void main(String[] args) {

		boolean quit = false;
		int choice = 0;
		printInstructions();

		while (!quit) {
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				groceryList.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				quit = true;
				break;

			}

		}
	}

	public static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice option.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To modify item in the list.");
		System.out.println("\t 4 - To remove item from the list.");
		System.out.println("\t 5 - To search for an item in the list");
		System.out.println("\t 6 - To quit the application");

	}
	
	public static void addItem() {
		System.out.print("Please enter the grocery item: ");
		groceryList.addGroceryItem(scan.nextLine());
	}
	public static void modifyItem() {
		System.out.print("Enter item name:");
		String itemNo = scan.nextLine();
		System.out.println("Enter replacement item: ");
		String newItem = scan.nextLine();
		groceryList.modifyGroceryItem(itemNo, newItem); //to access correct element. Start counting from 1
		
	}
	
	public static void removeItem() {
		System.out.print("Enter item name:");
		String itemNo = scan.nextLine();
		scan.nextLine();
		groceryList.removeGroceryItem(itemNo); //other way it will make IndexOutOfBoundsExceptio, because
		//user tries to access index 3, but in computer it is 2( counting from 0)
		
	}
	
	public static void searchForItem() {
		System.out.println("Item to search for: ");
		String searchItem = scan.nextLine();
		if (groceryList.onFile(searchItem)) {
			System.out.println("Found " + searchItem + " in  grocery list");
		}else {
			System.out.println(searchItem + " is not in the shopping list");
		}
		
	}
	
	public static void proccessArrayList() {
		ArrayList<String> newArray = new ArrayList<String>();
		newArray.addAll(groceryList.getGroceryList()); //copying the array
		
		ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());
		
		String [] myArray = new String [groceryList.getGroceryList().size()];
		myArray=groceryList.getGroceryList().toArray(myArray);
	}

}
