package com.wardsoft.uniappentityservice.repository;

import com.wardsoft.uniappentityservice.entities.Entities;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entities", path = "entities")
public interface EntitiesRepository extends PagingAndSortingRepository<Entities, Long> {
}
