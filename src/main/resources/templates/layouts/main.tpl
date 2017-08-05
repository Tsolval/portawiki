yieldUnescaped '<!DOCTYPE html>'
html {
   head {
      meta(charset: 'utf-8')
      meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
      title(pageTitle)
      link(rel: 'stylesheet', href: 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css')
      script(src:'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js', '')
      script(src:'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js', '')
   }
   body {
      div(class: 'container-fluid') {
         div(class: 'row content') {
            div(class: 'col-sm-3 sidenav') {
               a(href: '/') { h4(class: 'text-center', wikiTitle) }
               hr()
               div(class: 'input-group') {
                  input(type: 'text', class: 'form-control', placeholder: 'Search Blog..')
                  span(class: 'input-group-btn') {
                     button(class: 'btn btn-default', type: 'button') {
                        span(class: 'glyphicon glyphicon-search', '')
                     }
                  }
               }
               ul(class: 'nav nav-pills nav-stacked') {
                  li(class: 'active') { a(href: '#section1', 'Home') }
                  li() { a(href: '#section2', 'Friends') }
                  li() { a(href: '#section3', 'Family') }
                  li() { a(href: '#section4', 'Photos') }
               }
            }
            mainBody()
         }
      }
   }
}
