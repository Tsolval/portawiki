layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
pages: pages,
mainBody: contents {
   h3(class: 'text-center', 'Search Results')
   div(class: 'panel panel-default') {
      div(class: 'panel-heading'){ small("found ${found.size()} matching pages...") }
      div(class: 'panel-body') {
         if(found) {
            found.each { page ->
               p() {
                  a(href: "/page/${page.title}", "${page.title}")
               }
            }
         } else {
            yield 'no matches found...'
         }
      }
   }
}