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
import javax.swing.ImageIcon;

public class Detail extends JFrame {

	private JPanel contentPane;
	String CNDesencriptada;
	String CNEncriptado;
//	private CNSymmetrical CNS = new CNSymmetrical();
	private Conexion db = new Conexion();
	public JLabel etDetailUser;
	public JLabel etDetailName;
	public JLabel etDetaiLastName;
	public JLabel etDetailCred;
	public JLabel lblSecretNumber;
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
		lblDetailUser.setBounds(466, 144, 159, 26);
		contentPane.add(lblDetailUser);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Unispace", Font.BOLD, 21));
		lblNombre.setBounds(466, 181, 159, 26);
		contentPane.add(lblNombre);

		JLabel lblDetailUser_1_1 = new JLabel("Apellido:");
		lblDetailUser_1_1.setFont(new Font("Unispace", Font.BOLD, 21));
		lblDetailUser_1_1.setBounds(466, 218, 159, 26);
		contentPane.add(lblDetailUser_1_1);

		JLabel lblDetailUser_1_1_1 = new JLabel("Tarjeta:");
		lblDetailUser_1_1_1.setFont(new Font("Unispace", Font.BOLD, 21));
		lblDetailUser_1_1_1.setBounds(466, 255, 159, 26);
		contentPane.add(lblDetailUser_1_1_1);

		etDetailUser = new JLabel("User");
		etDetailUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailUser.setBounds(647, 144, 152, 26);
		contentPane.add(etDetailUser);

		etDetailName = new JLabel("Name");
		etDetailName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailName.setBounds(647, 183, 152, 26);
		contentPane.add(etDetailName);

		etDetaiLastName = new JLabel("LastName");
		etDetaiLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetaiLastName.setBounds(647, 220, 152, 26);
		contentPane.add(etDetaiLastName);

		etDetailCred = new JLabel("Credit");
		etDetailCred.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailCred.setBounds(647, 257, 152, 26);
		contentPane.add(etDetailCred);
		etDetailCred.setText("Tarjeta");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 456, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Detail");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(186, 336, 122, 68);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Detail.class.getResource("/images/istockphoto-1293134999-612x612.jpg")));
		lblNewLabel_1.setBounds(0, 0, 456, 290);
		panel.add(lblNewLabel_1);
		
		JLabel lblDetailUser_1_1_1_1 = new JLabel("Secret Number:");
		lblDetailUser_1_1_1_1.setFont(new Font("Unispace", Font.BOLD, 17));
		lblDetailUser_1_1_1_1.setBounds(466, 291, 165, 26);
		contentPane.add(lblDetailUser_1_1_1_1);
		
		lblSecretNumber = new JLabel("Secret Number");
		lblSecretNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecretNumber.setBounds(647, 293, 152, 26);
		contentPane.add(lblSecretNumber);
		
	}

} 
