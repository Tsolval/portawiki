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
   
   def addPageBody(String pageBody) {
	   new File("${path}/${pageBody}").createNewFile()
   }
   
   def addToIndex(String pageBody) {
	   def home=System.getProperty('user.home')
	   git.add().addFilepattern(pageBody).call()
   }
   
   def commit(String message) {
	   git.commit().setMessage( message ).call()
   }
   
   def remove(String pageBody) {
	  git.rm().addFilepattern(pageBody).call()
   }
   
}
