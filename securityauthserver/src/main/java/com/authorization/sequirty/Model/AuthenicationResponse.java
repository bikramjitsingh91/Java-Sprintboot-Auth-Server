package com.authorization.sequirty.Model;

public class AuthenicationResponse {

    private final String jwt;

    public AuthenicationResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return jwt;
    }
}
