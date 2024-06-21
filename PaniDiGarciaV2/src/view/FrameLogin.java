package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameLogin {

	private JFrame frame;
	private JTextField tfEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin window = new FrameLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 779, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Frame!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(223, 61, 314, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 28));
		lblEmail.setBackground(new Color(64, 0, 64));
		lblEmail.setBounds(223, 144, 300, 57);
		frame.getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail.setBounds(223, 194, 300, 40);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Serif", Font.PLAIN, 28));
		lblPassword.setBackground(new Color(64, 0, 64));
		lblPassword.setBounds(223, 235, 300, 57);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(225, 287, 300, 40);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(142, 242, 165));
		btnLogin.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLogin.setBounds(305, 366, 150, 40);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblRegister = new JLabel("Do you want some potato? ya patty fuck");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Serif", Font.PLAIN, 12));
		lblRegister.setForeground(new Color(87, 197, 238));
		lblRegister.setBounds(223, 338, 300, 20);
		frame.getContentPane().add(lblRegister);
	}
}
