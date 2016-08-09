package com.mongogeo.geospatial.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LocalidadeDTO> buscarLocalidadePorIdIbge(@PathVariable Long idIbge) {
        
        LocalidadeDTO retorno = localidadeService.buscarLocalidadePorIdIbge(idIbge);
        
        if (retorno != null) {
            return ResponseEntity.status(HttpStatus.OK).body(retorno);
            
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
        }
       
    }
}
