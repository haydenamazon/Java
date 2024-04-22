
@SuppressWarnings("unchecked")

public class Links
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
		System.out.println("Length of node 1: " + count(pos1) + " with a max value of: " + findMax(pos1));
		System.out.println("Length of node 2: " + count(pos2) + " with a max value of: " + findMax(pos2));
	}
	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}
	private static int count(Node head)
	{
		if(head == null)
		{
			return 0;
		}
		else
		{
			return (count(head.getNext()) + 1);
		}
	}	
	private static Object findMax(Node head)
	{
		Node curr = head;
		int max = 0;
		while (curr != null)
		{
			if(((Comparable)(curr.getItem())).compareTo((Comparable)(max)) > 0)
			{
				max = (Integer)curr.getItem();
			}
			curr = curr.getNext();
		}
		return max;
	}
}

