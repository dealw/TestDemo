package com.test.repository;

import com.test.pojo.entity.Car;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ElasticRepository extends ElasticsearchRepository<Car,String> {

    List<Car> findByName(String key);
}
