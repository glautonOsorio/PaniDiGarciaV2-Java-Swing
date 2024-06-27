package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		table.setBackground(new Color(224, 255, 255));
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Descrição", "Price", "Categorie", "User Id" }));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
		centralizar.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(1).setCellRenderer(centralizar);
		table.getColumnModel().getColumn(2).setCellRenderer(centralizar);
		table.setDefaultEditor(Object.class, null);

		table.getTableHeader().setReorderingAllowed(false);

		JLabel lblNewLabel = new JLabel("Welcome! " + loggedUser.getFullName() + " to Pani di Garcia V2!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 40));
		lblNewLabel.setBounds(10, 11, 964, 71);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("Register");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(152, 251, 152));
		btnNewButton_3.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3.setBounds(20, 471, 150, 30);
		getContentPane().add(btnNewButton_3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(611, 455, 363, 100);
		getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnReverseAlphabeticalOrder_1 = new JRadioButton("Sweets");
		buttonGroup.add(rdbtnReverseAlphabeticalOrder_1);
		rdbtnReverseAlphabeticalOrder_1.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnReverseAlphabeticalOrder_1.setBounds(6, 73, 100, 20);
		panel.add(rdbtnReverseAlphabeticalOrder_1);
		rdbtnReverseAlphabeticalOrder_1.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnNewRadioButton_1_2_1 = new JRadioButton("Savorys");
		buttonGroup.add(rdbtnNewRadioButton_1_2_1);
		rdbtnNewRadioButton_1_2_1.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_2_1.setBounds(256, 47, 100, 20);
		panel.add(rdbtnNewRadioButton_1_2_1);
		rdbtnNewRadioButton_1_2_1.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnReverseAlphabeticalOrder_1_2 = new JRadioButton("Breads");
		buttonGroup.add(rdbtnReverseAlphabeticalOrder_1_2);
		rdbtnReverseAlphabeticalOrder_1_2.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnReverseAlphabeticalOrder_1_2.setBounds(135, 47, 100, 20);
		panel.add(rdbtnReverseAlphabeticalOrder_1_2);
		rdbtnReverseAlphabeticalOrder_1_2.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnNewRadioButton_1_2_1_1 = new JRadioButton("Cakes");
		buttonGroup.add(rdbtnNewRadioButton_1_2_1_1);
		rdbtnNewRadioButton_1_2_1_1.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_2_1_1.setBounds(135, 73, 100, 20);
		panel.add(rdbtnNewRadioButton_1_2_1_1);
		rdbtnNewRadioButton_1_2_1_1.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnReverseAlphabeticalOrder_1_1 = new JRadioButton("Pies");
		buttonGroup.add(rdbtnReverseAlphabeticalOrder_1_1);
		rdbtnReverseAlphabeticalOrder_1_1.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnReverseAlphabeticalOrder_1_1.setBounds(256, 73, 100, 20);
		panel.add(rdbtnReverseAlphabeticalOrder_1_1);
		rdbtnReverseAlphabeticalOrder_1_1.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("A-Z Order");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(6, 27, 100, 20);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnReverseAlphabeticalOrder = new JRadioButton("Z-A Order");
		buttonGroup.add(rdbtnReverseAlphabeticalOrder);
		rdbtnReverseAlphabeticalOrder.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnReverseAlphabeticalOrder.setBounds(256, 24, 100, 20);
		panel.add(rdbtnReverseAlphabeticalOrder);
		rdbtnReverseAlphabeticalOrder.setBackground(new Color(240, 230, 140));

		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Your Products");
		buttonGroup.add(rdbtnNewRadioButton_1_2);
		rdbtnNewRadioButton_1_2.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_2.setBounds(6, 50, 100, 20);
		panel.add(rdbtnNewRadioButton_1_2);
		rdbtnNewRadioButton_1_2.setBackground(new Color(240, 230, 140));

		JLabel lblNewLabel_1 = new JLabel("Filters!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Serif", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(6, 6, 350, 25);
		panel.add(lblNewLabel_1);

		JButton btnNewButton_3_1 = new JButton("Edit");
		btnNewButton_3_1.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3_1.setBackground(new Color(255, 255, 224));
		btnNewButton_3_1.setBounds(84, 512, 150, 30);
		getContentPane().add(btnNewButton_3_1);

		JButton btnNewButton_3_1_1 = new JButton("Log Off");
		btnNewButton_3_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_3_1_1.setBounds(330, 471, 150, 30);
		getContentPane().add(btnNewButton_3_1_1);

		JButton btnNewButton_3_1_1_1 = new JButton("Refresh ");
		btnNewButton_3_1_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3_1_1_1.setBackground(new Color(176, 196, 222));
		btnNewButton_3_1_1_1.setBounds(175, 471, 150, 30);
		getContentPane().add(btnNewButton_3_1_1_1);

		JButton btnNewButton_3_1_2 = new JButton("Delete");
		btnNewButton_3_1_2.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3_1_2.setBackground(new Color(240, 128, 128));
		btnNewButton_3_1_2.setBounds(248, 512, 150, 30);
		getContentPane().add(btnNewButton_3_1_2);

		atualizarTabela();
	}

	public void atualizarTabela() {

		model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		List<Product> listProducts = dao.listarProducts();

		for (Product product : listProducts) {

			model.addRow(new Object[] { product.getId(), product.getName(), product.getDescription(),
					product.getPrice(), product.getCategories(), null });
		}

	}
}
