package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.UsersDao;
import entidades.User;

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
		frame.getContentPane().setBackground(new Color(255, 248, 220));
		frame.setBounds(100, 100, 779, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Frame!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 20, 743, 72);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 28));
		lblEmail.setBackground(new Color(64, 0, 64));
		lblEmail.setBounds(223, 140, 300, 57);
		frame.getContentPane().add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Serif", Font.PLAIN, 18));
		tfEmail.setHorizontalAlignment(SwingConstants.LEFT);
		tfEmail.setBounds(223, 188, 300, 40);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Serif", Font.PLAIN, 28));
		lblPassword.setBackground(new Color(64, 0, 64));
		lblPassword.setBounds(223, 226, 300, 57);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 18));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(223, 278, 300, 40);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				login();

			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(152, 251, 152));
		btnLogin.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLogin.setBounds(300, 364, 150, 40);
		frame.getContentPane().add(btnLogin);

		JLabel lblRegister = new JLabel("Don't have an account? Register-here!");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FrameRegisterUser frame = new FrameRegisterUser();

				frame.setVisible(true);
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblRegister.setForeground(new Color(70, 130, 180));
		lblRegister.setBounds(223, 324, 300, 40);
		frame.getContentPane().add(lblRegister);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(179, 20, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void login() {

		String email = tfEmail.getText().trim();
		String password = new String(passwordField.getPassword());
		UsersDao userDao = new UsersDao();

		User loggedUser = userDao.loginUser(email, password);

		if (loggedUser != null) {

			MainFrame main = new MainFrame(loggedUser);
			main.setVisible(true);
			frame.dispose();
		} else {

			JOptionPane.showMessageDialog(null, "Email or password are incorrect");

		}
		;

	}
}
