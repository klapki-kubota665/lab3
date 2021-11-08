import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {
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
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.GREEN);
    }
    protected void buildFrame() {

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mnitLogin = new JMenuItem("Login");
        mnitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ;
            }
        });
        mnitLogin.setMnemonic(KeyEvent.VK_S);
        mnFile.add(mnitLogin);

        JMenuItem mnitCancel = new JMenuItem("Cancel");
        mnitCancel.addActionListener(e -> {
            ;
        });
        mnitCancel.setMnemonic(KeyEvent.VK_C);
        mnFile.add(mnitCancel);
    }

    /*private void doLogin() {
        if()
    }*/
}

