package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	
/*	public List<Subject> getCurrent(){		
		return subjectDAO.getSubjects();
	}*/

	public void insert(Subject subject) {
		subjectDAO.insert(subject);
	}
	
	public List<Subject> getSubjectsBySemester(){
		return subjectDAO.getSubjectBySemester();
	}
	
	public List<Subject> getSubjects(int year, int semester){
		return subjectDAO.getSubjects(year, semester);
	}
	
	public List<Subject> getSubjectsByType(){
		return subjectDAO.getSubjectByType();
	}
	
/*	public List<Subject> getSubjectsByYear(int year){
		return subjectDAO.getSubjectByYear(year);
	}*/
	
	public List<Subject> getSubjectsBySelect(int year){
		return subjectDAO.getSubjectBySelect(year);
	}
	
}
