package com.urlmapping.controller;


import com.urlmapping.dtos.CreateURLDTO;
import com.urlmapping.dtos.ErrorResponseDTO;
import com.urlmapping.exceptions.ApplicationException;
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
    public ResponseEntity<?> createShortenURL(@RequestParam("url") String url,
                                              @RequestParam(value = "CUSTOM_ALIAS", required = false) String customAlias) {
        var createDTO = new CreateURLDTO(url, customAlias);
        try {
            var response = service.createShortenURL(createDTO);
            return ResponseEntity.status(201).body(response);

        } catch(ApplicationException e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(
                  customAlias,
                    e.getCode(),
                    e.getDescription()
            ));
        }
    }
}
