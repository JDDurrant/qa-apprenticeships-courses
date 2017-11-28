package Recap_HandleTree.starter.tree;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	private static ArrayList<Tree> trees = new ArrayList<>();

	public static void main(String[] args) {

		fillArray();

		Tree temp = trees.get(0);
		trees.set(0, trees.get(4));
		trees.set(4, temp);

		System.out.println(removalAnalysis());

		growAllTrees();
		String firstYear = String.format("Total debris first year: %.1f tonnes", totalDebrisCollectionWeight());
		System.out.println(firstYear);

		growAllTrees();
		String secondYear = String.format("Total debris second year: %.1f tonnes", totalDebrisCollectionWeight());
		System.out.println(secondYear);
		System.out.println();

		displayDetailsOf(TreeType.Deciduous);
		System.out.println();
		displayDetailsOf(TreeType.Evergreen);
		System.out.println();

		System.out.println(removalAnalysis());
	}

	private static String removalAnalysis() {

		StringBuilder analysis = new StringBuilder();

		for (Tree tree : trees) {
			int years = tree.yearsBeforeRemoval();
			String message = String.format("%s tree will need removal in %d years\n", tree.getName(), years);
			analysis.append(message);
		}

		return analysis.toString();
	}

	private static void fillArray() {
		// TODO Figure out how to sort these by years remaining
		trees.add(new Tree("Oak", 8, 1.9, TreeType.Deciduous));
		trees.add(new Tree("Larch", 15, 0.4, TreeType.Deciduous));
		trees.add(new Tree("Sycamore", 7, 1.4, TreeType.Deciduous));
		trees.add(new Tree("Pine", 5, 1.7, TreeType.Evergreen));
		trees.add(new Tree("Fir", 11, 0.4, TreeType.Evergreen));
	}

	private static void growAllTrees() {

		for(Tree tree : trees) {
			tree.grow();
		}
	}

	private static double totalDebrisCollectionWeight() {

		double tonnes = 0;

		for(Tree tree : trees) {
			tonnes += tree.debrisCollectionWeight();
		}

		return tonnes;
	}

	private static void displayDetailsOf(TreeType type) {
		for(Tree tree : trees) {
			if (tree.getType() == type) System.out.println(tree.details());
		}
	}
}
