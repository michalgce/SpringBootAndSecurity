package pl.majkel.security;

import org.springframework.security.authentication.BadCredentialsException;
import pl.majkel.dtos.security.UserDto;

public class ExternalWebServiceStub {

    public String getSomeStuff() {
        return "THIS COULD BE SOME EXTERNAL WEBSERVICE";
    }

    public void checkValidUserName(final UserDto aPrincipal) {
        if (!aPrincipal.getUsername().equals("test2")) {
            throw new BadCredentialsException("HASŁO NIEPRAWIDŁOWE ŻEś PODAŁ!");
        }
    }
}
