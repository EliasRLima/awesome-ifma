package com.maze;

/**
 * @author Duruoha-Ihemebiri Ezenwa
 *
 */
import java.util.*;

/*
 *Breadth-First Search Implementation
 */
public class BFS {
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
					this.start = i;
				}
				if (i.getid() == g) {
					this.goal = i;
				}
			}
			// call to the maze solver method
			parseGraph(start, goal);

		} catch (NullPointerException e) {
			System.out.println("Does Not Contain Start and Goal Values");
		}
		final long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Paths found in:" + elapsedTime + " nsec");
	}

	// Maze solver method
	private void parseGraph(Nodes start, Nodes goal) {
		// A FIFO data structure(Queue) used to hold each node for processing
		Queue<Nodes> list = new LinkedList<>();
		// A list to hold each node that creates a path
		List<Nodes> directions = new LinkedList<>();
		// Place holder node to hold the current node being processed
		Nodes iterate = null;
		// Adds the start node to the Queue and marks it as visited
		list.add(start);
		start.setVisited(true);
		// Beginning of processing(loops till the queue is empty)
		while (!list.isEmpty()) {
			// For every loop initialize the current node being processed to the
			// first node removed from the top of the queue
			iterate = list.remove();
			// Condition to check if the goal state has been reached
			if (iterate.equals(goal)) {
				// Back tracks to get the nodes that makes up the path and add
				// them to the direction list
				for (Nodes i = goal; i != null; i = i.getParent()) {
					directions.add(i);
				}
				Collections.reverse(directions);
				// Prints out the found path
				System.out.println("Shortest path found: " + directions);
				continue;
			} else {
				// Iterate through the adjacent nodes of the current node being
				// processed
				for (Nodes i : iterate.getAdjacent()) {
					/*
					 * Checks if it's neighbors have been encountered if not
					 * adds them to the queue, set the parent of this neighbor
					 * to the value of the current node(used to back track the
					 * path), set this neighbor to encountered.
					 */
					if (!i.isVisited()) {
						list.add(i);
						i.setParent(iterate);
						i.setVisited(true);
					}
				}
			}
		}
	}
}