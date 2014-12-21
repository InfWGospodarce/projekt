package org.pwr.transporter.server.web.controllers.base.enums;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * <pre>
 *    Control sites related with {@link AddrStreetPrefix}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class StreetPrefixController extends GenericController {

    @Autowired
    AddrStreetPrefixService addrStreetPrefixService;


    @RequestMapping(value = "/admin/streetPrefixList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<AddrStreetPrefix> streetPrefixList = getList(addrStreetPrefixService, request);
        request.setAttribute("prefixList", streetPrefixList);

        return "Views/admin/streetPrefixList";
    }


    @RequestMapping(value = "/admin/streetPrefixEdit", method = RequestMethod.GET)
    public String getPrefix(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = (Long) request.getAttribute("id");
        AddrStreetPrefix streetPrefix = null;
        if( id == null ) {
            streetPrefix = new AddrStreetPrefix();
        } else {
            streetPrefix = addrStreetPrefixService.getByID(id);
            if( streetPrefix == null || streetPrefix.getId() == null ) {
                streetPrefix = new AddrStreetPrefix();
            }
        }

        request.setAttribute("prefix", streetPrefix);

        return "Views/admin/streetPrefixList";
    }


    @RequestMapping(value = "/admin/streetPrefixEdit", method = RequestMethod.POST)
    public String postPrefix(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "redirect:Views/admin/streetPrefixList";
    }

}
