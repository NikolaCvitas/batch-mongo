package hr.cvitas.batchmongo.batch;

import hr.cvitas.batchmongo.model.Member;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Member, Member> {
    @Override
    public Member process(Member member) throws Exception {
        System.out.println(" Processor process member id: "+member.getId());

        return member;
    }
}
