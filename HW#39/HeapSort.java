//Kristin Lin
//APCS pd01
//HW#39 -- Heaping Piles of Sordidness
//2017-05-11

/**************************************
 * class HeapSort - 
 * Uses heapification to sort an array of ints
 *************************************/

public class HeapSort {

    //official sort method
    public static int[] sort(int[] _data) {
	return partHeap(heapify(_data));
    } //O(nlogn) - heapify's O(nlogn) + partHeap's O(nlogn) = 2nlogn

    /*~~~~~~~~~~~~~~~~~~~~Helper Sort Methods~~~~~~~~~~~~~~~~~~*/
    
    //heapify method - organizes array into a heap formation
    public static int[] heapify(int[] _data) {
	//if _data consists of one element, sorted 
	if (_data.length <= 1) {return _data;}
	//acting as if each element from index 1 onwards is added onto the heap
	for (int end = 1; end < _data.length; end++) {
	    //swap until it's no longer greater than the parent
	    int pos = end;
	    int newPos = (end-1)/2;
	    while (_data[pos] > _data[newPos]) {
		_data = swap (_data, pos, newPos);
		pos = newPos;
		newPos = (pos-1)/2;
	    }
	}
	return _data;
    } //O(nlogn) - the add method in ALHeap, which had O(logn), run n-1 times

    //partHeap method - removes max from heap section into sorted section
    public static int[] partHeap(int[] _data) {
	//if _data consists of one element, sorted
	if (_data.length <= 1) {return _data;}
	//decreasing heap section of array
	for (int end = _data.length - 1; end > 0; end--) {
	    //move max into sorted section
	    swap (_data, 0, end);
	    //maintain heapness by swapping until it's no longer less than child
	    int pos = 0;
	    int newPos = maxChildPos(_data, end, pos);
	    while (newPos != -1 && _data[pos] < _data[newPos]) {
		swap (_data, pos, newPos);
		pos = newPos;
		newPos = maxChildPos(_data, end, pos);
	    }
	}
	return _data;
    } //O(nlogn) - the remove method in ALHeap, which had O(logn), run n-1 times

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    
    /*~~~~~~~~~~~~~~~Helper Methods~~~~~~~~~~~~~~~~*/
    
    //helper method for finding greater child
    private static int maxChildPos( int[] _data, int end, int pos ) 
    {
	//indices of children
	int a = pos * 2 + 1;
	int b = pos * 2 + 2;
	//is pos or its children in heap section?
	if (pos >= end || a >= end && b >= end) {
	    return -1;
	} else {
	    //is one of its children nonexistent?
	    if (b >= end) {return a;}
	    else {
		//otherwise, return index of greater value
		if (_data[a] > _data[b]) {return a;}
		else {return b;}
	    }
	}
    }

    //helper for swapping values in an array
    private static int[] swap( int[] _data, int pos1, int pos2 ) 
    {
	int temp = _data[pos1];
	_data[pos1] = _data[pos2];
	_data[pos2] = temp;
	return _data;
    }
    
    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //test cases
    public static void main(String[] args) {

	System.out.println("Using heapification to sort an array of ints\n");
	
	int[] tester1 = {4, 6, 12, 3, 2, 7, 1, 8};
	int[] tester2 = {0, -1, -20, 39, 2};
	int[] tester3 = {1, 2, 3, 2, 3};

	printArray(tester1);
	printArray(sort(tester1));

	System.out.println("");
	printArray(tester2);
	printArray(sort(tester2));

	System.out.println("");
	printArray(tester3);
	printArray(sort(tester3));
    }
    
}
