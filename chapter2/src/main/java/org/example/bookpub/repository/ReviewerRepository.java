package org.example.bookpub.repository;

import org.example.bookpub.entity.Reviewer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewerRepository extends PagingAndSortingRepository<Reviewer, Long> {
}
