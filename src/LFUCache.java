import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LFUCache implements Cache {

	//declarare si initiere memorie cache
	List<Subscriptie> cache;
	LFUCache(int max_cache) {
		cache = new ArrayList<>(max_cache);
	}
	
	//cauta un element in cache dupa nume
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
	
	public int lastIndexOf(Object o) {
		return cache.lastIndexOf(o);
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public void add(Subscriptie element) {
		element.inclfu();
		cache.add(element);	
	}

	//stergerea unui anumit element din cache
	public void remove(String name) {
		
		for(int i = 0; i< cache.size(); i++)
		{
			if(cache.get(i).getName().equals(name))
			{
				cache.get(i).set0();//setez lfu 0;
				cache.remove(i);//sterg referinta din cache
				break;//opresc forul
			}
				
		}
	}  
	
	//stergerea unui element de tip subscriptie
	public void remove(Subscriptie element) {
		element.set0();
		cache.remove(element);		
	}
	
	//stergerea elementului cel mai putin utilizat
	public void remove() {

		if(cache.isEmpty())
			return;
		int x = 0;//pozitia elementului ce urmeaza sa fie sters
		Subscriptie element = cache.get(0);
		for(int i = 1 ; i < cache.size() ; i++)
			if(element.getlfu() > cache.get(i).getlfu())
			{
				x = i;
				element = cache.get(x);
			}
		cache.get(x).set0();//setez lfu 0 inainte sterg referinta
		cache.remove(x);
			
	}

}
