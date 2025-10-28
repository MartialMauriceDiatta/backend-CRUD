package sn.martial.crud.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;



}
