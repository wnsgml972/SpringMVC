package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;


@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/subjects_by_semester")
	public String showSubjectsBySemester(Model model) {
	
		List<Subject> subjects = subjectService.getSubjectsBySemester();
		model.addAttribute("subjects", subjects);
		
		return "subjects_by_semester";
	}
	
	@RequestMapping("/select_enrolment")
	public String showSubjectsBySelect(Model model, @RequestParam(value="year") String year) {
	
		List<Subject> subjects = subjectService.getSubjectsBySelect(Integer.parseInt(year));
		model.addAttribute("subjects", subjects);
		
		return "select_enrolment";
	}
	
	@RequestMapping("/subjects_by_type")
	public String showSubjectsByType(Model model) {
	
		List<Subject> subjects = subjectService.getSubjectsByType();
		model.addAttribute("subjects", subjects);
		
		return "subjects_by_type";
	}
	
	@RequestMapping("/subjects")
	public String showSubjects(Model model, @RequestParam(value="year") String year,
			@RequestParam(value="semester") String semester) {
		
		List<Subject> subjects = subjectService.getSubjects(Integer.parseInt(year), Integer.parseInt(semester));
		model.addAttribute("subjects", subjects);
		
		return "subjects";
	}
	
/*	@RequestMapping("/select_enrolment")
	public String showSubjectsByYear(Model model) {
	
		List<Subject> subjects = subjectService.getSubjectsByYear(2018);
		model.addAttribute("subjects", subjects);
		
		return "subjects_by_type";
	}*/
	
	@RequestMapping("/enrolment")
	public String createSubject(Model model){
		model.addAttribute("subject", new Subject());
		return "enrolment";
	}
	
	@RequestMapping("/createsubject")
	public String doCreate(Model model, @Valid Subject subject, BindingResult result){
		
 		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enrolment";
		}
 		
		subjectService.insert(subject);
		model.addAttribute("success", "success");
		return "home";
	}
}
