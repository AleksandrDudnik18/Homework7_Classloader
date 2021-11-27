package task2;

import task1.plugins.Outer;
import task1.plugins.Plugin;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        final String key = "qwterjbxt7cjcsyy";
        final String directory = "plugins/EncryptedOuter";
        final String algorithm = "AES";
        final String srcPluginName = "Outer";


        try {
            PluginCipher.encrypt(directory, srcPluginName, algorithm, key);
            EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(key, new File(directory),
                    Main.class.getClassLoader(), algorithm);
            Class<?> outerClass = encryptedClassLoader.findClass(srcPluginName);
            Plugin outer = (Plugin) outerClass.getDeclaredConstructor().newInstance();
            outer.action("my task");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
