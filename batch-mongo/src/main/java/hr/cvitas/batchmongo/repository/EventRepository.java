package hr.cvitas.batchmongo.repository;

import hr.cvitas.batchmongo.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Integer> {
}
