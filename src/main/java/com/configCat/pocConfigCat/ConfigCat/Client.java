package com.configCat.pocConfigCat.ConfigCat;

import com.configcat.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.lang.Thread;

@Component
public class Client {

    @Bean
    public void doConection() throws InterruptedException {
        ConfigCatClient client = ConfigCatClient.newBuilder()
                .mode(PollingModes.autoPoll(30/* polling interval in seconds */))
                .logLevel(LogLevel.INFO) // <-- Set the log level to INFO to track how your feature flags were evaluated. When moving to production, you can remove this line to avoid too detailed logging.
                .build("hL7aCNTvpkmOJiyCOBKc7A/ay5AGzp2EUyIxPHwcqTtXg"); // <-- This is the actual SDK Key for your 'Test Environment' environment.
        boolean pocconfigcat = client.getValue(Boolean.class, "pocconfigcat", false);

        while(true) {
            Thread.sleep(1000 * 30);
            System.out.println("pocconfigcat's value from ConfigCat: " + pocconfigcat);
        }

    }

}
