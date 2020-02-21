public class Premium extends Basic{
	public int nr_p;//numarul de accesari premium
	
	//constructorul pentru un element de tip premium
	public Premium(String name, int nr_b, int nr_p) {
		setName(name);
		setBasic(nr_b);
		setPremium(nr_p);
	}

	//returneaza numarul de accesari premium ramase
	public int getPremium() {
		return nr_p;
	}

	//setarea numarului de accesari premium
	public void setPremium(int nr_p) {
		this.nr_p = nr_p;
	}
	
	//metoda folosita pentru decrementarea numarul de accesari premium
	public void decPremium() {
		this.nr_p --;
	}
	
	//metoda folosita pentru aflarea tipului elementului
	public String class_element() {
		if(getPremium() != 0)
			return "Premium";
		else
			return super.class_element();
	}
	
}
