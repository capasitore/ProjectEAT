import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboBoxEvent implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		JComboBox cB = (JComboBox)e.getSource();
		String selectedTimeFilter = (String)cB.getSelectedItem();
		System.out.println(selectedTimeFilter);
	}
}
