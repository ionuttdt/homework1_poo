public class Basic extends Free{
	private int nr_b;
	
	public Basic() {
	}
	
	//constructor pentru un element de tip basic
	public Basic(String name, int nr_b) {
		setName(name);
		setBasic(nr_b);
	}

	//obtinerea numarului basic
	public int getBasic() {
		return nr_b;
	}

	//accesarea numarului basic
	public void setBasic(int nr_b) {
		this.nr_b = nr_b;
	}

	public int getNr_b() {
		return nr_b;
	}

	public void setNr_b(int nr_b) {
		this.nr_b = nr_b;
	}
	
	public void decBasic() {
		this.nr_b --;
	}
	
	public String class_element() {
		if(getBasic() != 0)
			return "Basic";
		else
			return super.class_element();
	}
	
}
