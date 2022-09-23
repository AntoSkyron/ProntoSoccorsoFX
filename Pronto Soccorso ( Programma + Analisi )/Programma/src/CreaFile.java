
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CreaFile {

	String NOME_FILE;
	FileWriter fileWriter;
	
	
	public CreaFile(String NOME_FILE) {
		try {
			this.NOME_FILE=NOME_FILE;
			apri();
			chiudi();

			System.out.println("File creato con successo");
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
		fileWriter = new FileWriter( NOME_FILE );
	}
	

	void chiudi() throws IOException {
		fileWriter.close();
	}
}