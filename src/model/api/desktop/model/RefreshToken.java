package model.api.desktop.model;

import java.io.Serial;
import java.io.Serializable;

public class RefreshToken implements Serializable {
    //default serialVersion id
    @Serial
    private static final long serialVersionUID = 1L;

    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
