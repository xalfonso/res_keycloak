package eas.com;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class KeycloakTokenVO {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("refreshExpiresIn")
    private Integer refreshExpiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("tokenType")
    private String token_type;
}
