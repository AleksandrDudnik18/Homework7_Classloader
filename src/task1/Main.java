package task1;


import task1.plugins.Plugin;
import task1.plugins.PluginManager;

public class Main {
    private static final String pluginRoot = "plugins";

    public static void main(String[] args) {
        PluginManager pluginManager = new PluginManager(pluginRoot);
        Plugin outer = pluginManager.load(
                "OuterDialog", "Outer");
        outer.action("Message");
    }
}
