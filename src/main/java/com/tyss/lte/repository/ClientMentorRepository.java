/**
 * 
 */
package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.ClientMentor;

/**
 * @author Sahid
 *
 */
@Repository
public interface ClientMentorRepository extends JpaRepository<ClientMentor, Integer> {

}
