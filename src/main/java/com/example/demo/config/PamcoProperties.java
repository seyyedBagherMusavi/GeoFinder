package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(
    prefix = "pamco",
    ignoreUnknownFields = false
)
public class PamcoProperties {
    @Getter
    private final Cache cache = new Cache();
    @Getter
    private final Security security = new Security();
    @Getter
    private final CorsConfiguration cors = new CorsConfiguration();
    public static class Cache {
        @Getter
        private final Redis redis = new Redis();
        @Getter
        @Setter
        @Accessors(chain = true)
        public static class Redis {
            private String[] server;
            private int expiration;
            private boolean cluster;
            private int connectionPoolSize;
            private int connectionMinimumIdleSize;
            private int subscriptionConnectionPoolSize;
            private int subscriptionConnectionMinimumIdleSize;
            private int database;
            private String password;
            public Redis() {
                this.server = new String[]{"redis://localhost:6379"};
                this.expiration = 300;
                this.cluster = false;
                this.connectionPoolSize = 64;
                this.connectionMinimumIdleSize = 24;
                this.subscriptionConnectionPoolSize = 50;
                this.subscriptionConnectionMinimumIdleSize = 1;
                this.password = null;
                this.database = 0;
            }
        }
    }
    @Getter
    public static class Security {
        @Setter
        private String contentSecurityPolicy = "default-src 'self'; frame-src 'self' data:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https://storage.googleapis.com; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:";
        private final Authentication authentication = new Authentication();

        @Getter
        public static class Authentication {

            private final Jwt jwt = new Jwt();

            @Getter
            @Setter
            @Accessors(chain = true)
            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = null;
                    this.base64Secret = null;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

            }
        }
    }
}
