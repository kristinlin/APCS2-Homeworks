//Kristin Lin
//APCS pd01
//HW#34 -- Algorithm As Data Structure
//2017-05-03

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	if (root == null) { //first value
	    root = new TreeNode(newVal);
	    return;
	}
	TreeNode scout = root; //scouts ahead to see if next node is null
	TreeNode current = null; //current node 
	while (scout != null) { //as long as there is another node...
	    current = scout; //current stays close behind scout
	    //if newVal is less than current val, move left. 
	    if (newVal < scout.getValue()) { 
		scout = scout.getLeft();
	    } else { //otherwise move right
		scout = scout.getRight();
	    }
	}
	//scout must have encountered null where newVal should be
	//current can call setLeft or setRight (where scout is) accordingly
	if (newVal < current.getValue()) {
	    current.setLeft(new TreeNode(newVal)); 
	} else {
	    current.setRight(new TreeNode(newVal));
	}

    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    //root is first, then left, then right
    public void preOrderTrav() 
    {
	System.out.println (preOrderTravH(root));
    }

    //helper recursive function for preOrderTrav
    public String preOrderTravH(TreeNode current) {
	String output = "";
	if (current == null) {return output;} //terminates at this deadend
	else { //current first, then everything in the left subtree and the right subtree 
	    output = current.getValue() + 
		preOrderTravH(current.getLeft()) + 
		preOrderTravH(current.getRight());
	    return output;
	}
    }

    public void inOrderTrav() 
    {
	System.out.println(inOrderTravH(root));
    }

    //helper recursive function for inOrderTrav
    public String inOrderTravH(TreeNode current) {
	String output = "";
	if (current == null) {return output;} //terminates at this deadend
	else { //everything in left subtree, then current, then everything in right subtree
	    output = inOrderTravH(current.getLeft()) + 
		current.getValue() + 
		inOrderTravH(current.getRight());
	    return output;
	}
    }

    public void postOrderTrav() 
    {
	System.out.println(postOrderTravH(root));
    }

    //helper recursive function for postOrderTrav
    public String postOrderTravH(TreeNode current) {
	String output = "";
	if (current == null) {return output;} //terminates at this deadend
	else { //everything in left subtree, then everything in right subtree, then current
	    output = postOrderTravH(current.getLeft()) +
		postOrderTravH(current.getRight()) + 
		current.getValue();
	    return output;
	}
    }
    
    
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();
	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	
    }

}//end class
