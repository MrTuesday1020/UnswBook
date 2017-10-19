package unswbook.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.GraphDao;
import unswbook.model.Edge;
import unswbook.model.Node;
import unswbook.service.GraphService;

public class GraphServiceImpl implements GraphService {
	@Autowired
	GraphDao graphDao;

	@Override
	public ArrayList<Node> nodes(String keyword, String selection) {
		return graphDao.nodes(keyword, selection);
	}

	@Override
	public ArrayList<Edge> edges() {
		return graphDao.edges();
	}
}
