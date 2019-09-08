yieldUnescaped '<!DOCTYPE html>'
html {
   head {
      meta(charset: 'utf-8')
      meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
      title('Wiki Manager')
      link(rel: 'stylesheet', 
         href: 'https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css', 
         integrity: 'sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T',
         crossorigin: 'anonymous', '')
      script(src: 'https://code.jquery.com/jquery-3.3.1.slim.min.js', 
         integrity: 'sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo',
         crossorigin: 'anonymous', '')
      script(src: 'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js', 
         integrity: 'sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1',
         crossorigin: 'anonymous', '')
      script(src: 'https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js',
         integrity: 'sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM',
         crossorigin: 'anonymous', '')
      
      link(rel: 'stylesheet', href: '/css/gwiki.css', '')
   }
   body {
      div(class: 'page') {
         div(class: 'container') {
            div(class: 'row content') {
               div(class: 'col') {
                  h1('Wiki Manager')
                  p('Choose the wiki to view from the registered Wiki list below.  You can also add a wiki with the Add Wiki button.')
                  p('Registered Wikis:')
                  if(wikis) {
                     table(class: 'table table-dark') {
                        thead() {
                           tr() {
                              th(scope: 'col', 'Name') 
                              th(scope: 'col', 'Path')
                           }
                        }
                        tbody() {
                           wikis.each() { w -> 
                              tr() {
                                 td(scope: 'row', "${w.name}")
                                 td("${w.path}")
                              }
                           }
                        }
                     }
                  } else {
                     table(class: 'table table-dark') {
                        tr() {
                           td(class: 'center', scope: 'col', 'No Wiki Found.  Add one with the Add Wiki button!')
                        }
                     }
                  }
                  p('TODO: Add Delete button on each wiki row')
                  p('TODO: Add "Add Wiki" button above wiki table')
                  p('TODO: Add pagination below wiki table')
                  p('TODO: Create Nav Bar, Nav tools')
                  p('TODO: Make page pretty')
                  
               }
            }
         }
      }
   }
}