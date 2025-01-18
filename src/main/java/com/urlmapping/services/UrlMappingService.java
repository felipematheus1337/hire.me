package com.urlmapping.services;


import com.urlmapping.dtos.CreateURLDTO;
import com.urlmapping.dtos.ResponseURLDTO;
import com.urlmapping.dtos.Statistics;
import com.urlmapping.entities.UrlMapping;
import com.urlmapping.exceptions.AliasAlreadyExistsException;
import com.urlmapping.exceptions.URLNotProvidedException;
import com.urlmapping.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {

    private final UrlMappingRepository repository;

    @Value("base-url-service")
    private String baseURL;

    public  UrlMappingService(UrlMappingRepository urlMappingRepository) {
        this.repository = urlMappingRepository;
    }

    public ResponseURLDTO createShortenURL(CreateURLDTO dto) {
        long startTime = System.currentTimeMillis();
        this.validateURLDTO(dto);
        var url = new UrlMapping();
        var alias = dto.customAlias();

        if (alias.isEmpty() || alias.isBlank())
            alias = this.generateCode();

        url.setAlias(alias);
        url.setClicks(0);

        this.repository.save(url);

        String timeTaken =  (System.currentTimeMillis() - startTime) + "ms";

        return new ResponseURLDTO(
                alias,
                baseURL + alias,
                dto.url(),
                new Statistics(timeTaken)
        );
    }

    public void validateURLDTO(CreateURLDTO dto) {

        var originalURL = dto.url();
        var customAlias = dto.customAlias();

        if (originalURL.isEmpty() || originalURL.isBlank())
            throw new URLNotProvidedException();

        if (customAlias.isEmpty() || customAlias.isBlank())
            return;

        var urlWithSameAlias = this.repository.findByAlias(customAlias);

        if (urlWithSameAlias.isPresent())
            throw new AliasAlreadyExistsException();
    }

    private String generateCode() {
        return "";
    }
}
