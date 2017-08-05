package net.tsolval.pwiki.model

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Represents a page in the Wiki.
 * 
 * @author tsolval
 */
@Entity
class Page {
   @Id
   String title
   String author
   Date date
   String subject
   String body
   @ElementCollection
   List<Tag> tags
}
