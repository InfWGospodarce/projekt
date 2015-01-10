package org.pwr.transporter.server.web.controllers.base.documents.sales;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.entity.enums.article.ArticleType;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.base.documents.GenericDocumentController;
import org.pwr.transporter.server.web.services.sales.RequestService;
import org.pwr.transporter.server.web.validators.documents.sales.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.article.ArticleService;
=======
>>>>>>> branch 'master' of https://github.com/InfWGospodarce/projekt.git
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Controller for {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class RequestController extends GenericDocumentController {

	private static Logger LOGGER = Logger.getLogger(RequestController.class);

	@Autowired
	RequestService requestService;

	@Autowired
	RequestValidator validator;

	@RequestMapping(value = "/seller/requestList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

<<<<<<< HEAD
    @Autowired 
    ArticleService articleService;
    
    @Override
    public void loadData(Model model) {
        model.addAttribute("addrStreetPrefixs", addrStreetPrefixService.getList());
        model.addAttribute("countries", countryService.getList());
=======
		Criteria criteria = restoreCriteria(request);
		List<Request> list = getListWithCriteria(requestService, request, criteria);
		model.addAttribute("list", list);
>>>>>>> branch 'master' of https://github.com/InfWGospodarce/projekt.git

		String ret = "/Views/seller/requestList";
		return ret;
	}

	@RequestMapping(value = "/customer/customerHistory", method = RequestMethod.GET)
	public String getListForCustomer( HttpServletRequest request, HttpServletResponse response, Model model ) {

		UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");

		Criteria criteria = restoreCriteria(request);
		if ( user != null && user.getCustomer() != null ) {
			criteria.getIdsCriteria().put("customer.id", user.getCustomer().getId());
		}
		List<Request> list = getListWithCriteria(requestService, request, criteria);

		model.addAttribute("list", list);
		return "Views/customer/customerHistory";
	}

	@RequestMapping(value = "/seller/requestEdit", method = RequestMethod.GET)
	public String get( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		loadData(model);
		Request object = null;
		if ( id == null ) {
			object = new Request();
		} else {
			object = requestService.getByID(id);
			if ( object == null || object.getId() == null ) {
				object = new Request();
			}
		}

		model.addAttribute("object", object);

		return "Views/seller/edit/requestEdit";
	}

	@RequestMapping(value = "/seller/requestEdit", method = RequestMethod.POST)
	public String post( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Request object,
			BindingResult formBindeings, Model model ) {

		if ( !validate(object, model, formBindeings, validator) ) {
			return "/Views/seller/edit/requestEdit";
		}

		if ( object.getId() != null ) {
			LOGGER.debug("Id not null");
			requestService.update(object);
		} else {
			requestService.insert(object);
		}

		return "redirect:../seller/requestList?page=" + getPage(request);
	}

<<<<<<< HEAD
        Long id = getId(request.getParameter("id"));
        Request requestOBJ = null;
        if( id == null ) {
            requestOBJ = new Request();
        } else {
            requestOBJ = requestService.getByID(id);
            if( requestOBJ == null || requestOBJ.getId() == null ) {
                requestOBJ = new Request();
            }
        }
        loadData(model);
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("articleType", ArticleType.TransportService);
        List<Article> art = articleService.search(criteria);  
      
        model.addAttribute("object", requestOBJ);
        model.addAttribute("art", art);
=======
	@RequestMapping(value = "/customer/customerHistoryEdit", method = RequestMethod.GET)
	public String getEdit( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Request requestOBJ = null;
		if ( id == null ) {
			requestOBJ = new Request();
		} else {
			requestOBJ = requestService.getByID(id);
			if ( requestOBJ == null || requestOBJ.getId() == null ) {
				requestOBJ = new Request();
			}
		}
		loadData(model);
>>>>>>> branch 'master' of https://github.com/InfWGospodarce/projekt.git

		model.addAttribute("object", requestOBJ);

		return "Views/customer/customerHistoryEdit";
		// return "Views/customer/customerHistory";
	}

	@RequestMapping(value = "/customer/customerHistoryEdit", method = RequestMethod.POST)
	public String postEdit( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") Request requestOBJ,
			BindingResult formBindeings, Model model ) {

		// FIXME VALIDATION
		if ( requestOBJ.getId() != null ) {
			LOGGER.debug("Id not null");
			// requestService.update(requestOBJ);
			LOGGER.debug("1:Update");
		} else {
			UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
			if ( user != null && user.getCustomer() != null ) {
				requestService.insertUserRequest(requestOBJ, user.getCustomer());
				LOGGER.debug("2:Insert");
				return "redirect:../customer/customerHistory";
			}
		}
		LOGGER.debug("3");
		return "redirect:../log/login";
	}

}
