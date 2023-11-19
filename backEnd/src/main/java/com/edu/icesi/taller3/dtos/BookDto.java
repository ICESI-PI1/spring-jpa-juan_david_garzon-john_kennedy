package com.edu.icesi.taller3.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BookDto {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private AuthorDto author;

}
