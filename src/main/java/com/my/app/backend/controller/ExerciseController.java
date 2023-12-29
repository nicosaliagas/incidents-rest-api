package com.my.app.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.dto.ExerciseDto;
import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.Exercise;
import com.my.app.backend.service.ExerciseService;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExerciseService exerciseService;

	@Autowired
    private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ExerciseDto> getExercises() {
		List<Exercise> exercices = exerciseService.list();

		List<ExerciseDto> exercicesDto = new ArrayList<>();

		exercices.forEach(( Exercise exercise) -> exercicesDto.add(convertToDto(exercise)));

		return exercicesDto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExerciseDto getExercise(@PathVariable UUID id) {

		Exercise exercise = exerciseService.findExerciseById(id);

		return convertToDto(exercise);
	}

	@PostMapping()
	public ResponseEntity<?> createExercise(@Valid @RequestBody Exercise newExercise) {
		try {
			Exercise _exercise = exerciseService.saveExercise(
				new Exercise(
					newExercise.getName(), 
					newExercise.getInstruction(),
					newExercise.getMuscle(),
					newExercise.getPhoto(),
					newExercise.getUser()
					));
			return new ResponseEntity<>(convertToDto(_exercise), HttpStatus.CREATED);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<?> putExercise(@Valid @RequestBody Exercise updateExercise) {
		try {
			Exercise exercise = exerciseService.findExerciseById(updateExercise.getId());
			
			exercise.setName(updateExercise.getName());
			exercise.setInstruction(updateExercise.getInstruction());
			exercise.setMuscle(updateExercise.getMuscle());
			exercise.setPhoto(updateExercise.getPhoto());

			return new ResponseEntity<>(convertToDto(exerciseService.saveExercise(exercise)), HttpStatus.OK);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ExerciseDto convertToDto(Exercise exercise) {
		ExerciseDto exerciseDto = modelMapper.map(exercise, ExerciseDto.class);

		exerciseDto.setUser(exercise.getUser().getId().toString());

		return exerciseDto;
	}
}
