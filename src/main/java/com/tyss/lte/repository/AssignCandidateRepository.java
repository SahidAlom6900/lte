/**
 * 
 */
package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.AssignCandidate;

/**
 * @author Sahid
 *
 */
@Repository
public interface AssignCandidateRepository  extends JpaRepository<AssignCandidate, Integer>  {

}
