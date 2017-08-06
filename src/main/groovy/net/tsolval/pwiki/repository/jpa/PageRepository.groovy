package net.tsolval.pwiki.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

import net.tsolval.pwiki.model.Page

/**
 * @author tsolval
 */
interface PageRepository extends JpaRepository<Page, Long> {
}
