package com.dh.catalogservice.service;

import com.dh.catalogservice.clients.SerieServiceClient;
import com.dh.catalogservice.records.Serie;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SeriesService implements SerieServiceClient {
    private SerieServiceClient SerieServiceClient;



    @Override
    public ResponseEntity<Serie> create(Serie serie) {
        return SerieServiceClient.create(serie);
    }
}

