/**
 * 
 */
package com.tyss.lte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyss.lte.dto.Batch;
import com.tyss.lte.pojo.BatchPojo;
import com.tyss.lte.service.BatchService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sahid
 *
 */
@RestController
@RequestMapping("api/v1/batch")
@Validated
@Slf4j
public class BatchController {
	@Autowired
	private BatchService batchService;

	@Autowired
	private ObjectMapper mapper;
//
//	@PostMapping("/add")
//	public ResponseEntity<?> addBatch(@RequestParam("file") MultipartFile file,
//			@RequestParam("batch") String batchPojo) {
//		System.out.println(batchPojo);
//		BatchPojo batchPojo0 = new BatchPojo();
////		BatchPojo batchPojo2 = mapper.readValue(batchPojo, BatchPojo.class);
//
////		Batch batch = batchService.addBatch(file, batchPojo2);
//		return new ResponseEntity<>(batch, HttpStatus.OK);
//	}

}
