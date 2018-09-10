package com.example.demo.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Subject;
import com.example.demo.model.SubjectTable;
import com.example.demo.service.GenericService;

@Controller
@RequestMapping("/api")
public class SubjectTableController {

	@Autowired
	private GenericService<SubjectTable> subjectTableService;

	@Autowired
	private GenericService<Subject> subjectService;

	@GetMapping("/allTables")
	@ResponseBody
	public ModelAndView viewAllSubjectTable() {
		List<SubjectTable> subjectTables = subjectTableService.getAll();
		ModelAndView mav = new ModelAndView();
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.changeDateFormat();
		}
		mav.addObject("tables", subjectTables);
		mav.setViewName("tables");
		return mav;
	}

	@GetMapping("/table/sortHeader")
	@ResponseBody
	public ModelAndView viewAllSubjectTableOrderByHeader() {
		ModelAndView mav = new ModelAndView();
		List<SubjectTable> subjectTables = subjectTableService.sortHeader();
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.changeDateFormat();
		}
		mav.addObject("tables", subjectTables);
		mav.setViewName("tables");
		return mav;
	}

	@GetMapping("/table/sortDate")
	@ResponseBody
	public ModelAndView viewAllSubjectTableOrderByDate() {
		ModelAndView mav = new ModelAndView();
		List<SubjectTable> subjectTables = subjectTableService.sortDate();
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.changeDateFormat();
		}
		mav.addObject("tables", subjectTables);
		mav.setViewName("tables");
		return mav;
	}

	@GetMapping("/table/{tableId}")
	public ModelAndView viewOneSubjectTable(@PathVariable int tableId) {
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId).changeDateFormat();
		List<Subject> subjects = theSubjectTable.getSubjects();
		for (Subject subject : subjects) {
			subject.changeDateFormat();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("table", theSubjectTable);
		mav.setViewName("table");
		return mav;
	}

	@RequestMapping("/table/{tableId}/sortHeader")
	public ModelAndView viewOneSubjectTableOrderByHeader(@PathVariable("tableId") int tableId) {
		ModelAndView mav = new ModelAndView();
		List<Subject> subjects = subjectService.sortHeader();
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		theSubjectTable.setSubjects(subjects);
		for (Subject subject : subjects) {
			subject.changeDateFormat();
			if (subject.getSubjectTable().getId() == tableId) {
				theSubjectTable.addSubject(subject);
			}
		}
		mav.addObject("table", theSubjectTable);
		mav.addObject("subjects", theSubjectTable.getSubjects());
		mav.setViewName("table");
		return mav;
	}

	@RequestMapping("/table/{tableId}/sortDate")
	public ModelAndView viewOneSubjectTableOrderByDate(@PathVariable("tableId") int tableId) {
		ModelAndView mav = new ModelAndView();
		List<Subject> subjects = subjectService.sortDate();
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		theSubjectTable.setSubjects(subjects);
		for (Subject subject : subjects) {
			subject.changeDateFormat();
			if (subject.getSubjectTable().getId() == tableId) {
				theSubjectTable.addSubject(subject);
			}
		}
		mav.addObject("subjects", theSubjectTable.getSubjects());
		mav.addObject("table", theSubjectTable);
		mav.setViewName("table");
		return mav;
	}

	@RequestMapping("/table-form-create")
	public ModelAndView showCreateForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table", new SubjectTable());
		mav.setViewName("table_form_create");
		return mav;
	}

	@RequestMapping("/table-form-update")
	public ModelAndView showUpdateForm(@RequestParam("tableId") int tableId) {
		ModelAndView mav = new ModelAndView();
		SubjectTable theTable = subjectTableService.getOne(tableId);
		mav.addObject("table", theTable);
		mav.setViewName("table_form_update");
		return mav;
	}

	@RequestMapping("/table-form-delete")
	public ModelAndView showDeleteForm(@RequestParam("tableId") int tableId) {
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("table", theSubjectTable);
		mav.setViewName("table_form_delete");
		return mav;
	}

	@PostMapping("/table")
	public String create(@ModelAttribute SubjectTable theSubjectTable) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(dateTime.format(formatter));
		theSubjectTable.setDate(dateTime.format(formatter));
		subjectTableService.createOne(theSubjectTable);
		return "redirect:/api/allTables";
	}

	@PutMapping("/table")
	public String update(@ModelAttribute("table") SubjectTable theSubjectTable) {
		subjectTableService.updateOne(theSubjectTable);
		return "redirect:/api/allTables";
	}

	@DeleteMapping("/table/{theTableId}")
	public String delete(@PathVariable("theTableId") int theTableId) {
		subjectTableService.deleteOne(theTableId);
		return "redirect:/api/allTables";
	}

}
