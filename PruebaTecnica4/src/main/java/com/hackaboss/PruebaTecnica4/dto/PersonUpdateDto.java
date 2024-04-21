package com.hackaboss.PruebaTecnica4.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateDto {
    private String name;
    private String lastName;
    private String email;
}
