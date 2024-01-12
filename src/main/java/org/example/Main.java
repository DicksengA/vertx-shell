package org.example;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.SelfSignedCertificate;
import io.vertx.ext.shell.ShellService;
import io.vertx.ext.shell.ShellServiceOptions;
import io.vertx.ext.shell.term.HttpTermOptions;
import io.vertx.ext.shell.term.SSHTermOptions;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        ShellService service = ShellService.create(vertx,
                new ShellServiceOptions().setSSHOptions(new SSHTermOptions().
                        setHost("localhost")
                        .setPort(5000)
                        .setKeyPairOptions(new JksOptions()
                                .setPath("/Users/dickson/Projects/vertxshell/src/test/resources/server-keystore.jks")
                                .setPassword("wibble")
                        )
                        .setAuthOptions(
                                new JsonObject()
                                        .put("provider", "properties")
                                        .put("config", new JsonObject().
                                                put("file", "/Users/dickson/Projects/vertxshell/src/test/resources/auth.properties"))
                        )

                ));


        service.start().onFailure(Throwable::printStackTrace);
    }
}