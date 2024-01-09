package com.memo.batch.process.register.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.memo.batch.process.register.step.RegisterTasklet;

@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {
    
	@Autowired
    private RegisterTasklet registerTasklet;
    
    @Bean
    public Job registerJob(JobRepository jobRepository, PlatformTransactionManager transactionManager, Step registerStep) {
    	Job job = new JobBuilder("registerJob", jobRepository)
    			.start(registerStep)
    			.build();
    	
    	return job;
    }
    
    @Bean
    public Step registerStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    	return new StepBuilder("registerStep", jobRepository)
    			.tasklet(registerTasklet, transactionManager)
    			.build();
    }
}
