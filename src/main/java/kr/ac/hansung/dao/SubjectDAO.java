package kr.ac.hansung.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sql = "select count(id) from subjectinfo";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<Subject> getSubjectBySemester() {
		String sqlStatement = "select year, semester, sum(grade) from subjectinfo group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				//subject.setId(rs.getInt("id"));
				subject.setGrade(rs.getInt("sum(grade)"));
				subject.setSemester(rs.getInt("semester"));
				//subject.setSubjectCode(rs.getString("subjectCode"));
				//subject.setSubjectName(rs.getString("subjectName"));
				//subject.setType(rs.getString("type"));
				subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}
	
	public List<Subject> getSubjectBySelect(int year) {
		String sqlStatement = "select * from subjectinfo where year=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year }, new RowMapper<Subject>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setGrade(rs.getInt("grade"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectCode(rs.getString("subjectCode"));
				subject.setSubjectName(rs.getString("subjectName"));
				subject.setType(rs.getString("type"));
				subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}
	
	public List<Subject> getSubjectByType() {
		String sqlStatement = "select type, sum(grade) from subjectinfo group by type";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				//subject.setId(rs.getInt("id"));
				subject.setGrade(rs.getInt("sum(grade)"));
				//subject.setSemester(rs.getInt("semester"));
				//subject.setSubjectCode(rs.getString("subjectCode"));
				//subject.setSubjectName(rs.getString("subjectName"));
				subject.setType(rs.getString("type"));
				//subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}
	
	// query and return a multiple object
	public List<Subject> getSubjects(int year, int semester) {
		String sqlStatement = "select * from subjectinfo where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Subject>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setGrade(rs.getInt("grade"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectCode(rs.getString("subjectCode"));
				subject.setSubjectName(rs.getString("subjectName"));
				subject.setType(rs.getString("type"));
				subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}

	public boolean insert(Subject subject) {
		
		int id = subject.getId();
		int grade = subject.getGrade();
		int semester = subject.getSemester();
		String subjectCode = subject.getSubjectCode();
		String subjectName = subject.getSubjectName();
		String type = subject.getType();
		int year = subject.getYear();
		
		String sqlStatement = "insert into subjectinfo (grade, semester, subjectCode, subjectName, type, year) values (?, ?, ?, ?, ?, ?)";
		
		//update ->  return Integer (1  or  0)  1 true,  0 false
		return (jdbcTemplate.update(sqlStatement, new Object[] {grade, semester, subjectCode, subjectName, type, year}) == 1);
	}
}