package codeisdesign.example.sso.security

class User {

	String username
//	String password
	String email
	List<Role> authorities
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
//		password blank: true
	}

	static mapping = {
//		password column: '`password`'
	}

	/*
	Set<Role> getAuthorities() {
		log.debug("CRAPget autoridades")
		UserRole.findAllByUser(this).collect { it.role } as Set
	}
	*/
}
