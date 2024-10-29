package ru.vsu.solution;


import ru.vsu.solution.util.JTableUtils;
import ru.vsu.solution.util.SwingUtils;
import ru.vsu.solution.Logic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FrameMain extends JFrame {
    private JTable tableInput;
    private JPanel mainPanel;

    //  private JButton buttonRandomInput;
    private JButton buttonExecuteTheProgramJava;
    private JButton buttonExecuteTheProgramMy;
    private JLabel outResult;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Task 3 - Amazing it works\n");
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(750, 475));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        JTableUtils.initJTableForArray(tableInput, 40, true, true, false, true);
        tableInput.setRowHeight(25);

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        String[] arr = {"a", "b", "b", "c", "b", "b", "a"};

        JTableUtils.writeArrayToJTable(tableInput, arr);

        this.pack();


        buttonExecuteTheProgramJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String[] array = JTableUtils.readStringArrayFromJTable(tableInput);
                    char[] matrix = new char[array.length];
                    for (int i = 0; i < matrix.length; i++) {
                        String s = array[i];
                        if (s.length() > 0) {
                            s = s.substring(0, 1);
                            matrix[i] = s.charAt(0);
                        } else {
                            matrix[i] = 0;
                        }
                    }
                    boolean res = LogicAboutJava.intoJavaInterfaceCheckPalindrome(LogicAboutJava.arrayInQueue(matrix));
                    String palindrome;
                    if (res){
                        palindrome = "Образуют";
                    } else {
                        palindrome = "Не образуют";
                    }

                    outResult.setText("Палиндром: " + palindrome);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonExecuteTheProgramMy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String[] array = JTableUtils.readStringArrayFromJTable(tableInput);
                    char[] matrix = new char[array.length];
                    for (int i = 0; i < matrix.length; i++) {
                        String s = array[i];
                        if (s.length() > 0) {
                            s = s.substring(0, 1);
                            matrix[i] = s.charAt(0);
                        } else {
                            matrix[i] = 0;
                        }
                    }
                    boolean res = LogicAboutVeryWellQueue.intoMyInterfaceCheckPalindrome(LogicAboutVeryWellQueue.arrayInQueue(matrix));
                    String palindrome;
                    if (res){
                        palindrome = "Образуют";
                    } else {
                        palindrome = "Не образуют";
                    }

                    outResult.setText("Палиндром: " + palindrome);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


        tableInput.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getOldValue() != null) {
                    String[] matrix = JTableUtils.readStringArrayFromJTable(tableInput);
                    for (int i = 0; i < matrix.length; i++) {
                        String s = matrix[i];
                        if (s.length() > 0) {
                            matrix[i] = "" + s.charAt(0);
                        }
                    }
                    JTableUtils.writeArrayToJTable(tableInput, matrix);
                }

            }
        });
    }

}
