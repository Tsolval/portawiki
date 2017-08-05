package net.tsolval.pwiki.config

import org.h2.server.web.WebServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configure the Web Application.  This class takes the place of the classic web.xml file.
 * 
 * @author tsolval
 * @since 0.0.1
 */
@Configuration
class WebApplicationConfiguration {
   @Bean
   ServletRegistrationBean h2servletRegistration() {
      def registrationBean = new ServletRegistrationBean(new WebServlet())
      registrationBean.addUrlMappings('/console/*')
      return registrationBean
   }
}
