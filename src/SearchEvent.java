import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;

import DB.sqliteConnection;

@SuppressWarnings("serial")
public class SearchEvent extends AbstractAction {
	
	String name;
	
	public SearchEvent(String name){
		super(name);
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(name=="Search"){
			URL dbFilePath = this.getClass().getResource("Resource/projecteat.sqlite");
        	sqliteConnection.dbConnector(dbFilePath);
		}
	}
}
