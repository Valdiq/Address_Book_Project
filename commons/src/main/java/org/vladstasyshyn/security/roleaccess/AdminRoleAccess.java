package org.vladstasyshyn.security.roleaccess;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority(T(org.vladstasyshyn.security.user.UserRoles).ADMIN)")
public @interface AdminRoleAccess {
}
