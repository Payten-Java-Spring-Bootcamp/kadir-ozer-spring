package com.example.week2.model.request;

import com.example.week2.model.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MovieAddRequest {

    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String directorName;
    private List<String> cast;
}
