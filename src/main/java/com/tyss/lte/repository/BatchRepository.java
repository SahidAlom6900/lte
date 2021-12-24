/**
 * 
 */
package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.Batch;

/**
 * @author Sahid
 *
 */
@Repository
public interface BatchRepository extends JpaRepository<Batch , Integer> {

}
