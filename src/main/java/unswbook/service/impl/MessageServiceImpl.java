package unswbook.service.impl;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;

import unswbook.dao.MessageDao;
import unswbook.dao.UserDao;
import unswbook.datacuration.DataCuration;
import unswbook.model.Message;
import unswbook.model.User;
import unswbook.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	@Autowired
	UserDao userDao;

	public ArrayList<Message> findMessageById(Integer id) {
		return messageDao.findMessageById(id);
	}

	public ArrayList<Message> findMessagesByUserId(Integer id) {
		ArrayList<Message> messages = messageDao.findMessagesByUserId(id);

		for (Message m : messages) {
			String text = m.getText();
			DataCuration dd = new DataCuration();
			ArrayList<String> keywords = new ArrayList<String>();
			try {
				keywords = dd.Keywords(text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keywords != null) {
				String bullywords = "";

				for (String s:keywords) {
					bullywords += s + ", ";
				}
				
				m.setBullywords(bullywords);
			} else {
				m.setBullywords(null);
			}
		}
		return messages;
	}

	public ArrayList<Message> findAllMessages() {
		return null;
	}

	public ArrayList<Message> findAllMessagesByUserID(Integer id) {
		ArrayList<User> users = userDao.findFriendsById(id);

		String ids = "";

		for (int i = 0; i < users.size(); i++) {
			ids += users.get(i).getId() + ", ";
		}
		ids += id;

		ArrayList<Message> messages = messageDao.findAllMessagesByUserID(ids);
		ArrayList<Message> Likedmessages = messageDao.findLikedMessages(id);

		int[] Liked = new int[Likedmessages.size()];
		for (int i = 0; i < Likedmessages.size(); i++) {
			Liked[i] = Likedmessages.get(i).getId();
		}

		for (Message m : messages) {
			if (ArrayUtils.contains(Liked, m.getId())) {
				m.setIsliked(1);
			} else {
				m.setIsliked(0);
			}
		}

		return messages;
	}

	@Override
	public void postMessage(Message message) {
		messageDao.postMessage(message);
	}
}
