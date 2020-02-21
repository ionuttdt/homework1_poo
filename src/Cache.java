public interface Cache {
	
	public void add(Subscriptie element); //add
	public void remove(Subscriptie element);//stergerea unui anumit element
	public void remove(String name);//sterge un element dupa nume
	public void remove();//stergerea unui element in functie de cache
	public Subscriptie findName(String name);//intoarce elementul sau null
	public int sizecache();//intoarce numarul de lemente din cache
	public boolean isEmpty();//verific daca am elemente in cache
	
}
