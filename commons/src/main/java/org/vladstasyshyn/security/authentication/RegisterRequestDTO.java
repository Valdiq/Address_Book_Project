package org.vladstasyshyn.security.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vladstasyshyn.security.user.UserRoles;
import org.vladstasyshyn.validation.user.UserRole;
import org.vladstasyshyn.validation.user.ValidUsername;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RegisterRequestDTO {

    @NotBlank
    @ValidUsername
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @UserRole
    private Set<UserRoles> roles;


}
