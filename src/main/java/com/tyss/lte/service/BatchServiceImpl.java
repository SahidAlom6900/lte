package com.tyss.lte.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.lte.dto.Batch;
import com.tyss.lte.pojo.BatchPojo;
import com.tyss.lte.repository.AssignCandidateRepository;
import com.tyss.lte.repository.AssignTrainerRepository;
import com.tyss.lte.repository.BatchRepository;
import com.tyss.lte.repository.ClientMentorRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository batchRepository;

	@Autowired
	private AssignCandidateRepository assignCandidateRepository;

	@Autowired
	private ClientMentorRepository clientMentorRepository;

	@Autowired
	private AssignTrainerRepository assignTrainerRepository;

	private Environment environment;
	private Path dirLocation;
	private String dir;

	private Path getPath(String fileName) {
		String dir = environment.getProperty("file.upload.location");
		this.dir = dir + "\\" + fileName;
		this.dirLocation = Paths.get(this.dir).toAbsolutePath().normalize();
		return this.dirLocation;
	}

	@Override
	public Batch addBatch(MultipartFile file, BatchPojo batchPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public Batch addBatch(MultipartFile file,BatchPojo batchPojo) {
//		
//		try {
//			if (batchPojo.getPersonId() >99) {
//				Person person1 = personRepository.findByPersonId(person.getPersonId());
//				if (person1 != null) {
//					FileUtils.forceDelete(
//							new File(getPath(person1.getPersonName() + person1.getContactNumber()).toString()));
//				}
//			}
//			this.dirLocation = getPath(person.getPersonName() + person.getContactNumber());
//			Files.createDirectories(this.dirLocation);
//		} catch (IOException exception) {
//			throw new FileNotFoundException(Message.FILE_NOT_FOUND);
//		}
//		Batch batch = new Batch();
//		BeanUtils.copyProperties(batchPojo, batch);
//		return batch;
//	}

}
