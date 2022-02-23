package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Conexion;
import Model.PwdHash;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField etUser;
	private JPasswordField passwordField;
	String contraseñaCifradaBD;
	String contraseñaCifradaLocal;
	private PwdHash ph = new PwdHash();
	private Conexion db = new Conexion();
	Detail viewDetail = new Detail();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login\r\n");
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 9, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(45, 68, 68, 27);
		contentPane.add(lblUser);

		JLabel lblPwd = new JLabel("Contrase\u00F1a");
		lblPwd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(19, 125, 94, 29);
		contentPane.add(lblPwd);

		etUser = new JFormattedTextField();
		etUser.setBounds(123, 72, 167, 19);
		contentPane.add(etUser);

		passwordField = new JPasswordField();
		passwordField.setBounds(123, 129, 167, 19);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contraseñaCifradaBD = db.sacarContraseña(etUser.getText());
//				System.out.println(contraseñaCifradaBD);
				contraseñaCifradaLocal = ph.funcionHash(passwordField.getPassword().toString());
				System.out.println(contraseñaCifradaLocal);
				if(contraseñaCifradaBD.equals(contraseñaCifradaLocal)) {
					setVisible(false);
					viewDetail.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(178, 182, 112, 27);
		contentPane.add(btnLogin);
	}
}
