package org.example.bookpub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.example.bookpub.entity.Publisher;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
}
