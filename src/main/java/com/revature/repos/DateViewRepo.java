package com.revature.repos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.DateView;

@Repository
public interface DateViewRepo extends CrudRepository<DateView, Integer>{
	
	List<DateView> findByWeekStartDate(Timestamp timestamp);

}
