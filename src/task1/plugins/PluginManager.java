package task1.plugins;

import java.io.File;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            PluginClassLoader classLoader = new PluginClassLoader(
                    getClass().getClassLoader(),
                    new File(pluginRootDirectory, pluginName).toURI().toURL()
            );
            return (Plugin) classLoader.loadClass(pluginClassName)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
