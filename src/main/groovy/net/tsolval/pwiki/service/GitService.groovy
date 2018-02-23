package net.tsolval.pwiki.service

import org.springframework.stereotype.Service

/**
 * Service handles git and filesystem integration.
 * @author tsolval
 */
@Service
class GitService {
   /** Create the data directories */
    def initializeWiki() {
      def home=System.getProperty('user.home')
      File rootDir = new File("${home}/.gwiki/conf")
      rootDir.mkdirs()
      rootDir.exists()
   }
}
