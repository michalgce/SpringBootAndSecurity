package pl.majkel.security;

import org.springframework.security.core.authority.AuthorityUtils;
import pl.majkel.dtos.security.UserDto;

public class ExternalServiceAuthenticatorImpl implements ExternalServiceAuthenticator {
    @Override
    public AuthenticationWithToken authenticate(final String username, final String password) {
        ExternalWebServiceStub externalWebServiceStub = new ExternalWebServiceStub();

        AuthenticatedExternalWebService authenticatedExternalWebService = new AuthenticatedExternalWebService(new UserDto(username), password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DOMAIN_USER"), new ExternalWebServiceStub());
        authenticatedExternalWebService.setExternalWebService(externalWebServiceStub);

        return authenticatedExternalWebService;
    }
}
