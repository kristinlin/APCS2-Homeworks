//Kristin Lin
//APCS pd01
//HW#34 -- Algorithm As Data Structure
//2017-05-03

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode 
{
    //instance variables / attributes of a TreeNode:
    private int cargo;
    private TreeNode left;
    private TreeNode right;

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue )
    {
	cargo = initValue;
	left = right = null;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified
     * value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	cargo = initValue;
	left = initLeft;
	right = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	return left;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	return right;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() 
    {
	return cargo;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	left = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	right = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int theNewValue ) 
    {
	cargo = theNewValue;
    }
 
}//end class
