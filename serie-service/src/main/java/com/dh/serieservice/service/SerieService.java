package com.dh.serieservice.service;


import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.SerieRepository;
import com.dh.serieservice.sender.SerieSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vaninagodoy
 */

@Service
public class SerieService {

    private final SerieRepository repository;
    @Autowired
    private SerieSender serieSender;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<Serie> getAll() {
        return repository.findAll();
    }

    public List<Serie> getSeriesBygGenre(String genre) {
        return repository.findAllByGenre(genre);
    }

    public Serie create(Serie serie) {
        Serie serieConID = repository.save(serie);
        serieSender.send(serieConID);
        return serieConID;
    }
}
