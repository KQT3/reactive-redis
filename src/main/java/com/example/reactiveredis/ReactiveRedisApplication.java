package com.example.reactiveredis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static java.lang.Thread.sleep;

@SpringBootApplication
//@EnableRedisRepositories
//@EnableReactiveMongoRepositories

@EnableCaching
public class ReactiveRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRedisApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(ArticleRepository repository) {
        return args -> {
            Article name = new Article(UUID.randomUUID().toString(), "name");
            repository.save(name).subscribe();
        };
    }
}


@RestController
@RequestMapping("article")
@AllArgsConstructor
@Slf4j
class ArticleController {

    ArticleRepository repository;

    @GetMapping("all")
    public Flux<Article> getAllNoCache() throws InterruptedException {
        log.warn("Get from db");
//        Thread.sleep(1000);
        return repository.findAll().delaySubscription(Duration.ofSeconds(1));
    }

    @Cacheable(cacheNames = "article")
    @GetMapping("all-cache")
    public Flux<Article> getAllCache() throws InterruptedException {
        log.warn("Get from db");
//        Thread.sleep(1000);
        return repository.findAll().delaySubscription(Duration.ofSeconds(1));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("article")
class Article implements Serializable {
    @Id String id;
    String name;
}

@Repository
interface ArticleRepository extends ReactiveMongoRepository<Article, String> {
}
