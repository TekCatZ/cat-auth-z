package com.tekcatz.authZ.configs;

import org.openidentityplatform.opendj.embedded.EmbeddedOpenDJ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public EmbeddedOpenDJ embeddedOpenDJ() {
        EmbeddedOpenDJ embeddedOpenDJ = new EmbeddedOpenDJ();
        embeddedOpenDJ.run();
        return embeddedOpenDJ;
    }
}
