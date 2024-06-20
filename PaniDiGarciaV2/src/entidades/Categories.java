package entidades;

public class Categories {

	private int Id;
	private String c_name;

	public Categories(int id, String c_name) {
		super();
		Id = id;
		this.c_name = c_name;
	}

	public Categories(String c_name) {
		super();
		this.c_name = c_name;
	}

	public int getId() {
		return Id;
	}


	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "Categories [Id=" + Id + ", c_name=" + c_name + "]";
	}
	
	

}
