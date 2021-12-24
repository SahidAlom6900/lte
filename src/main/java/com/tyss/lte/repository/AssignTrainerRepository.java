/**
 * 
 */
package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.AssignTrainer;

/**
 * @author Sahid
 *
 */
@Repository
public interface AssignTrainerRepository extends JpaRepository<AssignTrainer, Integer> {

}
