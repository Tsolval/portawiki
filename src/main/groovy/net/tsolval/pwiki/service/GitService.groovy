package net.tsolval.pwiki.service

import org.eclipse.jgit.api.Git
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * Service handles git and filesystem integration.
 * @author tsolval
 */
@Service
class GitService {
	Git git
	
	@Value('${user.home}/.gwiki/conf/wiki/')
	String path
	
	def listRepos() {
		[[name: 'Example Wiki', path: 'Path to Wiki']]
	}
   
	/** Create the data directories */ 
   def initializeWiki() {
	   System.out.println(path)
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
