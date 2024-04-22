import java.util.*;
@SuppressWarnings("unchecked")
//22 , 41
public class JCF {
	public static void main(String[] args) throws CloneNotSupportedException {
		Stack stack1 = new Stack();
		stack1.push(new Integer(27));
		stack1.push(new Integer(0));
		stack1.push(new Integer(-3));
		stack1.push(new Integer(-18));
		stack1.push(new Integer(99));
		printStack (stack1); 


		Scanner in = new Scanner(System.in);
		System.out.println("enter an integer");
		int x = in.nextInt();
		Object key = new Integer(x);
		System.out.println("key value: " + x);
		int index = stack1.search(key);
		if(index > 0)
		{
			System.out.println("key found at position: " + index);
		}
		else
		{
			System.out.println("key not found");
		}
		return;
	}
	private static void printStack (Stack s) throws CloneNotSupportedException 
	{
		Stack tempStack = (Stack) (s.clone());
		if (! tempStack.isEmpty())
		{
			System.out.println("*** Printing Out Stack:  ");
		}
		while (! tempStack.isEmpty()) 
		{ 
			System.out.println(tempStack.top());
			tempStack.pop();
		}
	}
}
