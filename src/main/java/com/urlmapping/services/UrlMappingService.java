package com.urlmapping.services;


import com.urlmapping.dtos.CreateURLDTO;
import com.urlmapping.entities.UrlMapping;
import com.urlmapping.exceptions.AliasAlreadyExistsException;
import com.urlmapping.exceptions.URLNotProvidedException;
import com.urlmapping.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {

    private final UrlMappingRepository repository;

    public  UrlMappingService(UrlMappingRepository urlMappingRepository) {
        this.repository = urlMappingRepository;
    }

    public ResponseURLDTO createShortenURL(CreateURLDTO dto) {
        this.validateURLDTO(dto);
        var url = new UrlMapping();
    }

    public void validateURLDTO(CreateURLDTO dto) {

        var originalURL = dto.url();

        if (originalURL.isEmpty() || originalURL.isBlank())
            throw new URLNotProvidedException();

        var urlWithSameAlias = this.repository.findByAlias(dto.customAlias());

        if (urlWithSameAlias.isPresent())
            throw new AliasAlreadyExistsException();


    }
}
