package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

	// yyyy-MM-dd HH:mm:ss.S to dd/MM/yyyy HH:mm
	public SubjectTable changeDateFormat() {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime dateTime = LocalDateTime.parse(this.getDate(), formatter1);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		this.setDate(dateTime.format(formatter2));
		return this;
	}

	// calculate how many days ago was created
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
	public static String formatDateTimeDifference(String[] dateTimeElementsName, long[] dateTimeElementsValue) {
		String format = null;
		if (dateTimeElementsValue[0] == 0) {
			if (dateTimeElementsValue[1] > 0) {
				format = Long.toString(dateTimeElementsValue[1]) + " " + dateTimeElementsName[1] + " önce"; // ay
			} else if (dateTimeElementsValue[1] == 0 && dateTimeElementsValue[2] > 0) {
				format = Long.toString(dateTimeElementsValue[2]) + " " + dateTimeElementsName[2] + " önce"; // gün
			} else if (dateTimeElementsValue[2] == 0 && dateTimeElementsValue[3] > 0) {
				format = Long.toString(dateTimeElementsValue[3]) + " " + dateTimeElementsName[3] + " önce"; // saat
			} else if (dateTimeElementsValue[3] == 0 && dateTimeElementsValue[4] > 0) {
				format = Long.toString(dateTimeElementsValue[4]) + " " + dateTimeElementsName[4] + " önce"; // dakika
			} else if (dateTimeElementsValue[4] == 0 && dateTimeElementsValue[5] > 0) {
				format = Long.toString(dateTimeElementsValue[5]) + " " + dateTimeElementsName[5] + " önce"; // saniye
			} else if (dateTimeElementsValue[5] == 0) {
				format = "Yeni oluşturuldu.";
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
