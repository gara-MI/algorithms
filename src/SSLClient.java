import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
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
	private static final String SERVERIP  = "xxx";
	private static final int SERVERPORT   = 8080;
	private final static String KEYSTOREPASSWORD = "xxxx";
	private final static String KEYSTOREPATH = "xxxx";

	public static void main(String[] arstring) {
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