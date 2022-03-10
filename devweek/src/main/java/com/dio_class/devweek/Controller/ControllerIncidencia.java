package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Repository.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerIncidencia {
    private final IncidenciaRepo ocRepository;


    public ControllerIncidencia(IncidenciaRepo ocRepository) {
        this.ocRepository = ocRepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> finIncidencia(){
        List<Incidencia> listaOcorrencia = ocRepository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciaById(@PathVariable Long id){
        Optional<Incidencia> ocorrenciaOptional = ocRepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            Incidencia ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia){
        return ocRepository.save(newIncidencia);
    }
}
