package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import entidades.Products.Categories;
import javax.swing.SwingConstants;
import entidades.Product;

public class FrameRegisterProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegisterProduct frame = new FrameRegisterProduct();
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
	public FrameRegisterProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(21, 21, 594, 359);
		contentPane.add(panel);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Serif", Font.ITALIC, 24));
		lblProductName.setBounds(49, 120, 250, 30);
		panel.add(lblProductName);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(49, 148, 250, 30);
		panel.add(textField);
		
		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPrice_1.setBounds(486, 120, 83, 30);
		panel.add(lblPrice_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Serif", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(479, 148, 85, 30);
		panel.add(textField_1);
		
		JLabel lblPrice = new JLabel("Description:");
		lblPrice.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPrice.setBounds(48, 189, 250, 30);
		panel.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Serif", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(48, 224, 459, 30);
		panel.add(textField_2);
		
		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCategories.setBounds(335, 120, 115, 30);
		panel.add(lblCategories);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Serif", Font.ITALIC, 30));
		btnCancel.setBackground(new Color(211, 211, 211));
		btnCancel.setBounds(307, 298, 200, 50);
		panel.add(btnCancel);
		
		JButton btnRegister = new JButton("Confirm");
		btnRegister.setFont(new Font("Serif", Font.ITALIC, 30));
		btnRegister.setBackground(new Color(152, 251, 152));
		btnRegister.setBounds(48, 298, 200, 50);
		panel.add(btnRegister);
		
		JLabel lblRegisterYourProduct = new JLabel("Register your product!");
		lblRegisterYourProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterYourProduct.setFont(new Font("Serif", Font.ITALIC, 56));
		lblRegisterYourProduct.setBounds(10, 0, 574, 70);
		panel.add(lblRegisterYourProduct);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(Product.Categories.values()));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(335, 150, 105, 30);
		panel.add(comboBox);
	}
}
