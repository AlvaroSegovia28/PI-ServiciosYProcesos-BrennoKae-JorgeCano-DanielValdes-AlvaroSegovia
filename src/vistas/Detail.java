package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Model.CNSymmetrical;
import Model.Conexion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Detail extends JFrame {

	private JPanel contentPane;
	String CNDesencriptada;
	String CNEncriptado;
//	private CNSymmetrical CNS = new CNSymmetrical();
	private Conexion db = new Conexion();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detail frame = new Detail();
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
	public Detail() {
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDetailUser = new JLabel("Usuario:");
		lblDetailUser.setFont(new Font("Unispace", Font.BOLD, 21));
		lblDetailUser.setBounds(497, 144, 104, 26);
		contentPane.add(lblDetailUser);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Unispace", Font.BOLD, 21));
		lblNombre.setBounds(497, 181, 99, 26);
		contentPane.add(lblNombre);

		JLabel lblDetailUser_1_1 = new JLabel("Apellido:");
		lblDetailUser_1_1.setFont(new Font("Unispace", Font.BOLD, 21));
		lblDetailUser_1_1.setBounds(497, 218, 128, 26);
		contentPane.add(lblDetailUser_1_1);

		JLabel lblDetailUser_1_1_1 = new JLabel("Tarjeta:");
		lblDetailUser_1_1_1.setFont(new Font("Unispace", Font.BOLD, 21));
		lblDetailUser_1_1_1.setBounds(497, 255, 128, 26);
		contentPane.add(lblDetailUser_1_1_1);

		JLabel etDetailUser = new JLabel("User");
		etDetailUser.setFont(new Font("Tahoma", Font.PLAIN, 21));
		etDetailUser.setBounds(647, 144, 115, 26);
		contentPane.add(etDetailUser);

		JLabel etDetailName = new JLabel("Name");
		etDetailName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailName.setBounds(647, 183, 73, 26);
		contentPane.add(etDetailName);

		JLabel etDetaiLastName = new JLabel("LastName");
		etDetaiLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetaiLastName.setBounds(647, 220, 73, 26);
		contentPane.add(etDetaiLastName);

		JLabel etDetailCred = new JLabel("Credit");
		etDetailCred.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailCred.setBounds(647, 257, 73, 26);
		contentPane.add(etDetailCred);
		CNEncriptado = db.sacarCN("asd");
//		CNDesencriptada = CNS.desencryptionCN(CNEncriptado);
		etDetailCred.setText("Tarjeta");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 456, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Detail");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(168, 366, 194, 95);
		panel.add(lblNewLabel);
		
	}

}
