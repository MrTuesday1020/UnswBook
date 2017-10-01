package unswbook.service;

import java.util.ArrayList;

import unswbook.model.Message;

public interface MessageService {

	ArrayList<Message> findMessageById(Integer id);
	
	ArrayList<Message> findMessagesByUserId(Integer id);
	
	ArrayList<Message> findAllMessages();
	
	ArrayList<Message> findAllMessagesByUserID(Integer id);

	void postMessage(Message message);
}
