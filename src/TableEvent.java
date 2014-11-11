import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;


public class TableEvent extends MouseAdapter {

	JTable table = new JTable();
	JTableHeader tableHeader = table.getTableHeader();
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().getClass().equals(tableHeader.getClass())){
			tableHeader = (JTableHeader)e.getSource();
			int col = tableHeader.columnAtPoint(e.getPoint());

			System.out.println("Column selected "+ col);
		}
		else if(e.getSource().getClass().equals(table.getClass())) {
			JTable target = (JTable)e.getSource();
			int row = target.getSelectedRow();
			System.out.println(row);

			// if appropriate column do this...

		}
	}
}
