package net.tsolval.pwiki.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import net.tsolval.pwiki.model.Page

/**
 * The Page Repository knows how to retrieve pwiki pages from the database.
 * @author tsolval
 */
interface PageRepository extends JpaRepository<Page, String> {
   List<Page> findByTitleContainingIgnoreCase(String searchString)
   @Query("Select page FROM Page page WHERE page.body like :searchString")
   List<Page> findByBodyContainingIgnoreCase(String searchString)
   @Query("SELECT page FROM Page page WHERE :searchString in elements (page.tags)")
   List<Page> findByTagContainingIgnoreCase(@Param("searchString") String searchString)
}
