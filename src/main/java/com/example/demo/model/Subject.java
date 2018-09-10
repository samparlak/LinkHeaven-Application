package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="header")
	private String header;
	
	@Column(name="link")
	private String link;
	
	@Column(name="note")
	private String note;
	
	@Column(name="date")
	private String date;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="subject_table_id")
	private SubjectTable subjectTable;
	
	public Subject changeDateFormat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime dateTime=LocalDateTime.parse(this.getDate(), formatter1);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		this.setDate(dateTime.format(formatter2));
		return this;
	}
	
	public SubjectTable getSubjectTable() {
		return subjectTable;
	}
	public void setSubjectTable(SubjectTable subjectTable) {
		this.subjectTable = subjectTable;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", header=" + header + ", link=" + link + ", note=" + note + ", date=" + date
				+ "]";
	}
	
	

}
