package task1;

public class Main {

    public static final String PLUGIN_ROOT = "plugins";

    public static void main(String[] args) {

        PluginManager pluginManager = new PluginManager(PLUGIN_ROOT);
        Plugin pluginOuter = pluginManager.load("OuterDialog", "Outer");

        pluginOuter.doUseful();
    }
}
