package task1.plugins;

import task1.Plugin;

public class Outer implements Plugin {
    @Override
    public void doUseful() {
        System.out.println("plugins.Outer is working");
    }
}
