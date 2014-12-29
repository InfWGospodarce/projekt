package org.pwr.transporter.server.web.controllers.base.article;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.server.web.controllers.GenericControllerWare;
import org.pwr.transporter.server.web.services.article.ArticleService;
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
public class ArticleController extends GenericControllerWare {

    private static Logger LOGGER = Logger.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;


    @RequestMapping(value = "/mag/articleList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<Article> articleList = getList(articleService, request);
        request.setAttribute("articleList", articleList);

        return "Views/base/article/articleList";
    }


    @RequestMapping(value = "/mag/articleEdit", method = RequestMethod.GET)
    public String getArticle(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Article article = null;
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
    public String postPrefix(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("article") Article article,
            BindingResult formBindeings) {

        // FIXME VALIDATION
        if( article.getId() != null ) {
            LOGGER.debug("Id not null");
            articleService.update(article);
        } else {
            articleService.insert(article);
        }

        return "redirect:../mag/articleList?page=" + getPage(request);
    }

}
