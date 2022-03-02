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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField passwordField;
	String contraseñaCifradaBD;
	String contraseñaCifradaLocal;
	private JFormattedTextField etUser;
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
		setForeground(Color.WHITE);
		setTitle("Login\r\n");
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 9, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Unispace", Font.BOLD, 15));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(443, 35, 68, 27);
		contentPane.add(lblUser);

		JLabel lblPwd = new JLabel("Contrase\u00F1a");
		lblPwd.setFont(new Font("Unispace", Font.BOLD, 15));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(443, 143, 94, 29);
		contentPane.add(lblPwd);

		passwordField = new JFormattedTextField();
		passwordField.setBounds(443, 183, 330, 42);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setBackground(SystemColor.activeCaptionText);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contraseñaCifradaBD = db.sacarContraseña(etUser.getText());
				contraseñaCifradaLocal = ph.funcionHash(passwordField.getText());
				System.out.println(contraseñaCifradaLocal);
				
				// La contraseña de local y de la BD es la misma pero en el if se compara de forma errónea
				System.out.println("CONTRASEÑA EN LA BD: " + contraseñaCifradaBD);
				System.out.println("CONTRASEÑA INTRODUCIDA: " + contraseñaCifradaLocal);
				if(contraseñaCifradaBD.equals(contraseñaCifradaLocal)) {
					setVisible(false);
					viewDetail.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(443, 283, 330, 42);
		contentPane.add(btnLogin);
		
		etUser = new JFormattedTextField();
		etUser.setForeground(Color.BLACK);
		etUser.setBounds(443, 73, 330, 42);
		contentPane.add(etUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 410, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/93f52a03c9229869dcdef8b0451057fc.jpg")));
		lblNewLabel.setBounds(-35, 0, 473, 238);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Log In");
		lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(151, 300, 113, 59);
		panel.add(lblNewLabel_1);
	}
}
