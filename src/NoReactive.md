```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>3.3.0</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
```

```
    @GetMapping("all")
    public List<Article> getAllNoCache() throws InterruptedException {
        log.warn("Get from db");
        Thread.sleep(1000);
        return repository.findAll();
    }

    @Cacheable(cacheNames = "article")
    @GetMapping("all-cache")
    public Flux<Article> getAllCache() throws InterruptedException {
        log.warn("Get from db");
        Thread.sleep(1000);
        return repository.findAll();
    }
```
