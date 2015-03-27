package pl.majkel.dtos.security;

public class UserDto {

    private String username;

    public UserDto(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }
}
