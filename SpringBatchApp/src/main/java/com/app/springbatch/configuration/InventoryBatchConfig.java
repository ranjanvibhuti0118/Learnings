package com.app.springbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.app.springbatch.entity.Inventory;
import com.app.springbatch.repository.InventoryRepo;

@Configuration
public class InventoryBatchConfig {

	@Autowired
	private InventoryRepo repo;
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	PlatformTransactionManager transactionalManager;

	// item reader
    @Bean
     FlatFileItemReader<Inventory> readFile(){
		
    	FlatFileItemReader<Inventory> reader= new FlatFileItemReader<>();
    	reader.setResource(new FileSystemResource("src/main/resources/uploads/inventory-data.csv"));
    	reader.setName("csv-reader");
    	reader.setLinesToSkip(1);
    	reader.setStrict(false);
    	reader.setLineMapper(lineMapper());
    	
		return reader;
	}

	private LineMapper<Inventory> lineMapper() {
		
		DefaultLineMapper<Inventory> lineMapper= new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer= new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("inventroyId","productId","productName","description","qty");
		
//		BeanWrapperFieldSetMapper<Inventory> fieldMapper= new BeanWrapperFieldSetMapper<>();
//		fieldMapper.setTargetType(Inventory.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(new InventoryFieldSetMapper());
		
		return lineMapper;
	}
	
	//item process
	
	@Bean
	InventoryProcessor processInventory() {
		
		return new InventoryProcessor();
	}
	
	
	@Bean
	RepositoryItemWriter<Inventory> itemWriter(){
		
		RepositoryItemWriter<Inventory> itemWriter=new RepositoryItemWriter<>();
		itemWriter.setRepository(repo);
		itemWriter.setMethodName("save");
		
		return itemWriter;
	}
	
	//item Step
	@Bean
	Step step() {
		return new StepBuilder("step-1",jobRepo).
				<Inventory,Inventory>chunk(10,transactionalManager)
				.reader(readFile())
				.processor(processInventory())
				.writer(itemWriter())
				.build();		
	}
	
	@Bean
	Job job() {
		return new JobBuilder("inventory-import",jobRepo)
		.start(step())
		.build();
	}
	
	
	
}
