package com.mongogeo.geospatial.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongogeo.geospatial.dto.LocalidadeDTO;
import com.mongogeo.geospatial.service.LocalidadeService;

@RestController
@RequestMapping("/v1/localidades")
public class LocalidadeControler {

    @Autowired
    private LocalidadeService localidadeService;
    
    @RequestMapping(value="/{idIbge}",  method = GET)
    public LocalidadeDTO buscarLocalidadePorIdIbge(@PathVariable Long idIbge) {
        
        LocalidadeDTO dto = localidadeService.buscarLocalidadePorIdIbge(idIbge);
        
        return dto;
    }
}
