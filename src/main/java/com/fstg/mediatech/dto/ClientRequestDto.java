package com.fstg.mediatech.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    @NotNull(message="Le nom doit etre non-null")
    @Size(min = 3, max = 10, message = "Le nombre de caracteres doit etre entre 3 et 10")
    private String nom;
    @NotNull(message="Le nom doit etre non-null")
    @Size(min = 3, max = 10, message = "Le nombre de caracteres doit etre entre 3 et 10")
    private String prenom;
    @NotNull(message="Le nom doit etre non-null")
    @Size(min = 3, max = 10, message = "Le nombre de caracteres doit etre entre 3 et 10")
    private String telephone;
}
