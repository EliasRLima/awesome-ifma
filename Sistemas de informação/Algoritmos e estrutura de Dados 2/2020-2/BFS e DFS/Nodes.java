package com.maze;
/**
 * @author Duruoha-Ihemebiri Ezenwa
 *
 */
import java.util.*;
/*
 * Blueprint Class to define a Node Object
 */
public class Nodes implements Comparable<Nodes> {
	/*
	 * INSTANCE VARIABLES
	 */
	//Defines a means of identification for the Node
	private int id;
	//A check variable used by a path finder algorithm to see if this node has be processed
	private boolean visited;
	//An Adjacency list of this node's neighbors
	private List<Nodes> adjacent;
	//Stores the value of this node's parent
	private Nodes parent = null;

	/*
	 * CONSTRUCTOR
	 */
	// Receives an integer value to initailize a Node
	public Nodes(int id) {
		this.id = id;
		this.adjacent = new ArrayList<>();
	}

	/*
	 * Getter and Setter Utility Methods
	 */
	
	public void addAdjacent(Nodes adj) {
		this.adjacent.add(adj);
	}

	public int getid() {
		return id;
	}

	public Nodes getParent() {
		return parent;
	}

	public void setParent(Nodes last) {
		this.parent = last;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Nodes> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(List<Nodes> adjacent) {
		this.adjacent = adjacent;
	}
	
	/*
	 * Overriden Methods
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodes other = (Nodes) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return String.valueOf(id);
	}
 
	@Override
	public int compareTo(Nodes object) {
		return this.id < object.id ? 1 : -1;
	}

}
