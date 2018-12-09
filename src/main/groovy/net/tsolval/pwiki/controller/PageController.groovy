package net.tsolval.pwiki.controller

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

import net.tsolval.pwiki.logging.Loggable
import net.tsolval.pwiki.model.Page
import net.tsolval.pwiki.repository.jpa.PageRepository
import net.tsolval.pwiki.service.MarkdownService

@Controller
@RequestMapping('/page')
class PageController {
	@Autowired
	PageRepository pageRepository
	@Autowired
	MarkdownService mdService
	
	@ModelAttribute(name='pages')
	def addPages() {
	   pageRepository.findAll()
	}
 
	@GetMapping('/')
	def showHome() {
		'redirect:/page/Home'
	}
	
	/**
	 * Retrieve a page by its title and display it.
	 * @param title String representing the id of the page to be displayed.
	 * @param model Model with data for display.
	 * @return a Mapping to the page to be displayed
	 */
	@GetMapping("/{title}")
	def showPage(@PathVariable String title, Model model) {
	   def page = pageRepository.findOne(title)
	   if (page?.body) {
		   page.body=mdService.toHtml(page.body)
	   }
	   model.addAttribute('page', page?:new Page(title: title))
	   page ? 'views/index' : 'views/newpage'
	}
 
	/**
	 * Save a page with a given title.
	 * @param title String representing the page id.
	 * @param page Page containing information to be saved.
	 * @return a mapping String to display the saved page
	 */
	@PostMapping("/{title}")
	def addPage(@PathVariable String title, Page page) {
	   page = pageRepository.save(page)
	   "redirect:/page/${page?.title}"
	}

	/**
	 * Show the page in an editing pane.
	 * @param title String representing the id of the page to be edited
	 * @param model Model with data for editing
	 * @return a Mapping to the new page form for editing
	 */
	@GetMapping("/{title}/edit")
	def editPage(@PathVariable String title, Model model) {
		def page = pageRepository.findOne(title)
		model.addAttribute('page', page)
		'views/newpage'
	}
	
	@PostMapping("/{title}/remove")
	def removePage(@PathVariable String title, Model model) {
		try {
			pageRepository.delete(title)
		} catch (EmptyResultDataAccessException e) {
			// do nothing.  I don't care that it's already gone.
		}
		return 'redirect:/page/Home'
	}

	/**
	 * This WebDataBinder translates between Date and String.
	 * @param binder Spring's WebDataBinder
	 */
	@InitBinder
	void dateBinder(WebDataBinder binder) {
	   SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy")
	   CustomDateEditor editor = new CustomDateEditor(dateFormat, true)
	   binder.registerCustomEditor(Date.class, editor)
	}
}
