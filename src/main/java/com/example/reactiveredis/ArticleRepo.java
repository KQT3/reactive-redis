package com.example.reactiveredis;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class ArticleRepo implements ArticleRepository{

    @Override
    public <S extends Article> Mono<S> insert(S entity) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> insert(Publisher<S> entities) {
        return null;
    }

    @Override
    public <S extends Article> Mono<S> findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Article> Mono<Long> count(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Article> Mono<Boolean> exists(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Article, R, P extends Publisher<R>> P findBy(Example<S> example, Function<FluentQuery.ReactiveFluentQuery<S>, P> queryFunction) {
        return null;
    }

    @Override
    public Flux<Article> findAll(Sort sort) {
        return null;
    }

    @Override
    public <S extends Article> Mono<S> save(S entity) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Article> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<Article> findById(String s) {
        return null;
    }

    @Override
    public Mono<Article> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<Article> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<Article> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Article entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends String> strings) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Article> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Article> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
