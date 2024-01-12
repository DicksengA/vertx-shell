package org.example;

import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.config.keys.AuthorizedKeysAuthenticator;

import java.io.File;

public class Test {

    public void a(){
        SshServer h=SshServer.setUpDefaultServer();
        h.setPublickeyAuthenticator(new AuthorizedKeysAuthenticator(new File("<Location of authorized_keys file>")));
        h.setPublickeyAuthenticator( (username, key, session) -> {
            return true;
        });
    }
}
