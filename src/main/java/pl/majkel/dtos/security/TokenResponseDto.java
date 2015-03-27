package pl.majkel.dtos.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponseDto {

    @JsonProperty
    private String token;

    public TokenResponseDto() {
    }

    public TokenResponseDto(final String token) {
        this.token = token;
    }
}
