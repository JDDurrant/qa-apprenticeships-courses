package solution;

public class NestedLoopPractice {

	public static void main(String[] args) {
		// Outer loop (rows)
        for (int i = 1; i <= 10; i++){
        	// Inner loop (columns)
            for (int j = 1; j <= 10; j++){
            	System.out.printf("%d\t",i*j);
            }
            System.out.println();
        }

	}

}
