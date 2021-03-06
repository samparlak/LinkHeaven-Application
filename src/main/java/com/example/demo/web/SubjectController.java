package com.example.demo.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Subject;
import com.example.demo.model.SubjectTable;
import com.example.demo.service.GenericService;
import com.example.demo.util.Search;

@Controller
@RequestMapping("/mvc")
public class SubjectController {

	@Autowired
	private GenericService<Subject> subjectService;

	@Autowired
	private GenericService<SubjectTable> subjectTableService;

	@RequestMapping("/home")
	public String index() {
		return "index";
	}

	@RequestMapping("/allSubjects")
	public ModelAndView getAllSubjects() {
		List<Subject> subjects = subjectService.sortHeader();
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("search", new Search());
		mav.setViewName("all-subjects");
		return mav;
	}

	@RequestMapping("/allSubjects-sortByDate")
	public ModelAndView indexSortByDate_Subjects() {
		List<Subject> subjects = subjectService.sortDate();
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("search", new Search());
		mav.setViewName("all-subjects");
		return mav;
	}

	@PostMapping("/search-subjects")
	public ModelAndView search(@ModelAttribute("search") Search search) {
		Set<Subject> subjects = subjectService.search(search.getWord());
		for (Subject subject : subjects) {
			subject.setDate(subject.getDateTimeDifference());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjects", subjects);
		mav.addObject("search", new Search());
		mav.setViewName("all-subjects");
		return mav;
	}

	@GetMapping("subject")
	public ModelAndView viewOneSubject(@RequestParam("id") int theSubjectId) {
		Subject theSubject = subjectService.getOne(theSubjectId).changeDateFormat();
		ModelAndView mav = new ModelAndView();
		mav.addObject("subject", theSubject);
		mav.setViewName("subject");
		return mav;
	}

	@GetMapping("/subject-form-create")
	public ModelAndView showCreateForm(@RequestParam("tableId") int tableId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("subject", new Subject());
		mav.addObject("tableId", tableId);
		mav.setViewName("subject_form_create");
		return mav;
	}

	@GetMapping("/subject-form-update")
	public ModelAndView showUpdateForm(@RequestParam("tableId") int tableId, @RequestParam("subjectId") int subjectId) {
		Subject theSubject = subjectService.getOne(subjectId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("subject", theSubject);
		mav.addObject("tableId", tableId);
		mav.setViewName("subject_form_update");
		return mav;
	}

	@GetMapping("/subject-form-delete")
	public ModelAndView showDeleteForm(@RequestParam("subjectId") int subjectId) {
		Subject theSubject = subjectService.getOne(subjectId).changeDateFormat();
		ModelAndView mav = new ModelAndView();
		mav.addObject("subject", theSubject);
		mav.addObject("subjectId", subjectId);
		mav.setViewName("subject_form_delete");
		return mav;
	}

	@PostMapping("/subject")
	public String create(@ModelAttribute("subject") Subject theSubject, @RequestParam("tableId") int tableId) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss.SSS");
		String date = dateTime.format(formatter);
		theSubject.setDate(date);
		SubjectTable theSubjectTable = subjectTableService.getOne(tableId);
		theSubjectTable.addSubject(theSubject);
		subjectService.createOne(theSubject);
		return "redirect:/mvc/allSubjects";
	}

	@PutMapping("/subject")
	public String update(@ModelAttribute Subject theSubject, @RequestParam("tableId") int tableId) {
		theSubject.setSubjectTable(subjectTableService.getOne(tableId));
		subjectService.updateOne(theSubject);
		return "redirect:/mvc/allSubjects";
	}

	@DeleteMapping("subject/{theSubjectId}")
	public String delete(@PathVariable int theSubjectId) {
		subjectService.deleteOne(theSubjectId);
		return "redirect:/mvc/allSubjects";
	}

}