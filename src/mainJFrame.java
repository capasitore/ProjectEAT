import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.Panel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.sqliteConnection;
import Model.Recipe;
import Repositories.RecipeRepository;


public class mainJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainJFrame frame = new mainJFrame();
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
	public mainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{47, 47, 89, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{333, 220, 0};
		gbl_panel_1.rowHeights = new int[] {10, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		txtSearch = new JTextField();
		txtSearch.setText("Find by name or ingredient...");
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.anchor = GridBagConstraints.NORTH;
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.insets = new Insets(0, 0, 0, 5);
		gbc_txtSearch.gridx = 0;
		gbc_txtSearch.gridy = 0;
		panel_1.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);


		JButton btnNewButton = new JButton(new SearchEvent("Search"));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);



		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 204, 102));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Italian", "Greek", "Persian"}));
		comboBox.addActionListener(new ComboBoxEvent());
		panel_2.add(comboBox);




		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "<20 min", "<30 min", "<40 min"}));
		comboBox_1.addActionListener(new ComboBoxEvent());
		panel_2.add(comboBox_1);

		


			// RecipeList shows the recipe result from search
		RecipeList recipeFrame = new RecipeList();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		gbc_panel.weighty = 1;
		gbc_panel.weightx = 1;

		contentPane.add(recipeFrame, gbc_panel);


		//MouseListener for Table Column
		table.getTableHeader().addMouseListener(new TableEvent());


		//ActionListener table
		// Gets the row nr for the clicked row

		table.addMouseListener(new TableEvent());

		RecipeRepository recipeRepository = new RecipeRepository();
		ArrayList<Recipe> allRecipes = recipeRepository.GetAll();
		for (Recipe recipe : allRecipes) {
			model.addRow( recipe.getObjectForTable());
		}


	}

}
