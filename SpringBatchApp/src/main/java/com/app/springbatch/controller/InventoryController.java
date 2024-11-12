package com.app.springbatch.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.springbatch.entity.Inventory;
import com.app.springbatch.service.InventoryService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	@Autowired
	private InventoryService invService;

	private final String UPLOAD_DIR = System.getProperty("user.home") + "/Desktop/tinyURL/SpringBatchApp/src/main/resources/uploads";

	@PostMapping("/upload")
	public  ResponseEntity<?> uploadInventory(@RequestParam("File") MultipartFile file) throws Exception {

		System.out.println(UPLOAD_DIR);

		if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file type or empty file");
		}

		File uploadDir = new File(UPLOAD_DIR);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); 
		}

		File destinationFile = new File(uploadDir, file.getOriginalFilename());
		try {
			file.transferTo(destinationFile);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload .csv file");
		}

		JobParameters jobParam = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(job, jobParam);


		return ResponseEntity.ok("Batch updated successfully");
	}

	@GetMapping("/findInventory/{productId}/{quantity}")
	public ResponseEntity<Inventory> getInventoryForProduct(@PathVariable("productId") String productId,
			@PathVariable("quantity") String quantity){

		Inventory inv = invService.findInventory(productId, quantity);

		return new ResponseEntity<Inventory>(inv,HttpStatus.OK);
	}

}
