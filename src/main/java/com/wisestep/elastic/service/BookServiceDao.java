package com.wisestep.elastic.service;

import java.util.List;

import com.wisestep.elastic.model.Book;

/**
 * Provides methods to query Book index 
 * @author Ashish
 */
public interface BookServiceDao {
	
	
	/**
	 * Query Elastic server at Book index based on some text words 
	 * @param text
	 * @return List of Book/Empty List
	 */
	public List<Book> getBookContent(String text);
}
