import javafx.beans.property.SimpleStringProperty;

public class Paziente {
	
	
	private SimpleStringProperty nome;
	private SimpleStringProperty cognome;
	private SimpleStringProperty colore_caso;
	private SimpleStringProperty data;
	private SimpleStringProperty esenzione;
	private SimpleStringProperty sintomi;
	private SimpleStringProperty ora_entrata;
	private SimpleStringProperty maggiorenne;
	
	
	public Paziente(String nome,String cognome,String colore_caso,String data,String esenzione,String sintomi,String ora_entrata,String maggiorenne)
	{
		this.nome= new SimpleStringProperty(nome);
		this.cognome= new SimpleStringProperty(cognome);
		this.colore_caso=new SimpleStringProperty(colore_caso);
		this.data = new SimpleStringProperty(data);
		this.esenzione = new SimpleStringProperty(esenzione);
		this.sintomi=new SimpleStringProperty(sintomi);
		this.ora_entrata= new SimpleStringProperty(ora_entrata);
		this.maggiorenne = new SimpleStringProperty(maggiorenne);
	}

	public String getEsenzione()
	{
		return esenzione.get();
	}
	
	public String getMaggiorenne()
	{
		return maggiorenne.get();
	}
	
	
	public String getOra_entrata()
	{
		return ora_entrata.get();
	}
	

	public String getSintomi() {
		return sintomi.get();
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public String getCognome()
	{
		return cognome.get();
	} 
	
	public String getColore_caso() {
		return colore_caso.get();
	}
	
	
	public String getData() {
		return data.get();
	}
	
	
	public void setNome(SimpleStringProperty nome) {
		this.nome = nome;
	}


	public void setEsenzione(SimpleStringProperty esenzione) {
		this.esenzione = esenzione; 
	}
	

	public void setSintomi(SimpleStringProperty sintomi)
	{
		this.sintomi=sintomi;
	}
	
	public void setMaggiorenne(SimpleStringProperty maggiorenne)
	{
		this.maggiorenne=maggiorenne;
	}
	
	public void setOra_entrata(SimpleStringProperty ora_entrata)
	{
		this.ora_entrata=ora_entrata;
	}
	
	
	
	public void setCognome(SimpleStringProperty cognome) {
		this.cognome = cognome;
	}
		

	public void setColore_caso(SimpleStringProperty colore_caso) {
		this.colore_caso = colore_caso;
	}


	public void setData(SimpleStringProperty data) {
		this.data = data;
	}


	

	


}