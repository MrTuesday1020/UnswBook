package unswbook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.GraphDao;
import unswbook.model.Edge;
import unswbook.model.Node;

public class GraphDaoImpl implements GraphDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public ArrayList<Node> nodes(String keyword, String selection) {
		String sql1 = null;
		String sql2 = null;
		
		if(selection == null) {
			sql1 = "select ID as id, Username as label , 'people' as `group` from User";
			sql2 = "select ID as id, Text as label , 'message' as `group` from Message";
		}
		else {
			if(selection.equals("people")) {
				sql1 = "select ID as id, Username as label , 'people' as `group` from User where Username like '%" + keyword + "%'";
				sql2 = "select Message.ID as id, Message.Text as label , 'message' as `group` from Message,User where Message.UserID = User.ID and User.Username like '%" + keyword + "%'";
			}
			else if (selection.equals("message")) {
				sql1 = "select User.ID as id, User.Username as label , 'people' as `group` from Message,User where Message.Text like '%" + keyword + "%' and Message.UserID = User.ID";
				sql2 = "select ID as id, Text as label , 'message' as `group` from Message where Text like '%" + keyword + "%'";
			}
		}
		

		Connection connection = null;
		ArrayList<Node> nodes = new ArrayList<Node>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			while(rs1.next()) {
				Node node = new Node();
				node.setId("p" + rs1.getInt("id"));
				node.setLabel(rs1.getString("label"));
				node.setGroup(rs1.getString("group"));
				nodes.add(node);
			}
			while(rs2.next()) {
				Node node = new Node();
				node.setId("m" + rs2.getInt("id"));
				node.setLabel(rs2.getString("label"));
				node.setGroup(rs2.getString("group"));
				nodes.add(node);
			}
			return nodes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public ArrayList<Edge> edges() {
		String sql1 = "select UserID as `from`, MessageID as `to` , 'liked' as label from `Like`";
		String sql2 = "select UserID1 as `from`, UserID2 as `to` , 'friendof' as label from Friend";
		String sql3 = "select UserID as `from`, ID as `to`, 'posted' as label from message";
		Connection connection = null;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			PreparedStatement ps3 = connection.prepareStatement(sql3);
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			while(rs1.next()) {
				Edge edge = new Edge();
				edge.setFrom("p" + rs1.getInt("from"));
				edge.setTo("m" + rs1.getInt("to"));
				edge.setLabel(rs1.getString("label"));
				edges.add(edge);
			}
			while(rs2.next()) {
				Edge edge = new Edge();
				edge.setFrom("p" + rs2.getInt("from"));
				edge.setTo("p" + rs2.getInt("to"));
				edge.setLabel(rs2.getString("label"));
				edges.add(edge);
			}
			while(rs3.next()) {
				Edge edge = new Edge();
				edge.setFrom("p" + rs3.getInt("from"));
				edge.setTo("m" + rs3.getInt("to"));
				edge.setLabel(rs3.getString("label"));
				edges.add(edge);
			}
			return edges;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
