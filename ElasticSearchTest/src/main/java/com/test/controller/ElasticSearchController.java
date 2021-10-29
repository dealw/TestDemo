package com.test.controller;

import com.test.pojo.entity.Car;
import com.test.service.ElasticSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.client.GetAliasesResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@Api(tags = "全文搜索相关接口")
@RequestMapping("/elastic")
public class ElasticSearchController {
    @Resource
    private ElasticSearchService elasticSearchService;

    @PostMapping
    @ApiOperation("保存")
    public void save(@RequestBody Car car) {
        elasticSearchService.save(car);
    }

    @GetMapping("index")
    @ApiOperation("获取所有索引")
    public GetAliasesResponse getAllIndex() throws IOException {
        return elasticSearchService.getAllIndex();
    }

    @DeleteMapping("{name}")
    @ApiOperation("根据索引名字删除索引")
    public void deleteIndexByName(@PathVariable String name){
        elasticSearchService.deleteIndexByName(name);
    }

    @GetMapping()
    @ApiOperation("获取所有文档")
    public Iterable<Car> getAll() {
        return elasticSearchService.findAll();
    }

    @GetMapping("id/{id}")
    @ApiOperation("根据id获取文档")
    public Car getById(@PathVariable String id){
        return elasticSearchService.findById(id);
    }

    @DeleteMapping()
    @ApiOperation("删除所有文档")
    public void delete() {
        elasticSearchService.delete();
    }

    @GetMapping("key/{key}")
    @ApiOperation("根据关键字查找文档")
    public List<Car> findByKey(@PathVariable String key) {
        return elasticSearchService.findByKey(key);
    }
}
