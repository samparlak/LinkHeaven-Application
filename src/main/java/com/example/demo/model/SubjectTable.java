package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject_table")
public class SubjectTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "header")
	private String header;

	@Column(name = "date")
	private String date;

	@OneToMany(mappedBy = "subjectTable", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Subject> subjects;

	public void addSubject(Subject theSubject) {
		if (subjects == null) {
			subjects = new ArrayList<Subject>();
		} else if (!subjects.contains(theSubject)) {
			subjects.add(theSubject);
			theSubject.setSubjectTable(this);
		}
	}
	
	public SubjectTable changeDateFormat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime dateTime=LocalDateTime.parse(this.getDate(), formatter1);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		this.setDate(dateTime.format(formatter2));
		return this;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "SubjectTable [id=" + id + ", header=" + header + ", date=" + date + ", subjects=" + subjects + "]";
	}

}
