import task1.plugins.Plugin;

public class Outer implements Plugin {
    @Override
    public void action(String s) {
        Dialog.show(s);
    }
}
