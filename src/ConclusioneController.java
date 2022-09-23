import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ConclusioneController {

	
	@FXML
	Text NomePaziente;
	
	@FXML
	Text CognomePaziente;
	
	@FXML
	Rectangle Rettangolo;
	
	@FXML
	TextField Prestazione,ora_uscita;
	
	
	 String n, c, colorecaso, data, ticket, sintomi,ora , magg;

	private CreaTestoFine h;

	private CreaPrestazione l;
	
	public void Conclusione( String n, String c, String colorecaso, String data, String ticket, String sintomi, String ora , String magg)
	{
		this.n=n;
		this.c=c;
		this.colorecaso=colorecaso;
		this.data=data;
		this.ticket=ticket;
		this.sintomi=sintomi;
		this.ora=ora;
		this.magg=magg;
	
		
		NomePaziente.setText(n);
		CognomePaziente.setText(c);
		
		
		if(colorecaso.equals("Rosso"))
		{
			Rettangolo.setFill(Color.RED);
		}
		else if (colorecaso.equals("Giallo"))
		{
			Rettangolo.setFill(Color.YELLOW);
		}
		else if (colorecaso.equals("Bianco"))
		{
			Rettangolo.setFill(Color.WHITE);
		}
		
	}
	
	
	
	
	public void Conferma()
	{
		if(Prestazione.getText().equals("") && ora_uscita.getText().equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}
		
		
		if(Prestazione.getText().equals("") || ora_uscita.getText().equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Pronto Soccorso");
			alert.show();
			return;
		}
		
		String presta = Prestazione.getText();
		String orau = ora_uscita.getText();
		h = new CreaTestoFine(n,c,colorecaso,ora,orau,magg,"Lista Pazienti usciti dal Pronto soccorso.txt");		
	
		CreaFile f = new CreaFile("Prestazione del Paziente " + n + " " + c + ".txt");
		l = new CreaPrestazione(presta,f.NOME_FILE);
		
		
		 Alert alert = new Alert(AlertType.CONFIRMATION, "Visita conclusa con successo!", ButtonType.OK);
		 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		 alert.setTitle("Pronto Soccorso");
		 alert.show();
		
	}	
}
