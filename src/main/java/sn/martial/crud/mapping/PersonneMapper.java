package sn.martial.crud.mapping;

import sn.martial.crud.dto.PersonneDto;
import sn.martial.crud.entities.Personne;

public class PersonneMapper {

    public static PersonneDto mapToPersonneDto(Personne personne){
        return new PersonneDto(
                personne.getId(),
                personne.getPrenom(),
                personne.getNom(),
                personne.getAdresse(),
                personne.getTelephone(),
                personne.getEmail()
        );
    }

    public static Personne mapToPersonne(PersonneDto personneDto){
        return new Personne(
                personneDto.getId(),
                personneDto.getPrenom(),
                personneDto.getNom(),
                personneDto.getTelephone(),
                personneDto.getAdresse(),
                personneDto.getEmail()
        );
    }

}
