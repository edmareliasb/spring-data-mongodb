package com.mongogeo.geospatial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongogeo.geospatial.dto.GeoDTO;
import com.mongogeo.geospatial.dto.LocalidadeDTO;
import com.mongogeo.geospatial.model.Localidade;
import com.mongogeo.geospatial.repository.LocalidadeRepository;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepository;
    
    public LocalidadeDTO buscarLocalidadePorIdIbge(Long idIbge) {
     
        Localidade localidade = localidadeRepository.findByIdIbge(idIbge);
        
        if (localidade != null) {
            
            LocalidadeDTO dto = new LocalidadeDTO();
            
            dto.setIdIbge(localidade.getIdIbge());
            dto.setLocalidade(localidade.getLocalidade());
            dto.setMunicipio(localidade.getMunicipio());
            dto.setUf(localidade.getUf());
            
            GeoDTO geoDto = new GeoDTO();
            geoDto.setLatitude(localidade.getGeo().getLatitude());
            geoDto.setLongitude(localidade.getGeo().getLongitude());
            
            dto.setGeo(geoDto);
            
            return dto;
            
        } else {
            return null;
        }
    }
    
    public Double calcularDistanciaEntreCidades () {
        return null;
    }
    
    public List<Localidade> buscarLocalidadesPeloRaioEmKM() {
        return null;
    }
    
}
