package com.mongogeo.geospatial.dto;

import java.io.Serializable;

public class LocalidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idIbge;

    private String uf;

    private String municipio;

    private String localidade;

    private GeoDTO geoDto;

    public long getIdIbge() {
        return idIbge;
    }

    public void setIdIbge(long idIbge) {
        this.idIbge = idIbge;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public GeoDTO getGeoDto() {
        return geoDto;
    }

    public void setGeoDto(GeoDTO geoDto) {
        this.geoDto = geoDto;
    }

}
