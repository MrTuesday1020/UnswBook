package unswbook.dao;

import java.util.ArrayList;

import unswbook.model.Edge;
import unswbook.model.Node;

public interface GraphDao {
	ArrayList<Node> nodes(String keyword, String selection);

	ArrayList<Edge> edges();
}
