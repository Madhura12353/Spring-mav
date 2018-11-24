package com.student.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("mylogin", new Login());
		return mav;

	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView validateUser(Login login) {
		ModelAndView mav;
		User user = studentService.getUser(login.getUsername(), login.getPassword());
		if (user.getUsername().trim().equals("madhura")) {
			mav = new ModelAndView("home");
		} else {
			mav = new ModelAndView("login");
			mav.addObject("mylogin", new Login());
		}

		return mav;

	}

	
	@RequestMapping(value = "/createStudent", method = RequestMethod.GET)
	public ModelAndView registerStudent() {
		ModelAndView mav = new ModelAndView("createStudent");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@RequestMapping(value = "/createStudentProcess", method = RequestMethod.POST)
	public ModelAndView createStudentProcess(Student std) {
		ModelAndView mav;
	     int id = studentService.createStudent(std);
	     std.id = id;
		mav = new ModelAndView("registationSuccess");
		
		//mav.addObject("Studentinfo",std.firstname);
		mav.addObject("Studentinfo",std);
		return mav;
		}
	
	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("getStudent");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@RequestMapping(value = "/getStudentProcess", method = RequestMethod.GET)
	public ModelAndView getStudentprocess(String id) {
		System.out.println(id);
		ModelAndView mav;
		mav = new ModelAndView("getStudentProcess");
		Student std= studentService.getStudent(Integer.parseInt(id));
    	mav.addObject("studentinfo", std);
		return mav;
		
	}
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent() {
		ModelAndView mav = new ModelAndView("deleteStudent");
		mav.addObject("dstudent", new Student());
		return mav;
	}
	
	@RequestMapping(value = "/deleteStudentProcess", method = RequestMethod.GET)
	public ModelAndView deleteStudentProcess(String id) {
		ModelAndView mav = new ModelAndView("deleteStudentProcess");
		int deletedStudentid = studentService.deleteStudent(Integer.parseInt(id));
		
		mav.addObject("deltedStudentId", deletedStudentid);
		return mav;
	}
	
	@RequestMapping(value = "/updatestudent", method = RequestMethod.GET)
	public ModelAndView upadateStudent() {
		ModelAndView mav = new ModelAndView("updatestudent");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@RequestMapping(value = "/updatestudentprocess", method = RequestMethod.GET)
	public ModelAndView updateStudentProcess(String id) {
		ModelAndView mav = new ModelAndView("updatestudentform");
		
		Student std  = studentService.getStudent(Integer.parseInt(id));
		std.setId(Integer.parseInt(id));
		
		mav.addObject("student",std);
		return mav;
	}
	
	
	@RequestMapping(value = "/updatestudentobjectprocess", method = RequestMethod.POST)
	public ModelAndView updateStudentProcess(Student std) {
		
		ModelAndView mav = new ModelAndView("updatedstudentobject");
		Student updatedStudent = studentService.updateStudent(std.getId(), std);
	
		
		mav.addObject("updatedStudent",updatedStudent);
		return mav;
	}
	
	
	}
	
	

