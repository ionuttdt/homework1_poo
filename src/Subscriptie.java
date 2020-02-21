public abstract class Subscriptie {
	private String name;
	//nr_lru este folosit pentru a stabili care element de tip 
	//subscriptie este sters din lrucache
	private int lfu = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String class_element() {
		return "Subscriptie";
	}
	
	public int getNr_b() {
		return 0;
	}

	
	public int getNr_p() {
		return 0;
	}
	
	public void decBasic() {
		
	}
	
	public void decPremium() {
		
	}

	public int getlfu() {
		return this.lfu;
	}

	public void setlfu(int lfu) {
		this.lfu = lfu;
	}
	
	public void set0() {
		setlfu(0);
	}
	
	//motada folosita pentru incrementarea nr_lru
	public void inclfu() {
		this.lfu ++;
	}
	

	
}
