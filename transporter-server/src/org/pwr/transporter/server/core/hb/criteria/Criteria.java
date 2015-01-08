package org.pwr.transporter.server.core.hb.criteria;


import java.util.LinkedHashMap;
import java.util.Map;



/**
 * <pre>
 *    Search criteria for hb requests
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public class Criteria {

    public enum SortOptions {
        ASC, DESC
    };


    private Map<String, Object> likeCriteria = new LinkedHashMap<String, Object>();
    private Map<String, Between> betweenCriteria = new LinkedHashMap<String, Between>();
    private Map<String, Object> idsCriteria = new LinkedHashMap<String, Object>();
    private Map<String, Object> equalCriteria = new LinkedHashMap<String, Object>();
    private Map<String, Object> sortCriteria = new LinkedHashMap<String, Object>();

    private String orderBy = null;


    public Criteria() {
    }


    public Map<String, Between> getBetweenCriteria() {
        return this.betweenCriteria;
    }


    public void setBetweenCriteria(Map<String, Between> betweenCriteria) {
        this.betweenCriteria = betweenCriteria;
    }


    public Map<String, Object> getEqualCriteria() {
        return this.equalCriteria;
    }


    public void setEqualCriteria(Map<String, Object> equalCriteria) {
        this.equalCriteria = equalCriteria;
    }


    public Map<String, Object> getIdsCriteria() {
        return this.idsCriteria;
    }


    public void setIdsCriteria(Map<String, Object> idsCriteria) {
        this.idsCriteria = idsCriteria;
    }


    public Map<String, Object> getLikeCriteria() {
        return this.likeCriteria;
    }


    public void setLikeCriteria(Map<String, Object> likeCriteria) {
        this.likeCriteria = likeCriteria;
    }


    public Map<String, Object> getSortCriteria() {
        return this.sortCriteria;
    }


    public void setSortCriteria(Map<String, Object> sortCriteria) {
        this.sortCriteria = sortCriteria;
    }


    public String getOrderBy() {
        return this.orderBy;
    }


    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
