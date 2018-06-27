package Teachium.Teachium.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Teachium.Teachium.domain.Message;

public interface AdminMessageRepository extends MongoRepository<Message, String> {

	List<Message> findByTo(String id);

}
