package org.pwr.transporter.server.web.controllers.base.documents;


import javax.servlet.http.HttpServletRequest;

import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions;
import org.pwr.transporter.server.web.controllers.GenericController;



public class GenericDocumentController extends GenericController {

    @Override
    public Criteria restoreCriteria(HttpServletRequest request) {
        Criteria criteria = super.restoreCriteria(request);

        criteria.getSortCriteria().put("modifyDate", SortOptions.DESC);
        return criteria;
    }

}
