package Recap_HandleTree.solution;

import java.util.ArrayList;
import java.util.Iterator;

public class HandleTree {

	static ArrayList<Tree> treeList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		treeList.add(new Tree("Oak", 1.9,8.0,TreeType.Deciduous));
		treeList.add(new Tree("Larch",0.4,15.0,TreeType.Deciduous));
		treeList.add(new Tree("Sycamore",1.4,7.0,TreeType.Deciduous));
		treeList.add(new Tree("Pine",1.7,5.0,TreeType.Evergreen));
		treeList.add(new Tree("Fir",0.4,11.0,TreeType.Evergreen));
		System.out.println(RemovalAnalysis());
		
	}
	
	public static String RemovalAnalysis(){
		String str = "";
		for (Tree list: treeList){
			str += list.toString() + "\n";
		}
		
		return str;
	}

}
