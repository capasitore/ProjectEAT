import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Recipe;
import Repositories.RecipeRepository;

public class RecipeList extends JPanel {

	// RecipeList recipeFrame = new RecipeList();
	private JTable table;

	public RecipeList() {
		JPanel recipeContainer = new JPanel();

		table = new JTable();

		table.setFillsViewportHeight(true);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Cousine", "Time Required" }) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		table.setModel(model);
		recipeContainer.setLayout(new BorderLayout());
		recipeContainer.add(table, BorderLayout.CENTER);
		recipeContainer.add(table.getTableHeader(), BorderLayout.NORTH);

		// MouseListener for Table Column
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.columnAtPoint(e.getPoint());
				String name = table.getColumnName(col);
				System.out.println("Column selected " + name);
			}
		});

		add(recipeContainer);
		// ActionListener table
		// Gets the row nr for the clicked row

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				System.out.println(row);

				// if appropriate column do this...

			}
		});

		RecipeRepository recipeRepository = new RecipeRepository();
		ArrayList<Recipe> allRecipes = recipeRepository.GetAll();
		for (Recipe recipe : allRecipes) {
			model.addRow(recipe.getObjectForTable());
		}

	}
}
