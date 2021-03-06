//Kristin Lin
//APCS pd01
//HW#38 -- Sort of Like Magic
//2017-05-10

/***************************************
 * Class HeapSort -
 * Uses ALHeap class to sort a dataset.
 ***************************************/

public class HeapSort {

    //instance vars:
    static ALHeap _sorter = new ALHeap();

    //method heapSort
    //Adds all numbers to ALHeap then continuously removes min into a new array
    public static int[] heapSort(int[] dataSet) {
	//add to heap
	for (int num : dataSet) {
	    _sorter.add(num);
	}
	//remove from heap into new array
	int[] output = new int[dataSet.length];
	for (int x = 0; x < output.length; x++) {
	    output[x] = _sorter.removeMin();
	}
	return output;
    } //O(nlogn) - adding each number O(nlogn) + removing each number O(nlogn)

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    
    public static void main (String[] args) {

	System.out.println("Using ALHeap class to sort a dataset.\n");
	
	int[] tester1 = {4, 6, 12, 3, 2, 7, 1, 8};
	int[] tester2 = {0, -1, -20, 39, 2};
	int[] tester3 = {1, 2, 3, 2, 3};

	printArray(tester1);
	printArray(heapSort(tester1));

	System.out.println("");
	printArray(tester2);
	printArray(heapSort(tester2));

	System.out.println("");
	printArray(tester3);
	printArray(heapSort(tester3));
    }

}
