package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import entidades.Users.Gender;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameRegisterUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfZipcode;
	private JTextField tfEmail;
	private JTextField tfCPF;
	private JTextField tfFullName;
	private JTextField tfCity;
	private JTextField tfState;
	private JTextField tfStreet;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegisterUser frame = new FrameRegisterUser();
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
	public FrameRegisterUser() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setBounds(100, 100, 900, 529);
		getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Full Name:");
		lblName.setFont(new Font("Serif", Font.ITALIC, 24));
		lblName.setBounds(32, 115, 250, 30);
		getContentPane().add(lblName);

		JLabel lblRegisterYourProfile = new JLabel("Register your profile!");
		lblRegisterYourProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterYourProfile.setFont(new Font("Serif", Font.ITALIC, 50));
		lblRegisterYourProfile.setBounds(10, 11, 864, 70);
		getContentPane().add(lblRegisterYourProfile);

		tfZipcode = new JTextField();
		tfZipcode.setFont(new Font("Serif", Font.PLAIN, 16));
		tfZipcode.setBounds(55, 302, 150, 30);
		getContentPane().add(tfZipcode);
		tfZipcode.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Serif", Font.ITALIC, 24));
		lblEmail.setBounds(315, 115, 250, 30);
		getContentPane().add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Serif", Font.PLAIN, 16));
		tfEmail.setColumns(10);
		tfEmail.setBounds(315, 146, 250, 30);
		getContentPane().add(tfEmail);

		JComboBox cboxGender = new JComboBox();
		cboxGender.setEditable(true);
		cboxGender.setBackground(new Color(255, 255, 255));
		cboxGender.setFont(new Font("Serif", Font.PLAIN, 16));
		cboxGender.setModel(new DefaultComboBoxModel(Gender.values()));
		cboxGender.setBounds(712, 218, 100, 30);
		getContentPane().add(cboxGender);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCpf.setBounds(70, 187, 250, 30);
		getContentPane().add(lblCpf);

		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Serif", Font.PLAIN, 16));
		tfCPF.setColumns(10);
		tfCPF.setBounds(70, 218, 250, 30);
		getContentPane().add(tfCPF);

		JLabel lblZipcode = new JLabel("Zipcode:");
		lblZipcode.setFont(new Font("Serif", Font.ITALIC, 24));
		lblZipcode.setBounds(55, 271, 150, 30);
		getContentPane().add(lblZipcode);

		tfFullName = new JTextField();
		tfFullName.setFont(new Font("Serif", Font.PLAIN, 16));
		tfFullName.setColumns(10);
		tfFullName.setBounds(32, 146, 250, 30);
		getContentPane().add(tfFullName);

		JLabel lblEmail_2 = new JLabel("City:");
		lblEmail_2.setFont(new Font("Serif", Font.ITALIC, 24));
		lblEmail_2.setBounds(261, 271, 150, 30);
		getContentPane().add(lblEmail_2);

		tfCity = new JTextField();
		tfCity.setFont(new Font("Serif", Font.PLAIN, 16));
		tfCity.setColumns(10);
		tfCity.setBounds(261, 302, 150, 30);
		getContentPane().add(tfCity);

		JLabel lblCpf_1 = new JLabel("State:");
		lblCpf_1.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCpf_1.setBounds(467, 271, 150, 30);
		getContentPane().add(lblCpf_1);

		tfState = new JTextField();
		tfState.setFont(new Font("Serif", Font.PLAIN, 16));
		tfState.setColumns(10);
		tfState.setBounds(467, 302, 150, 30);
		getContentPane().add(tfState);

		JLabel lblEmail_1_1 = new JLabel("Street:");
		lblEmail_1_1.setFont(new Font("Serif", Font.ITALIC, 24));
		lblEmail_1_1.setBounds(673, 271, 150, 30);
		getContentPane().add(lblEmail_1_1);

		tfStreet = new JTextField();
		tfStreet.setFont(new Font("Serif", Font.PLAIN, 16));
		tfStreet.setColumns(10);
		tfStreet.setBounds(673, 302, 150, 30);
		getContentPane().add(tfStreet);

		JLabel lblBirhday = new JLabel("Birhday:");
		lblBirhday.setBackground(new Color(244, 164, 96));
		lblBirhday.setFont(new Font("Serif", Font.ITALIC, 24));
		lblBirhday.setBounds(391, 187, 250, 30);
		getContentPane().add(lblBirhday);

		JFormattedTextField ftfBirthday = new JFormattedTextField();
		ftfBirthday.setFont(new Font("Serif", Font.PLAIN, 16));
		ftfBirthday.setBounds(391, 218, 250, 30);
		getContentPane().add(ftfBirthday);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPassword.setBounds(598, 115, 250, 30);
		getContentPane().add(lblPassword);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Serif", Font.ITALIC, 24));
		lblGender.setBounds(712, 187, 100, 30);
		getContentPane().add(lblGender);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Serif", Font.ITALIC, 30));
		btnCancel.setBackground(new Color(211, 211, 211));
		btnCancel.setBounds(509, 393, 200, 50);
		getContentPane().add(btnCancel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(20, 11, 839, 455);
		getContentPane().add(panel);
		panel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 16));
		passwordField.setBounds(579, 134, 250, 30);
		panel.add(passwordField);
		
				JButton btnRegister = new JButton("Confirm");
				btnRegister.setBounds(148, 394, 200, 50);
				panel.add(btnRegister);
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnRegister.setBackground(new Color(152, 251, 152));
				btnRegister.setFont(new Font("Serif", Font.ITALIC, 30));

	}

}
