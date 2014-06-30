package codeisdesign.example.sso.mierda

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(codeisdesign.example.sso.security.Role.class,
		new RolePropertyEditor());
	}
}