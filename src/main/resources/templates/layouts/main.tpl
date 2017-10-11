yieldUnescaped '<!DOCTYPE html>'
html {
   head {
      meta(charset: 'utf-8')
      meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
      title(pageTitle)
      link(rel: 'stylesheet', href: 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css')
      link(rel: 'stylesheet', href: '/css/pwiki.css', '')
      script(src:'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js', '')
      script(src:'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js', '')
      link(rel: 'stylesheet', href: '//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css')
      script(src:'https://cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js', '')
      if(pageScript) {
         script(src: "$pageScript", '')
      }
   }
   body {
      div(class: 'container-fluid') {
         div(class: 'row content') {
            div(class: 'col-sm-3 sidenav') {
               a(href: '/') { h4(class: 'text-center', 'Portable Wiki') }
               form(action: '/search', method: 'get') {
                  div(class: 'input-group') {
                     input(type: 'text', class: 'form-control', name: 'q', placeholder: 'Search Wiki...')
                     span(class: 'input-group-btn') {
                        button(class: 'btn btn-default', type: 'submit') {
                           span(class: 'glyphicon glyphicon-search', '')
                        }
                     }
                  }
               }
               div(class: 'toolbar') {
                  a(href: '/+', title: 'add a new page') {
                     span(class: 'glyphicon glyphicon-plus leader', '')
                  }
                  a(href: "/${page.title}/edit", title: 'add a new page') {
                     span(class: 'glyphicon glyphicon-pencil leader', '')
                  }
                  a(href: "/export", title: 'export all pages') {
                     span(class: 'glyphicon glyphicon-export leader', '')
                  }
               }
               if(pages) {
                  ul(class: 'nav nav-pills nav-stacked') {
                     pages.each { p ->
                        def active = p?.equals(page) ? [class:'active'] : [:]
                        li(active) { a(href: "/${p.title}", "${p.subject}") }
                     }
                     p('')
                  }
               }
            }
            div(class: 'col-sm-9') { mainBody() }
         }
      }
   }
}
