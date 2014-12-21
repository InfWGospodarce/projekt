package org.pwr.transporter.server.web.controllers.base.article;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * <pre>
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
@Controller
public class ArticleController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(ArticleController.class);

    @RequestMapping(value = "/mag/articleList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

    	List<Article> articleList = new ArrayList<Article>();
//    	FIXME get list from db
    	Article article = new Article();
    	article.setCode("Test code");
    	article.setSearchKey("test search key");
    	article.setName("Test");
    	articleList.add(article);
    	
        request.setAttribute("articleList", articleList);

        return "Views/base/article/articleList";
    }


}
