package org.pwr.transporter.server.web.controllers;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.web.services.IService;



/**
 * <pre>
 *    Basic functions for controllers.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.6
 */
public class GenericController {

    public static final String SESION_USER_NAME = "userctx";
    public static final String PAGE = "page";
    public static final String PAGE_COUNT = "pageCount";


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
    public <T extends GenericEntity> List<T> getList(IService service, HttpServletRequest request) {

        Logger LOGGER = Logger.getLogger(GenericController.class);

        List<T> list = null;

        UserAcc user = (UserAcc) request.getSession().getAttribute(SESION_USER_NAME);
        if( user == null ) {
            return list;
        }

        int page = 1;
        String ob = request.getParameter(PAGE);
        LOGGER.debug("PAGE: " + ob);
        if( ob != null ) {
            try {
                page = Integer.valueOf(ob);
            } catch ( NumberFormatException e ) {

            }
        }
        request.setAttribute(PAGE, page);
        BigDecimal pages = ( new BigDecimal(service.count()) ).divide(new BigDecimal(user.getRowsPerPage()), BigDecimal.ROUND_UP);

        request.setAttribute(PAGE_COUNT, pages.intValue());

        if( page < 1 || page > pages.intValue() ) {
            return new ArrayList<T>();
        }
        return service.getListRest(user.getRowsPerPage(), user.getRowsPerPage() * ( page - 1 ));
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
}
