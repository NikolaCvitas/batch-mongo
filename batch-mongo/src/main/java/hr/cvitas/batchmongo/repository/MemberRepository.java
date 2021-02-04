package hr.cvitas.batchmongo.repository;

import hr.cvitas.batchmongo.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, Integer> {
}
