package net.tsolval.pwiki.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

import net.tsolval.pwiki.service.GitService

/**
 * Controller for gitwiki functionality.
 * @author tsolval
 */
@Controller
class NewWikiController {

   @Autowired GitService gitservice
   /** Show the start page.  Select the root directory and configure pwiki, if it's not already done. */
   @GetMapping("/")
   def startPage(Model model) {
	   model.addAttribute('wikis', gitservice.listRepos());
	   'views/wikilist'
   }

   @GetMapping("/status")
   @ResponseBody
   def status() {
      gitservice.initializeWiki()
      "Service initialized."
   }
}
