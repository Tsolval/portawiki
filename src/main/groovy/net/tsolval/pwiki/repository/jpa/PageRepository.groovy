package net.tsolval.pwiki.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

import net.tsolval.pwiki.model.Page

/**
 * The Page Repository knows how to retrieve pwiki pages from the database.
 * @author tsolval
 */
interface PageRepository extends JpaRepository<Page, String> {
   List<Page> findByTitleContainingIgnoreCase(String title)
   List<Page> findBySubjectContainingIgnoreCase(String title)
   List<Page> findByBodyContainingIgnoreCase(String title)
}
