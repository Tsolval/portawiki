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
      nav(class: 'navbar navbar-default') {
         div(class: 'container-fluid') {
            div(class: 'navbar-header') {
               button(type: 'button', class: 'navbar-toggle collapsed', 'data-toggle': 'collapse', 'data-target': '#main-navbar-collapse', 'aria-expanded': 'false') {
                  span(class: 'sr-only', 'Toggle navigation')
                  span(class: 'icon-bar', '')
                  span(class: 'icon-bar', '')
                  span(class: 'icon-bar', '')
               }
               a(class: 'navbar-brand', href: '/page/Home', 'Portable Wiki')
            }
            div(class: 'collapse navbar-collapse', id: 'main-navbar-collapse') {
               form(class: 'navbar-form navbar-right', action: '/search') {
                  div(class: 'form-group') {
                     input(type: 'text', class: 'form-control', size: '50', placeholder: 'Search Wiki...', name: 'q')
                     button(type: 'submit', class: 'btn btn-default' ) {
                        span(class: 'glyphicon glyphicon-search', '')
                     }
                  }
               }
            } 
         }
      }
      div(class: 'container-fluid') {
         div(class: 'row content') {
            div(class: 'col-sm-3 sidenav navbar-right') {
               div(class: 'toolbar') {
                  a(class: 'btn btn-primary btn-xs', href: "/add", title: 'add a new page') {
                     span(class: 'glyphicon glyphicon-plus', '')
                     span('Add Page')
                  }
                  span(class: 'spacer', '')
                  a(class: 'btn btn-primary btn-xs', href: "/page/${page?.title}/edit", title: 'edit the current page') {
                     span(class: 'glyphicon glyphicon-pencil', '')
                     span('Edit Page')
                  }
               }
               if(pages) {
                  ul(class: 'nav nav-pills nav-stacked') {
                     pages.each { p ->
                        def active = p?.equals(page) ? [class:'active'] : [:]
                        li(active) { a(href: "/page/${p?.title}", "${p?.title}") }
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
