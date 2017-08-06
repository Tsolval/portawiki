layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
mainBody: contents {
   div() {
      if(page) {
         h2("$page.subject")
         h5() {
            span(class:'glyphicon glyphicon-time', '')
            yield(" Written by $page.author, ${page.date.format('MM-dd-yyyy')} ")
         }
         p("$page.body")
         h5() {
            page.tags.each { tag ->
               span(class: 'label label-success', "${tag}")
               yield ' '
            }
         }
         hr()
      } else {
         h2("Page Not Found")
      }
   }
}