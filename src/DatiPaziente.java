
import java.util.*;

public class DatiPaziente {
	private String nome,cognome,colore_caso,data,esenzione,sintomi,ora_entrata,maggiorenne;

	
	public DatiPaziente(String nome, String cognome,String colore_caso,String data,String esenzione,String sintomi,String ora_entrata,String maggiorenne) {
		this.nome = nome;
		this.cognome = cognome;
		this.colore_caso = colore_caso;
		this.data=data;
		this.esenzione=esenzione;
		this.sintomi=sintomi;
		this.ora_entrata=ora_entrata;
		this.maggiorenne=maggiorenne;
	}
	
	public DatiPaziente()
	{
	}
	
	
	
	public DatiPaziente( String linea ) {
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
			data = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			esenzione = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			sintomi = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			ora_entrata = st.nextToken();
		}
		
		if( st.hasMoreTokens() ) {
			maggiorenne = st.nextToken();
		}
	}
	

	String toRecord() {
		return nome + ";" + cognome + ";" + colore_caso + ";" + data + ";" + esenzione + ";" + sintomi + ";" + ora_entrata + ";" + maggiorenne;
	}

	public String getNome() {
		return nome;
	}
	
	public String getOra_entrata()
	{
		return ora_entrata;
	}
	
	public String getSintomi()
	{
		return sintomi;
	}
	
	public void setSintomi(String sintomi)
	{
		this.sintomi=sintomi;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEsenzione() {
		return esenzione;
	}

	public void setEsenzione(String esenzione) {
		this.esenzione = esenzione;
	}

	public void setMaggiorenne(String maggiorenne)
	{
		this.maggiorenne= maggiorenne;
	}
	
	public String getMaggiorenne()
	{
		return maggiorenne;
	}
}