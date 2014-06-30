import codeisdesign.example.sso.security.User
import codeisdesign.example.sso.security.Role

class BootStrap {

    def init = { servletContext ->
		new User(
				username:"codeisdesign", 
			 	enabled:true,
				accountExpired:false,
				accountLocked:false,
				passwordExpired:false
			).save(flush:true)
		new Role(
			authority:"ROLE_USER"
			).save(flush:true)
		new Role(
			authority:"ROLE_NOMAMESSS"
			).save(flush:true)
    }
    def destroy = {
    }
}
