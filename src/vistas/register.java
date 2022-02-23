package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class register extends JFrame {

	private JPanel contentPane;
	private JPasswordField etRegPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
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
		
		JFormattedTextField etRegName = new JFormattedTextField();
		etRegName.setBounds(73, 52, 210, 16);
		contentPane.add(etRegName);
		
		JFormattedTextField etRegLastName = new JFormattedTextField();
		etRegLastName.setBounds(74, 99, 210, 16);
		contentPane.add(etRegLastName);
		
		JFormattedTextField etRegUser = new JFormattedTextField();
		etRegUser.setBounds(72, 149, 210, 16);
		contentPane.add(etRegUser);
		
		JFormattedTextField etRegCred = new JFormattedTextField();
		etRegCred.setBounds(72, 252, 210, 16);
		contentPane.add(etRegCred);
		
		etRegPwd = new JPasswordField();
		etRegPwd.setBounds(72, 204, 210, 16);
		contentPane.add(etRegPwd);
		
		JButton btnRegister = new JButton("Registrar");
		btnRegister.setBounds(130, 289, 85, 21);
		contentPane.add(btnRegister);
	}

}
