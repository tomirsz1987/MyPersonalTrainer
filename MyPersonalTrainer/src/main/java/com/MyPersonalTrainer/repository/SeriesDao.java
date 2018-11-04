package com.MyPersonalTrainer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyPersonalTrainer.domain.Series;

@Transactional
@Repository
public interface SeriesDao extends CrudRepository<Series, Integer> {
	
	@Query
	List<Series> getChartData(@Param("NAME") String name);
}
