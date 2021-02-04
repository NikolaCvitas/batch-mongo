package hr.cvitas.batchmongo.batch;

import hr.cvitas.batchmongo.model.Member;
import hr.cvitas.batchmongo.repository.MemberRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoDBWriter implements ItemWriter<Member> {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public void write(List<? extends Member> list) throws Exception {
        memberRepository.saveAll(list);
    }
}
