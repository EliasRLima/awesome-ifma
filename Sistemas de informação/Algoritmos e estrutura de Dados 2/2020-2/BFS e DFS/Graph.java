package com.maze;

/**
 * @author Duruoha-Ihemebiri Ezenwa
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Defines a class to read pairwise connections from a file
 */
public class Graph {
	/*
	 * INSTANCE VARIABLES
	 */

	// A helper set to calculate the number of unique nodes read from a file
	private Set<Nodes> list = new HashSet<>();
	// Initialize an array of Node objects that form the maze(an array was used
	// because indexing operations were performed faster)
	private Nodes[] maze = new Nodes[list.size()];
	// place holder nodes
	private Nodes u;
	private Nodes v;

	/*
	 * UTILITY METHODS
	 */

	// Receives a string value to the file path and returns an array of Node
	// objects
	public Nodes[] readGraph(String fileName) {

		// Initializes a new file from the given path name
		File f = new File(fileName);
		try {
			// Initializes a character input stream of the file
			BufferedReader read = new BufferedReader(new FileReader(f));
			// Variable to hold each line of text from the file
			String parse;
			// Continues looping while the file contains text
			while ((parse = read.readLine()) != null) {
				// Separates each line of text using a space as the delimiter
				// and Stores the pairwise connection in an array
				String[] tokens = parse.split(" ");
				// Converts each token of the line read from the file into
				// integer values
				int t1 = Integer.parseInt(tokens[0]);
				int t2 = Integer.parseInt(tokens[1]);
				/*
				 * Initializes new nodes from the converted token value and adds
				 * them to the helper set which does not allow duplicates
				 */
				u = new Nodes(t1);
				v = new Nodes(t2);
				list.add(u);
				list.add(v);
				// Copies the objects in the helper set to the array of Nodes
				maze = list.toArray(maze);
				// Stores the index values returned from calls to the index
				// method
				int u1 = index(t1);
				int v1 = index(t2);
				// Adds the object at the v1 index to the adjacency list of the
				// object at the u1 index and vice versa(assumes it is an
				// undirected graph)
				maze[u1].addAdjacent(maze[v1]);
				maze[v1].addAdjacent(maze[u1]);

			}
			read.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return maze;

	}

	// Determines the index of each node in the array
	private int index(int next) {
		for (int y = 0; y < maze.length; y++) {
			if (maze[y].getid() == next) {
				return y;
			}
		}
		return -1;
	}

	// prints out the values in the array
	public void readSet(Object[] set2) {
		for (int i = 0; i < set2.length; i++) {
			System.out.println(set2[i]);
		}
	}

	// prints out the adjacent's list of each node in an array
	public void printAdj(Nodes[] set2) {
		for (Nodes i : set2) {
			List<Nodes> x = i.getAdjacent();
			System.out.println(i + "---" + x);
		}
	}

}
