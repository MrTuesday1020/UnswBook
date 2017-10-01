package unswbook.dao;

import java.util.ArrayList;

import unswbook.model.Message;

public interface MessageDao {

	ArrayList<Message> findMessagesByUserId(Integer id);
	
	ArrayList<Message> findMessageById(Integer id);

	ArrayList<Message> findAllMessagesByUserID(String ids);
	
	ArrayList<Message> findLikedMessages(Integer id);

	void postMessage(Message message);
	
}
