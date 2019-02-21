package com.wisestep.elastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisestep.elastic.model.Bank;
import com.wisestep.elastic.service.BankServiceDao;
import com.wisestep.elastic.utils.BankEnum;

@RestController
@RequestMapping("/bank")
@CrossOrigin
public class BankController {

	@Autowired
	private BankServiceDao bankService;

	/**
	 * HTTP Rest API for searching Bank Detail from Elastic Server
	 * @return List<Bank> max 10 records
	 */
	@RequestMapping
	public List<Bank> getAllBanks() {
		return bankService.getAllBanks();
	}

	/**
	 * HTTP Rest API for searching Bank Detail on selected field and text provided
	 * @param key
	 * @param text
	 * @return List<Bank> max 10 records
	 */
	@RequestMapping("/search")
	public List<Bank> getBandDetailByField(@RequestParam("key") BankEnum key, @RequestParam("text") String text) {
		return bankService.getBandDetailByFieldAndText(key, text);
	}

}
