package org.example.bookpub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.example.bookpub.entity.Publisher;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
}
