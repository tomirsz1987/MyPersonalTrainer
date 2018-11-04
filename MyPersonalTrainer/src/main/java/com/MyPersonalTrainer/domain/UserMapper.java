package com.MyPersonalTrainer.domain;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {
	
	public UserDto mapToUserDto(User user) {
		return new UserDto(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				user.getExcercise());
	}
	
	public User mapToUser(UserDto userDto) {
		return new User(
				userDto.getUsername(),
				userDto.getPassword(),
				userDto.getExcercise());
	}
	
}
