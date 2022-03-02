package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.CNSymmetrical;
import Model.Conexion;
import Model.PwdHash;
import Model.SNAsymmetrical;

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
	public JFormattedTextField etRegUser;
	private JFormattedTextField etRegCred;
	private PwdHash ph = new PwdHash();
	private CNSymmetrical CNS = new CNSymmetrical();
	private SNAsymmetrical SNA = new SNAsymmetrical();
	private Conexion db = new Conexion();
	Login milg = new Login();
	String miPwd;
	String miCN;
	String miSN;
	String prvKey;
	private JFormattedTextField etRegPwd;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JFormattedTextField etRegSN;

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
		lblName.setBounds(619, 10, 82, 16);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("Apellido");
		lblLastName.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblLastName.setBounds(619, 88, 125, 14);
		contentPane.add(lblLastName);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblUsuario.setBounds(619, 164, 101, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblContrasea.setBounds(619, 240, 151, 12);
		contentPane.add(lblContrasea);

		JLabel lblCN = new JLabel("Tarjeta");
		lblCN.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblCN.setBounds(619, 314, 124, 18);
		contentPane.add(lblCN);

		etRegName = new JFormattedTextField();
		etRegName.setBounds(619, 36, 378, 42);
		contentPane.add(etRegName);

		etRegLastName = new JFormattedTextField();
		etRegLastName.setBackground(Color.WHITE);
		etRegLastName.setBounds(618, 112, 379, 42);
		contentPane.add(etRegLastName);

		etRegUser = new JFormattedTextField();
		etRegUser.setBounds(619, 188, 378, 42);
		contentPane.add(etRegUser);

		etRegCred = new JFormattedTextField();
		etRegCred.setBounds(619, 342, 378, 42);
		contentPane.add(etRegCred);

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Unispace", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miPwd = ph.funcionHash(etRegPwd.getText());
				miCN = CNS.encryptCN(etRegCred.getText());
				SNA.generateKeyASN();
				prvKey = SNA.prvkey;
				miSN = SNA.encryptCN(etRegSN.getText());
				db.insertar(etRegUser.getText(), miPwd, etRegName.getText(), etRegLastName.getText(), miCN, CNS.key.toString(), prvKey, miSN);
				setVisible(false);
				milg.setVisible(true);
			}
		});
		btnRegister.setBounds(619, 485, 378, 47);
		contentPane.add(btnRegister);
		
		etRegPwd = new JFormattedTextField();
		etRegPwd.setBounds(619, 262, 378, 42);
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
		lblNewLabel.setBounds(221, 406, 155, 88);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 556, 350);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/images/360_F_315349043_6ohfFyx37AFusCKZtGQtJR0jqUxhb25Y.jpg")));
		
		JLabel lblSN = new JLabel("Secret Number");
		lblSN.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblSN.setBounds(620, 394, 124, 18);
		contentPane.add(lblSN);
		
		etRegSN = new JFormattedTextField();
		etRegSN.setBounds(619, 422, 378, 42);
		contentPane.add(etRegSN);
	}
}