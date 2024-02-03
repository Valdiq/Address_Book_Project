package org.vladstasyshyn.security.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vladstasyshyn.validation.user.ValidUsername;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AuthenticationRequestDTO {

    @NotBlank
    @ValidUsername
    private String username;

    @NotBlank
    private String password;
}
