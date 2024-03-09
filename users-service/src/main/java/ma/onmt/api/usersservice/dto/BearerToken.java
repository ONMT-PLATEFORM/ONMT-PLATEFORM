package ma.onmt.api.usersservice.dto;

import lombok.Data;

@Data
public class BearerToken {
    private String accessToken;
    private String expiresIn = "36000000";
    private String TokenType;

    private String refreshToken;

    public BearerToken(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        TokenType = tokenType;
    }
}
