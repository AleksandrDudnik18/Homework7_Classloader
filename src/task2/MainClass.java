package task2;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        try {
            String data = "Привет Мир!";
            System.out.println(Arrays.toString(data.getBytes()));
            //
            String alg = "AES";
            String baseKey = "Dgh6JKohgIorf8fk";
            Key key = new SecretKeySpec(
                    baseKey.getBytes(),
                    alg
            );
            //
            Cipher cipher = Cipher.getInstance(alg);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //
            byte[] bytes = cipher.doFinal(data.getBytes());
            System.out.println(Arrays.toString(bytes));
            //
            cipher.init(Cipher.DECRYPT_MODE, key);
            bytes = cipher.doFinal(bytes);
            System.out.println(Arrays.toString(bytes));
            //
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
