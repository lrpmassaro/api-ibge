package br.com.csv.repository;

import br.com.csv.model.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ColumnsRepository {

    @PersistenceContext
    EntityManager entityManager;
  
    public List<City> findByFilters(String column, String filter){

        StringBuilder consultvalue = new StringBuilder();
        consultvalue.append("SELECT COUNT(DISTINCT ");
        consultvalue.append(getNameColumn(column));
        consultvalue.append(") FROM cities");
        TypedQuery<City> query = entityManager.createQuery(consultvalue.toString(), City.class);

        switch (column) {
            case "ibge_id" : query.setParameter("FILTER", (filter));break;
            case "lat" : query.setParameter("FILTER", (filter));break;
            case "lon" : query.setParameter("FILTER", (filter));break;
            default:
                query.setParameter("FILTER", filter);
        }

        return query.getResultList();
    }
    
    private String getNameColumn(String column) {
        switch (column) {
            case "ibgeId" : return "ibge_id";
            case "uf" : return "uf";
            case "name" : return "name";
            case "capital" : return "capital";
            case "lon" : return "lon";
            case "lat" : return "lat";
            case "noAccents" : return "no_accents";
            case "alternativeNames" : return "alternative_names";
            case "microRegion" : return "microregion";
            case "macroRegion" : return "macroregion";

            default:
                throw new RuntimeException("A coluna informada não existe.");
        }
    }

}
