package com.eventRecommender.viagogo;

import java.util.Comparator;

//Class that implements comparator interface
//This compares the distance between an event and the user location
//Used for sorting in priority queue
class Checker implements Comparator<Event>
{
	int x,y;
	public Checker(int x,int y){
		//Assign the user location
		this.x=x;
		this.y=y;
	}
   public int compare(Event e1, Event e2)
   {
   	float dist1=e1.getDist(x,y);
   	float dist2=e2.getDist(x,y);
   	return (dist1 < dist2) ? -1 : ((dist1 > dist2) ? 1 : 0);
   }
}