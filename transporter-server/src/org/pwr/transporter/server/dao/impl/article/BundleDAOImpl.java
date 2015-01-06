package org.pwr.transporter.server.dao.impl.article;


import org.pwr.transporter.entity.article.Bundle;
import org.pwr.transporter.server.dao.article.BundleDAO;
import org.pwr.transporter.server.dao.impl.GenericWareDAOImpl;



/**
 * <pre>
 *    Custom functions impl for {@link Bundle} .
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class BundleDAOImpl extends GenericWareDAOImpl<Bundle> implements BundleDAO {

    public BundleDAOImpl() {
        setEntityClass(Bundle.class);
    }

}
