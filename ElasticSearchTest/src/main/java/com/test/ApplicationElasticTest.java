package com.test;

import com.test.repository.ElasticRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@ComponentScan("com.test")
@EnableElasticsearchRepositories(basePackages = {"com.test.repository"})
public class ApplicationElasticTest {
}
