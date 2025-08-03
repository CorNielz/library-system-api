package com.cornielz.librarysystem.domain.author;

import java.util.Objects;

public class Author {
    private final UUID id;

    private String name;
    private String bios;

    private Datetime birthDdate;
    private String nationality;

    public Author(UUID id, String name, String bios, Datetime birthDdate, String nationality) {
        this.id = id;

        this.name = name;
        this.bios = bios;

        this.birthDdate = birthDdate;
        this.nationality = nationality;
    }
}