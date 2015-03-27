package pl.majkel.security;

import org.springframework.security.core.GrantedAuthority;
import pl.majkel.dtos.security.UserDto;

import java.util.Collection;

public class AuthenticatedExternalWebService extends AuthenticationWithToken {

    private ExternalWebServiceStub externalWebService;

    public AuthenticatedExternalWebService(Object aPrincipal, Object aCredentials, Collection<? extends GrantedAuthority> anAuthorities, final ExternalWebServiceStub externalWebService) {
        super(aPrincipal, aCredentials, anAuthorities);
        this.externalWebService = externalWebService;
        externalWebService.checkValidUserName((UserDto) aPrincipal);
    }

    public void setExternalWebService(ExternalWebServiceStub externalWebService) {
        this.externalWebService = externalWebService;
    }

    public ExternalWebServiceStub getExternalWebService() {
        return externalWebService;
    }
}
