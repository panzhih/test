package com.testweb.testWeb.repository;

import com.testweb.testWeb.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MonitorAlarmRepository extends ElasticsearchRepository<Book, Long> {

}
