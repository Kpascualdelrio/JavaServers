module JavaServersP4 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens javaservers.modelo to javafx.graphics, javafx.fxml;
}
