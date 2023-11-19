package com.edu.icesi.taller3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String nationality;
}
