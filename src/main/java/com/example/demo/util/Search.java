package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class Search {

	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "Search [word=" + word + "]";
	}

}
