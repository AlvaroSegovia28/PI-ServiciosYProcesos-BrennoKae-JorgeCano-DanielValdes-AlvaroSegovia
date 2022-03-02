package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.CNSymmetrical;
//import Model.CNSymmetrical;
import Model.Conexion;
import Model.PwdHash;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField etRegName;
	private JFormattedTextField etRegLastName;
	private JFormattedTextField etRegUser;
	private JFormattedTextField etRegCred;
	private PwdHash ph = new PwdHash();
	private CNSymmetrical CNS = new CNSymmetrical();
	private Conexion db = new Conexion();
	Login milg = new Login();
	String miPwd;
	String miCN;
	private JFormattedTextField etRegPwd;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblName.setBounds(620, 30, 82, 16);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("Apellido");
		lblLastName.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblLastName.setBounds(619, 120, 125, 14);
		contentPane.add(lblLastName);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblUsuario.setBounds(620, 204, 101, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblContrasea.setBounds(620, 291, 151, 12);
		contentPane.add(lblContrasea);

		JLabel lblUsuario_1_1 = new JLabel("Tarjeta");
		lblUsuario_1_1.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblUsuario_1_1.setBounds(620, 367, 124, 18);
		contentPane.add(lblUsuario_1_1);

		etRegName = new JFormattedTextField();
		etRegName.setBounds(621, 56, 378, 42);
		contentPane.add(etRegName);

		etRegLastName = new JFormattedTextField();
		etRegLastName.setBackground(Color.WHITE);
		etRegLastName.setBounds(620, 152, 379, 42);
		contentPane.add(etRegLastName);

		etRegUser = new JFormattedTextField();
		etRegUser.setBounds(620, 239, 378, 42);
		contentPane.add(etRegUser);

		etRegCred = new JFormattedTextField();
		etRegCred.setBounds(620, 396, 378, 42);
		contentPane.add(etRegCred);

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Unispace", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miPwd = ph.funcionHash(etRegPwd.getText());
				miCN = CNS.funcionSymmCN(etRegCred.getText());
				db.insertar(etRegUser.getText(), miPwd, etRegName.getText(), etRegLastName.getText(), miCN);
				setVisible(false);
				milg.setVisible(true);
			}
		});
		btnRegister.setBounds(620, 462, 378, 47);
		contentPane.add(btnRegister);
		
		etRegPwd = new JFormattedTextField();
		etRegPwd.setBounds(620, 313, 378, 42);
		contentPane.add(etRegPwd);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 556, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(208, 421, 130, 83);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 556, 350);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/images/360_F_315349043_6ohfFyx37AFusCKZtGQtJR0jqUxhb25Y.jpg")));
	}

}