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

    private Object first;
    private Object second;


    public Between() {
        first = null;
        second = null;
    }


    public Between(Object first, Object to) {
        this.first = first;
        this.second = to;
    }


    public void setFirst(Object from) {
        this.first = from;
    }


    public Object getFirst() {
        return this.first;
    }


    public void setSecond(Object to) {
        this.second = to;
    }


    public Object getSecond() {
        return this.second;
    }

}
