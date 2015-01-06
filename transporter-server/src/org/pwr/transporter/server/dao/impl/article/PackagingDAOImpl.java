package org.pwr.transporter.server.dao.impl.article;


import org.pwr.transporter.entity.article.Packaging;
import org.pwr.transporter.server.dao.article.PackagingDAO;
import org.pwr.transporter.server.dao.impl.GenericWareDAOImpl;



/**
 * <pre>
 *    Custom functions impl for {@link Packaging}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PackagingDAOImpl extends GenericWareDAOImpl<Packaging> implements PackagingDAO {

    public PackagingDAOImpl() {
        setEntityClass(Packaging.class);
    }

}
