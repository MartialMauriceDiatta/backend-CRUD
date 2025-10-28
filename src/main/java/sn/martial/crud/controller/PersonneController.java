package sn.martial.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.martial.crud.dto.PersonneDto;
import sn.martial.crud.service.PersonneService;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    private final PersonneService personneService;

    // Ajouter une personne
    @PostMapping
    public ResponseEntity<PersonneDto> savePersonne(@RequestBody PersonneDto personneDto) {
        PersonneDto save = personneService.createPersonne(personneDto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    // Récupérer une personne par ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonneDto> getPersonne(@PathVariable long id) {
        PersonneDto personneDto = personneService.personneById(id);
        return ResponseEntity.ok(personneDto);
    }

    // Mettre à jour une personne
    @PutMapping("/{id}")
    public ResponseEntity<PersonneDto> updatePersonne(
            @PathVariable long id,
            @RequestBody PersonneDto personneDto) {
        PersonneDto update = personneService.updatePersonne(id, personneDto);
        return ResponseEntity.ok(update);
    }

    // Supprimer une personne
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonne(@PathVariable long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.ok("Personne supprimée avec succès.");
    }

    // Récupérer toutes les personnes
    @GetMapping
    public ResponseEntity<List<PersonneDto>> findAll() {
        List<PersonneDto> personnes = personneService.findAll();
        return ResponseEntity.ok(personnes);
    }
}
