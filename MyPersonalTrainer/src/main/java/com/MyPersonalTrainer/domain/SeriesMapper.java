package com.MyPersonalTrainer.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SeriesMapper {

	public SeriesDto mapToSeriesDto(Series series) {
		return new SeriesDto(
				series.getId(),
				series.getMicrocycleNo(),
				series.getNumber(),
				series.getReps(),
				series.getWeight(),
				series.getExcercise(),
				series.getDoneWeight(),
				series.getDoneReps(),
				series.getDate());	
	}
	
	public Series mapToSeries(SeriesDto seriesDto) {
		return new Series(
				seriesDto.getId(),
				seriesDto.getMicrocycleNo(),
				seriesDto.getNumber(),
				seriesDto.getReps(),
				seriesDto.getWeight(),
				seriesDto.getExcercise(),
				seriesDto.getDoneWeight(),
				seriesDto.getDoneReps(),
				seriesDto.getDate());
	}
	
	public List<SeriesDto> mapToSeriesDto(List<Series> seriesList) {
		return seriesList.stream()
				.map(s -> new SeriesDto(s.getId(), s.getMicrocycleNo(), s.getNumber(),
						s.getReps(), s.getWeight(), s.getExcercise(), s.getDoneWeight(),
						s.getDoneReps(), s.getDate()))
				.collect(Collectors.toList());
	}
	
}
