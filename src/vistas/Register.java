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
		setBounds(100, 100, 355, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(132, 26, 60, 16);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("Apellido");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(136, 75, 61, 14);
		contentPane.add(lblLastName);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(139, 125, 55, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(130, 180, 82, 12);
		contentPane.add(lblContrasea);

		JLabel lblUsuario_1_1 = new JLabel("Tarjeta");
		lblUsuario_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario_1_1.setBounds(139, 226, 63, 18);
		contentPane.add(lblUsuario_1_1);

		etRegName = new JFormattedTextField();
		etRegName.setBounds(73, 52, 210, 16);
		contentPane.add(etRegName);

		etRegLastName = new JFormattedTextField();
		etRegLastName.setBounds(74, 99, 210, 16);
		contentPane.add(etRegLastName);

		etRegUser = new JFormattedTextField();
		etRegUser.setBounds(72, 149, 210, 16);
		contentPane.add(etRegUser);

		etRegCred = new JFormattedTextField();
		etRegCred.setBounds(72, 252, 210, 16);
		contentPane.add(etRegCred);

		JButton btnRegister = new JButton("Registrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miPwd = ph.funcionHash(etRegPwd.getText());
				miCN = CNS.funcionSymmCN(etRegCred.getText());
				db.insertar(etRegUser.getText(), miPwd, etRegName.getText(), etRegLastName.getText(), miCN);
				setVisible(false);
				milg.setVisible(true);
			}
		});
		btnRegister.setBounds(130, 289, 85, 21);
		contentPane.add(btnRegister);
		
		etRegPwd = new JFormattedTextField();
		etRegPwd.setBounds(73, 202, 210, 21);
		contentPane.add(etRegPwd);
	}

}