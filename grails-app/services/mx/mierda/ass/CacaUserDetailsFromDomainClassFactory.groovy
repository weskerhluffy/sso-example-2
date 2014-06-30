package mx.mierda.ass

import org.codehaus.groovy.grails.plugins.springsecurity.cas.UserDetailsFromDomainClassFactory
import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import groovy.util.logging.Log4j

//XXX: http://stackoverflow.com/questions/1410463/inject-log-object-in-grails-class-outside-of-grails-app
@Log4j
@org.springframework.stereotype.Component
class CacaUserDetailsFromDomainClassFactory implements
UserDetailsFromDomainClassFactory {

	/**
	 * When using cas, the password attribute of the User object means nothing.
	 */
	private static final String NON_EXISTENT_PASSWORD_VALUE = "NO_PASSWORD";

	@Override
	UserDetails createUserDetails(Object domainClass,
			Collection<GrantedAuthority> authorities) {

		log.debug("FFFFFFFFFFFuck")
		log.debug("everythin is awewsome "+domainClass.dump())
		def conf = SpringSecurityUtils.securityConfig

		String usernamePropertyName = conf.userLookup.usernamePropertyName
		String username = domainClass."$usernamePropertyName"

		log.debug("me corto las pelotas "+domainClass.dump())
		log.debug("negro de mierda "+authorities.dump())

		new GrailsUser(username, NON_EXISTENT_PASSWORD_VALUE,
				true, true, true, true, authorities, domainClass.id)
	}
}
