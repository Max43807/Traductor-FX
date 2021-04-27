/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import traductorfx.service.TraductorServiceImpl;
import traductorfx.obj.Palabra;
import traductorfx.obj.Idioma;

/**
 *
 * @author ander
 */
public class TraductorFX extends Application {
    
    TraductorServiceImpl service = new TraductorServiceImpl();
    
    @Override
    public void start(Stage stage) {
        
        //Controles:
        Label lbl = new Label("Ingresar palabra: ");
        TextField txfPalOriginal = new TextField();
        TextField txfPalTraducida = new TextField();
        ComboBox cmbIdiomas = new ComboBox();

        AnchorPane panel = new AnchorPane();
        
        //Añadir los componentes al panel
        panel.getChildren().addAll(lbl, txfPalOriginal, txfPalTraducida, cmbIdiomas);
        
        Scene scene = new Scene(panel, 580, 110);
        
        stage.setTitle("Traductor FX");
        stage.setScene(scene);
        stage.setResizable(false);
        
        //Posicionar controles:
        lbl.setLayoutX(20);
        lbl.setLayoutY(12);
        
        txfPalOriginal.setLayoutX(20);
        txfPalOriginal.setLayoutY(40);
        
        txfPalTraducida.setLayoutX(380);
        txfPalTraducida.setLayoutY(40);
        txfPalTraducida.setEditable(false);
        txfPalTraducida.setFocusTraversable(false);
        
        cmbIdiomas.setLayoutX(230);
        cmbIdiomas.setLayoutY(40);
        cmbIdiomas.setPromptText("Seleccionar");
        cmbIdiomas.getItems().addAll(service.listarIdiomas());
        
        stage.show();
        
        //Manejador de eventos del combobox
        cmbIdiomas.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                
                Palabra p = new Palabra();
                p.setPalabra(txfPalOriginal.getText().trim());
                p.setIdioma((Idioma)cmbIdiomas.getItems().get(0));  //Establecer español como default
                Idioma idiomaDestino = (Idioma)cmbIdiomas.getSelectionModel().getSelectedItem();
                
                String trad = service.traducir(p, idiomaDestino);
                
                txfPalTraducida.setText(trad);
                //Por ahora, solo mostrar el idioma seleccionado...
               // System.out.println("Idioma seleccionado: " + cmbIdiomas.getSelectionModel().getSelectedItem());
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
