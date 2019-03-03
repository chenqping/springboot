package org.example.bookpub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.example.bookpub.entity.Author;

//@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
