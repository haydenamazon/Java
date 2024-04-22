import java.util.*;
import java.io.*;

public class TimeShare
{
	//clock
	public static int clock = 1;

	//queues for list and finish
	public static Queue finishQueue = new Queue();
	public static Queue list = new Queue();

	//variables declared here to be used throughout
	public static boolean validJob = true;	public static double counter;	public static double wait = 0;	public static double num = 0; public static double cpuPercentage; public static double idle;

	public static void main(String[] args)
	{
		try
		{
			File jobs = new File(args[0]);
			createJobs(jobs);
			all();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("No file found");
		}
	}
	public static void all()
	{
		int finishjob = 0;
		//for (int i; i < files.length(); i++)
		jobTrial();
		finishjob++;
	}
	public static void jobTrial() //throws CloneNotSupportedException
	{
		
		int njobs = 0;
		int traffic = -1;	

		idle = 0;
		counter = 0;
		clock = 1;

		//set value to the variables

		Queue jobQueue = new Queue();

		while (! (list.isEmpty()) || ! (jobQueue.isEmpty()))
		{
/*			Queue tmp = new Queue();
			if (jobQueue.isEmpty())
			{
				//
			}
			else
			{
				tmp = (Queue) jobQueue.clone();
			}*/
			if (!list.isEmpty())
			{
				Job front = (Job)list.front();
				if (front.arrivalTime == clock)
				{
					jobQueue.enqueue(list.dequeue());
					num++;
				}
			}
			if (!jobQueue.isEmpty())
			{
				Job front = (Job)jobQueue.front();
				if ((front.startTime != traffic) && (front.runTime == (clock - (front.startTime))))
				{
					front.turnTime = front.waitTime + front.runTime;
					finishQueue.enqueue(jobQueue.dequeue());
				}
			}
			//
			//series of if loops to check and manipulate queue data
			//
			if (! (jobQueue.isEmpty()))
			{
				Job front = (Job)jobQueue.front();
				if ((front.arrivalTime <= clock) && (front.startTime == traffic))
				{
					front.startTime = clock;
					front.waitTime = (front.startTime - front.arrivalTime);
					wait = wait + front.waitTime;
				}
			}
			/*for (int i = 0; i < jobQueue.length; i++)
			{
				front = clock;
				clock++;
			}*/
			if (! (jobQueue.isEmpty()))
			{
				counter++;
			}
			if (! (list.isEmpty()))
			{
				njobs++;
			}
			if (njobs == 0)
			{
				jobQueue.dequeue();
			}
			if (jobQueue.isEmpty() && !list.isEmpty())
			{
				idle++;
			}

			clock++;

		}
		if(! (finishQueue.isEmpty()))
		{
			menu();
			//System.out.println(njobs);
		}
	}
	public static void clearScreen()
	{
		System.out.println("\u001b[H\u001b[2J");
	}
		
	public static void createJobs(File jobFile)	//goes through files and pulls information to occupy data structure
	{
		int x = 0;
		int x2 = 5;

		int[] jobArrival;
		int[] runTime;
		int[] turnAround;

		String[] jobName;		

		try
		{
			Scanner in = new Scanner(jobFile);
			while(in.hasNext())
			{
				x++;
				in.next();
			}
			x = (x / (x2 - 2));

			jobName = new String[x];
			jobArrival = new int[x];
			runTime = new int[x];
			
			in = new Scanner(jobFile);
			for (int i = 0; i < x; i++)
			{
				jobName[i] = in.next();
				jobArrival[i] = in.nextInt();
				runTime[i] = in.nextInt();
			}
		/*	if (x > x2)  
			{
				for (int i = 0; i < x; i++)
				{
					turnAround[i] = in.nextInt();
				}
			}*/
			for (int i = 0; i < x; i++)
			{
				list.enqueue(new Job(jobName[i], jobArrival[i], runTime[i]));
			}
				
		}
		catch (FileNotFoundException e)
		{
			validJob = false;
			System.out.println(e.getMessage());
		}
	}
	public static void printJobs()	//prints job information including int and job name i.e. job1, job2, etc.
	{
		//if (! (finishQueue.isEmpty()))
		Job head;
		while (! (finishQueue.isEmpty()))
		{
			head = (Job)finishQueue.front();
			System.out.println(head);
			finishQueue.dequeue();
		}
	}
	public static void printJobs(Queue queue)
	{
		Job head;
		while(! (queue.isEmpty()))
		{
			if (validJob == true)
			{
				head = (Job)queue.front();
				System.out.println(head);
				queue.dequeue();
			}
			else
			{
				System.out.println("Invalid job.");
				finishQueue.dequeue();
			}
		}
	}
	public static void menu()	//method to print formatted information
	{
		cpuPercentage = 0;
		double max = 100.00;
		clearScreen();

		String dash = "---------------------------------------------------------------";
		String menu2 = "JobID\tArrival\tStart\tRun\tWait\tTurnAround\n\tTime\tTime\tTime\tTime\tTime\n-----\t-------\t-----\t---\t----\t----------";
		System.out.println(dash);
		System.out.println(menu2);
		printJobs();

		System.out.print("Average Wait Time : ");
		System.out.printf("%2.2f\t", wait / num);
		System.out.print("\n        CPU Usage: ");
		System.out.printf("%2.2f\t", counter);
		System.out.print("\n        CPU Idle: ");
		System.out.printf("%2.2f\t", idle);
		System.out.print("\n        CPU Usage(%): ");
		cpuPercentage = (double)(counter) / (double)(counter + idle);
		System.out.printf("%2.2f\t", cpuPercentage*100);
		if (cpuPercentage == max)
		{
			System.out.println("CPU Usage maximum.");
		}
		System.out.println(" ");
	}
}


