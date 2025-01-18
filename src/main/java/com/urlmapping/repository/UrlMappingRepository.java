package com.urlmapping.repository;

import com.urlmapping.entities.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {

    Optional<UrlMapping> findByAlias(String alias);
}
