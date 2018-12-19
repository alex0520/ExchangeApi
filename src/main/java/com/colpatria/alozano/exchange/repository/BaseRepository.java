package com.colpatria.alozano.exchange.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    Optional<T> findById(ID id);
}