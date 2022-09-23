
import java.io.*;

public class CreaTestoFine {

	String NOME_FILE;
	private String nome,cognome,colore_caso,ora_entrata,ora_uscita,magg;

	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;
	

	public CreaTestoFine(String nome, String c, String colore_caso,String ora_entrata , String ora_uscita , String magg,String NOME_FILE) {
		try {
			
			this.nome=nome; this.cognome =c; this.colore_caso = colore_caso; 
			this.ora_entrata=ora_entrata;
			this.ora_uscita=ora_uscita;
			this.magg=magg;
			this.NOME_FILE=NOME_FILE;
			
			inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );
			
			apri();
			
			DatiFine dl;
			
			dl = acquisisci();
			scrivi(dl);
	
			chiudi();
			
		} 
		catch( FileNotFoundException fe ) 
		{
			System.err.println(
				"Nella directory corrente esiste gia' il file "
				+ NOME_FILE + 
				" ma non puo' essere aperto in scrittura "+
				"(forse e' una directory?)");
			fe.printStackTrace();
		} 
		catch( IOException ex ) 
		{
			System.err.println(
				"Si e'verificato un generico errore di I/O ");
			ex.printStackTrace();
		}
	}
	
	
	void apri() throws FileNotFoundException, IOException {
		fileWriter = new FileWriter( NOME_FILE,true );
		input = new BufferedWriter(fileWriter);
		printer = new PrintWriter(input);
		
	}
	
	
	void chiudi() throws IOException {		
		printer.flush();
		printer.close();
		
	}
	
	DatiFine acquisisci() throws IOException {
		DatiFine dl = new DatiFine();
		
		dl.setNome(nome);
		dl.setCognome(cognome);
		dl.setColore_caso(colore_caso);
		dl.setOra_entrata(ora_entrata);
		dl.setOra_uscita(ora_uscita);
		dl.setMagg(magg);
	
				
		return dl;
	}


	void scrivi( DatiFine dl ) throws IOException {
		String record = dl.toRecord();
		printer.println( record );
		
	
	}
	
}
