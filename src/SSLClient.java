import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLClient {
	private static final String SERVERIP  = "194.51.35.120";
	private static final int SERVERPORT   = 6257;
	private final static String KEYSTOREPASSWORD = "GuillaumeMaucomblea30piges";
	private final static String KEYSTOREPATH = "T:\\gara\\Dev\\FTV\\Varet\\Agent\\SPVLVAREPADAGT.dmz.cde.francetv.fr.cacerts";

	public static void main(String[] arstring) throws IOException {
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
	    SSLSocket soc = (SSLSocket) factory.createSocket();

	    // Returns the names of the protocol versions which are
	    // currently enabled for use on this connection.
	    String[] protocols = soc.getEnabledProtocols();

	    System.out.println("Enabled protocols:");
	    for (String s : protocols) {
	      System.out.println(s);
	    }

		try {
			final KeyStore keyStore = KeyStore.getInstance("JKS");
			final InputStream ksIs = new FileInputStream(KEYSTOREPATH);
			try {
				keyStore.load(ksIs, KEYSTOREPASSWORD.toCharArray());
			} finally {
				if (ksIs != null) {
					ksIs.close();
				}
			}
			final TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(keyStore);

			final SSLContext context = SSLContext.getInstance("TLS");
			final TrustManager[] trustManagers = tmf.getTrustManagers();

			context.init(null, trustManagers, null);
			final SSLSocketFactory sslsocketfactory = context.getSocketFactory();

			final SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(SSLClient.SERVERIP, SSLClient.SERVERPORT);

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(sslsocket.getOutputStream()));

			String string = null;
			while ((string = bufferedreader.readLine()) != null) {
				bufferedwriter.write(string + '\n');
				bufferedwriter.flush();
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}