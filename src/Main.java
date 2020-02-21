import java.io.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		/*
			Pentru a avea o metoada main cat mai redus, am ales sa
		scriu codul pentru citire/scriere, ADD si GET in clasa
		Read. In main apelez functia read cu parametri primiti in
		linia de comanda.
		*/
		File inFile = new File(args[0]);//fisierul de intrare
		File outFile = new File(args[1]);//fisierul de iesire
		Read r = new Read();
		r.read(inFile, outFile);
		
    }
}
