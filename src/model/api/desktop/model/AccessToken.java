package model.api.desktop.model;

import java.io.Serial;
import java.io.Serializable;

public class AccessToken implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private String accessToken;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


}
