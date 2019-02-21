package com.wisestep.elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "shakespeare", type = "doc")
public class Book {

	@Id
	private int line_id;

	private String text_entry;

	private float score;

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public String getText_entry() {
		return text_entry;
	}

	public void setText_entry(String text_entry) {
		this.text_entry = text_entry;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Book [line_id=" + line_id + ", text_entry=" + text_entry
				+ ", score=" + score + "]";
	}

}
