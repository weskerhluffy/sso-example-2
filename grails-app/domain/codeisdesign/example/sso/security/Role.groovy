package codeisdesign.example.sso.security

class Role {

	String authority

	public Role(String authority){
		this.authority=authority
	}

	//XXX: http://groovy.329449.n5.nabble.com/Constructors-and-Groovy-td371040.html
	public Role(Map m){
		this.authority=m.authority
	}


	static mapping = { cache true }

	static constraints = {
		authority blank: false, unique: true
	}
}
