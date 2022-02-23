package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Detail extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 322, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDetailUser = new JLabel("Usuario:");
		lblDetailUser.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDetailUser.setBounds(35, 44, 115, 26);
		contentPane.add(lblDetailUser);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(35, 110, 73, 26);
		contentPane.add(lblNombre);

		JLabel lblDetailUser_1_1 = new JLabel("Apellido:");
		lblDetailUser_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDetailUser_1_1.setBounds(35, 164, 73, 26);
		contentPane.add(lblDetailUser_1_1);

		JLabel lblDetailUser_1_1_1 = new JLabel("Tarjeta:");
		lblDetailUser_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDetailUser_1_1_1.setBounds(35, 214, 73, 26);
		contentPane.add(lblDetailUser_1_1_1);

		JLabel etDetailUser = new JLabel("User");
		etDetailUser.setFont(new Font("Tahoma", Font.PLAIN, 21));
		etDetailUser.setBounds(160, 44, 115, 26);
		contentPane.add(etDetailUser);

		JLabel etDetailName = new JLabel("Name");
		etDetailName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailName.setBounds(157, 110, 73, 26);
		contentPane.add(etDetailName);

		JLabel etDetaiLastName = new JLabel("LastName");
		etDetaiLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetaiLastName.setBounds(157, 164, 73, 26);
		contentPane.add(etDetaiLastName);

		JLabel etDetailCred = new JLabel("Credit");
		etDetailCred.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etDetailCred.setBounds(157, 214, 73, 26);
		contentPane.add(etDetailCred);
	}

}
