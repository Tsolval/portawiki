package net.tsolval.pwiki.model

import javax.persistence.Entity
import javax.persistence.Id

/**
 * A Tag can be used to categorize a Wiki Page.
 * 
 * @author tsolval
 */
@Entity
class Tag {
   @Id
   String name
}
