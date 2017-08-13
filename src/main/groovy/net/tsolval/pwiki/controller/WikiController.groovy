package net.tsolval.pwiki.controller

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

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
   PageRepository pageRepository

   @RequestMapping("/")
   def index() {
      "redirect:/gettingStarted"
   }

   @GetMapping("/{title}")
   def showPageByName(@PathVariable String title, Model model) {
      def page = pageRepository.findOne(title)
      model.addAttribute('page', page?:new Page(title: title))
      def pages = pageRepository.findAll()
      model.addAttribute('pages', pages)
      println pages
      page ? 'views/index' : 'views/newpage'
   }

   @PostMapping("/{title}")
   def addPageByTitle(Page page) {
      page = pageRepository.save(page)
      "redirect:/${page.title}"
   }

   @GetMapping("/+")
   def createPage(Model model) {
      model.addAttribute('pages', pageRepository.findAll())
      model.addAttribute('page', new Page())
      'views/newpage'
   }

   @InitBinder
   def dateBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy")
      CustomDateEditor editor = new CustomDateEditor(dateFormat, true)
      binder.registerCustomEditor(Date.class, editor)
   }
}
