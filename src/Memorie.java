import java.util.*;

public class Memorie {
	
	List<Subscriptie> list = new ArrayList<>();//memoria principala
	
	/*functia cu care verific daca un element este deja in memorie*/
	public Subscriptie findName(String name)
	{
		    Iterator<Subscriptie> iterator = list.iterator();
		    while (iterator.hasNext()) {
		    	Subscriptie element = iterator.next();
		        if (element.getName().equals(name)) {
		            return element;
		        }
		    }
		    return null;//daca nu il gaseste
	}

	//intoarce numarul elementelor din memorie
	public int size() {
		return list.size();
	}
	
	//verifica daca memoria este goala
	public boolean isEmpty() {
		return list.isEmpty();
	}

	//adauga un element premium in memorie
	public boolean add(Premium e) {
		return list.add(e);
	}
	
	//adauga un element basic in memorie
	public boolean add(Basic e) {
		return list.add(e);
	}
	
	//sterge un element din memorie
	public boolean remove(Object o) {
		return list.remove(o);
	}
	
	//sterge un element din memorie dupa nume
	public void remove(String name) {
	
		for(int i = 0; i< list.size(); i++)
		{
			if(list.get(i).getName().equals(name))
			list.remove(i);
		}
	}

	//stergerea unui element din memorie in functie de pozitia lui
	public Subscriptie remove(int index) {
		return list.remove(index);
	}

	//indexul unui obiect din memorie
	public int indexOf(Object o) {
		return list.indexOf(o);
	}
	
	
	

}
