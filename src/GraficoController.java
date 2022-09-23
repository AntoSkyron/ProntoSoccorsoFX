import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

public class GraficoController {

    @FXML
    private LineChart<?, ?> LineChart;

    @FXML
    private Text testo;
    
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    
    
    
    public void CalcolaGrafico(ArrayList<Integer> arrei,int scelta)
    {
    	
    	if(scelta==1){
    	int somma = 0;	
    	XYChart.Series series = new XYChart.Series();
    	testo.setText("Pazienti entrati nel pronto soccorso.");
    	series.setName("Pazienti entrati nel pronto soccorso. ");
    	for(int i=0;i<arrei.size();i++)
    	{
    		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
    	}
    	LineChart.getData().add(series);
    	return;
    	}
    	else if(scelta==2){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti con casi rossi");
        	testo.setText("Pazienti con casi rossi.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}
    	else if(scelta==3){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	testo.setText("Pazienti con casi gialli.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}
    	else if(scelta==4){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti con casi bianchi");
        	testo.setText("Pazienti con casi bianchi.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}
       	else if(scelta==5){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti maggiorenni");
        	testo.setText("Pazienti maggiorenni.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}
    	
    	else if(scelta==6){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti minorenni");
        	testo.setText("Pazienti minorenni.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}
    	else if(scelta==7){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti che escono giornalmente");
        	testo.setText("Pazienti che escono giornalmente.");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}else if(scelta==8){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti che pagano il ticket");
        	testo.setText("Pazienti che pagano il ticket");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	} else if(scelta==9){
    	  	int somma = 0;	
        	XYChart.Series series = new XYChart.Series();
        	series.setName("Pazienti che non pagano il ticket");
        	testo.setText("Pazienti che non pagano il ticket");
        	for(int i=0;i<arrei.size();i++)
        	{
        		series.getData().add(new XYChart.Data( "   "  + (i+1)  + "° giorno",arrei.get(i)));
        	}
        	LineChart.getData().add(series);
        	return;		
    	}	
    }
}