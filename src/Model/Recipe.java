package Model;

public class Recipe {
	//Sets name
	private String name;

	public void setName(String name) {
	   this.name = name;
	}

	public String getName() {
	   return this.name;
	}
	
	//Sets cousine
	private String cousine;

	public void setCousine(String cousine) {
	   this.cousine = cousine;
	}

	public String getCousine() {
	   return this.cousine;
	}
	
	
	//Sets time required
	private String timeReq;

	public void setTimeReq(String timeReq) {
	   this.timeReq = timeReq;
	}

	public String getTimeReq() {
	   return this.timeReq;
	}
	
	
	public Object[] getObjectForTable()
	{
		Object[] objectArray = new Object[]
		{
			name,
			cousine,
			timeReq
		};
		
		return objectArray;
	}
	
	
	
}
