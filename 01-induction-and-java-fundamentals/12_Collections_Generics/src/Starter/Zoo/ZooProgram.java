package Starter.Zoo;

import java.util.*;

public class ZooProgram {

	private static HashMap<String, Integer> animalMap;

	private static String[] originalAnimals
	    = { "Zebra", "Lion", "Buffalo" };

	private static String[] newAnimals
	    = { "Zebra", "Gazelle", "Buffalo", "Zebra" };

	public static void main(String[] args) {

		animalMap = new HashMap<>();

		addAnimals(originalAnimals);

		System.out.println("Original Animal Inventory");
		System.out.println("-------------------------");
		displayAnimalData();

		addAnimals(newAnimals);

		System.out.println("Final Animal Inventory");
		System.out.println("----------------------");
		displayAnimalData();

		displaySortedListOfTypes();
	}

	private static void addAnimals(String[] animals) {
		// iterate over the array passing each in turn
		for (String type : animals) {
			addNewOrReplaceExisting(type);
		}
	}

	private static void addNewOrReplaceExisting(String type) {

		int amt;

		// have we already processed an animal of this type?
		if(animalMap.containsKey(type)) {
			// if so increment value and put back
			amt = animalMap.get(type) + 1;
		} else {
			// otherwise new sort of animal so make new entry
			amt = 1;
		}

		animalMap.put(type, amt);
	}

	private static void displayAnimalData() {
		System.out.println("Type\t\tCount");
		System.out.println("----\t\t-----");
		// get the keySet of the map and iterate over it
		// printing the type and the associated value

		for(String type : animalMap.keySet()) {
			System.out.printf("%s\t\t%d\n", type, animalMap.get(type));
		}


		System.out.println();
	}

	private static void displaySortedListOfTypes() {
		// declare and create list using correct constructor
		ArrayList<String> animalTypes = new ArrayList<>(animalMap.keySet());

		// sort the collection
		Collections.sort(animalTypes);

		System.out.println("\nAnimals sorted by type");
		System.out.println("----------------------");

		// print them out
		for(String animal : animalTypes) {
			System.out.println(animal);
		}

		System.out.println();

		Collections.reverse(animalTypes);

		for(String animal : animalTypes) {
			System.out.println(animal);
		}

		System.out.println();
	}

}
