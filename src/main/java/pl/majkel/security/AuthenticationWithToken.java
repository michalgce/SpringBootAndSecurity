package pl.majkel.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Collection;

public class AuthenticationWithToken extends PreAuthenticatedAuthenticationToken {

    public AuthenticationWithToken(final Object aPrincipal, final Object aCredentials) {
        super(aPrincipal, aCredentials);
    }

    public AuthenticationWithToken(final Object aPrincipal, final Object aCredentials, final Collection<? extends GrantedAuthority> anAuthorities) {
        super(aPrincipal, aCredentials, anAuthorities);
    }

    public void setToken(final String token) {
        super.setDetails(token);
    }

    public String getToken() {
        return (String) getDetails();
    }
}
