import java.util.*;

public class LRUCache implements Cache {
	
	//initializare +constructor
	List<Subscriptie> cache;

	LRUCache(int max_cache) {
		cache = new ArrayList<>(max_cache);
	}
	
	//cauta un element in cache
	public Subscriptie findName(String name)
	{
		    Iterator<Subscriptie> iterator = cache.iterator();
		    while (iterator.hasNext()) {
		    	Subscriptie element = iterator.next();
		        if (element.getName().equals(name)) {
		            return element;
		        }
		    }
		    return null;
	}
	
	//metoda cu care verific daca memoria cache este plina
	public int sizecache() {
		return cache.size();		
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public void add(Subscriptie element) {
		cache.add(cache.size(), element);	
	}

	//stergerea unui anumit element din cache
	public void remove(String name) {
		
		int i;
		for(i = 0; i< cache.size(); i++)
		{
			if((cache.get(i).getName()).equals(name)) 
				break;
		}
		if(i != cache.size())
			cache.remove(i);
	}
	   
	public void remove(Subscriptie element) {
		cache.remove(element);		
	}
	
	//stergerea elementului cel mai putin utilizat
	public void remove() {
		cache.remove(cache.get(0));		
	}

	public List<Subscriptie> getCache() {
		return cache;
	}

}
