package unswbook.model;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
}
