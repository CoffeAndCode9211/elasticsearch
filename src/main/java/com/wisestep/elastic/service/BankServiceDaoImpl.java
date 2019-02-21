package com.wisestep.elastic.service;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.prefixQuery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.wisestep.elastic.model.Bank;
import com.wisestep.elastic.utils.BankEnum;

@Service
public class BankServiceDaoImpl implements BankServiceDao {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private ElasticsearchTemplate elasticTemplate;

	@Override
	public List<Bank> getAllBanks() {
		SearchQuery getAllQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
		return elasticTemplate.queryForList(getAllQuery, Bank.class);
	}

	@Override
	public List<Bank> getBandDetailByFieldAndText(BankEnum key, String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(prefixQuery(key.toString(), text)).build();
		return elasticTemplate.queryForList(searchQuery, Bank.class);
	}

}
