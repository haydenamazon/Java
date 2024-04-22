import java.util.*;
import java.io.*;
public class Pez
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Stack pez = new Stack();
		pez.push("yellow");
		pez.push("red");
		pez.push("green");
		pez.push("green");
		pez.push("yellow");
		pez.push("yellow");
		pez.push("red");
		pez.push("green");
		
		System.out.println("First stack:");
		printPez(pez);
		pez = rmvGreen(pez);
		System.out.println("Second Stack");
		printPez(pez);
	
	}
	private static void printPez(Stack stack) throws CloneNotSupportedException
	{
		Stack temp = (Stack) stack.clone();
		while (! temp.isEmpty())
		{
		//	System.out.println(pez.peek());
		//	pez.pop();
			System.out.println(temp.pop());
		}		
		return;
	}
	private static Stack rmvGreen(Stack stack) //throws CloneNotSupportedException
	{
		Stack temp = new Stack();
		while (! stack.isEmpty())
		{
			temp.push(stack.pop());
		}
		while (! temp.isEmpty())
		{
			String s = (String) temp.pop();
			if (! (s.compareTo("green") == 0))
			{
				stack.push(s);
			}
		}
		return stack;
	}
}
