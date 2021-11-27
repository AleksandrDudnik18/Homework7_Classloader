package task2;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;
    private String algorithm;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent, String algorithm) {
        super(parent);
        this.key = key;
        this.dir = dir;
        this.algorithm = algorithm;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        return defineEncryptedClass(name);
    }


    private Class<?> defineEncryptedClass(String name) throws ClassNotFoundException {

        try {
            Path pluginPath = Path.of(dir.getPath(), name);
            byte[] bytes = Files.readAllBytes(pluginPath);

            System.err.println("bytes = " + Arrays.toString(bytes));

            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), 0, key.length(), algorithm));
            byte[] decryptedBytes = cipher.doFinal(bytes);

            System.err.println("decryptedBytes = " + Arrays.toString(decryptedBytes));

            return defineClass(name, decryptedBytes, 0, decryptedBytes.length);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
