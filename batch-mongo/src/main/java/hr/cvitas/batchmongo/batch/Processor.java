package hr.cvitas.batchmongo.batch;

import hr.cvitas.batchmongo.model.Member;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class Processor implements ItemProcessor<Member, Member> {

    private String eve_id = null;


    @Override
    public Member process(Member member) throws Exception {
        System.out.println(" Processor process member id: "+member.getId());

        System.out.println(" Processor process member eve_id: "+eve_id);

        member.setEve_id(eve_id);


        System.out.println(" Processor process member: "+member.toString());

        return member;
    }

    @BeforeStep
    public void beforeStep(final StepExecution stepExecution) {
        JobParameters jobParameters = stepExecution.getJobParameters();
        // Do stuff with job parameters, e.g. set class-scoped variables, etc.
        System.out.println(" BEFORE STEP_______________");
        System.out.println("JOB PARAMS: "+jobParameters.toString());
        Map<String, JobParameter> params = jobParameters.getParameters();

        JobParameter eve_id = params.get("eve_id");
        JobParameter time = params.get("time");

        System.out.println("JOB PARAMS time: "+time.toString());
        System.out.println("JOB PARAMS eve_id: "+eve_id.toString());

        setEve_id(eve_id.toString());


    }

    public String getEve_id() {
        return eve_id;
    }

    public void setEve_id(String eve_id) {
        this.eve_id = eve_id;
    }
}
