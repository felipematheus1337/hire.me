package com.urlmapping.controller;


import com.urlmapping.dtos.CreateURLDTO;
import com.urlmapping.dtos.ErrorResponseDTO;
import com.urlmapping.dtos.ResponseURLDTO;
import com.urlmapping.exceptions.AliasAlreadyExistsException;
import com.urlmapping.exceptions.ApplicationException;
import com.urlmapping.exceptions.URLNotProvidedException;
import com.urlmapping.services.UrlMappingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/u")
public class URLMappingController {

    private final UrlMappingService service;

    public URLMappingController(UrlMappingService urlMappingService) {
        this.service = urlMappingService;
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseURLDTO> createShortenURL(@RequestParam("url") String url,
                                                           @RequestParam(value = "CUSTOM_ALIAS",
                                                                   required = false) String customAlias) throws ApplicationException {
        var createDTO = new CreateURLDTO(url, customAlias);
        var response = service.createShortenURL(createDTO);
        return ResponseEntity.status(201).body(response);
    }

}

