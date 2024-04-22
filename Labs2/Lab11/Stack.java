@SuppressWarnings("unchecked")
public class Stack {
  private Node top;

  public Stack() {
    top = null; 
  }  // end default constructor
  
  public boolean isEmpty() {
    return top ==  null;
  }  // end isEmpty

  public void push(Object newItem) {
    top = new Node(newItem, top);
  }  // end push
  
  public Object pop() throws StackException {
    if (!isEmpty()) {
      Node temp = top;
      top = top.getNext();
      return temp.getItem();
    }
    else {
      throw new StackException("StackException on " +
                               "pop: stack empty");
    }  // end if
  }  // end pop
  
  public void popAll() {
    top = null;
  }  // end popAll
  
  public Object top() throws StackException {
    if (!isEmpty()) {
      return top.getItem();
    }
    else {
      throw new StackException("StackException on " +
                               "peek: stack empty");
    }  // end if
  }  // end top
 
  public Object clone() throws CloneNotSupportedException
  {
	Stack copy = new Stack();
	Node curr = top, prev = null;

	while (curr != null) 
	{
    		Node temp = new Node(curr.getItem());
                if (prev == null)
			copy.top = temp;
		else
			prev.setNext(temp);
		prev = temp;
      		curr = curr.getNext();
	}

	return copy;
  }

  // Your findMax instance method goes HERE
/*	public Object findMax()
	{
		Node curr = top;
		Object currMax = "AAAAAAAAA";
		while (curr != null)
		{
			if(((Comparable)curr.getItem()).compareTo(currMax) > 0)
			{
				currMax = curr.getItem();
			}
			curr = curr.getNext();
		}
		return currMax;
	}
	public Object findMin()
	{
		Node curr2 = top;
		Object currMin = "zzzzz";
		while (curr != null)
		{
			if(((Comparable)curr.getItem()).compareTo(currMax) < 0)
			{
				currMin = curr.getItem();
			}
			curr = curr.getNext();
		}
		return currMin;
	}

*/
	public String findmax()
	{
		Node curr = top;
		String currMax = (String)top.getItem();
		while (curr != null)
		{
			if (((Comparable)(curr.getItem())).compareTo(currMax) > 0)
			{
				currMax = (String)curr.getItem();
			}
			curr = curr.getNext();
		}
		return currMax;
		
}  // end Stac
}
