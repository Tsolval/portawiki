package net.tsolval.pwiki.service

import org.springframework.stereotype.Service

import com.vladsch.flexmark.ast.Node
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet

import net.tsolval.pwiki.logging.Loggable

/**
 * Services for use in parsing the Markdown markup language.
 * @author tsolval
 */
@Service
class MarkdownService {
   @Loggable
   def toHtml(String markdown) {
      MutableDataSet options = new MutableDataSet()

      options.set(Parser.EXTENSIONS, [
         TablesExtension.create(),
         StrikethroughExtension.create()
      ])
      options.set(HtmlRenderer.SOFT_BREAK, "<br />\n")

      Parser parser = Parser.builder(options).build()
      HtmlRenderer renderer = HtmlRenderer.builder(options).build()

      // You can re-use parser and renderer instances
      Node document = parser.parse(markdown)
      String html = renderer.render(document)
      return html
   }
}
