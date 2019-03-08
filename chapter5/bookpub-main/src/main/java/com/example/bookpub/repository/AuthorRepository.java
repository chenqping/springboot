package com.example.bookpub.repository;

import com.example.bookpub.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

//@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
