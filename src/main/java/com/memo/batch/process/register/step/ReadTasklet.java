package com.memo.batch.process.register.step;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.memo.batch.entity.TMemos;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Path path = Paths.get("");
		try(BufferedReader br = Files.newBufferedReader(null, null)){
			CsvToBean<TMemos> csvToBean = new CsvToBeanBuilder<TMemos>(br).withType(TMemos.class).build();
			return RepeatStatus.FINISHED;	
		}
	}

}
