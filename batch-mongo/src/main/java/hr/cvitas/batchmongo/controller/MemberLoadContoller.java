package hr.cvitas.batchmongo.controller;

import hr.cvitas.batchmongo.model.Event;
import hr.cvitas.batchmongo.repository.EventRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load-members")
public class MemberLoadContoller {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    EventRepository eventRepository;

    public static String eve_id = null;

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        long current_time = System.currentTimeMillis();

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(current_time));
        maps.put("eve_id", new JobParameter(getEve_id("LOAD MEMBERS","LOAD MEMBERS").concat("-").concat(String.valueOf(current_time))));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job,parameters);

        System.out.println("JobExecution: "+ jobExecution.getStatus());
        System.out.println("Batch is Running...");

        while(jobExecution.isRunning()){
            System.out.println("...");
        }

        return jobExecution.getStatus();

    }

    public String getEve_id(String code, String description){

        Event event = new Event();

        UUID uuid = getUUID();

        event.setId(uuid);
        event.setUuid(uuid);
        event.setCode(code);
        event.setDescription(description);
        event.setCreated_date(System.currentTimeMillis());

        eventRepository.save(event);

        String eve_id = null;
        if(event.getUuid() !=null){
            eve_id = event.getUuid().toString();
        }

        return eve_id;
    }

    private UUID getUUID(){
        UUID uuid=UUID.randomUUID();
        return uuid;
    }

}
