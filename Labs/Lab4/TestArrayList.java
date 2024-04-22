import java.util.*;
public class TestArrayList
{
    public static void main(String[] args)
    {
	ArrayList<String> myArrayList = new ArrayList<String>(10);
	
	myArrayList.add("Python");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");

	Object key = new String ("C++");
	int count = count(myArrayList, key);
	delete(myArrayList, "Java");
	printArrayList(myArrayList);
	System.out.println("Your key " + key + " was found "  + count + " times");
    }

    private static void printArrayList(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines
	for (int i = 0; i < myArrayList.size(); i++)
	{
		System.out.println(myArrayList.get(i));
	}

    }

    private static void delete(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	
// Post : All copies of key are removed from myArrayList
	int index = myArrayList.indexOf("Java");
	while (index >= 0) {
	myArrayList.remove(index);
	index = myArrayList.indexOf("Java");
	}



    }

    private static int count(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : number of occurre nces of key is computed and returned
	
	int count = Collections.frequency(myArrayList, key);
	return count;

    }
}
