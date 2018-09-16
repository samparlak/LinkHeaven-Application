package com.example.demo.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.example.demo.util.Search;

@Controller
@RequestMapping("/mvc")
public class SubjectTableController {

	@Autowired
	private GenericService<SubjectTable> subjectTableService;

	@Autowired
	private GenericService<Subject> subjectService;

	@GetMapping("/allTables")
	public ModelAndView viewAllSubjectTable() {
		List<SubjectTable> subjectTables = subjectTableService.sortHeader();
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.setDate(subjectTable.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("tables", subjectTables);
		mav.addObject("search", new Search());
		mav.setViewName("all-tables");
		return mav;
	}

	@GetMapping("/allTables-sortByDate")
	@ResponseBody
	public ModelAndView viewAllSubjectTableOrderByDate() {
		List<SubjectTable> subjectTables = subjectTableService.sortDate();
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.setDate(subjectTable.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("tables", subjectTables);
		mav.addObject("search", new Search());
		mav.setViewName("all-tables");
		return mav;
	}

	@PostMapping("/search-subjectTables")
	public ModelAndView search(@ModelAttribute("search") Search search) {
		Set<SubjectTable> subjectTables = subjectTableService.search(search.getWord());
		for (SubjectTable subjectTable : subjectTables) {
			subjectTable.setDate(subjectTable.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("tables", subjectTables);
		mav.addObject("search", new Search());
		mav.setViewName("all-tables");
		return mav;
	}

	@GetMapping("/table/{tableId}")
	public ModelAndView viewOneSubjectTable(@PathVariable int tableId) {
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId).changeDateFormat();
		List<Subject> subjects = theSubjectTable.getSubjects();
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("table", theSubjectTable);
		mav.addObject("search", new Search());
		mav.setViewName("table");
		return mav;
	}

	@RequestMapping("/table/{tableId}/sortHeader")
	public ModelAndView viewOneSubjectTableOrderByHeader(@PathVariable("tableId") int tableId) {
		List<Subject> subjects = subjectService.sortHeader();
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		theSubjectTable.setSubjects(subjects);
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
			if (subject.getSubjectTable().getId() == tableId) {
				theSubjectTable.addSubject(subject);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("table", theSubjectTable);
		mav.addObject("subjects", subjects);
		mav.addObject("search", new Search());
		mav.setViewName("table");
		return mav;
	}

	@RequestMapping("/table/{tableId}/sortDate")
	public ModelAndView viewOneSubjectTableOrderByDate(@PathVariable("tableId") int tableId) {
		List<Subject> subjects = subjectService.sortDate();
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		theSubjectTable.setSubjects(subjects);
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
			if (subject.getSubjectTable().getId() == tableId) {
				theSubjectTable.addSubject(subject);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("table", theSubjectTable);
		mav.addObject("search", new Search());
		mav.setViewName("table");
		return mav;
	}

	@PostMapping("/table/{tableId}/search-Subjects")
	public ModelAndView searchInOneTable(@ModelAttribute("search") Search search,
			@PathVariable("tableId") int tableId) {
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		Set<Subject> resultSubjects = new HashSet<>();
		System.out.println(search.getWord());
		Set<Subject> subjects = subjectService.search(search.getWord());
		System.out.println(subjects);
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
			if (subject.getSubjectTable().getId() == tableId) {
				resultSubjects.add(subject);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", resultSubjects);
		mav.addObject("table", theSubjectTable);
		mav.addObject("search", new Search());
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
	public ModelAndView showUpdateForm(@RequestParam("id") int tableId) {
		SubjectTable theTable = subjectTableService.getOne(tableId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("table", theTable);
		mav.setViewName("table_form_update");
		return mav;
	}

	@RequestMapping("/table-form-delete")
	public ModelAndView showDeleteForm(@RequestParam("id") int tableId) {
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId).changeDateFormat();
		ModelAndView mav = new ModelAndView();
		mav.addObject("table", theSubjectTable);
		mav.setViewName("table_form_delete");
		return mav;
	}

	@PostMapping("/table")
	public String create(@ModelAttribute SubjectTable theSubjectTable) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		theSubjectTable.setDate(dateTime.format(formatter));
		subjectTableService.createOne(theSubjectTable);
		return "redirect:/mvc/allTables";
	}

	@PutMapping("/table")
	public String update(@ModelAttribute("table") SubjectTable theSubjectTable) {
		subjectTableService.updateOne(theSubjectTable);
		return "redirect:/mvc/allTables";
	}

	@DeleteMapping("/table/{theTableId}")
	public String delete(@PathVariable("theTableId") int theTableId) {
		subjectTableService.deleteOne(theTableId);
		return "redirect:/mvc/allTables";
	}

}
