package task1;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {

        try {
            URI uri = new File(pluginRootDirectory, pluginName).toURI();
            URLClassLoader urlLoader = URLClassLoader.newInstance(new URL[]{uri.toURL()});
            Class<?> pluginClass = urlLoader.loadClass(pluginClassName);
            return (Plugin) pluginClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
