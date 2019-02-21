package com.wisestep.elastic.service;

import java.util.List;

import com.wisestep.elastic.model.Bank;
import com.wisestep.elastic.utils.BankEnum;

/**
 * Provides methods to query Bank index
 * 
 * @author Ashish
 *
 */
public interface BankServiceDao {

	/**
	 * Get Bank record
	 * 
	 * @return List<Bank> max 10 records
	 */
	public List<Bank> getAllBanks();

	/**
	 * Get Bank detail based on Field and text provided
	 * 
	 * @param key
	 * @param text
	 * @return List<Bank> max 10 records
	 */
	public List<Bank> getBandDetailByFieldAndText(BankEnum key, String text);
}
