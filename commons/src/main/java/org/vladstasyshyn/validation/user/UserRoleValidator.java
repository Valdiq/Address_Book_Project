package org.vladstasyshyn.validation.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.vladstasyshyn.security.user.UserRoles;

import java.util.Set;

public class UserRoleValidator implements ConstraintValidator<UserRole, Set<UserRoles>> {

    private static final Set<UserRoles> USER_ROLES_SET = Set.of(UserRoles.values());

    @Override
    public boolean isValid(Set<UserRoles> userRoles, ConstraintValidatorContext constraintValidatorContext) {
        return isUserRoleValid(userRoles);
    }

    public boolean isUserRoleValid(Set<UserRoles> roles) {
        if (roles.isEmpty()) {
            return false;
        }
        for (UserRoles role : roles) {
            if (!USER_ROLES_SET.contains(role)) {
                return false;
            }
        }
        return true;
    }
}
