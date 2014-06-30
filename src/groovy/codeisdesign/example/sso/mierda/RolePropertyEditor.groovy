package codeisdesign.example.sso.mierda

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

import codeisdesign.example.sso.security.Role;

import groovy.util.logging.Log4j

//XXX: https://corketech.wordpress.com/category/groovygrails/
@Log4j
public class RolePropertyEditor extends PropertyEditorSupport implements
PropertyEditor {
	public void setAsText(String text) {
		Role rolCanela=null
		//XXX: http://grails.org/doc/latest/ref/Domain%20Classes/findBy.html
		log.debug("intentando sacar autoridad "+text)
		rolCanela=Role.findByAuthority(text);
		log.debug("la autoridad encontrara "+rolCanela?.dump())
		setValue(rolCanela)
	}

	public String getAsText() {
		Object value = getValue();
		if (value instanceof Role) {
			return value.authority;
		}
		return ("" + value);
	}
}