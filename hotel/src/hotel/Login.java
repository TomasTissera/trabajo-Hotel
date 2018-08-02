/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    String user;
    String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;

        //Objetos
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.gray);

        JLabel label = new JLabel("         CHAT");
        label.setBounds(100, 10, 90, 30);
        label.setForeground(Color.white);

        JLabel labUser = new JLabel("Usuario:");
        labUser.setBounds(25, 50, 60, 30);
        labUser.setForeground(Color.white);

        JLabel labPass = new JLabel("Password:");
        labPass.setBounds(20, 90, 80, 30);
        labPass.setForeground(Color.white);

        JTextField fuser = new JTextField();
        fuser.setBounds(110, 52, 170, 25);
        fuser.setText(user);

        JPasswordField fpass = new JPasswordField();
        fpass.setBounds(110, 92, 170, 25);
        fpass.setText(pass);

        JCheckBox ver = new JCheckBox("Mostrar contraseña");
        ver.setBounds(107, 120, 170, 15);
        ver.setBackground(Color.gray);
        ver.setForeground(Color.white);
        ver.setMnemonic('M');
        fpass.setEchoChar('*');

        JButton enter = new JButton("Ingresar");
        enter.setBounds(70, 165, 150, 30);
        enter.setMnemonic('I');

        JCheckBox checkbox = new JCheckBox("Recordarme");
        checkbox.setBounds(20, 135, 110, 30);
        checkbox.setBackground(Color.gray);
        checkbox.setForeground(Color.white);
        checkbox.setMnemonic('R');
        checkbox.setSelected(true);

        //Acciones
        fuser.addActionListener((e) -> {
            fpass.requestFocus();
        });

        fpass.addActionListener((e) -> {
            pasarVentana(frame, checkbox, fuser, fpass);
        });

        enter.addActionListener((e) -> {
            pasarVentana(frame, checkbox, fuser, fpass);

        });

        ver.addActionListener((e) -> {
            if (ver.isSelected()) {
                fpass.setEchoChar((char) 0);
            } else {
                fpass.setEchoChar('*');
            }
            fpass.requestFocus();
        });

        frame.add(ver);
        frame.add(checkbox);
        frame.add(enter);
        frame.add(fpass);
        frame.add(fuser);
        frame.add(labPass);
        frame.add(labUser);
        frame.add(label);
        frame.setVisible(true);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void pasarVentana(JFrame frame, JCheckBox checkbox, JTextField fuser, JPasswordField fpass) {
        if (!checkbox.isSelected()) {
            this.user = "";
            this.pass = "";
        } else {
            this.user = fuser.getText();
            this.pass = String.valueOf(fpass.getPassword());
        }
        Login frame1 = new Login(this.user, this.pass);
        frame.dispose();
    }

    @Override
    public String toString() {
        return "Login{" + "user=" + user + ", pass=" + pass + '}';
    }

}