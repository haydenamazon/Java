import java.util.*;
public class MyTree {
	
	public static void main(String[] args) throws CloneNotSupportedException {
	BinarySearchTree t = new BinarySearchTree();
	t.insert(new KeyedItem("M"));
	t.insert(new KeyedItem("J"));
	t.insert(new KeyedItem("W"));
	t.insert(new KeyedItem("D"));
	t.insert(new KeyedItem("L"));
	t.insert(new KeyedItem("S"));
	t.insert(new KeyedItem("Z"));
	t.insert(new KeyedItem("F"));
	t.insert(new KeyedItem("T"));
	
	System.out.println("Values in order: ");
	t.inorder();
	System.out.println("");
	t.preorder();

	BinarySearchTree myCopy = new BinarySearchTree();
	
	if (t.duplicateCheck(myCopy))
	{
		System.out.println("They're duplicates");
	}
	else
	{
		System.out.println("They're not duplicates");
	}
	myCopy.insert(new KeyedItem("M"));
	myCopy.insert(new KeyedItem("J"));
	myCopy.insert(new KeyedItem("W"));
	myCopy.insert(new KeyedItem("D"));
	myCopy.insert(new KeyedItem("L"));
	myCopy.insert(new KeyedItem("S"));
	myCopy.insert(new KeyedItem("Z"));
	myCopy.insert(new KeyedItem("F"));
	myCopy.insert(new KeyedItem("T"));

	System.out.println("\nNow adding items... \n");	

	if (t.duplicateCheck(myCopy))
	{
		System.out.println("They're duplicates");
	}
	else
	{
		System.out.println("They're not duplicates");
	}
	
	t.delete("M");
	System.out.println("");
	t.preorder();

	}

}
