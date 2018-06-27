package Teachium.Teachium.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Teachium.Teachium.database.TeachiumDatabase;

class AdminMessagesServiceTest {

	@Test
	void testAddMessage() {
		TeachiumDatabase database = mock(TeachiumDatabase.class);
		AdminMessagesService service = new AdminMessagesServiceImpl(database);
		Message message = new Message("text", "from", "to");
		service.addMessage(message);
		verify(database).insertMessage(message);
	}

}
