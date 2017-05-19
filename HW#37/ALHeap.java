//Kristin Lin
//APCS pd01
//HW#37 -- Heap o Trouble
//2017-05-10

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *
 * add()
 * Adds new value to the end of the ArrayList, then continously compares it with
 * its parent index--(current index - 1) / 2, which truncates. If it is less 
 * than the parent value, then swap it, otherwise, stop. 
 *
 * removeMin() 
 * Swap last value in ArrayList with first value. This will allow for us to 
 * easily remove the minimum value without altering the index of other data. 
 * The new first value is then compared with the lesser value of its two 
 * children (minChildPos), if it is greater, than swap with this lesser value. 
 * Repeat comparing and swapping until value is no longer greater than the 
 * lesser of its two children. 
 *
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
	/*
	String output = "";
	for (Integer x : _heap) {
	    output += x + " ";
	}
	return output;
	*/

	//traverse through ArrayList
	int level = 1;
	String output = "";
	for (int x = 0; x < _heap.size(); x++) {
	    //if the index is 2^(level) - 1, start new line
	    if (x == Math.pow(2, level) - 1) {
		output += "\n";
		level++;
	    }
	    output += _heap.get(x) + " ";
	}
	return output + "\n";
    }//O(n) - Traverse through each element in the array


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)

 

    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
	//min heap has root as the min
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *
     * Adds new value to the end of the ArrayList, then continously compares it
     * with its parent index--(current index - 1) / 2, which truncates. If it is
     * less than the parent value, then swap it, otherwise, stop. 
     *****************************************************/
    public void add( Integer addVal ) 
    {
	//if it was previously empty, just add
	if (_heap.size() == 0) {_heap.add(addVal);}
	else {
	    //otherwise, add at next open spot
	    int node = _heap.size();
	    _heap.add(node, addVal);
	    //then continously swap with parent until it is no longer lesser than parent	  
	    while (addVal < _heap.get((node-1)/2)) {
		swap(node, (node-1)/2);
		node = (node-1)/2;
	    }
	}
    } //O(logn)
    /*
     The greatest number of swaps would be the height-1 of the tree. This can
     be found by log2(total number of nodes), truncated.
    */

    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *
     * Swap last value in ArrayList with first value. This will allow for us to 
     * easily remove the minimum value without altering the index of other data.
     * The new first value is then compared with the lesser value of its two 
     * children (minChildPos), if it is greater, than swap with this lesser 
     * value. Repeat comparing and swapping until value is no longer greater 
     * than the lesser of its two children. 
     *****************************************************/
    public Integer removeMin() 
    {
	if (_heap.size() == 0) {return null;}
	swap (0, _heap.size()-1); //swap last value with first
	Integer output = _heap.remove(_heap.size()-1); //remove last value (min)
	int pos = 0;
	int newPos = minChildPos(pos);
	//swap current position with lesser of children if possible and if curr
	//pos is greater than lesser of children
	while (newPos != -1 && _heap.get(pos) > _heap.get(newPos)) {
	    swap (pos, newPos);
	    pos = newPos;
	    newPos = minChildPos(pos);
	}
	return output;
    }//O(logn)
    /*
     The greatest number of swaps would be the height of the tree. This can
     be found by log2(total number of nodes), truncated, + 1.
    */

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	//indices of children
	int a = pos * 2 + 1;
	int b = pos * 2 + 2;
	//is pos or its children in ArrayList?
	if (pos > _heap.size() || a >= _heap.size() && b >= _heap.size()) {
	    return -1;
	} else {
	    //are any of the children nonexistent?
	    if (a >= _heap.size())  {return b;} 
	    else if (b >= _heap.size()) {return a;}
	    else {
		//otherwise, return index of lesser value
		if (_heap.get(a) < _heap.get(b)) {return a;}
		else {return b;}
	    }
	}

    }//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {

	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  /*--------------------move me down---------------------
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
