package sn.martial.crud.service;

import sn.martial.crud.dto.PersonneDto;
import sn.martial.crud.entities.Personne;

import java.util.List;

public interface PersonneService {

    PersonneDto createPersonne(PersonneDto personneDto);

    PersonneDto personneById(Long id);

    PersonneDto updatePersonne(long id, PersonneDto personneDto);

    void deletePersonne(long id);

    List<PersonneDto> findAll();
}
