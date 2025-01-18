package net.tsolval.pwiki.model

import jakarta.persistence.*

import org.springframework.format.annotation.DateTimeFormat

import groovy.transform.ToString

import java.time.LocalDate

/**
 * Represents a page in the Wiki.
 * 
 * @author tsolval
 */
@Entity
@ToString
class Page {
   @Id
   String title
   String author
   @DateTimeFormat(pattern='MM-dd-YYYY')
   @Temporal(TemporalType.DATE)
   Date date
   @Lob
   String body
   @ElementCollection
   List<String> tags
}
