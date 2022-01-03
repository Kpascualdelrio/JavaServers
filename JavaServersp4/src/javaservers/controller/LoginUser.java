package javaservers.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginUser {
	
	
	public void Login(Stage primaryStage) {
		
		
		// Esta parte del código nos crea la escena con un título
		primaryStage.setTitle("Sing in ONG");
		//Esto nos muestra la escena
		primaryStage.show();
		
		//Creamos un objeto de GridPane y lo asignamos a una variable
		GridPane grid = new GridPane();
		
		//setAlignment cambia de default a centrar la escena
		grid.setAlignment(Pos.CENTER);
		
		//setHgap y setVgap maneja el espacio entre las columnas y las filas
		grid.setHgap(10);
		grid.setVgap(10);
		
		//setPadding maneja el espacio alrededor de los bordes del panel de la cuadrícula en este caso hemos añadido 25 pixeles de relleno
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		
		//Creamos un objeto de tipo texto y añade el texto de welcome //NO EDITAR
		Text scenetitle = new Text("Welcome");
		
		//agregamos el tipo de fuente y el tamaño de las letras
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		//estos números se refieren a las columnas donde se asignan los objetos
		grid.add(scenetitle, 0, 0, 2, 1);
		
		//creamos un objeto etiqueta llamado user a la columna 0 y el cuadro de díalogo en la columna 1 
		Label userName = new Label("User:");
		grid.add(userName, 0, 1);
		
		//Creamos el cuadro de díalogo y lo añadimos a la columna 1
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		//creamos un objeto etiqueta llamado Password a la columna 0 el cuadro de díalogo en la columna 2
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		
		////Creamos el cuadro de díalogo de la contraseña y lo añadimos a la columna 1 y a la 2 donde irá password
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		//Nos pondrá el nombre de la acción
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
		//Creamos una escena con las dimensionas aquí propuestas
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		
		//creación del botón de login
		
		//creamos el botón
		Button btn = new Button("Sign in");
		
		//nos crea el diseño del botón con un espacio de 10 pixeles
		HBox hbBtn = new HBox(10);
		
		//asignamos la posición del botón
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		//asignamos al hijp del diseño HBOX
		hbBtn.getChildren().add(btn);
		
		//le asignamos un aposición
		grid.add(hbBtn, 1, 4);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
			//método que se ejecuta cuando presionamos el botón
		    @Override
		    public void handle(ActionEvent e) {
		        actiontarget.setFill(Color.FIREBRICK);
		        actiontarget.setText("Sign in button pressed");
		    }
		});
		
	}
}
