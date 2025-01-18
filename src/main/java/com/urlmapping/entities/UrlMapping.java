package com.urlmapping.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_url")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "original_url", nullable = false)
    private String originalURL;

    @Column(unique = true, nullable = false)
    private String alias;

    @Column(nullable = false)
    private Integer clicks;




}
