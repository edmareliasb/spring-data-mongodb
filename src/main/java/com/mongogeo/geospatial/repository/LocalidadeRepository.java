package com.mongogeo.geospatial.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongogeo.geospatial.model.Localidade;

@Repository
public class LocalidadeRepository {

    public static final Double RAIO_DE_DISTANCIA_EM_KM = 90.0d;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public void save(Localidade localidade) {
        mongoTemplate.insert(localidade);
    }
    
    public void save(List<Localidade> localidades) {
        mongoTemplate.insert(localidades, "brlocalidades");
    }
 
    public Localidade findById(String id) {

        Query query = new Query(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, Localidade.class);
    }
    
    public Localidade findByIdIbge(Long idIbge) {
        
        Query query = new Query(Criteria.where("idIbge").is(idIbge));

        Localidade localidade = mongoTemplate.findOne(query, Localidade.class);

        return localidade;
    }

    public List<Localidade> findAll() {
        return mongoTemplate.findAll(Localidade.class);
    }
    
    public Long quantidadeRegistrosBase() {
        return mongoTemplate.count(new Query(), Localidade.class);
    }
    
    public Localidade findByUfNomeLocalidade(String uf, String nomeLocalidade) {
                
        Query query = new Query(Criteria.where("uf").is(uf).and("localidade").is(nomeLocalidade));

        return mongoTemplate.findOne(query,Localidade.class);
    }
    
}
