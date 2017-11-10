package net.tsolval.pwiki.logging

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Aspect which controls logging for <code>@Loggable</code> classes.
 * @author tsolval
 * 
 *
 */
@Aspect
@Component
class LoggingAspect {
   Logger logger = LoggerFactory.getLogger(LoggingAspect.class)

   @Before('@annotation(net.tsolval.pwiki.logging.Loggable) || @within(net.tsolval.pwiki.logging.Loggable)')
   def beforeLoggableAdvice(JoinPoint jp) {
      logger.info("Entering method ${jp.toString()} with ${jp.args.size()} parameters.")
   }

   @After('@annotation(net.tsolval.pwiki.logging.Loggable) || @within(net.tsolval.pwiki.logging.Loggable)')
   def afterLoggableAdvice(JoinPoint jp) {
      logger.info("Exiting method ${jp.toString()}")
   }
}
