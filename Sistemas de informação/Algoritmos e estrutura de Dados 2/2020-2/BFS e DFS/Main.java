package com.maze;

/**
 * @author Duruoha-Ihemebiri Ezenwa
 *
 */

import java.util.Scanner;
/*
 * SYSTEM RUNS FROM THIS CLASS
 */
public class Main {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Gets maze file path as input
		System.out.println("Please input File Path: ");	
		
		//Initialize a Graph object which reads the maze file and returns an array of Nodes
		Graph read2 = new Graph();
		Nodes[] list2 = read2.readGraph(input.nextLine());
		//read2.printAdj(list2);
		
		// Prompts user for mode of traversal
		System.out.println("Please input mode type (single or all): ");
		String modeType = input.nextLine();
		
		//Prompts user for start and goal states
		System.out.println("Please input start value(int): ");	
		int start = input.nextInt();
		System.out.println("Please input goal value(int): ");	
		int goal = input.nextInt();
		
		//Initialize Dfs and Bfs objects which traverse the maze
		DFS dfsBot = new DFS();
		BFS bfsBot = new BFS();
		//Switch statement to control the mode
		switch(modeType){
			case "single":
				bfsBot.visitAll(list2,start,goal);
				break;
			case "all":
				dfsBot.visitAll(list2, start, goal);
				break;
		}	

	}
}
