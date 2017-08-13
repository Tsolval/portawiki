layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
pages: pages,
page: page,
mainBody: contents {
   div() {
      if(page) {
         h2("$page.subject")
         h5() {
            span(class: 'leader glyphicon glyphicon-user', '')
            span("${page.author}")
            span(class: 'leader glyphicon glyphicon-time', '')
            span("${page.date?.format('MM-dd-yyyy')}")
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