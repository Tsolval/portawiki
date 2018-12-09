layout 'layouts/main.tpl',
wikiTitle: "$wikiTitle",
pageTitle: 'PortaWiki - New Page',
pageScript: 'js/newPage.js',
page: page,
pages: pages,
mainBody: contents {
   h3(class: 'text-center', 'Page Editor')
   hr()
   form(class: 'form-horizontal', action: "/page/${page?.title}", method: 'post') {
      div(class: 'form-group') {
         label(for: 'title', class: 'col-sm-1 control-label', 'Title:')
         div(class: 'col-sm-11'){
            input(name: 'title', type: 'text', class: 'form-control', id: 'title', placeholder: 'Enter Unique Title', value: "${page?.title?:''}")
         }
      }
      div(class: 'form-group') {
         label(for: 'author', class: 'col-sm-1 control-label', 'Author:')
         div(class: 'col-sm-5') {
            input(name: 'author', type: 'text', class: 'form-control', id: 'author', placeholder: 'Author', value: "${page.author?:''}")
         }
         label(for: 'date', class: 'col-sm-1 control-label', 'Date:')
         div(class: 'col-sm-5') {
            input(name: 'date', type: 'text', class: 'form-control', id: 'date', value: "${page.date?page.date.format('MM-dd-YYYY'):new Date().format('MM-dd-YYYY')}")
         }
      }
      div(class: 'form-group') {
         label(for: 'body', class: 'col-sm-1 control-label', 'Body:')
         div(class: 'col-sm-11') {
            textarea(name: 'body', class: 'form-control', rows: '20', id: 'body', placeholder: 'Body',  "${page.body?:''}" )
         }
      }
      div(class: 'form-group') {
         label(for: 'tags', class: 'col-sm-1 control-label', 'Tags:')
         div(class: 'col-sm-11') {
            input(name: 'tags', type: 'text', class: 'form-control', id: 'tags', placeholder: 'Tags', 'data-role': 'tagsinput', value: "${page.tags?page.tags.join(', '):''}" )
         }
      }
      div(class: 'btn-group pull-left') {
         button(type: 'submit', class: 'btn btn-danger', onclick: "this.form.action='/page/${page?.title}/remove'") {
            span(class: 'glyphicon glyphicon-remove', ' Remove')
         }
      }
      div(class: 'btn-group pull-right'){
         button(type: 'cancel', class: 'btn btn-primary') {
            span( ' Cancel')
         }
         button(type: 'submit', class: 'btn btn-primary') {
            span(class: 'glyphicon glyphicon-ok', ' Save')
         }
      }
   }
}