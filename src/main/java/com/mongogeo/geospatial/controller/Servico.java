package com.mongogeo.geospatial.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongogeo.geospatial.service.ImportaDadosKmlMongoDB;

@RestController
@RequestMapping("/v1/servico")
public class Servico {

    @Autowired
    private ImportaDadosKmlMongoDB importaDados;
    
    @RequestMapping(method = GET)
    public String buscarAgencias(HttpServletRequest request) {
        
        importaDados.carregarBaseMongoDBLocalidades();
        
        return request.getContextPath();
    }
    
}
