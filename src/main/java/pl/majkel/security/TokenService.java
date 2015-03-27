package pl.majkel.security;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;

import java.util.UUID;


public class TokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenService.class);
    private static final Cache restApiAuthTokenCache = CacheManager.getInstance().getCache("restApiAuthTokenCache");
    public static final int HALF_AN_HOUR_IN_MILLISECONDS = 30 * 60 * 1000;

    @Scheduled(fixedRate = HALF_AN_HOUR_IN_MILLISECONDS)
    public void evictExpiredTokens() {
        LOGGER.info("Evicting expired toknes.");
        restApiAuthTokenCache.evictExpiredElements();
    }

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public void store(final String token, final Authentication authentication) {
        restApiAuthTokenCache.put(new Element(token, authentication));
    }

    public Boolean contains(final String token) {
        return restApiAuthTokenCache.get(token) != null;
    }

    public Authentication retrive(final String token) {
        return (Authentication) restApiAuthTokenCache.get(token).getObjectValue();
    }

}
