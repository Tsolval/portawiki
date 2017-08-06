package net.tsolval.pwiki.model

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Temporal
import javax.persistence.TemporalType

import org.springframework.format.annotation.DateTimeFormat

import groovy.transform.ToString

/**
 * Represents a page in the Wiki.
 * 
 * @author tsolval
 */
@Entity
@ToString
class Page {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   Long id
   String author
   @DateTimeFormat(pattern='MM-dd-YYYY')
   @Temporal(TemporalType.DATE)
   Date date
   String subject
   String body
   @ElementCollection
   List<String> tags
}
