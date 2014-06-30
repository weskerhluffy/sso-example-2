// Place your Spring DSL code here
//import org.codehaus.groovy.grails.plugins.springsecurity.cas.CasUserDetailsService

beans = {
	userDetailsFromDomainClassFactory(mx.mierda.ass.CacaUserDetailsFromDomainClassFactory)
	registrar(codeisdesign.example.sso.mierda.CustomPropertyEditorRegistrar)
	configurer(org.springframework.beans.factory.config.CustomEditorConfigurer) {
		propertyEditorRegistrars = [ref("registrar")]
	}
}
