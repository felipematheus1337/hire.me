package com.urlmapping.services;


import com.urlmapping.entities.UrlMapping;
import com.urlmapping.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {

    private final UrlMappingRepository repository;

    public  UrlMappingService(UrlMappingRepository urlMappingRepository) {
        this.repository = urlMappingRepository;
    }

}
