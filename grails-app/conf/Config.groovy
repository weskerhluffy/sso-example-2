// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
import grails.plugin.springsecurity.SecurityConfigType

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
    production {
        grails.serverURL = "http://www.changeme.com"
    }
    development {
        grails.serverURL = "http://localhost:8081/${appName}"
    }
    test {
        grails.serverURL = "http://localhost:8081/${appName}"
    }

}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    warn 'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugin', // plugin
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
    warn   'org.mortbay.log'
	debug   'grails.plugin.springsecurity'
	debug   'org.codehaus.groovy.grails.plugin.springsecurity'
	debug   'org.springframework.security'
	debug   'org.jasig.cas.client'
	debug   'mx.mierda'
	debug	'validation'
	debug   'codeisdesign'
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'codeisdesign.example.sso.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'codeisdesign.example.sso.security.UserRole'
grails.plugin.springsecurity.authority.className = 'codeisdesign.example.sso.security.Role'

grails.plugin.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap

grails.plugin.springsecurity.interceptUrlMap = [
	'/home/**':    ['IS_AUTHENTICATED_REMEMBERED'],
	'/js/**':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/css/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/images/**':    ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/*':            ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/login/**':     ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/logout/**':    ['IS_AUTHENTICATED_ANONYMOUSLY']
 ]

grails.plugin.springsecurity.cas.loginUri = '/login'
grails.plugin.springsecurity.cas.serviceUrl = 'http://localhost:8082/sso-example-2/j_spring_cas_security_check'
grails.plugin.springsecurity.cas.serverUrlPrefix = 'https://localhost:8443/cas'
//grails.plugin.springsecurity.cas.proxyCallbackUrl = 'http://localhost:8081/sso-example-1/secure/receptor'
//grails.plugin.springsecurity.cas.proxyReceptorUrl = '/secure/receptor'
grails.plugin.springsecurity.logout.afterLogoutUrl = 'https://localhost:8443/cas/logout?url=http://localhost:8082/sso-example-2/'
grails.plugin.springsecurity.cas.userAttribsFromCas = true
grails.plugin.springsecurity.cas.authorityAttribNamesFromCas = ['authorities']
grails.plugin.springsecurity.userLookup.userDomainClassName = 'codeisdesign.example.sso.security.User'
