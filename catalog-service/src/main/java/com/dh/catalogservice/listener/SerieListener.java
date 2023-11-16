package com.dh.catalogservice.listener;
import com.dh.catalogservice.records.Serie;
import com.dh.catalogservice.repositories.CatalogRepository;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {
    private final CatalogService catalogService;
    private CatalogRepository catalogRepository;

    public SerieListener(CatalogService catalogService) {

        this.catalogService = catalogService;
    }


    @RabbitListener(queues = {"${queue.ColaSerie.name}"})
    public void receive(@Payload Serie serie){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catalogService.guardarSerieEnCatalog(serie);
    }
}
