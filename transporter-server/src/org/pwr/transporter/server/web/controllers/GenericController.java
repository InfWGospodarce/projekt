package org.pwr.transporter.server.web.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
 * @version 0.0.3
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

        List<T> list = null;

        UserAcc user = (UserAcc) request.getSession().getAttribute(SESION_USER_NAME);
        if( user == null ) {
            return list;
        }

        int page = (Integer) request.getAttribute(PAGE);
        request.setAttribute(PAGE_COUNT, service.count());

        return service.getListRest(user.getRowsPerPage(), user.getRowsPerPage() * page);
    }
}
