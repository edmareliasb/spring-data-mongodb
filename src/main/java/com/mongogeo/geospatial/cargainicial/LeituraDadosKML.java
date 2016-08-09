package com.mongogeo.geospatial.cargainicial;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.mongogeo.geospatial.model.Geo;
import com.mongogeo.geospatial.model.Localidade;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.SchemaData;
import de.micromata.opengis.kml.v_2_2_0.SimpleData;

public class LeituraDadosKML {
    
    private static String ID = "ID";
    private static String UF = "NM_UF";
    private static String MUNICIPIO = "NM_MUNICIPIO";
    private static String LOCALIDADE = "NM_LOCALIDADE";
    private static String LONG = "LONG";
    private static String LAT = "LAT";

    public List<Localidade> carregarLocalidadesKml() {

        try {

            File file = new File("dados\\BR Localidades 2010 v1.kml");

            InputStream in = new BufferedInputStream(new FileInputStream(file));

            Kml kml = Kml.unmarshal(in);

            Document document = (Document) kml.getFeature();

            List<Feature> features = document.getFeature();

            List<Localidade> localidades = new ArrayList<>();

            Localidade localidade;
            Geo geo;

            for (Feature feature : features) {

                Folder folder = (Folder) feature;
                List<Feature> folderFeatures = folder.getFeature();

                for (Feature folderFeature : folderFeatures) {

                    List<SchemaData> schemaDataList = folderFeature.getExtendedData().getSchemaData();

                    for (SchemaData schemaData : schemaDataList) {
                        List<SimpleData> simpleDataList = schemaData.getSimpleData();

                        localidade = new Localidade();
                        geo = new Geo();
                        for (SimpleData simpleData : simpleDataList) {
                            montarLocalidade(simpleData, localidade, geo);
                        }

                        localidade.setGeo(geo);
                        localidades.add(localidade);
                    }

                }

                // Sai do FOR. Nesse projeto vou carregar apenas os dados das
                // cidades
                break;
            }

            return localidades;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void montarLocalidade(SimpleData simpleData, Localidade localidade, Geo geo) {

        if (ID.equals(simpleData.getName())) {
            localidade.setIdIbge(Long.parseLong(simpleData.getValue()));

        } else if (UF.equals(simpleData.getName())) {
            localidade.setUf(simpleData.getValue());

        } else if (MUNICIPIO.equals(simpleData.getName())) {
            localidade.setMunicipio(simpleData.getValue());

        } else if (LOCALIDADE.equals(simpleData.getName())) {
            localidade.setLocalidade(simpleData.getValue());

        } else if (LONG.equals(simpleData.getName())) {
            geo.setLongitude(Double.valueOf(simpleData.getValue()));

        } else if (LAT.equals(simpleData.getName())) {
            geo.setLatitude(Double.valueOf(simpleData.getValue()));

        }
    }

}