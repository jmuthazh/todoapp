package com.workfront.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.workfront.todo.model.Item;

public class TodoApp {

	public static String file = "todo-record.txt";

	/**
	 * This function performs: Add Items to the Todo List
	 * 
	 * @param item
	 */
	public void addTodo(Item item) {
		System.out.println("addTodo - Start");

		List<String> listOfItem = new ArrayList<String>();
		try {
			if (new File(file).exists()) {

				Scanner inputFile = new Scanner(new FileReader(file));

				String eachItem;
				while (inputFile.hasNextLine()) {
					eachItem = inputFile.nextLine();
					if ((item != null && eachItem != null)) {
						listOfItem.add(eachItem.trim());
					}

				}
				inputFile.close();

			}
			String itemName = item.getItemName().trim();
			if (listOfItem.contains(itemName)) {

				System.out.println("Duplicate Item found cannot be Added to the List: " + item);
			} else {
				PrintWriter outputFile = new PrintWriter(new FileWriter(file, true));
				outputFile.println(item.getItemName());
				System.out.println("addTodo - Added: " + item);
				outputFile.close();
			}

		} catch (IOException e) {
			System.out.println("Cannot write a file: " + e.getMessage());
		}

		System.out.println("addTodo - End");
	}

	/**
	 * This function performs: Remove Items from the Todo List
	 * 
	 * @param item
	 */
	public List<String> removeTodo(Item item) {

		System.out.println("removeTodo - Start");
		List<String> listOfItem = new ArrayList<String>();

		try {
			Scanner inputFile = new Scanner(new FileReader(file));

			String eachItem;
			while (inputFile.hasNextLine()) {
				eachItem = inputFile.nextLine();
				if ((item != null && eachItem != null)) {
					listOfItem.add(eachItem);
				}

			}
			inputFile.close();
			System.out.println("removeTodo - Removed :" + item.getItemName());
			PrintWriter outputFile = new PrintWriter(new FileWriter(file));
			String itemName = item.getItemName().trim();
			if (listOfItem.contains(itemName))
				listOfItem.remove(itemName);
			for (String it : listOfItem) {
				System.out.println("writing" + it);
				outputFile.println(it);
			}
			outputFile.close();
		} catch (IOException exp) {
			System.out.println("Cannot access (or) write file: " + exp.getMessage());
		}
		System.out.println("removeTodo - End");

		return listOfItem;

	}

	/**
	 * This function performs: List the items added to the Todo list.
	 * 
	 * @return List
	 */
	public List<String> displayTodo() {
		System.out.println("displayTodo - Start");
		List<String> listOfItems = new ArrayList<String>();

		try {
			Scanner inputFile = new Scanner(new FileReader(file));
			String item;
			int row = 1;
			while (inputFile.hasNextLine()) {
				item = inputFile.nextLine();
				listOfItems.add(item);
				System.out.println(row + "." + item);
				++row;
			}
			inputFile.close();
		} catch (FileNotFoundException e) {

			System.out.println("File not found: " + e.getMessage());
		}
		System.out.println("displayTodo - End");
		return listOfItems;
	}
	
	/**
	 * This function performs: Delete All the items from the Todo List.
	 * 
	 * @return String
	 */
	public String clearAll() {
		System.out.println("clearAll - Start");
		String message = null;

		
			File fileName = new File(file);
			if(fileName.delete()){
				message = "Successfully cleared all the records from Todo List";
			}else{
				message = "Requested record cannot be found (or) deleted";
			}
			
		System.out.println(message);
		System.out.println("clearAll - End");
		return message;
	}

}
