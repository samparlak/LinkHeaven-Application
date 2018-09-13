package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "header")
	private String header;

	@Column(name = "link")
	private String link;

	@Column(name = "note")
	private String note;

	@Column(name = "date")
	private String date;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "subject_table_id")
	private SubjectTable subjectTable;

	public Subject changeDateFormat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime dateTime = LocalDateTime.parse(this.getDate(), formatter1);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		this.setDate(dateTime.format(formatter2));

		return this;
	}

	public String getDateTimeDifference() {
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		 LocalDateTime fromDateTime = LocalDateTime.parse(this.getDate(), formatter);

		long years = fromDateTime.until(now, ChronoUnit.YEARS);
		fromDateTime = fromDateTime.plusYears(years);

		long months = fromDateTime.until(now, ChronoUnit.MONTHS);
		fromDateTime = fromDateTime.plusMonths(months);

		long days = fromDateTime.until(now, ChronoUnit.DAYS);
		fromDateTime = fromDateTime.plusDays(days);

		long hours = fromDateTime.until(now, ChronoUnit.HOURS);
		fromDateTime = fromDateTime.plusHours(hours);

		long minutes = fromDateTime.until(now, ChronoUnit.MINUTES);
		fromDateTime = fromDateTime.plusMinutes(minutes);

		long seconds = fromDateTime.until(now, ChronoUnit.SECONDS);

		String[] dateTimeElementsName = { "yıl", "ay", "gün", "saat", "dakika", "saniye" };
		long[] dateTimeElementsValue = { years, months, days, hours, minutes, seconds };

		return formatDateTimeDifference(dateTimeElementsName, dateTimeElementsValue);
	}

	// index 0:yıl(year) , 1:ay(month) , 2:gün(day) , 3:saat(hour) ,
	// 4:dakika(minute) , 5:saniye(second)
	public String formatDateTimeDifference(String[] dateTimeElementsName, long[] dateTimeElementsValue) {
		String format = null;
		if (dateTimeElementsValue[0] == 0) {
			if (dateTimeElementsValue[1] > 0) {
				format = Long.toString(dateTimeElementsValue[1]) + " " + dateTimeElementsName[1] + " önce";
			}
			if (dateTimeElementsValue[1] == 0) {
				format = Long.toString(dateTimeElementsValue[2]) + " " + dateTimeElementsName[2] + " önce";
			}
			if (dateTimeElementsValue[2] == 0) {
				format = Long.toString(dateTimeElementsValue[3]) + " " + dateTimeElementsName[3] + " önce";
			}
			if (dateTimeElementsValue[3] == 0) {
				format = Long.toString(dateTimeElementsValue[4]) + " " + dateTimeElementsName[4] + " önce";
			}
			if (dateTimeElementsValue[4] == 0) {
				format = Long.toString(dateTimeElementsValue[5]) + " " + dateTimeElementsName[5] + " önce";
			}
		} else {
			if (dateTimeElementsValue[1] == 0) {
				format = Long.toString(dateTimeElementsValue[0]) + " " + dateTimeElementsName[0] + " önce";
			} else {
				format = Long.toString(dateTimeElementsValue[0]) + " " + dateTimeElementsName[0] + " "
						+ Long.toString(dateTimeElementsValue[1]) + " " + dateTimeElementsName[1] + " önce";
			}
		}
		return format;
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
