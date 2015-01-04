package org.pwr.transporter.server.core.hb.criteria;


/**
 * <pre>
 *    Helper pair class
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class Between {

    private Object from;
    private Object to;


    public Between() {
        from = null;
        to = null;
    }


    Between(Object from, Object to) {
        this.from = from;
        this.to = to;
    }


    public void setFrom(Object from) {
        this.from = from;
    }


    public Object getFrom() {
        return this.from;
    }


    public void setTo(Object to) {
        this.to = to;
    }


    public Object getTo() {
        return this.to;
    }

}
