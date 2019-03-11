package org.example.bookpub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.example.bookpub.entity.Author;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
The @RepositoryRestResource annotation, while optional, provides us with the ability to have finer control
over the exposure of the repository as a web data service. For example, if we wanted to change the
URL path or rel value, to writers instead of authors, we could have tuned the annotation as follows:
@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
* */
@RepositoryRestResource
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
