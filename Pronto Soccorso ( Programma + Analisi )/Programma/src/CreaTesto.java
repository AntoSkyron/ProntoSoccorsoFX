
import java.io.*;

public class CreaTesto {

	String NOME_FILE;
	private String nome,cognome,colore_caso,data,esenzione,sintomi,ora_entrata,maggiorenne;

	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;
	

	public CreaTesto(String nome, String cognome, String colore_caso, String data , String esenzione , String sintomi ,String ora_entrata , String maggiorenne,String NOME_FILE) {
		try {
			
			this.nome=nome; this.cognome =cognome; this.colore_caso = colore_caso; this.data = data; this.esenzione = esenzione; 
			this.ora_entrata=ora_entrata;
			this.sintomi = sintomi;
			this.maggiorenne=maggiorenne;
			this.NOME_FILE=NOME_FILE;
			
			inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );
			
			apri();
			
			DatiPaziente dl;
			
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
	
	DatiPaziente acquisisci() throws IOException {
		DatiPaziente dl = new DatiPaziente();
		
		dl.setNome(nome);
		dl.setCognome(cognome);
		dl.setColore_caso(colore_caso);
		dl.setData(data);
		dl.setEsenzione(esenzione);
		dl.setSintomi(sintomi);
		dl.setOra_entrata(ora_entrata);
		dl.setMaggiorenne(maggiorenne);
				
		return dl;
	}


	void scrivi( DatiPaziente dl ) throws IOException {
		String record = dl.toRecord();
		printer.println( record );
		
	
	}
	
}
