package sn.martial.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.martial.crud.dto.PersonneDto;
import sn.martial.crud.entities.Personne;
import sn.martial.crud.exception.ResourceNotFoundException;
import sn.martial.crud.mapping.PersonneMapper;
import sn.martial.crud.repository.PersonneRepository;
import sn.martial.crud.service.PersonneService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;

    @Override
    public PersonneDto createPersonne(PersonneDto personneDto) {
        Personne personne = PersonneMapper.mapToPersonne(personneDto);
        Personne saved = personneRepository.save(personne);
        return PersonneMapper.mapToPersonneDto(saved);
    }

    @Override
    public PersonneDto personneById(Long id) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personne not found with id: " + id));
        return PersonneMapper.mapToPersonneDto(personne);
    }

    @Override
    public PersonneDto updatePersonne(long id, PersonneDto personneDto) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personne not found with id: " + id));

        personne.setNom(personneDto.getNom());
        personne.setPrenom(personneDto.getPrenom());
        personne.setEmail(personneDto.getEmail());
        personne.setTelephone(personneDto.getTelephone());
        personne.setAdresse(personneDto.getAdresse());

        Personne updated = personneRepository.save(personne);
        return PersonneMapper.mapToPersonneDto(updated);
    }

    @Override
    public void deletePersonne(long id) {
        if (!personneRepository.existsById(id)) {
            throw new ResourceNotFoundException("Personne not found with id: " + id);
        }
        personneRepository.deleteById(id);
    }

    @Override
    public List<PersonneDto> findAll() {
        return personneRepository.findAll()
                .stream()
                .map(PersonneMapper::mapToPersonneDto)
                .collect(Collectors.toList());
    }
}
