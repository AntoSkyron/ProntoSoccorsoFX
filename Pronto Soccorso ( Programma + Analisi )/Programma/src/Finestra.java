
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Finestra extends Application {
	
	static Stage stageprim;
	Stage stage1;
	static Stage stage2;
	
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	    public void start(Stage stage) throws Exception {
	        this.stage1 = stage;
	        Caricamento();
	    }


	
	
	 @SuppressWarnings("unused")
	public void Caricamento() {

	        try {

	            FXMLLoader loader = new FXMLLoader(CaricamentoController.class.getResource("Caricamento.fxml"));
	            AnchorPane pane = loader.load();
	            CaricamentoController controller = loader.getController();
	            controller.Main(this, stage1);
	            Scene scene = new Scene(pane);
	            System.out.println("File creati con successo");
	           stage1.initStyle(StageStyle.UNDECORATED);
	            stage1.setScene(scene);
	            stage1.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 	 
	
	   public void FinestraWindow() {

	        try {
	            FXMLLoader loader = new FXMLLoader(Finestra.class.getResource("ProntoSoccorsoUI.fxml"));
	            AnchorPane pane = loader.load();
	            FinestraController controller = loader.getController();
	            stageprim = new Stage();
	            controller.Main(this, stageprim);
	            Scene scene = new Scene(pane);
	          //  stageprim.setResizable(false);
	            stageprim.setTitle("Pronto Soccorso");
	            stageprim.setScene(scene);
	            stageprim.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 public void signInClose() {
	        stageprim.close();
	    }
	
	
 
	 public void splashWindowClose() {
	        stage1.close();
	    }
	
	 
	 
	 
	 
	 
	 
	 
	
}
