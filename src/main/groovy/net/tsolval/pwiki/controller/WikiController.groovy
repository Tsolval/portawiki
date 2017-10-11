package net.tsolval.pwiki.controller

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import net.tsolval.pwiki.model.Page
import net.tsolval.pwiki.repository.jpa.PageRepository
import net.tsolval.pwiki.service.MarkdownService

/**
 * Controls the flow of the application.
 * 
 * @author tsolval
 */
@Controller
class WikiController {
   @Autowired PageRepository pageRepository
   @Autowired MarkdownService mdService

   @ModelAttribute(name='pages')
   def addPages() {
      pageRepository.findAll()
   }

   @RequestMapping("/")
   def index() {
      "redirect:/gettingStarted"
   }

   /**
    * Find pages whose titles, subjects, or bodies matching or containing the given criteria.
    * 
    * @param criteria
    * @param model
    * @return
    */
   @GetMapping("/search")
   def searchWiki(@RequestParam('q') String criteria, Model model) {
      Set<Page> found = new HashSet<Page>()
      // search first for titles matching the string
      found.addAll(pageRepository.findByTitleContainingIgnoreCase(criteria))
      found.addAll(pageRepository.findBySubjectContainingIgnoreCase(criteria))
      found.addAll(pageRepository.findByBodyContainingIgnoreCase(criteria))
      // add all variables to model
      model.addAllAttributes([found: found])
      // redirect to results page
      'views/results'
   }

   @GetMapping("/{title}")
   def showPage(@PathVariable String title, Model model) {
      def page = pageRepository.findOne(title)
      page.body=mdService.toHtml(page.body)
      model.addAttribute('page', page?:new Page(title: title))
      page ? 'views/index' : 'views/newpage'
   }

   @PostMapping("/{title}")
   def addPage(@PathVariable String title, Page page) {
      page = pageRepository.save(page)
      "redirect:/${page.title}"
   }

   @GetMapping("/{title}/edit")
   def editPage(@PathVariable String title, Model model) {
      def page=pageRepository.findOne(title)
      model.addAttribute('page', page)
      'views/newpage'
   }

   @GetMapping("/+")
   def createPage(Model model) {
      model.addAttribute('page', new Page())
      'views/newpage'
   }

   @GetMapping("/export")
   @ResponseBody
   def exportPages(Model model) {
      model.asMap().get('pages')
   }

   @InitBinder
   def dateBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy")
      CustomDateEditor editor = new CustomDateEditor(dateFormat, true)
      binder.registerCustomEditor(Date.class, editor)
   }
}
