package us.malfeasant.hubconfig;

import java.net.InetAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.tinylog.Logger;

public class ConnectHub {
    public static void connect(InetAddress hub) {
        Logger.info("Setting up TLS connection to Hub at {}", hub);
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            // These can all be null- do we need any at all?
            context.init(null, null, null);
        } catch (NoSuchAlgorithmException e) {
            // This should not happen...
            Logger.error("Flagrant error- TLS not supported?");
        } catch (KeyManagementException e) {
            // TODO Not sure what to do here...
            Logger.error(e);
        }
    }
}
