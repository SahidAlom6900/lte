package com.tyss.lte.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.CalendarDate;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, Integer> {
	List<CalendarDate> findByDate(LocalDate date); 
}
