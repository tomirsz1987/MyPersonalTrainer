package com.MyPersonalTrainer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyPersonalTrainer.domain.DoneSeries;
import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.repository.ExcerciseDao;
import com.MyPersonalTrainer.repository.SeriesDao;
import com.MyPersonalTrainer.domain.Series;

@Service
public class DbService {
	@Autowired
	private ExcerciseDao excerciseDao;
	
	@Autowired
	private SeriesDao seriesDao;
	
	public Excercise addExcercise(Excercise excercise) {
		LocalDateTime dateTime = LocalDateTime.now();
		excercise.setAddingTime(dateTime);
		return excerciseDao.save(excercise);
	}
	
	public void deleteExcercise(String name) {
		excerciseDao.deleteByName(name);
		
	}
	
	public Excercise getExcercise(int id) {
		if(excerciseDao.findById(id) == null) {
			return new Excercise();
		}else {
			return excerciseDao.findById(id);
		}		
	}
	
	public List<Series> getChartData(String name) {
		List<Series> resultList = seriesDao.getChartData(name);
		return resultList;
	}
	
	public Excercise addSeries(int id, Series series) {
		List<Series> seriesList = new ArrayList<>();
		Excercise e1 = excerciseDao.findById(id);
		if(e1 == null) {
			System.out.println("Cannot find excercise");
			return new Excercise();
		} else {
			series.setExcercise(e1);
			seriesList.add(series);
			e1.setSeries(seriesList);
			return excerciseDao.save(e1);
		}
	}

	public List<Excercise> showAllExcercises() {
		List<Excercise> wholeList = (List<Excercise>) excerciseDao.findAll();
		return wholeList;
	}

	public List<Series> showAllSeries(int id) {
		Excercise resultExcercise = excerciseDao.findById(id);
		if(resultExcercise == null) {
			return new ArrayList<>();
		}else {
			System.out.println(resultExcercise.getSeries());
			return resultExcercise.getSeries();
		}
	}
	
	public List<Excercise> getExcerciseListByName(String name) {
		List<Excercise> excerciseList = excerciseDao.findAllByName(name);
		return excerciseList;
	}
	
	public void updateSeries(DoneSeries doneSeries) {
		System.out.println(doneSeries.getSeriesNumber());
		System.out.println("DbService ok");
		Excercise e1 = excerciseDao.findById(doneSeries.getExcerciseId());
		List<Series> resultList = e1.getSeries();
		for(int n = 0; n< resultList.size(); n++) {
			if(resultList.get(n).getNumber() == doneSeries.getSeriesNumber()) {
				Series s1 = resultList.get(n);
				s1.buildDoneSeries(s1, doneSeries.getDoneWeight(), doneSeries.getDoneReps(), doneSeries.getDate());
				excerciseDao.save(s1);
			}
		}	
	}
	
	public List<Excercise> getExcercisesListWithParam(int value) {
		List<Excercise> wholeList = (List<Excercise>) excerciseDao.getExcerciseList(value);
		return wholeList;
	}
	
}
