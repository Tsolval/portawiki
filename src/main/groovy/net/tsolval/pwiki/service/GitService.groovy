package net.tsolval.pwiki.service

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.dircache.DirCache
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.springframework.stereotype.Service

/**
 * Service handles git and filesystem integration.
 * @author tsolval
 */
@Service
class GitService {
	Git git
	String home=System.getProperty('user.home')
	String path = "${home}/.gwiki/conf/wiki/"
   
	/** Create the data directories */ 
   def initializeWiki() {
	   git = Git.init().setDirectory(new File("${path}")).call()	   
   }
   
   def addPage(String pageTitle, String pageBody) {
	   def file = new File("${path}/${pageTitle}") //.createNewFile()
	   file << pageBody
   }
   
   def addToIndex(String pageBody) {
	   git.add().addFilepattern(pageBody).call()
   }
   
   def commit(String message) {
	   git.commit().setMessage( message ).call()
   }
   
   def remove(String pageTitle) {
	  git.rm().addFilepattern(pageTitle).call()
   }
   
}
