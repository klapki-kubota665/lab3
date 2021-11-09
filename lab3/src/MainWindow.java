import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MainWindow extends JFrame {
    private HashMap<String, String> users;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow("Okno");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
    public MainWindow() throws HeadlessException {
        this("undefined");
    }
    public MainWindow(String title) throws HeadlessException {
        super(title);
        buildFrame();
        users = new HashMap<>();
        users.put("Kowalski", "Jan" );
        users.put("Wisniewski", "Michal");
        users.put("Lewandowski","Robert");
        users.put( "Zielinski","Piotr");
    }
    protected void buildFrame() {


        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JPanel jPanel = new JPanel(null);
        setContentPane(jPanel);

        jPanel.setBackground(Color.GRAY);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("CANCEL");
        jPanel.add(okButton);
        jPanel.add(cancelButton);
        okButton.setBounds(100, 200, 100, 40);
        cancelButton.setBounds(250, 200, 100, 40);
        JLabel label = new JLabel("Login");
        JLabel label2 = new JLabel("Password");
        JTextField loginField = new JTextField();
        loginField.setBounds(200, 50, 100,40);
        jPanel.add(loginField);
        label.setLabelFor(loginField);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 100, 100,40);
        label2.setLabelFor(passwordField);
        jPanel.add(passwordField);
        jPanel.add(label);
        jPanel.add(label2);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(users.containsKey(loginField.getText()))
                    if(users.get(loginField.getText()).equals(passwordField.getText()))
                        jPanel.setBackground(Color.GREEN);
                    else{
                    jPanel.setBackground(Color.ORANGE);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
                loginField.setText("");
            }
        });

}
}

