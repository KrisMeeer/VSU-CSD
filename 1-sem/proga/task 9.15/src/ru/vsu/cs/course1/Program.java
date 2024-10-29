package ru.vsu.cs.course1;
import ru.vsu.cs.util.SwingUtils;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        winMain();
    }

    public static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}