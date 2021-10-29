package com.test.service;

import com.test.pojo.entity.Car;
import com.test.repository.ElasticRepository;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.DeleteAliasRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class ElasticSearchService {
    @Resource
    private ElasticRepository elasticRepository;
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private RestHighLevelClient restHighLevelClient;

    public void save(Car car) {
        elasticRepository.save(car);
    }

    public Iterable<Car> findAll() {
        Iterable<Car> all = elasticRepository.findAll();
        return all;
    }

    public void delete() {
        elasticRepository.deleteAll();
    }

    public Car findById(String id) {
        return elasticRepository.findById(id).get();
    }

    public List<Car> findByKey(String key) {
       return elasticRepository.findByName(key);

    }

    public GetAliasesResponse getAllIndex() throws IOException {
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
        GetAliasesResponse alias = restHighLevelClient.indices().getAlias(getAliasesRequest, RequestOptions.DEFAULT);
        return alias;
    }

    public void deleteIndexByName(String name) {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(name);
        try {
            restHighLevelClient.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
            restHighLevelClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
