package com.authorization.sequirty;

//import com.example.appbackendapi.Repository.UserRepository;
//import com.example.appbackendapi.Service.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class UserTokenEnhancer extends JwtAccessTokenConverter {

//    @Autowired
//    public UserRepository userRepository;

//    @Autowired
//    @Qualifier("MyUserDetailService")
//    private UserDetailsService userDetailsService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication  authentication) {
        final Map<String,Object> additionalInfo = new HashMap<>();
        additionalInfo.put("unique_id",authentication.getName());

        DefaultOAuth2AccessToken  customAccessToken= new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(additionalInfo);

        return super.enhance(customAccessToken, authentication);
    }

//    public static String oneWayHashing(string toHash){
//        return String.valueOf(Hex)
//    }
}
