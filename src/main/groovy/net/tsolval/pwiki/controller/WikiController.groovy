package net.tsolval.pwiki.controller

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import net.tsolval.pwiki.model.Page
import net.tsolval.pwiki.repository.jpa.PageRepository

/**
 * Controls the flow of the application.
 * 
 * @author tsolval
 */
@Controller
class WikiController {
   @Autowired
   PageRepository pages

   @RequestMapping("/")
   def index(Model model) {
      return new ModelAndView('views/index', 'page', getPage())
   }

   @GetMapping("/p")
   public String newPage(Model model) {
      model.addAttribute('page', new Page())
      return 'views/newpage'
   }

   @PostMapping("/p")
   def saveNewPage(Page page, BindingResult result, RedirectAttributes redirect) {
      println page
      page = pages.save(page)
      //      return new ModelAndView('views/newpage', 'page', page)
      "redirect:/p/${page.id}"
   }

   @GetMapping("/p/{id}")
   def showPage(@PathVariable Long id, Model model) {
      def page = pages.findOne(id)
      return new ModelAndView('views/index', 'page', page)
   }

   @InitBinder
   def dateBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy")
      CustomDateEditor editor = new CustomDateEditor(dateFormat, true)
      binder.registerCustomEditor(Date.class, editor)
   }

   def getPage() {
      def page = new Page(
            author: 'Walker D. Adams',
            date: new Date(),
            subject: 'My First Wiki Page',
            body: 'This is the body of my first Wiki Page',
            tags:['First', 'Wiki', 'Page'])
   }
}
