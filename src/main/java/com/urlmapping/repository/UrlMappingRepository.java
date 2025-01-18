package com.urlmapping.repository;

import com.urlmapping.dtos.TopVisitedURLDTO;
import com.urlmapping.entities.UrlMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {

    Optional<UrlMapping> findByAlias(String alias);









}
