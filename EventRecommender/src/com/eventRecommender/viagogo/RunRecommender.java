package com.eventRecommender.viagogo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.*;


public class RunRecommender {
		
	public static void main(String args[]){
		//generate random number of seed events
		Random rand = new Random();
		int num = rand.nextInt(20) + 10; //minimum 10 events
		Event[] events=new Event[num];
		System.out.println("Number of seeds: "+num);
		
		//Initialize the number of seed events
		
		for (int i=0;i<num;i++){
			events[i]=new Event();
			events[i].initializeSeeds();			
		}
		//Get user input
		System.out.println("Please input coordinates");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int xc=0,yc=0;
			boolean flag = true;
			//Check if input is in specified range or not. If not prompt again to enter
			while(flag){
				String s = br.readLine();
				String [] coords=s.split(",");
				xc=Integer.parseInt(coords[0]);
				yc=Integer.parseInt(coords[1]);
				if(xc>10 || yc >10 ||xc<-10||yc <-10)
					System.out.println("Invalid input. Please enter coordinates between -10 to 10");
				else
					flag=false;
			}
			//Process the events in a priority queue which sorts it..
			//so that the event with minimum distance is at the head or the top
			
			PriorityQueue<Event> pQueue = new PriorityQueue<Event>(10,new Checker(xc,yc));
			for (int i=0;i<num;i++){
				pQueue.offer(events[i]);			
			}
			System.out.println("Closest events to "+xc+","+yc);
			
			for (int i=0;i<5;i++){
				Event e = pQueue.remove();
				System.out.println("Event "+e.id+" - "+e.getCheapestTicket()+", Distance "+e.getDist(xc, yc));							
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
 		
	}
	
}
