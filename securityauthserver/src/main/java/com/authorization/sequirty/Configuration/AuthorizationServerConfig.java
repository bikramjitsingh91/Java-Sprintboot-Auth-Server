package com.authorization.sequirty.Configuration;

import com.authorization.sequirty.UserTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.endpoint.TokenKeyEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    @Value("${app.security.jwt.keystore-location}")
	private String keyStorePath;

	@Value("${app.security.jwt.keystore-password}")
	private String keyStorePassword;

	@Value("${app.security.jwt.key-alias}")
	private String keyAlias;

	@Value("${app.security.jwt.private-key-passphrase}")
	private String privateKeyPassphrase;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("MyUserDetailServic")
    public UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){ return NoOpPasswordEncoder.getInstance();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
          .withClient("client")
                .secret(passwordEncoder().encode("password"))
                .scopes("read")
                .authorizedGrantTypes("client_credentials","password");
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");

    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .accessTokenConverter(tokenConverter())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Bean
   public TokenStore tokenStore() {
      return new JwtTokenStore(tokenConverter());
    }

    public JwtAccessTokenConverter tokenConverter(){
        ClassPathResource ksFile =
          new ClassPathResource(keyStorePath);
        KeyStoreKeyFactory ksFactory =
          new KeyStoreKeyFactory(ksFile, keyStorePassword.toCharArray());
        KeyPair keyPair = ksFactory.getKeyPair(keyAlias, privateKeyPassphrase.toCharArray());
        JwtAccessTokenConverter converter = new UserTokenEnhancer();
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Bean
    public TokenKeyEndpoint tokenKeyEndpoint() {
        return new TokenKeyEndpoint(tokenConverter());
    }
}
