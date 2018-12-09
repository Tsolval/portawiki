layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
pages: pages,
page: page,
mainBody: contents {
   div() {
      if(page) {
         div {
            h1("${page.title}")
         }
         h5() {
            span(class: 'glyphicon glyphicon-user', "${page.author}")
            span(class: 'spacer', '')
            span(class: 'glyphicon glyphicon-time', "${page.date?.format('MM-dd-yyyy')}")
         }
         h5() {
            page.tags.each { tag ->
               span(class: 'leader label label-success', "${tag}")
            }
         }
         hr()
         p("$page.body")
         hr()
      } else {
         h2("Page Not Found")
      }
   }
}