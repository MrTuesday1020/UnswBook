package unswbook.service;

import java.util.ArrayList;

import unswbook.model.Edge;
import unswbook.model.Node;

public interface GraphService {
	ArrayList<Node> nodes(String keyword, String selection);
	
	ArrayList<Edge> edges();
}
