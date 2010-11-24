package ca.ubc.cpsc.mystuff.model;

public class ContentBean implements java.io.Serializable {
	private String[] menuID;
	private String main;
	
	public ContentBean() {
		menuID = new String[] {"id='last'", "", "", "", "", ""};
	}
	
	public void setMenuID(String[] value) {
		menuID = value;
	}
	
	public void setMain(String value) {
		main = value;
	}
	
	/* Default getters */
	public String[] getMenuID() { return(menuID); }
	public String getMain() { return(main); }
	
	/* Parameterized Getters */
	public String getMenuID(int index) { return(menuID[index]); }
}
