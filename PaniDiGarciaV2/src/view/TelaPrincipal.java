package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.ProductsDao;
import entidades.Product;
import entidades.Product.Categories;
import entidades.User;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ProductsDao dao = new ProductsDao();
	private Product product;

	public TelaPrincipal(User loggedUser) {
		getContentPane().setBackground(new Color(255, 165, 0));
		setBounds(100, 100, 1000, 601);
		getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 93, 964, 350);
		getContentPane().add(scrollPane_1);

		table = new JTable();
		table.setFont(new Font("Serif", Font.PLAIN, 16));
		table.setBackground(new Color(255, 228, 181));
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Descrição", "Price", "Categorie", "User Id" }));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
		centralizar.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(1).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(2).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(3).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(4).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(5).setCellRenderer(centralizar);
		table.setDefaultEditor(Object.class, null);

		table.getTableHeader().setReorderingAllowed(false);

		JLabel lblMainText = new JLabel("Welcome! " + loggedUser.getFullName() + " to Pani di Garcia V2!");
		lblMainText.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainText.setFont(new Font("Serif", Font.ITALIC, 40));
		lblMainText.setBounds(10, 11, 964, 71);
		getContentPane().add(lblMainText);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register(loggedUser);
			}
		});
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setBackground(new Color(152, 251, 152));
		btnRegister.setFont(new Font("Serif", Font.PLAIN, 20));
		btnRegister.setBounds(20, 471, 150, 30);
		getContentPane().add(btnRegister);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(611, 455, 363, 100);
		getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnSweets = new JRadioButton("Sweets");
		rdbtnSweets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnSweets);
		rdbtnSweets.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnSweets.setBounds(135, 70, 100, 20);
		panel.add(rdbtnSweets);
		rdbtnSweets.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnSavorys = new JRadioButton("Savorys");
		rdbtnSavorys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnSavorys);
		rdbtnSavorys.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnSavorys.setBounds(256, 50, 100, 20);
		panel.add(rdbtnSavorys);
		rdbtnSavorys.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnBreads = new JRadioButton("Breads");
		rdbtnBreads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnBreads);
		rdbtnBreads.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnBreads.setBounds(135, 50, 100, 20);
		panel.add(rdbtnBreads);
		rdbtnBreads.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnCakes = new JRadioButton("Cakes");
		rdbtnCakes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnCakes);
		rdbtnCakes.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnCakes.setBounds(256, 30, 100, 20);
		panel.add(rdbtnCakes);
		rdbtnCakes.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnPies = new JRadioButton("Pies");
		rdbtnPies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnPies);
		rdbtnPies.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnPies.setBounds(256, 70, 100, 20);
		panel.add(rdbtnPies);
		rdbtnPies.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnAZorder = new JRadioButton("A-Z Order");
		rdbtnAZorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnAZorder);
		rdbtnAZorder.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnAZorder.setBounds(6, 10, 100, 20);
		panel.add(rdbtnAZorder);
		rdbtnAZorder.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnZAorder = new JRadioButton("Z-A Order");
		rdbtnZAorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnZAorder);
		rdbtnZAorder.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnZAorder.setBounds(256, 10, 100, 20);
		panel.add(rdbtnZAorder);
		rdbtnZAorder.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnUserProducts = new JRadioButton("Your Products");
		rdbtnUserProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);
			}
		});
		buttonGroup.add(rdbtnUserProducts);
		rdbtnUserProducts.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnUserProducts.setBounds(6, 30, 100, 20);
		panel.add(rdbtnUserProducts);
		rdbtnUserProducts.setBackground(new Color(240, 230, 140));

		JLabel lblFilters = new JLabel("Filters!");
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setFont(new Font("Serif", Font.ITALIC, 24));
		lblFilters.setBounds(6, 6, 350, 25);
		panel.add(lblFilters);

		JRadioButton rdbtnLowerPrice = new JRadioButton("Lower Price Order");
		rdbtnLowerPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);

			}
		});
		buttonGroup.add(rdbtnLowerPrice);
		rdbtnLowerPrice.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnLowerPrice.setBackground(new Color(240, 230, 140));
		rdbtnLowerPrice.setBounds(6, 50, 115, 20);
		panel.add(rdbtnLowerPrice);

		JRadioButton rdbtnHighPrice = new JRadioButton("High Price Order");
		rdbtnHighPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter(loggedUser);

			}
		});
		buttonGroup.add(rdbtnHighPrice);
		rdbtnHighPrice.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnHighPrice.setBackground(new Color(240, 230, 140));
		rdbtnHighPrice.setBounds(6, 70, 115, 20);
		panel.add(rdbtnHighPrice);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editProduct(loggedUser);
			}
		});
		btnEdit.setFont(new Font("Serif", Font.PLAIN, 20));
		btnEdit.setBackground(new Color(255, 255, 224));
		btnEdit.setBounds(84, 512, 150, 30);
		getContentPane().add(btnEdit);

		JButton btnLogOff = new JButton("Log Off");
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOff();
			}
		});
		btnLogOff.setFont(new Font("Serif", Font.PLAIN, 20));
		btnLogOff.setBackground(new Color(211, 211, 211));
		btnLogOff.setBounds(330, 471, 150, 30);
		getContentPane().add(btnLogOff);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnRefresh.setFont(new Font("Serif", Font.PLAIN, 20));
		btnRefresh.setBackground(new Color(176, 196, 222));
		btnRefresh.setBounds(175, 471, 150, 30);
		getContentPane().add(btnRefresh);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Serif", Font.PLAIN, 20));
		btnDelete.setBackground(new Color(240, 128, 128));
		btnDelete.setBounds(248, 512, 150, 30);
		getContentPane().add(btnDelete);

		atualizarTabela();
	}

	public void logOff() {
		/// tentar implementar

		dispose();
	}

	public void atualizarTabela() {

		model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		List<Product> listProducts = dao.listarProducts();

		for (Product product : listProducts) {

			model.addRow(new Object[] { product.getId(), product.getName(), product.getDescription(),
					product.getPrice(), product.getCategories(), product.getUser().getId() });
		}

	}

	public void register(User user) {

		FrameRegisterProduct frameRegister = new FrameRegisterProduct(user, null);

		frameRegister.setVisible(true);
		dispose();

	}

	public void filter(User user) {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		ProductsDao dao = new ProductsDao();
		while (buttons.hasMoreElements()) {

			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				String selectedText = button.getText();
				model.setRowCount(0);

				List<Product> listProducts = dao.productsFilter(selectedText, user);

				for (Product product : listProducts) {
					model.addRow(new Object[] { product.getId(), product.getName(), product.getDescription(),
							product.getPrice(), product.getCategories(), product.getUser().getId() });
				}

				model.fireTableDataChanged();
			}
		}
	}

	public void editProduct(User user) {

		int line = table.getSelectedRow();

		if (line != -1) {

			Object objUserId = table.getValueAt(line, 5);
			int userId = (Integer) objUserId;

			if (user.getId() != userId) {
				JOptionPane.showMessageDialog(null, "You dont have permission to edit this Product");
				return;

			} else {

				int productId = (Integer) table.getValueAt(line, 0);
				String productName = (String) table.getValueAt(line, 1);
				String productDesc = (String) table.getValueAt(line, 2);
				double productPrice = (Double) table.getValueAt(line, 3);
				Categories productCategorie = (Categories) table.getValueAt(line, 4);

				Product newProduct = new Product(productId, productName, productDesc, productPrice, productCategorie,
						user);
				FrameRegisterProduct frameRegister = new FrameRegisterProduct(user, newProduct);

				frameRegister.setVisible(true);
				dispose();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Select a product to edit");
			return;

		}
	}
}
