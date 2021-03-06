package org.pwr.transporter.server.web.controllers;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;



/**
 * <pre>
 *    Basic functions for controllers.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.9
 */
public abstract class GenericController {

    private static Logger LOGGER = Logger.getLogger(GenericController.class);

    public static final String SESION_USER_NAME = "userctx";
    public static final String PAGE = "page";
    public static final String PAGE_COUNT = "pageCount";


    public Criteria restoreCriteria(HttpServletRequest request) {

        Criteria criteria = new Criteria();
        String actName = "active";
        String active = request.getParameter(actName);
        if( active == null ) {
            actName = "filled";
            active = request.getParameter(actName);
        }

        if( active != null ) {
            if( active.equals("0") ) {
                criteria.getEqualCriteria().put(actName, true);
            } else if( active.equals("1") ) {
                criteria.getEqualCriteria().put(actName, false);
            }
        }
        String searchKey = (String) request.getParameter("searchKey");
        if( searchKey != null && !searchKey.isEmpty() ) {
            criteria.getLikeCriteria().put("searchKey", searchKey);
        }
        String name = (String) request.getParameter("name");
        if( name != null && !name.isEmpty() ) {
            criteria.getLikeCriteria().put("name", name);
        }
        return criteria;
    }


    /**
     * <pre>
     *        Return ranged list of selected objects
     * </pre>
     * <hr/>
     * 
     * @param service
     * @param request
     * @return
     */
    public <T extends Generic> List<T> getList(IService service, HttpServletRequest request) {

        List<T> list = new ArrayList<T>();

        UserAcc user = (UserAcc) request.getSession().getAttribute(SESION_USER_NAME);
        if( user == null ) {
            return list;
        }

        int page = getPage(request);
        request.setAttribute(PAGE, page);
        request.getSession().setAttribute(PAGE, page);
        BigDecimal pages = ( new BigDecimal(service.count()) ).divide(new BigDecimal(user.getRowsPerPage()), BigDecimal.ROUND_UP);
        if( pages.compareTo(BigDecimal.ZERO) == 0 ) {
            pages = BigDecimal.ONE;
        }

        request.setAttribute(PAGE_COUNT, pages.intValue());

        if( page < 1 || page > pages.intValue() ) {
            return new ArrayList<T>();
        }
        return service.getListRest(user.getRowsPerPage(), user.getRowsPerPage() * ( page - 1 ));
    }


    public <T extends Generic> List<T> getListWithCriteria(IService service, HttpServletRequest request, Criteria criteria) {

        List<T> list = null;

        UserAcc user = (UserAcc) request.getSession().getAttribute(SESION_USER_NAME);
        if( user == null ) {
            return list;
        }

        int page = getPage(request);
        request.setAttribute(PAGE, page);
        request.getSession().setAttribute(PAGE, page);
        BigDecimal pages = ( new BigDecimal(service.count(criteria)) ).divide(new BigDecimal(user.getRowsPerPage()), BigDecimal.ROUND_UP);
        if( pages.compareTo(BigDecimal.ZERO) == 0 ) {
            pages = BigDecimal.ONE;
        }

        request.setAttribute(PAGE_COUNT, pages.intValue());

        if( page < 1 || page > pages.intValue() ) {
            return new ArrayList<T>();
        }
        return service.getListRestCrit(user.getRowsPerPage(), user.getRowsPerPage() * ( page - 1 ), criteria);
    }


    public int getPage(HttpServletRequest request) {
        int page = 1;
        String ob = request.getParameter(PAGE);
        LOGGER.debug("PAGE: " + ob);
        if( ob != null ) {
            try {
                page = Integer.valueOf(ob);
            } catch ( NumberFormatException e ) {

            }
        } else {
            if( request.getSession().getAttribute(PAGE) == null ) {
                return page;
            }
            ob = request.getSession().getAttribute(PAGE).toString();
            if( ob != null ) {
                try {
                    page = Integer.valueOf(ob);
                } catch ( NumberFormatException e ) {

                }
            }
        }
        return page;
    }


    protected Long getId(String parameter) {
        if( parameter == null ) {
            return null;
        }
        try {
            return Long.parseLong(parameter);
        } catch ( NumberFormatException e ) {
            return null;
        }
    }


    public boolean validate(Object object, Model model, BindingResult formBindeings, Validator validator) {
        validator.validate(object, formBindeings);

        if( formBindeings.hasErrors() ) {
            LOGGER.info("Validation fails");
            model.addAttribute("object", object);
            loadData(model);
            LOGGER.debug(formBindeings.getFieldErrors().toString());
            return false;
        }
        return true;
    }


    public abstract void loadData(Model model);
}
