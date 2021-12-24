package com.tyss.lte.service;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.lte.dto.Batch;
import com.tyss.lte.pojo.BatchPojo;

public interface BatchService {
	
	Batch addBatch(MultipartFile file,BatchPojo batchPojo);

}
