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
               div(class: 'input-group') {
                  input(type: 'text', class: 'form-control', placeholder: 'Search Wiki...')
                  span(class: 'input-group-btn') {
                     button(class: 'btn btn-default', type: 'button') {
                        span(class: 'glyphicon glyphicon-search', '')
                     }
                  }
               }
               div(class: 'toolbar') {
                  a(href: '/p', title: 'add a new page') {
                     span(class: 'glyphicon glyphicon-plus', '')
                  }
               }
               ul(class: 'nav nav-pills nav-stacked') {
                  li(class: 'active') { a(href: '#section1', 'Home') }
                  li() { a(href: '#section2', 'Friends') }
                  li() { a(href: '#section3', 'Family') }
                  li() { a(href: '#section4', 'Photos') }
               }
            }
            div(class: 'col-sm-9') { mainBody() }
         }
      }
   }
}
