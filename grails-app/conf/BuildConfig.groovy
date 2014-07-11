grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
//grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// uncomment to disable ehcache
		// excludes 'ehcache'
	}
	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()

		// uncomment the below to enable remote dependency resolution
		// from public Maven repositories
		mavenLocal()
		mavenCentral()
		mavenRepo "http://snapshots.repository.codehaus.org"
		mavenRepo "http://repository.codehaus.org"
		mavenRepo "http://download.java.net/maven/2/"
		mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://repo.spring.io/milestone/"
		mavenRepo "https://repository.jboss.org/nexus/content/repositories/releases"
		mavenRepo "http://repo.grails.org/grails/repo"
		mavenRepo "http://central.maven.org/maven2"
		mavenRepo "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"
	}
	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		// runtime 'mysql:mysql-connector-java:5.1.13'
		//XXX: https://jira.grails.org/browse/GRAILS-11184
		compile 'org.springframework:spring-aop:3.2.9.RELEASE'
		compile 'org.springframework:spring-expression:3.2.9.RELEASE'
		//XXX: http://stackoverflow.com/questions/24164351/grails-2-4-throws-ehcache-class-not-found-error
		compile "net.sf.ehcache:ehcache-core:2.4.8"
		//XXX: http://stackoverflow.com/questions/10704539/noclassdeffounderror-org-codehaus-groovy-grails-plugins-springsecurity-ui-regist
		runtime 'org.apache.commons:commons-exec:1.1'
		compile 'opensaml:opensaml:1.1b', 'org.apache.santuario:xmlsec:1.5.2'
	}

	plugins {
		// plugins for the build system only
		build ':tomcat:7.0.52.1'
		// plugins for the compile step
		compile ':scaffolding:2.1.0'
		compile ':cache:1.1.3'
		compile ':asset-pipeline:1.8.3'

		// plugins needed at runtime but not for compilation
//runtime ':hibernate4:4.3.5.2' // or ':hibernate:3.6.10.14'
		runtime ':database-migration:1.4.0'
		runtime ':jquery:1.11.0.2'
		compile ":spring-security-core:2.0-RC3"
		compile ":spring-security-cas:2.0-RC1"
//		runtime ":hibernate4:4.3.5.4" // or ":hibernate:3.6.10.16"
		runtime ":hibernate:3.6.10.16"
//		runtime ":hibernate:3.6.10.3"
		//XXX: http://stackoverflow.com/questions/15751285/whats-the-correct-way-to-install-a-grails-plugin-from-a-zip-file
		runtime ':grails-spring-security-cas-attribs:1.1.1'
	}
}
