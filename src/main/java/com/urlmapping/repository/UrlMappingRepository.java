package com.urlmapping.repository;

import com.urlmapping.entities.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {
}
