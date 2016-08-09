package com.mongogeo.geospatial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongogeo.geospatial.cargainicial.LeituraDadosKML;
import com.mongogeo.geospatial.model.Localidade;
import com.mongogeo.geospatial.repository.LocalidadeRepository;

@Service
public class ImportaDadosKmlMongoDB {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public void carregarBaseMongoDBLocalidades() {

        Long count = localidadeRepository.quantidadeRegistrosBase();

        if (count == 0l) {
            LeituraDadosKML dadosCarregados = new LeituraDadosKML();

            List<Localidade> localidades = dadosCarregados.carregarLocalidadesKml();

            localidadeRepository.save(localidades);
        }
    }

}