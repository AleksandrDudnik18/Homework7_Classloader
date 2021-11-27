package task1.plugins;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(ClassLoader parent, URL... urls) {
        super(urls, parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            return super.loadClass(name);
        }
        catch (ClassNotFoundException e) {
            return getParent().loadClass(
                    getClass().getPackage().getName() + "." + name
            );
        }
    }
}