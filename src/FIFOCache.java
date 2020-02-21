import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FIFOCache implements Cache {
	
	//initializarea memoriei cache si constructorul pentru aceasta
	List<Subscriptie> cache ;
	FIFOCache(int max_cache) {
		cache = new ArrayList<>(max_cache);
	}
	

	//cauta si sterge un element avand cheia numele acestuia
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
		cache.add(element);	
	}

	//stergerea unui anumit element din cache
	public void remove(Subscriptie element) {
		cache.remove(element);		
	}
	
	//stergerea elementului cel mai putin utilizat
	public void remove() {
		cache.remove(cache.get(0));
	}

	//sterg un element in functie de numele acestuia
	public void remove(String name) {
		
		for(int i = 0; i< cache.size(); i++)
		{
			if(cache.get(i).getName().equals(name))
			cache.remove(i);
		}
	}
	
	public Subscriptie get(int index) {
		return cache.get(index);
	}
	
}
