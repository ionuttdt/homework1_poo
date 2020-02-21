import java.util.*;
import java.io.*;

public class Read {
	
	Memorie M = new Memorie();//memoria propriu zisa 
	
	public void read(File inFile, File outFile) throws FileNotFoundException {
		Scanner sc;
		Cache Ca;// = new LRUCache(4);//declar memoria cache
		PrintWriter pwr = new PrintWriter(outFile);
		
        try {

            String sc_l;
            int nr_bs = 0;//numarul pentru citirea basic
            int nr_pr = 0;//numarul pentru citirea premium

            sc = new Scanner(inFile);
            String type = sc.next();//tipul memoriei cache     
            int max_cache = Integer.parseInt(sc.next());//numarul maxim de elemente din cache
            
            //verificarea tipului cache si initializarea memoriei
            if(type.equals("FIFO")) {
            	Ca = new FIFOCache(max_cache);
            }
            else if(type.equals("LRU")){
            	Ca = new LRUCache(max_cache);
            }
            else {
            	Ca = new LFUCache(max_cache);
            }
            
            //citesc numarul instructiunilor
            int N = Integer.parseInt(sc.next());
            sc_l = sc.nextLine(); 

            /*In continuare citesc ficare rand din fisier si fac operatiile
            specificate in enuntul temei.*/
            for(int i = 0; i < N; i++) {	
            	sc_l = sc.nextLine(); 

            	nr_bs = 0;
            	nr_pr = 0;
            	String[] in_file = sc_l.split(" ");
            	
            	if(in_file.length == 2)//GET
            	{
            		Subscriptie elementC;
            		Subscriptie elementM;
            		elementC = Ca.findName(in_file[1]);
            		elementM = M.findName(in_file[1]);
            		
            		if(elementC != null) {//elementul se afla in cache
            			elementC.inclfu();
            			
            			if(type.equals("LRU"))//mut elementul la sfarsitul listei <=> actualizare timestep
            			{
            				Ca.remove(elementC.getName());
            				Ca.add(elementC);
            			}
            			
            			pwr.println(0 + " " + elementC.class_element() );
            			if(elementC.class_element() == "Premium") {//cazul cand are accesari de timp premium
            				elementC.decPremium();
            			}
            			else if(elementC.class_element() == "Basic") {// -||- basic
            				elementC.decBasic();
            			}
            		}
            		else if(elementM != null){//elementul nu e in memoria normala, implicit nici in cace
            			if(Ca.sizecache() == max_cache)
            			{
            				Ca.remove();
            			}
            			Ca.add(elementM);
            			pwr.println(1 + " " +elementM.class_element());
            			if(elementM.class_element() == "Premium") {
            				elementM.decPremium();
            			}
            			else if(elementM.class_element() == "Basic") {
            				elementM.decBasic();
            			}
            	
            		}
            		else {//cazul simplu cand nu avem elementul nicaieri
            			pwr.println(2);
            		}
            	}	
            	
            	else if(in_file.length == 3)//cazul add basic vezi mai jos functia
            	{
            		nr_bs = Integer.parseInt(in_file[2]);
            		Basic B = new Basic(in_file[1],nr_bs );
            		ADD(B, Ca);
            	}
            	else if(in_file.length == 4)//a mai ramas doar cazul add premium vezi functia mai jos
            	{
            		nr_bs = Integer.parseInt(in_file[2]);
            		nr_pr = Integer.parseInt(in_file[3]);
            		Premium P = new Premium(in_file[1],nr_bs, nr_pr );
            		ADD(P, Ca);
            	}
            	else {
					System.out.println("Eroare");
            	}                    	
            }
            sc.close();
            pwr.flush();
            pwr.close();       
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        //end
	}
	
	public void ADD(Premium p, Cache C) {
		if( M.findName(p.getName()) == null )//nu este in M
			M.add(p);
		//p este doar in M
		else if(C.findName(p.getName()) == null && M.findName(p.getName()) != null)
		{
			M.remove(p.getName());
			M.add(p);	
		}
		//p este in ambele memorii, il elimin din cache si il suprescriu in M
		else {
			C.remove(p.getName());
			M.remove(p.getName());
			M.add(p);
			M.findName(p.getName()).set0();
		}
		
	}
	
	//vezi functia de mai sus
	public void ADD(Basic b, Cache C) {
		if( M.findName(b.getName()) == null )
			M.add(b);

		else if(C.findName(b.getName()) == null && M.findName(b.getName()) != null)
		{
			M.remove(b.getName());
			M.add(b);			
		}
		
		else {
			C.remove(b.getName());
			M.remove(b.getName());
			M.add(b);
			M.findName(b.getName()).set0();
		}
	}

}
