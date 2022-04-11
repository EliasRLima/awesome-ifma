package com.maze;

/**
 * @author Duruoha-Ihemebiri Ezenwa
 *
 */

import java.util.LinkedList;
import java.util.List;

/*
 *Depth-First Search Implementation
 */
public class DFS {

	/*
	 * INSTANCE VARIABLES
	 */

	// Place holder nodes to hold the Start state and the Goal state of maze
	private Nodes start;
	private Nodes goal;

	/*
	 * UTILITY METHODS
	 */

	// Receives a Node array and iterates through it to set the Start state and
	// the Goal state
	public void visitAll(Nodes[] nodeList, int s, int g) {
		final long startTime = System.nanoTime();
		try {
			for (Nodes i : nodeList) {
				// checks if the defined nodes "s" and "g" are in the array and
				// set the start and goal state to these values
				if (i.getid() == s) {
					start = i;
				}
				if (i.getid() == g) {
					goal = i;
				}

			}

		} catch (NullPointerException e) {
			System.out.println("Does Not Contain Start and Goal Values");
		}
		// Initializes a linked list to hold the nodes to a given goal
		LinkedList<Nodes> path = new LinkedList<>();
		// Adds the start node to the head of the path list
		path.add(start);
		// Call to the maze solver method
		run(path);
		final long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Paths found in:" + elapsedTime + " nsec");
	}

	// Maze solver method
	public void run(LinkedList<Nodes> path) {
		// A list to hold the neighbors of the current node being
		// processed(using a LIFO data structure)
		List<Nodes> adj = path.getLast().getAdjacent();
		// Iterates through the neighbors of the current node being processed
		for (Nodes i : adj) {
			/*
			 * A check condition to verify if this neighbor is in the path list
			 * if the condition is met, it jumps to the next iteration of the
			 * loop
			 */
			if (path.contains(i)) {

				continue;
			}
			/*
			 * Checks if this neighbor is the goal state if condition is met
			 * adds it to the path list to complete the path prints out the
			 * completed path remove the goal node and breaks this loop
			 */
			if (i.equals(goal)) {
				path.add(i);
				printPath(path);
				path.removeLast();
				break;
			}

		}
		// The core loop of the maze solver: Iterates through the neighbors of
		// the current node being processed
		for (Nodes j : adj) {
			/*
			 * A check condition to verify if this neighbor is in the path list
			 * or if this neighbor is the goal state if the condition is met, it
			 * jumps to the next iteration of the loop
			 */
			if (path.contains(j) || j.equals(goal)) {
				continue;
			}
			// adds this neighbor to the path list
			path.addLast(j);
			// Recursive call to the maze solver method on the updated path list
			run(path);
			// Back tracks if no other path can be found from this current node
			path.removeLast();

		}
	}

	// Prints the found path to screen
	public void printPath(LinkedList<Nodes> path) {
		System.out.println("Path found: " + path);
		System.out.println();

	}

}
