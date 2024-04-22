
import java.util.*;

@SuppressWarnings("unchecked")
public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                    identicalCheck(queue1, queue2));
		printQueue(queue1);

		findAndReplace(queue1, key, new Character('*'));
		System.out.println("\n** After findAndReplace **\n");
		printQueue(queue1);
		System.out.println(" ");
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{
		LinkedList Q1 = (LinkedList) queue1.clone();
		LinkedList Q2 = (LinkedList) queue2.clone();
		if (Q1.size() != Q2.size())
		{
			return true;
		}
		for (int i = 0; i < Q1.size(); i++)
		{
			if (((Comparable)(Q1.get(i))).compareTo((Comparable)(Q2.get(i))) == 0)
			{
				return true;
			}
		}
		return false;
	}


	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{
		for(int i = 0; i < queue1.size(); i++)
		{
			if(((Comparable)(queue1.get(i))).compareTo((Comparable)(key)) == 0)
			{
				queue1.remove(i);
				queue1.add(i, newVal);
			}
		}
	}



	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{
		for(int i = 0; i < q.size(); i++)
		{
			System.out.print(q.get(i) + ", ");
		}
	}


}
