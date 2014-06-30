package codeisdesign.example.sso
import codeisdesign.example.sso.security.User;
import groovy.util.logging.Log4j

@Log4j
class HomeController {

	def index = {
		//XXX: http://stackoverflow.com/questions/775053/grails-and-spring-security-how-do-i-get-the-authenticated-user-from-within-a-co
		log.debug("la concha de la lora "+getAuthenticatedUser().dump())
		log.debug("bananeroooo "+getPrincipal().getAuthorities())
		log.debug("MIERDA")
		log.debug("cagada "+User.findById(getAuthenticatedUser().id))
	}
}
