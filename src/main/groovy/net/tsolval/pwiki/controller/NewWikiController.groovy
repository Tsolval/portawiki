package net.tsolval.pwiki.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import net.tsolval.pwiki.service.GitService

/**
 * Controller for gitwiki functionality.
 * @author tsolval
 */
@Controller
@RequestMapping("gwiki")
class NewWikiController {

   @Autowired GitService gitservice
   /** Show the start page.  Select the root directory and configure pwiki, if it's not already done. */
   @GetMapping("/")
   @ResponseBody
   def startPage() {
      gitservice.initializeWiki()
      "Service initialized."
   }
}
