layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki',
pages: pages,
mainBody: contents {
   div() {
      if(titles) {
         h2('Title Matches')
         hr()
         titles.each { page ->
            a(href: "/${page.title}", "${page.title}")
         }
      }

      if(subjects) {
         h2('Subject Matches')
         hr()
         subjects.each { page ->
            a(href: "/${page.title}", "${page.subject}")
         }
      }

      if(bodies) {
         h2('Body Matches')
         hr()
         subjects.each { page ->
            a(href: "/${page.title}", "${page.body}")
         }
      }

      if (!titles && !subjects && !bodies) {
         yield 'No matches found...'
      }
   }
}