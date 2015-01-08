package org.pwr.transporter.server.web.controllers.logistic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.sales.GoodsIssuedNote;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.base.documents.GenericDocumentController;
import org.pwr.transporter.server.web.services.sales.GoodsIssuedNoteService;
import org.pwr.transporter.server.web.validators.documents.sales.GoodsIssuedNoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsIssuedNoteController extends GenericDocumentController {
	private static Logger LOGGER = Logger.getLogger(GoodsIssuedNoteController.class);

	@Autowired
	GoodsIssuedNoteService service;
	
	@Autowired
	GoodsIssuedNoteValidator validator;
	
	
	@RequestMapping(value = "/logistic/goodsIssuedNoteList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

		Criteria criteria = restoreCriteria(request);
        List<GoodsIssuedNote> list = getListWithCriteria(service, request, criteria);
        model.addAttribute("list", list);
        return "/Views/logistic/goodsIssuedNoteList";
    }


    


    
	
	

}
