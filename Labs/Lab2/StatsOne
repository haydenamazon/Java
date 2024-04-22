import java.util.*;

public class Stats {

final static int NUM_ITEMS = 100;

public static void statting()
{
int[] List = new int[NUM_ITEMS];
int numItems;

numItems = fillUp(List);
System.out.println("The mean of your list of " + numItems + " items is " + mean(List, numItems));
System.out.println("The range of your list of " + numItems + " items is: " + range(List, numItems));
}
public static int fillUp (int[] List)
{
int n = 0;
System.out.println("Please Input an Integer. To Stop, enter a '0'");
System.out.println(" ");
Scanner in = new Scanner(System.in);

while (true)
{
List[n] = in.nextInt();
if (List[n] == 0)
{
break;
}
n++;
}
return n;
}
public static int range (int[] List, int numItems)
{
int max = List[0];
int min = List[0];

for (int i = 1; i < numItems; i++)
{
if (List[i] > max)
{
max = List[i];
}
}
for (int i = 1; i < numItems; i++)
{
if (List[i] < min)
{
min = List[i];
}
}
System.out.println("Maximum Value: " + max);
System.out.println("Minimum Value: " + min);
int range = max - min;
return range;
}
public static double mean(int[] List, int numItems)
{
int sum = 0;
for (int i = 0; i < numItems; i++)
{
sum+= List[i];
}
double men = Double.valueOf(sum);
double mean = men/numItems;
return mean;
}


}           
