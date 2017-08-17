layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
pages: pages,
mainBody: contents {
   h3(class: 'text-center', 'Search Results')
   div(class: 'panel panel-default') {
      div(class: 'panel-heading'){ small("Found ${found.size()} matching pages...") }
      div(class: 'panel-body') {
         if(found) {
            found.each { page ->
               p() {
                  a(href: "/${page.title}", "${page.subject}")
               }
            }
         } else {
            yield 'No matches found...'
         }
      }
   }
}