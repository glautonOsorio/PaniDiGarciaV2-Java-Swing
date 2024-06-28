package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.ProductsDao;
import entidades.Product;
import entidades.Product.Categories;
import entidades.User;

public class FrameRegisterProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfProductName;
	private JTextField tfPrice;
	private JComboBox<Categories> cboxCategories;

	private JTextArea taDescription;

	public FrameRegisterProduct(User loggedUser, Product newProduct) {
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

		tfProductName = new JTextField();
		tfProductName.setFont(new Font("Serif", Font.PLAIN, 20));
		tfProductName.setColumns(10);
		tfProductName.setBounds(49, 148, 250, 30);
		panel.add(tfProductName);

		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPrice_1.setBounds(486, 120, 83, 30);
		panel.add(lblPrice_1);

		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Serif", Font.PLAIN, 20));
		tfPrice.setColumns(10);
		tfPrice.setBounds(479, 148, 85, 30);
		panel.add(tfPrice);

		JLabel lblPrice = new JLabel("Description:");
		lblPrice.setFont(new Font("Serif", Font.ITALIC, 24));
		lblPrice.setBounds(48, 189, 250, 30);
		panel.add(lblPrice);

		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setFont(new Font("Serif", Font.ITALIC, 24));
		lblCategories.setBounds(335, 120, 115, 30);
		panel.add(lblCategories);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Serif", Font.ITALIC, 30));
		btnCancel.setBackground(new Color(211, 211, 211));
		btnCancel.setBounds(364, 298, 200, 50);
		panel.add(btnCancel);

		JButton btnRegister = new JButton("Confirm");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				registerProduct(loggedUser);
			}
		});
		btnRegister.setFont(new Font("Serif", Font.ITALIC, 30));
		btnRegister.setBackground(new Color(152, 251, 152));
		btnRegister.setBounds(48, 298, 200, 50);
		panel.add(btnRegister);

		JLabel lblRegisterYourProduct = new JLabel("Register your product!");
		lblRegisterYourProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterYourProduct.setFont(new Font("Serif", Font.ITALIC, 56));
		lblRegisterYourProduct.setBounds(10, 0, 574, 70);
		panel.add(lblRegisterYourProduct);

		cboxCategories = new JComboBox();
		cboxCategories.setEditable(true);
		cboxCategories.setBackground(new Color(255, 255, 255));
		cboxCategories.setFont(new Font("Serif", Font.PLAIN, 20));
		cboxCategories.setModel(new DefaultComboBoxModel(Product.Categories.values()));
		cboxCategories.setSelectedIndex(0);
		cboxCategories.setBounds(335, 150, 105, 30);
		panel.add(cboxCategories);

		taDescription = new JTextArea();
		taDescription.setWrapStyleWord(true);
		taDescription.setLineWrap(true);
		taDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		taDescription.setBounds(49, 218, 515, 69);
		panel.add(taDescription);
	}

	public void registerProduct(User user) {
		String productName = tfProductName.getText();
		Categories categorie = (Categories) cboxCategories.getSelectedItem();
		double price = (double) Integer.valueOf(tfPrice.getText());
		String description = taDescription.getText();

		if (productName.isEmpty() || categorie == null || tfPrice.getText().isEmpty() || description.isEmpty()) {
			JOptionPane.showMessageDialog(this, "All fields need to be filled", "Error", JOptionPane.ERROR_MESSAGE);
			return;

		}

		Product product = new Product(productName, description, price, categorie, user);
		ProductsDao dao = new ProductsDao();

		int created = 0;
		try {
			created = dao.insertProduct(product);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		if (created == 0) {
			JOptionPane.showMessageDialog(this, "Error in registering product!", "Error", JOptionPane.ERROR_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(this, "Product registered successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);

			TelaPrincipal tela = new TelaPrincipal(user);
			tela.setVisible(true);
			dispose();
		}
	}
}
