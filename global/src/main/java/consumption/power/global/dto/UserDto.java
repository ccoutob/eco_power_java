package consumption.power.global.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class UserDto {

    private String username;
    private String password;
    private Set<String> roles;
}
