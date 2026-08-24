import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** Versão JavaFX do programa Soma, usando Integer.parseInt. */
public class SomaJavaFX extends Application {
    @Override
    public void start(Stage palco) {
        TextField primeiroNumero = new TextField();
        TextField segundoNumero = new TextField();
        Label resultado = new Label("A soma aparecerá aqui.");
        resultado.setFont(Font.font(16));

        Button somar = new Button("Somar");
        somar.setDefaultButton(true);
        somar.setOnAction(evento -> {
            try {
                int numero1 = Integer.parseInt(primeiroNumero.getText().trim());
                int numero2 = Integer.parseInt(segundoNumero.getText().trim());
                resultado.setText("A soma é " + (numero1 + numero2));
            } catch (NumberFormatException e) {
                new Alert(Alert.AlertType.ERROR,
                    "Digite somente números inteiros nos dois campos.").showAndWait();
            }
        });

        GridPane raiz = new GridPane();
        raiz.setPadding(new Insets(25));
        raiz.setHgap(12);
        raiz.setVgap(14);
        raiz.setAlignment(Pos.CENTER);
        raiz.add(new Label("Primeiro número:"), 0, 0);
        raiz.add(primeiroNumero, 1, 0);
        raiz.add(new Label("Segundo número:"), 0, 1);
        raiz.add(segundoNumero, 1, 1);
        raiz.add(somar, 1, 2);
        raiz.add(resultado, 0, 3, 2, 1);

        palco.setTitle("Soma de dois números");
        palco.setScene(new Scene(raiz, 410, 250));
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
