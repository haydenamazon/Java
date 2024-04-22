import java.util.*;
@SuppressWarnings("unchecked")
public class QCount
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Queue q = new Queue();

        	q.enqueue(new Character('b'));
        	q.enqueue(new Character('$'));
        	q.enqueue(new Character('E'));
        	q.enqueue(new Character('+'));
        	q.enqueue(new Character('I'));
        	q.enqueue(new Character('y'));
        	q.enqueue(new Character('s'));
        	q.enqueue(new Character('#'));
		System.out.println("Total letters in queue = " +
				   letterCount(q));
//		System.out.println("Total letters in queue = " +
//				   q.letterCount());
	}

	private static int letterCount (Queue q) throws CloneNotSupportedException
	{
		int count = 0;
		Queue temp = (Queue) q.clone();
		while (! temp.isEmpty())
		{
			if (Character.isLetter((Character)(temp.front())))
			{
				temp.dequeue();
				++count;
			}
			else
			{
				temp.dequeue();
			}
		}
		return count;
	}
}
