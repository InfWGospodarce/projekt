package org.pwr.transporter.server.core.hb.criteria;


import java.util.HashMap;
import java.util.Map;



/**
 * <pre>
 *    Search criteria for hb requests
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class Criteria {

    private Map<String, Object> likeCriteria = new HashMap<String, Object>();
    private Map<String, Between> betweenCriteria = new HashMap<String, Between>();
    private Map<String, Object> idsCriteria = new HashMap<String, Object>();
    private Map<String, Object> equalCriteria = new HashMap<String, Object>();


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
}
