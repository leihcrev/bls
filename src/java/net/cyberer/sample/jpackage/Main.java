package net.cyberer.sample.jpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
  private static final long serialVersionUID = 1L;

  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          JFrame mainFrame = new Main();
          mainFrame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  private final JPanel panel;
  private Main() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100, 100, 420, 340);
    panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(new BorderLayout(0, 0));
    setContentPane(panel);

    JLabel hw = new JLabel("Hello, world!");
    panel.add(hw, BorderLayout.CENTER);
  }
}
