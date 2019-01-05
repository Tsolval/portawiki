package net.tsolval.pwiki.service

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.dircache.DirCache
import org.eclipse.jgit.revwalk.RevCommit
import spock.lang.Shared
import spock.lang.Specification
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertEquals

class GitServiceTest extends Specification {

	@Shared gitService = new GitService()
	@Shared pageBody = "test9.txt";
	
	// update variables to create test repository
	def setupSpec() {
		gitService.path = "${gitService.home}/.gwiki/conf/testwiki/"
	}
	
	// destroy test repository when testing is complete
	def cleanupSpec() {
		String home=System.getProperty('user.home')
		String path = "${home}/.gwiki/conf/testwiki/"
		new File("${home}/.gwiki").deleteDir()
	}

	def "intializeWiki should create a git repo"() {
		given:
		gitService.initializeWiki()

		when:
		gitService.addPageBody(pageBody)

		then:
		assertTrue( gitService.git.status().call().getUntracked().contains(	pageBody ) );
	}

	def "addToIndex should stage a file"(){
		when:
		gitService.addToIndex(pageBody)

		then:
		assertTrue( gitService.git.status().call().getAdded().contains(pageBody) );
	}

	def "def commit(String message)"(){
		def message = "My test message."
		
		when: 
		RevCommit commit = gitService.commit(message)
		
		then: 
		assertEquals(message, commit.getFullMessage())
	}
	
	def "remove should remove file from git"(){

		when:
		gitService.remove(pageBody)
	
		then:
		gitService.git.status().call().getRemoved().contains(pageBody)
	}
	
}

