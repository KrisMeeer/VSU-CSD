import util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class FrameMain extends JFrame {
    private JTable tableInput;
    private JPanel mainPanel;

    //  private JButton buttonRandomInput;
    private JButton buttonExecuteTheProgramJava;
    private JButton buttonExecuteTheProgramMy;
    private JSpinner spinner1;
    private JTextArea textArea1;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Task 3 - Amazing it works\n");
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(750, 475));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        spinner1.setValue(10);


        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);


        this.pack();


        buttonExecuteTheProgramJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int n = (int) spinner1.getValue();
                    new NestedQueue(n);
                    textArea1.setText("");

                    for (LinkedList<Integer> nestedQueue : NestedQueue.getQueue()) {
                        String end = "{";
                        for (int num : nestedQueue) {
                            end = end + num + " ";
                        }
                        end += "}\n";
                        textArea1.append(end);
                    }


                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

}
