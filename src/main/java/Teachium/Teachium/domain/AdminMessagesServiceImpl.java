package Teachium.Teachium.domain;

import org.springframework.stereotype.Service;

import Teachium.Teachium.database.TeachiumDatabase;

@Service
public class AdminMessagesServiceImpl implements AdminMessagesService {
	private TeachiumDatabase teachiumDatabase;
	
	public AdminMessagesServiceImpl(TeachiumDatabase teachiumDatabase) {
		this.teachiumDatabase = teachiumDatabase;
	}

	@Override
	public void addMessage(Message message) {
		this.teachiumDatabase.insertMessage(message);
	}

}
