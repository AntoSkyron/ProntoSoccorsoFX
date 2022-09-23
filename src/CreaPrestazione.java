import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CreaPrestazione {

	String NOME_FILE;	
	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;
	
	
	public CreaPrestazione(String prestazione, String NOME_FILE)
	{
		try {

		this.NOME_FILE=NOME_FILE;
		
		
		inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );

		apri();
		
		scrivi(prestazione);
		
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
	
	
	void scrivi( String prestazione ) throws IOException {
		printer.println( prestazione );
	}
	
	
	
}
