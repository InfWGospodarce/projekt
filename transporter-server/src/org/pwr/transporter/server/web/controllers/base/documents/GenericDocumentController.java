package org.pwr.transporter.server.web.controllers.base.documents;


import javax.servlet.http.HttpServletRequest;

import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CurrencyService;
import org.pwr.transporter.server.web.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;



public abstract class GenericDocumentController extends GenericController {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    UnitService unitService;


    @Override
    public Criteria restoreCriteria(HttpServletRequest request) {
        Criteria criteria = super.restoreCriteria(request);

        criteria.getSortCriteria().put("modifyDate", SortOptions.DESC);
        return criteria;
    }


    @Override
    public void loadData(Model model) {
        model.addAttribute("currencies", currencyService.getList());
        model.addAttribute("units", unitService.getList());
    }

}
