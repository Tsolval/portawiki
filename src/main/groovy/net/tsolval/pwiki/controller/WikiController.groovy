package net.tsolval.pwiki.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import net.tsolval.pwiki.model.Page

/**
 * Controls the flow of the application.
 * 
 * @author tsolval
 */
@Controller
class WikiController {
   @RequestMapping("/")
   public String index(Model model) {
      model.addAttribute('wikiTitle', "Tsolval's Personal Wiki")
      model.addAttribute('page', getPage())
      return 'views/index'
   }

   def getPage() {
      def page = new Page(
            title: 'firstPage',
            author: 'Walker D. Adams',
            date: new Date(),
            subject: 'My First Wiki Page',
            body: 'This is the body of my first Wiki Page',
            tags:['First', 'Wiki', 'Page'])
   }
}
