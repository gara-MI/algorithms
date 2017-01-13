
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLServer {

	private static final int PORT = 8080;
	private static final String KEYSTOREPASSWORD = "xxxx";
	private static final String KEYPASSWORD = "xxxx";
	private static final String KEYPATH = "xxxx";

	public static void main(String[] args) throws Exception {
		final KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new FileInputStream(KEYPATH), KEYSTOREPASSWORD.toCharArray());
		final KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		kmf.init(keystore, KEYPASSWORD.toCharArray());
		final SSLContext context = SSLContext.getInstance("TLS");
		final KeyManager[] keyManagers = kmf.getKeyManagers();

		context.init(keyManagers, null, null);

		final SSLServerSocketFactory ssf = context.getServerSocketFactory();
		final ServerSocket ss = ssf.createServerSocket(PORT);

		final Socket s = ss.accept();

		final BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while (((line = in.readLine()) != null)) {
			System.out.println(line);
		}
		s.getOutputStream().write("HTTP/1.1 200 OK".getBytes());
		in.close();
		s.close();
	}
}