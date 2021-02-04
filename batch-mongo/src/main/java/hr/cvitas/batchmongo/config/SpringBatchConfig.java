package hr.cvitas.batchmongo.config;

import hr.cvitas.batchmongo.model.Member;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                   ItemReader<Member> itemReader,
                   ItemProcessor<Member, Member> itemProcessor,
                   ItemWriter<Member> itemWriter){


        Step step = stepBuilderFactory.get("Member-file-load")
                .<Member, Member>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();



        Job job =jobBuilderFactory.get("Member-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

        return job;

    }


    @Bean
    public FlatFileItemReader<Member> fileItemReader(@Value("${input}") Resource resource){

        FlatFileItemReader<Member> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return  flatFileItemReader;
    }

    @Bean
    public LineMapper<Member> lineMapper() {

        DefaultLineMapper<Member> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id","first_name","last_name","birth_date","sex","tax_number","street","city","postal_code","country"});

        BeanWrapperFieldSetMapper<Member> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Member.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;

    }

}
