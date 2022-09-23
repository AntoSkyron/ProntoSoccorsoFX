import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FinestraController implements Initializable{

	
	  Finestra su;
      Stage stage;

      
      //Definisco tutti i componenti grafici appartenenti all'interfaccia principale
      @FXML TextField Nome,Cognome,ColoreCaso,Data,EsenzioneTicket,Sintomi,ora_entrata,maggiorenne;
      
      @FXML
      Line scelta_linea_rossa_1,scelta_linea_rossa_2;
	
      @FXML
      Line scelta_linea_gialla_1,scelta_linea_gialla_2;
  	
  	  @FXML
  	  Line scelta_linea_bianca_1,scelta_linea_bianca_2;
      @FXML TableColumn<Paziente,String> ColonnaNome;
      @FXML TableColumn<Paziente,String> ColonnaCognome;
      @FXML TableColumn<Paziente,String> ColonnaColoreCaso;    
      @FXML TableColumn<Paziente,String> ColonnaData;
      @FXML TableColumn<Paziente,String> ColonnaTicket;
      @FXML TableColumn<Paziente,String> ColonnaSintomi;
      @FXML TableColumn<Paziente,String> ColonnaOra;
      @FXML TableColumn<Paziente,String> ColonnaMaggiorenne;

      @FXML TableView<Paziente> tableview;
      
      String colore_caso = null;   
      
      
      private final ObservableList<Paziente> dataList = FXCollections.observableArrayList();

      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Aggiungi.fxml"));
	   Stage stage1 = new Stage();
      
     /*Definisco Le Liste Linkate */
    LinkedList<Paziente> listalinkata = new LinkedList<>();  
  	LinkedList<Paziente> Rosso = new LinkedList<>();
  	LinkedList<Paziente> Giallo = new LinkedList<>();
  	LinkedList<Paziente> Bianco = new LinkedList<>();
  	ArrayList<Integer> mediapazienti = new ArrayList<>();
  	ArrayList<Integer> media_casirossi = new ArrayList<>();
  	ArrayList<Integer> media_casigialli = new ArrayList<>();
  	ArrayList<Integer> media_casibianchi = new ArrayList<>();
  	ArrayList<Integer> pazientiusciti = new ArrayList<>();
  	ArrayList<Integer> pazientimaggiorenni = new ArrayList<>();
  	ArrayList<Integer> pazientiminorenni = new ArrayList<>();
  	ArrayList<Integer> pazientiticket= new ArrayList<>();
  	ArrayList<Integer> pazientinonpaganti = new ArrayList<>();

  	private int num_pazienti;
  	private int num_casirossi;
  	private int num_casigialli;
  	private int num_casibianchi;
  	private int num_pazientiusciti;
  	private int num_pazientiticket;
  	private int num_pazientinonpaganti;
  	private int num_pazientimaggiorenni;
  	private int num_pazientiminorenni;
  	
  	
  	
	@SuppressWarnings("unused")
	private CreaTesto f;
	@SuppressWarnings("unused")
	private DatiPaziente m;
	@SuppressWarnings("unused")
	private CreaTesto a;
	@SuppressWarnings("unused")
	private CreaTesto b;
	@SuppressWarnings("unused")
	private CreaTesto k;
	@SuppressWarnings("unused")
	private CreaTesto z;

  	  
    public  void Main( Finestra su,Stage stage){
      this.stage=stage;
      this.su=su;
      }
      
      

    // Il Metodo controlla se il file lista pazienti esiste o meno, se esiste e contiene dei pazienti li riporta sulla tabella principale,
    // se non esiste lo ricrea.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		File file = new File("Lista Pazienti.txt");
		boolean exists = file.exists();
		File file2 = new File("Cronologia Pazienti.txt");
		boolean exists2 = file2.exists();
		
		
		if(exists2==false)
		{
            CreaFile l = new CreaFile("Cronologia Pazienti.txt"); 
		}
		
		
		if(exists==true){
			Scanner x;
			String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;	
			
			try{	
			x = new Scanner(new File("Lista Pazienti.txt"));
			x.useDelimiter("[;\n]");
			
			while(x.hasNext())
			{
				nome_in = x.next();
				cognome_in = x.next();
				colore_caso_in = x.next();
				data_in = x.next();
				es_in = x.next();
				sint_in = x.next();
				ora_in = x.next();
				magg_in = x.next();	
				
				listalinkata.add(new Paziente(nome_in,cognome_in,colore_caso_in,data_in,es_in,sint_in,ora_in,magg_in));
				num_pazienti++;

				if(colore_caso_in.equals("Rosso")){
				Rosso.add(new Paziente(nome_in,cognome_in,colore_caso_in,data_in,es_in,sint_in,ora_in,magg_in));
				num_casirossi++;
				}
				else if(colore_caso_in.equals("Giallo"))
				{
					Giallo.add(new Paziente(nome_in,cognome_in,colore_caso_in,data_in,es_in,sint_in,ora_in,magg_in));
					num_casigialli++;
				}else if(colore_caso_in.equals("Bianco"))
				{
					Bianco.add(new Paziente(nome_in,cognome_in,colore_caso_in,data_in,es_in,sint_in,ora_in,magg_in));
					num_casibianchi++;
				}
				

				if(es_in.equals("Si") || es_in.equals("SI") || es_in.equals("sI"))
				{
					num_pazientinonpaganti++;

				}else if(es_in.equals("No") || es_in.equals("NO") || es_in.equals("nO"))
				{
					num_pazientiticket++;
				}
				
				
				
				if(magg_in.equals("Si") || magg_in.equals("SI") || magg_in.equals("sI"))
				{
					num_pazientimaggiorenni++;
				}else if(magg_in.equals("No") || magg_in.equals("NO") || magg_in.equals("nO"))
				{
					num_pazientiminorenni++;
				}
				
				
			}
						
			for(int i=0;i<Rosso.size();i++) {
				dataList.add(Rosso.get(i));
			}
						
			for(int i=0;i<Giallo.size();i++) {
				dataList.add(Giallo.get(i));
			}
			
			
			for(int i=0;i<Bianco.size();i++) {
				dataList.add(Bianco.get(i));
			}
					        
			ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
			ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
			ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
			ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
			ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
			ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
			ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
			ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));

			
			//tableview.setItems(null);
		    tableview.setItems(dataList);	
			}
			
			catch( Exception e)
			{
				Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.setTitle("Pronto Soccorso");
				alert.show();
			}	
		}
		else if(exists==false)	
		{
	            CreaFile f = new CreaFile("Lista Pazienti.txt");
	            CreaFile d = new CreaFile("Lista Pazienti con Casi Rossi.txt");
	            CreaFile e = new CreaFile("Lista Pazienti con Casi Gialli.txt");
	            CreaFile c = new CreaFile("Lista Pazienti con Casi Bianchi.txt"); 
	            CreaFile b = new CreaFile("Lista Pazienti usciti dal Pronto soccorso.txt");
		}
	}
	
	
	
	// Metodo che consente di aggiungere mediante lista linkata i pazienti.
	public void Aggiungi()
	{
		String n = Nome.getText();
		String c = Cognome.getText();
		String cs = colore_caso;
		String datas = Data.getText();
		String es = EsenzioneTicket.getText();
		String ora = ora_entrata.getText();
		String sintomi = Sintomi.getText();
		String magg = maggiorenne.getText();
		
		// Verifica se i campi inseriti sono vuoti o meno
		if(n.equals("") && c.equals("") && datas.equals("") && es.equals("") && ora.equals("") && sintomi.equals("") && magg.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Ops.. C'è qualcosa che non va! Ricontrolla i dati!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}
		
		
		// Verifica se un campo non è stato inserito o meno
		if(n.equals("") || c.equals("") || cs.equals(null) || datas.equals("") || es.equals("") || ora.equals("") || sintomi.equals("") || magg.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Ops.. C'è qualcosa che non va! Ricontrolla i dati!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}	
				
		
		
		//Creazione di un paziente all'interno della lista linkata principale
		listalinkata.add(new Paziente(n,c,cs,datas,es,sintomi,ora,magg));
		m = new DatiPaziente(n,c,cs,datas,es,sintomi,ora,magg);
		z = new CreaTesto(n,c,cs,datas,es,sintomi,ora,magg,"Cronologia Pazienti.txt");
		f = new CreaTesto(n,c,cs,datas,es,sintomi,ora,magg,"Lista Pazienti.txt");
		num_pazienti++;
		
		// Controlla se il colore del caso è giallo
		if(cs.equals("Giallo"))
		{
		Giallo.add(new Paziente(n,c,cs,datas,es,sintomi,ora,magg));	
		a = new CreaTesto(n,c,cs,datas,es,sintomi,ora,magg,"Lista Pazienti con Casi Gialli.txt");
		num_casigialli++;
		}
		
		// Controlla se il colore del caso è rosso
		if(cs.equals("Rosso"))
		{
		Rosso.add(new Paziente(n,c,cs,datas,es,sintomi,ora,magg));
		b = new CreaTesto(n,c,cs,datas,es,sintomi,ora,magg,"Lista Pazienti con Casi Rossi.txt");
		num_casirossi++;
		}
		
		// Controlla se il colore del caso è bianco
		if(cs.equals("Bianco"))
		{
		Bianco.add(new Paziente(n,c,cs,datas,es,sintomi,ora,magg));
		k = new CreaTesto(n,c,cs,datas,es,sintomi,ora,magg,"Lista Pazienti con Casi Bianchi.txt");
		num_casibianchi++;
		}
		
		
		if(es.equals("Si") || es.equals("SI") || es.equals("sI"))
		{
			num_pazientinonpaganti++;

			num_pazientiticket++;
		}else if(es.equals("No") || es.equals("NO") || es.equals("nO"))
		{
			num_pazientiticket++;
		}
		
		if(magg.equals("Si") || magg.equals("SI") || magg.equals("sI"))
		{
			num_pazientimaggiorenni++;
		}else if(magg.equals("No") || magg.equals("NO") || magg.equals("nO"))
		{
			num_pazientiminorenni++;
		}
		
		
	
		// Pulizia della tabella dell'interfaccia grafica
		dataList.clear();
		
		
		for(int i=0;i<Rosso.size();i++) {
			dataList.add(Rosso.get(i));
		}
					
		for(int i=0;i<Giallo.size();i++) {
			dataList.add(Giallo.get(i));
		}
		
		
		for(int i=0;i<Bianco.size();i++) {
			dataList.add(Bianco.get(i));
		}
		
		
		// Inizializzazione delle celle presenti nella tabella.
		ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
		ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
		ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
		ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
		ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
		ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
		ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
		ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));

		
		// Aggiorna la tabella in tempo reale.
		tableview.setItems(null);
	    tableview.setItems(dataList);
        
		 Alert alert = new Alert(AlertType.CONFIRMATION, "Paziente Aggiunto con successo!", ButtonType.OK);
		 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		 alert.setTitle("Pronto Soccorso");
		 alert.show();
		 
		 	scelta_linea_bianca_1.setVisible(false);
	  		scelta_linea_bianca_2.setVisible(false);
	  		scelta_linea_rossa_1.setVisible(false);
	  		scelta_linea_rossa_2.setVisible(false);
	  		scelta_linea_gialla_1.setVisible(false);
	  		scelta_linea_gialla_2.setVisible(false);
	  		Nome.setText("");
	  		Cognome.setText("");
	  		Data.setText("");
	  		EsenzioneTicket.setText("");
	  		ora_entrata.setText("");
	  		Sintomi.setText("");
	}	
	
	public void AttivaSpuntaRossa()
  	{
  		scelta_linea_rossa_1.setVisible(true);
  		scelta_linea_rossa_2.setVisible(true);
		scelta_linea_gialla_1.setVisible(false);
  		scelta_linea_gialla_2.setVisible(false);
  		scelta_linea_bianca_1.setVisible(false);
  		scelta_linea_bianca_2.setVisible(false);
  		colore_caso="Rosso";
  	}
  	
  	public void AttivaSpuntaGialla()
  	{
  		scelta_linea_gialla_1.setVisible(true);
  		scelta_linea_gialla_2.setVisible(true);
  		scelta_linea_rossa_1.setVisible(false);
  		scelta_linea_rossa_2.setVisible(false);
  		scelta_linea_bianca_1.setVisible(false);
  		scelta_linea_bianca_2.setVisible(false);
  		colore_caso="Giallo";
  	}

  	public void AttivaSpuntaBianca()
  	{
  		scelta_linea_bianca_1.setVisible(true);
  		scelta_linea_bianca_2.setVisible(true);
  		scelta_linea_rossa_1.setVisible(false);
  		scelta_linea_rossa_2.setVisible(false);
  		scelta_linea_gialla_1.setVisible(false);
  		scelta_linea_gialla_2.setVisible(false);
  		colore_caso="Bianco";
  	}

  	
  	// Rimozione di un paziente immesso per sbaglio.
	public void Rimuovi()
	{
		String n = Nome.getText();
		String c = Cognome.getText();
		String cs = colore_caso;
		String datas = Data.getText();
		String es = EsenzioneTicket.getText();
		String ora = ora_entrata.getText();
		String sintomi = Sintomi.getText();
		String magg = maggiorenne.getText();
		boolean tuttok = false;
		boolean tuttok1 = false;

		
		if(n.equals("") && c.equals("") && cs.equals(null) && datas.equals("") && es.equals("") && ora.equals("") && sintomi.equals("") && magg.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Ops.. C'è qualcosa che non va! Ricontrolla i dati!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}
		
		if(n.equals("") || c.equals("") || cs.equals(null) || datas.equals("") || es.equals("") || ora.equals("") || sintomi.equals("") && magg.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Ops.. C'è qualcosa che non va! Ricontrolla i dati!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}	
		
		
		
		for(int i=0;i<listalinkata.size() && tuttok != true;i++)
		{
			
		if(tuttok==false)
		{
			if(listalinkata.get(i).getNome().equals(n) && listalinkata.get(i).getCognome().equals(c) &&
			listalinkata.get(i).getColore_caso().equals(cs) && listalinkata.get(i).getData().equals(datas) &&
			listalinkata.get(i).getEsenzione().equals(es) && listalinkata.get(i).getOra_entrata().equals(ora) &&
			listalinkata.get(i).getSintomi().equals(sintomi) && listalinkata.get(i).getMaggiorenne().equals(magg))
			{
				listalinkata.remove(i);
				Scanner x;
				String nomeFile = "Lista Pazienti.txt";
				String fileTemporaneo = "temp.txt";
				
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;	
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);
				
				try
				{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
					
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
					
						if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(cs) && !data_in.equals(datas) &&
						!es_in.equals(es) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg_in);
						}
					}
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					tuttok=true;
				}
				catch( Exception e)
				{
					Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.setTitle("Pronto Soccorso");
					alert.show();
				}				
			}
		}
		}
		
		
		
		
		if(colore_caso.equals("Rosso"))
		{
		for(int i=0;i<Rosso.size();i++)
		{
			
		 if(tuttok1==false)
		 {
			if(Rosso.get(i).getNome().equals(n) && Rosso.get(i).getCognome().equals(c) &&
			Rosso.get(i).getColore_caso().equals(cs) && Rosso.get(i).getData().equals(datas) &&
			Rosso.get(i).getEsenzione().equals(es) && Rosso.get(i).getOra_entrata().equals(ora) &&
			Rosso.get(i).getSintomi().equals(sintomi) && Rosso.get(i).getMaggiorenne().equals(magg))
			{
				Rosso.remove(i);
				Scanner x;
				String nomeFile = "Lista Pazienti con Casi Rossi.txt";
				String fileTemporaneo = "temp.txt";
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);
				
				try
				{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
					
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
						
						if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(cs) && !data_in.equals(datas) &&
						!es_in.equals(es) && !ora_in.equals(ora) && !sint_in.equals(sintomi))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in);
						}
					}
					
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					tuttok=true;
					
					dataList.clear();
					
					
					for(int h=0;h<Rosso.size();h++) {
						dataList.add(Rosso.get(h));
					}
						
					for(int h=0;h<Giallo.size();h++) {
						dataList.add(Giallo.get(h));
					}
					
					for(int h=0;h<Bianco.size();h++) {
						dataList.add(Bianco.get(h));
					}
						        
					ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
					ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
					ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
					ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
					ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
					ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
					ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
					ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));

					tableview.setItems(null);
				    tableview.setItems(dataList);	
				    
					 Alert alert = new Alert(AlertType.CONFIRMATION, "Paziente Rimosso con successo!", ButtonType.OK);
					 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					 alert.setTitle("Pronto Soccorso");
					 alert.show();
					 return;
				}
				catch( Exception e)
				{
					Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.setTitle("Pronto Soccorso");
					alert.show();
				}	
			}			
		 	}
		}
		}
		
		else if (colore_caso.equals("Giallo"))
		{
		for(int i=0;i<Giallo.size();i++)
		{
		 if(tuttok1==false)
		 {
			if(Giallo.get(i).getNome().equals(n) && Giallo.get(i).getCognome().equals(c) &&
			Giallo.get(i).getColore_caso().equals(cs) && Giallo.get(i).getData().equals(datas) &&
			Giallo.get(i).getEsenzione().equals(es) && Giallo.get(i).getOra_entrata().equals(ora) &&
			Giallo.get(i).getSintomi().equals(sintomi) && Giallo.get(i).getMaggiorenne().equals(magg))
			{
				Giallo.remove(i);
				
				Scanner x;
				String nomeFile = "Lista Pazienti con Casi Gialli.txt";
				String fileTemporaneo = "temp.txt";
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;
				
				
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);
					
				try
				{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
					
					
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
							
						if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(cs) && !data_in.equals(datas) &&
						!es_in.equals(es) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in);
						}
					}
					
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					tuttok=true;
							
					dataList.clear();	
					
					for(int h=0;h<Rosso.size();h++) {
						dataList.add(Rosso.get(h));
					}		
					
					for(int h=0;h<Giallo.size();h++) {
						dataList.add(Giallo.get(h));
					}	
					
					for(int h=0;h<Bianco.size();h++) {
						dataList.add(Bianco.get(h));
					}
						        
					ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
					ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
					ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
					ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
					ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
					ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
					ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
					ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));			
					tableview.setItems(null);
				    tableview.setItems(dataList);	 
				 	scelta_linea_bianca_1.setVisible(false);
			  		scelta_linea_bianca_2.setVisible(false);
			  		scelta_linea_rossa_1.setVisible(false);
			  		scelta_linea_rossa_2.setVisible(false);
			  		scelta_linea_gialla_1.setVisible(false);
			  		scelta_linea_gialla_2.setVisible(false);
			  		Nome.setText("");
			  		Cognome.setText("");
			  		Data.setText("");
			  		EsenzioneTicket.setText("");
			  		ora_entrata.setText("");
			  		Sintomi.setText("");
			  		maggiorenne.setText("");
					 Alert alert = new Alert(AlertType.CONFIRMATION, "Paziente Rimosso con successo!", ButtonType.OK);
					 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					 alert.setTitle("Pronto Soccorso");
					 alert.show();
					 return;
				}
				catch( Exception e)
				{
					Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.setTitle("Pronto Soccorso");
					alert.show();
				}	
			}			
		 	}
			}
		}
			
		else if (colore_caso.equals("Bianco")){
			for(int i=0;i<Bianco.size();i++)
			{	
			 if(tuttok1==false)
			 {
				if(Bianco.get(i).getNome().equals(n) && Bianco.get(i).getCognome().equals(c) &&
				Bianco.get(i).getColore_caso().equals(cs) && Bianco.get(i).getData().equals(datas) &&
				Bianco.get(i).getEsenzione().equals(es) && Bianco.get(i).getOra_entrata().equals(ora) &&
				Bianco.get(i).getSintomi().equals(sintomi) && Bianco.get(i).getMaggiorenne().equals(magg))
				{
					Bianco.remove(i);	
					Scanner x;
					String nomeFile = "Lista Pazienti con Casi Bianchi.txt";
					String fileTemporaneo = "temp.txt";	
					String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;		
					File vecchioFile = new File(nomeFile);
					File nuovoFile = new File(fileTemporaneo);	
					
					try
					{
						FileWriter fw = new FileWriter(fileTemporaneo,true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						x = new Scanner(new File(nomeFile));
						x.useDelimiter("[;\n]");
						
						while(x.hasNext())
						{
							nome_in = x.next();
							cognome_in = x.next();
							colore_caso_in = x.next();
							data_in = x.next();
							es_in = x.next();
							sint_in = x.next();
							ora_in = x.next();
							magg_in = x.next();
								
							if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(cs) && !data_in.equals(datas) &&
							!es_in.equals(es) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
							{
							pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg_in);
							}
						}
						
						x.close();
						pw.flush();
						pw.close();
						vecchioFile.delete();
						File dump = new File(nomeFile);
						nuovoFile.renameTo(dump);
						tuttok=true;
							
						dataList.clear();
									
						for(int h=0;h<Rosso.size();h++) {
							dataList.add(Rosso.get(h));
						}
											
						for(int h=0;h<Giallo.size();h++) {
							dataList.add(Giallo.get(h));
						}
									
						for(int h=0;h<Bianco.size();h++) {
							dataList.add(Bianco.get(h));
						}
							        
						ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
						ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
						ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
						ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
						ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
						ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
						ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
						ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));

						
						tableview.setItems(null);
					    tableview.setItems(dataList);	
					    
					 	scelta_linea_bianca_1.setVisible(false);
				  		scelta_linea_bianca_2.setVisible(false);
				  		scelta_linea_rossa_1.setVisible(false);
				  		scelta_linea_rossa_2.setVisible(false);
				  		scelta_linea_gialla_1.setVisible(false);
				  		scelta_linea_gialla_2.setVisible(false);
				  		Nome.setText("");
				  		Cognome.setText("");
				  		Data.setText("");
				  		EsenzioneTicket.setText("");
				  		ora_entrata.setText("");
				  		Sintomi.setText("");
				  		maggiorenne.setText("");
						 Alert alert = new Alert(AlertType.CONFIRMATION, "Paziente Rimosso con successo!", ButtonType.OK);
						 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						 alert.setTitle("Pronto Soccorso");
						 alert.show();
						 
					    return;
					}
					catch( Exception e)
					{
						Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
						alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						alert.setTitle("Pronto Soccorso");
						alert.show();
					}	
				}			
			 	}
			}
		}
	}
	
	public void Concludi()
	{
		if(Rosso.size() <= 0 && Giallo.size() <= 0 && Bianco.size() <= 0)
		{
			Alert alert = new Alert(AlertType.ERROR, "Non è presente nessun paziente nel pronto soccorso", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}
	   try
	   {
		   String n= null, c = null, data = null, ticket = null, sintomi = null,ora = null , magg = null;
		  
		   
		   if(Rosso.size()>0)
		   {
			 n= Rosso.getFirst().getNome();
			 c= Rosso.getFirst().getCognome();
			 colore_caso=  Rosso.getFirst().getColore_caso();
			 data = Rosso.getFirst().getData();
			 ticket = Rosso.getFirst().getEsenzione();
			 sintomi = Rosso.getFirst().getSintomi();
			 ora = Rosso.getFirst().getOra_entrata();
			 magg = Rosso.getFirst().getMaggiorenne();
			 Rosso.removeFirst();
			 
			 Scanner x;
				String nomeFile = "Lista Pazienti con Casi Rossi.txt";
				String fileTemporaneo = "temp.txt";
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;								
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);
									
									
				try
					{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
										
										
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
											
											
					if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(colore_caso) && !data_in.equals(data) &&
					!es_in.equals(ticket) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg);
						}
					}
									
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					}
					catch( Exception e)
					{
						Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
						alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						alert.setTitle("Pronto Soccorso");
						alert.show();
					}

			 
		   }else if(Giallo.size()>0)
		   {
			 n= Giallo.getFirst().getNome();
			 c= Giallo.getFirst().getCognome();
			 colore_caso=  Giallo.getFirst().getColore_caso();
			 data = Giallo.getFirst().getData();
			 ticket = Giallo.getFirst().getEsenzione();
			 sintomi = Giallo.getFirst().getSintomi();
			 ora = Giallo.getFirst().getOra_entrata();
			 magg = Giallo.getFirst().getMaggiorenne();
			 Giallo.removeFirst();
			 
			 
				Scanner x;
				String nomeFile = "Lista Pazienti con Casi Gialli.txt";
				String fileTemporaneo = "temp.txt";
									
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;						
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);			
									
				try
					{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
										
										
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
																	
					if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(colore_caso) && !data_in.equals(data) &&
					!es_in.equals(ticket) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg);
						}
					}
										
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					}
					catch( Exception e)
					{
						Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
						alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						alert.setTitle("Pronto Soccorso");
						alert.show();
					}
			 
		   }else if(Bianco.size()>0)
		   {
			 n= Bianco.getFirst().getNome();
			 c= Bianco.getFirst().getCognome();
			 colore_caso=  Bianco.getFirst().getColore_caso();
			 data = Bianco.getFirst().getData();
			 ticket = Bianco.getFirst().getEsenzione();
			 sintomi = Bianco.getFirst().getSintomi();
			 ora = Bianco.getFirst().getOra_entrata();
			 magg = Bianco.getFirst().getMaggiorenne();
			 Bianco.removeFirst();	 
			 
				Scanner x;
				String nomeFile = "Lista Pazienti con Casi Bianchi.txt";
				String fileTemporaneo = "temp.txt";
									
				String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;
									
									
				File vecchioFile = new File(nomeFile);
				File nuovoFile = new File(fileTemporaneo);
									
									
				try
					{
					FileWriter fw = new FileWriter(fileTemporaneo,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(new File(nomeFile));
					x.useDelimiter("[;\n]");
										
										
					while(x.hasNext())
					{
						nome_in = x.next();
						cognome_in = x.next();
						colore_caso_in = x.next();
						data_in = x.next();
						es_in = x.next();
						sint_in = x.next();
						ora_in = x.next();
						magg_in = x.next();
											
											
					if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(colore_caso) && !data_in.equals(data) &&
					!es_in.equals(ticket) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
						{
						pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg);
						}
					}
										
					x.close();
					pw.flush();
					pw.close();
					vecchioFile.delete();
					File dump = new File(nomeFile);
					nuovoFile.renameTo(dump);
					}
					catch( Exception e)
					{
						Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
						alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						alert.setTitle("Pronto Soccorso");
						alert.show();
					}
			 
		   }
		   		 
		 	Scanner x;
		 	String nomeFile = "Lista Pazienti.txt";
		 	String fileTemporaneo = "temp.txt";
						
			String nome_in,cognome_in,colore_caso_in,data_in,es_in,ora_in,sint_in,magg_in;
			File vecchioFile = new File(nomeFile);
			File nuovoFile = new File(fileTemporaneo);
						
			try
				{
							FileWriter fw = new FileWriter(fileTemporaneo,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							x = new Scanner(new File(nomeFile));
							x.useDelimiter("[;\n]");
							
							while(x.hasNext())
							{
								nome_in = x.next();
								cognome_in = x.next();
								colore_caso_in = x.next();
								data_in = x.next();
								es_in = x.next();
								sint_in = x.next();
								ora_in = x.next();
								magg_in = x.next();
													
								if(!nome_in.equals(n) && !cognome_in.equals(c) && !colore_caso_in.equals(colore_caso) && !data_in.equals(data) &&
								!es_in.equals(ticket) && !ora_in.equals(ora) && !sint_in.equals(sintomi) && !magg_in.equals(magg))	
								{
									pw.println(nome_in + ";" + cognome_in + ";" + colore_caso_in + ";" + data_in + ";" + es_in + ";" + sint_in + ";" + ora_in + ";" + magg);
								}
							}
							
							x.close();
							pw.flush();
							pw.close();
							vecchioFile.delete();
							File dump = new File(nomeFile);
							nuovoFile.renameTo(dump);
						}
						catch( Exception e)
						{
							Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
							alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
							alert.setTitle("Pronto Soccorso");
							alert.show();
						}
						
			 dataList.clear();			
						
			for(int h=0;h<Rosso.size();h++) {
				dataList.add(Rosso.get(h));
			}
				
			for(int h=0;h<Giallo.size();h++) {
				dataList.add(Giallo.get(h));
			}
			
			for(int h=0;h<Bianco.size();h++) {
				dataList.add(Bianco.get(h));
			}
			    
			ColonnaNome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("nome"));
			ColonnaCognome.setCellValueFactory(new PropertyValueFactory<Paziente,String>("cognome"));
			ColonnaColoreCaso.setCellValueFactory(new PropertyValueFactory<Paziente,String>("colore_caso"));
			ColonnaData.setCellValueFactory(new PropertyValueFactory<Paziente,String>("data"));
			ColonnaTicket.setCellValueFactory(new PropertyValueFactory<Paziente,String>("esenzione"));
			ColonnaSintomi.setCellValueFactory(new PropertyValueFactory<Paziente,String>("sintomi"));
			ColonnaOra.setCellValueFactory(new PropertyValueFactory<Paziente,String>("ora_entrata"));
			ColonnaMaggiorenne.setCellValueFactory(new PropertyValueFactory<Paziente,String>("maggiorenne"));

			
			num_pazientiusciti++;
			tableview.setItems(null);
		    tableview.setItems(dataList);	
		   
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Conclusione.fxml"));
		   Parent root = (Parent) loader.load();
		   ConclusioneController secondoController = loader.getController();
		   secondoController.Conclusione(n, c, colore_caso, data, ticket, sintomi, ora , magg);
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
		   colore_caso=null;
		 	scelta_linea_bianca_1.setVisible(false);
	  		scelta_linea_bianca_2.setVisible(false);
	  		scelta_linea_rossa_1.setVisible(false);
	  		scelta_linea_rossa_2.setVisible(false);
	  		scelta_linea_gialla_1.setVisible(false);
	  		scelta_linea_gialla_2.setVisible(false);
	  		Nome.setText("");
	  		Cognome.setText("");
	  		Data.setText("");
	  		EsenzioneTicket.setText("");
	  		ora_entrata.setText("");
	  		Sintomi.setText("");
	  		maggiorenne.setText("");
	   }		
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
	}
	
	public void Reset()
	{
		 colore_caso=null;
		 	scelta_linea_bianca_1.setVisible(false);
	  		scelta_linea_bianca_2.setVisible(false);
	  		scelta_linea_rossa_1.setVisible(false);
	  		scelta_linea_rossa_2.setVisible(false);
	  		scelta_linea_gialla_1.setVisible(false);
	  		scelta_linea_gialla_2.setVisible(false);
	  		Nome.setText("");
	  		Cognome.setText("");
	  		Data.setText("");
	  		EsenzioneTicket.setText("");
	  		ora_entrata.setText("");
	  		Sintomi.setText("");
	  		maggiorenne.setText("");
	}
	
	public void ConcludiGiorno()
	{
		mediapazienti.add(num_pazienti);
		media_casirossi.add(num_casirossi);
		media_casigialli.add(num_casigialli);
		media_casibianchi.add(num_casibianchi);
		pazientiusciti.add(num_pazientiusciti);
		pazientiticket.add(num_pazientiticket);
		pazientinonpaganti.add(num_pazientinonpaganti);	
		pazientimaggiorenni.add(num_pazientimaggiorenni);
		pazientiminorenni.add(num_pazientiminorenni);
		num_pazientiticket=0;
		num_pazientinonpaganti=0;
		num_pazienti=0;
		num_casirossi=0;
		num_casigialli=0;
		num_casibianchi=0;
		num_pazientiusciti=0;
		
		 Alert alert = new Alert(AlertType.CONFIRMATION, "Giornata Conclusa!", ButtonType.OK);
		 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		 alert.setTitle("Pronto Soccorso");
		 alert.show();
	}
		
	public void CalcoloMedia() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(mediapazienti,1);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	

	public void CalcoloRossi() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(media_casirossi,2);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	
	
	public void CalcoloGialli() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(media_casigialli,3);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	
	
	public void CalcoloBianchi() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(media_casibianchi,4);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	
	public void CalcoloMaggiorenni() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(pazientimaggiorenni,5);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	
	
	public void CalcoloMinorenni() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(pazientiminorenni,6);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	
	public void CalcoloPazientiUsciti() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(pazientiusciti,7);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	public void CalcoloPazientiPaganti() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(pazientiticket,8);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}
	
	public void CalcoloPazientiNonPaganti() throws IOException
	{
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("GraficoMedia.fxml"));
		   Parent root = (Parent) loader.load();
		   GraficoController secondoController = loader.getController();   
		   secondoController.CalcolaGrafico(pazientinonpaganti,9);   
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root));
		   stage.show();
	}	
}