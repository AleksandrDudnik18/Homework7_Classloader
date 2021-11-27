package task2;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PluginCipher {

    public static void encrypt(String pluginDirectory, String pluginClassName, String algorithm, String key) throws Exception {
        Path pluginPath = Path.of(pluginDirectory, pluginClassName + ".class");
        byte[] bytes = Files.readAllBytes(pluginPath);

        System.err.println("bytes = " + Arrays.toString(bytes));

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), 0, key.length(), algorithm));
        byte[] encryptedBytes = cipher.doFinal(bytes);

        System.err.println("encryptedBytes = " + Arrays.toString(encryptedBytes));

        Files.write(pluginPath.getParent().resolve(pluginClassName), encryptedBytes);
    }

}
