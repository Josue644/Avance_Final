package com.Trabajo.Final.service;

import com.Trabajo.Final.model.Docente;
import com.Trabajo.Final.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    public void saveDocente(Docente docente) {
        docenteRepository.save(docente);
    }

    public void deleteDocenteById(Long id) {
        docenteRepository.deleteById(id);
    }
}
