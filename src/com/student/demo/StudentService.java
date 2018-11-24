package com.student.demo;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	HashMap<Integer, Student> hash_map = new HashMap<>();
	int id= 0;
	
	public User getUser(String username, String password) {
		User user = new User(username, password);
		return user;
	}
	
	public int createStudent(Student std) {
		id++;
		//Student std = new Student();
		std.setId(id);
		//std.setFirstname("madhura");
		//std.setLastname("Kulkarni");
		hash_map.put(id, std);
		
		return id;
		
		
	}
	
	public Student getStudent(int id) {
		Student std = hash_map.get(id);
		return std;
	}
	
	
	public int deleteStudent(int id) {
		hash_map.remove(id);
	
		return id;
	}
	
	public Student updateStudent(int id, Student std) {
		hash_map.put(id, std);
		
		return std;
		
	}
}
