package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import dao.UsersDao;
import entidades.Address;
import entidades.User;
import entidades.User.Gender;

public class FrameRegisterUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private MaskFormatter cpfMask;
	private MaskFormatter dateMask;
	private MaskFormatter zipcodeMask;
	private JTextField tfEmail;
	private JTextField tfFullName;
	private JTextField tfCity;
	private JTextField tfState;
	private JTextField tfStreet;
	private JFormattedTextField ftfCPF;
	private JFormattedTextField ftfZipcode;
	private JFormattedTextField ftfBirthday;
	private JComboBox<Gender> cboxGender;

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

		formatTextFields();
		getContentPane().setBackground(new Color(255, 248, 220));
		setBounds(100, 100, 900, 529);
		getContentPane().setLayout(null);

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
		btnRegister.setBounds(151, 382, 200, 50);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerUser();
			}
		});
		btnRegister.setBackground(new Color(152, 251, 152));
		btnRegister.setFont(new Font("Serif", Font.ITALIC, 30));

		cboxGender = new JComboBox<>();
		cboxGender.setModel(new DefaultComboBoxModel(Gender.values()));
		cboxGender.setFont(new Font("Serif", Font.PLAIN, 20));
		cboxGender.setEditable(true);
		cboxGender.setBackground(Color.WHITE);
		cboxGender.setBounds(687, 206, 100, 30);
		panel.add(cboxGender);

		ftfCPF = new JFormattedTextField(cpfMask);
		ftfCPF.setFont(new Font("Serif", Font.PLAIN, 16));
		ftfCPF.setBounds(51, 206, 250, 30);
		panel.add(ftfCPF);

		ftfZipcode = new JFormattedTextField(zipcodeMask);
		ftfZipcode.setFont(new Font("Serif", Font.PLAIN, 16));
		ftfZipcode.setBounds(34, 292, 150, 30);
		panel.add(ftfZipcode);

		JLabel lblName = new JLabel("Full Name:");
		lblName.setFont(new Font("Serif", Font.ITALIC, 24));
		lblName.setBounds(9, 104, 250, 30);
		panel.add(lblName);

		JLabel lblRegisterYourProfile_1 = new JLabel("Register your profile!");
		lblRegisterYourProfile_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterYourProfile_1.setFont(new Font("Serif", Font.ITALIC, 50));
		lblRegisterYourProfile_1.setBounds(-13, 0, 864, 70);
		panel.add(lblRegisterYourProfile_1);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Serif", Font.ITALIC, 24));
		lblEmail.setBounds(292, 104, 250, 30);
		panel.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Serif", Font.PLAIN, 16));
		tfEmail.setColumns(10);
		tfEmail.setBounds(292, 135, 250, 30);
		panel.add(tfEmail);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCpf.setBounds(47, 176, 250, 30);
		panel.add(lblCpf);

		JLabel lblZipcode = new JLabel("Zipcode:");
		lblZipcode.setFont(new Font("Serif", Font.ITALIC, 24));
		lblZipcode.setBounds(32, 260, 150, 30);
		panel.add(lblZipcode);

		tfFullName = new JTextField();
		tfFullName.setFont(new Font("Serif", Font.PLAIN, 16));
		tfFullName.setColumns(10);
		tfFullName.setBounds(9, 135, 250, 30);
		panel.add(tfFullName);

		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCity.setBounds(238, 260, 150, 30);
		panel.add(lblCity);

		tfCity = new JTextField();
		tfCity.setFont(new Font("Serif", Font.PLAIN, 16));
		tfCity.setColumns(10);
		tfCity.setBounds(238, 291, 150, 30);
		panel.add(tfCity);

		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Serif", Font.ITALIC, 24));
		lblState.setBounds(444, 260, 150, 30);
		panel.add(lblState);

		tfState = new JTextField();
		tfState.setFont(new Font("Serif", Font.PLAIN, 16));
		tfState.setColumns(10);
		tfState.setBounds(444, 291, 150, 30);
		panel.add(tfState);

		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Serif", Font.ITALIC, 24));
		lblStreet.setBounds(650, 260, 150, 30);
		panel.add(lblStreet);

		tfStreet = new JTextField();
		tfStreet.setFont(new Font("Serif", Font.PLAIN, 16));
		tfStreet.setColumns(10);
		tfStreet.setBounds(650, 291, 150, 30);
		panel.add(tfStreet);

		JLabel lblBirhday = new JLabel("Birthday:");
		lblBirhday.setFont(new Font("Serif", Font.ITALIC, 24));
		lblBirhday.setBackground(new Color(244, 164, 96));
		lblBirhday.setBounds(368, 176, 250, 30);
		panel.add(lblBirhday);

		ftfBirthday = new JFormattedTextField(dateMask);
		ftfBirthday.setFont(new Font("Serif", Font.PLAIN, 16));
		ftfBirthday.setBounds(368, 207, 250, 30);
		panel.add(ftfBirthday);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPassword.setBounds(575, 104, 250, 30);
		panel.add(lblPassword);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Serif", Font.ITALIC, 24));
		lblGender.setBounds(689, 176, 100, 30);
		panel.add(lblGender);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Serif", Font.ITALIC, 30));
		btnCancel.setBackground(new Color(211, 211, 211));
		btnCancel.setBounds(486, 382, 200, 50);
		panel.add(btnCancel);

	}

	public void formatTextFields() {
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			dateMask = new MaskFormatter("####-##-##");
			zipcodeMask = new MaskFormatter("#####-###");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void registerUser() {
		String fullName = tfFullName.getText().trim();
		String email = tfEmail.getText().trim();
		String password = new String(passwordField.getPassword()).trim();
		String cpf = ftfCPF.getText().trim();
		String birthdateStr = ftfBirthday.getText().trim();
		String zipcode = ftfZipcode.getText().trim();
		String city = tfCity.getText().trim();
		String state = tfState.getText().trim();
		String street = tfStreet.getText().trim();
		Gender gender = (Gender) cboxGender.getSelectedItem();

		if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || cpf.isEmpty() || birthdateStr.isEmpty()
				|| zipcode.isEmpty() || city.isEmpty() || state.isEmpty() || street.isEmpty() || gender == null) {
			JOptionPane.showMessageDialog(this, "All fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Date birthdate;
		try {
			birthdate = Date.valueOf(birthdateStr);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Address address = new Address(zipcode, street, city, state);
		User user = new User(fullName, gender, email, birthdate, cpf, password, address);

		UsersDao dao = new UsersDao();

		try {
			dao.insertUser(user);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		JOptionPane.showMessageDialog(this, "User registered successfully!", "Success",
				JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
}
