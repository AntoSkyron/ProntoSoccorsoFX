import java.util.*;

public class DatiFine {
	private String nome,cognome,colore_caso,ora_entrata,ora_uscita,magg;

	
	public DatiFine(String nome, String cognome,String colore_caso,String ora_entrata,String ora_uscita,String magg) {
		this.nome = nome;
		this.cognome = cognome;
		this.colore_caso = colore_caso;
		this.ora_entrata=ora_entrata;
		this.ora_uscita=ora_uscita;
		this.magg=magg;
	}
	
	public DatiFine()
	{
	}
	
	
	
	public DatiFine( String linea ) {
		StringTokenizer st = new StringTokenizer( linea, ";" );
		if( st.hasMoreTokens() ) {
			nome = st.nextToken();
		}
		if( st.hasMoreTokens() ) {
			cognome = st.nextToken();
		}
		if( st.hasMoreTokens() ) {
			colore_caso = st.nextToken();
		}
		if( st.hasMoreTokens() ) {
			ora_entrata = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			ora_uscita = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			magg = st.nextToken();
		}
		
		
		
	}
	

	String toRecord() {
		return nome + ";" + cognome + ";" + colore_caso + ";" + ora_entrata + ";" + ora_uscita + ";" + magg;
	}

	public String getNome() {
		return nome;
	}
	
	
	public String getMagg()
	{
		return magg;
	}
	
	public void setMagg(String magg)
	{
		this.magg=magg;
	}
	
	public String getOra_entrata()
	{
		return ora_entrata;
	}
	
	public String getOra_uscita()
	{
		return ora_uscita;
	}
	
	public void setOra_uscita(String ora_uscita) {
		this.ora_uscita=ora_uscita;
	}
	
	
	
	
	public void setOra_entrata(String ora_entrata)
	{
		this.ora_entrata=ora_entrata;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getColore_caso() {
		return colore_caso;
	}

	public void setColore_caso(String colore_caso) {
		this.colore_caso = colore_caso;
	}


	
}

