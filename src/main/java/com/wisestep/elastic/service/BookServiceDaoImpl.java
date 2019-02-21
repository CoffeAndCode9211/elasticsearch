package com.wisestep.elastic.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisestep.elastic.model.Book;
import com.wisestep.elastic.utils.Const;

@Service
public class BookServiceDaoImpl implements BookServiceDao {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Book> getBookContent(String text) {
		List<Book> profileDocuments = new ArrayList<>();
		try {
			SearchRequest searchRequest = new SearchRequest();
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(
					"text_entry", text);
			searchSourceBuilder.query(matchQueryBuilder);
			searchRequest.source(searchSourceBuilder);
			SearchResponse searchResponse = client.search(searchRequest,
					RequestOptions.DEFAULT);

			SearchHit[] searchHit = searchResponse.getHits().getHits();
			if (searchHit != null) {
				for (SearchHit hit : searchHit) {
					float score = hit.getScore();
					Book book = objectMapper.convertValue(hit.getSourceAsMap(),
							Book.class);
					book.setScore(score);
					profileDocuments.add(book);
				}
			}
		} catch (IOException e) {
			LOG.error(Const.BOOK_SEARCH_ERROR, e);
		}
		return profileDocuments;
	}

}
