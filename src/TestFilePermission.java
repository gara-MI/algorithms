import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

public class TestFilePermission {
	public static void main(String[] args) {
		
		try {
			Files.createDirectories(Paths.get("/tmp/thisisSmallTest1"),PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwxrwxr-x")));
			Files.createDirectories(Paths.get("/tmp/thisisSmallTest2"),PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwxrwxr-x")));
			Files.setPosixFilePermissions(Paths.get("/tmp/	.tmp"), PosixFilePermissions.fromString("rw-rw-r--"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
