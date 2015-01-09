package org.pwr.transporter.server.web.controllers.base.article;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.entity.enums.article.ArticleType;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.TaxItemService;
import org.pwr.transporter.server.web.services.UnitService;
import org.pwr.transporter.server.web.services.article.ArticleService;
import org.pwr.transporter.server.web.validators.article.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleValidator validator;

    @Autowired
    UnitService unitService;

    @Autowired
    TaxItemService taxItemService;


    @RequestMapping(value = { "/mag/articleList", "/seller/articleList" }, method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Article> articleList = getListWithCriteria(articleService, request, criteria);
        request.setAttribute("articleList", articleList);

        Article art = articleList.get(0);
        LOGGER.debug(art.getName() + " " + art.getSearchKey() + " " + art.getId());

        String ret = "Views/base/article/articleList";
        if( request.getContextPath().startsWith("/seller") ) {
            ret = "Views/base/seller/customer/articleList";
        }
        return ret;
    }


    @RequestMapping(value = "/mag/articleEdit", method = RequestMethod.GET)
    public String getArticle(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Article article = null;
        loadData(model);
        if( id == null ) {
            article = new Article();
        } else {
            article = articleService.getByID(id);
            if( article == null || article.getId() == null ) {
                article = new Article();
            }
        }

        model.addAttribute("article", article);

        return "Views/base/article/articleEdit";
    }


    @RequestMapping(value = "/mag/articleEdit", method = RequestMethod.POST)
    public String postPrefix(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("article") @Validated Article article,
            BindingResult formBindeings, Model model) {

        if( !validate(article, model, formBindeings, validator) ) {
            return "/Views/mag/articleEdit";
        }

        if( article.getId() != null ) {
            LOGGER.debug("Id not null");
            articleService.update(article);
        } else {
            articleService.insert(article);
        }

        return "redirect:../mag/articleList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        model.addAttribute("units", unitService.getList());
        model.addAttribute("taxItems", taxItemService.getList());
        model.addAttribute("articleTypes", ArticleType.values());
    }

}
