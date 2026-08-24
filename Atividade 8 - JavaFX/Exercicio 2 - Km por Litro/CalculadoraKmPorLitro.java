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

/** Calcula o consumo de um carro em quilômetros por litro. */
public class CalculadoraKmPorLitro extends Application {
    @Override
    public void start(Stage palco) {
        TextField kmField = new TextField();
        kmField.setPromptText("Ex.: 450,5");
        TextField litrosField = new TextField();
        litrosField.setPromptText("Ex.: 35");
        Label resultado = new Label("Informe os dados e clique em Calcular.");
        resultado.setFont(Font.font(16));

        Button calcular = new Button("Calcular consumo");
        calcular.setDefaultButton(true);
        calcular.setOnAction(evento -> calcular(kmField, litrosField, resultado));

        GridPane raiz = new GridPane();
        raiz.setPadding(new Insets(25));
        raiz.setHgap(12);
        raiz.setVgap(14);
        raiz.setAlignment(Pos.CENTER);
        raiz.add(new Label("Quilômetros percorridos:"), 0, 0);
        raiz.add(kmField, 1, 0);
        raiz.add(new Label("Litros consumidos:"), 0, 1);
        raiz.add(litrosField, 1, 1);
        raiz.add(calcular, 1, 2);
        raiz.add(resultado, 0, 3, 2, 1);

        palco.setTitle("Calculadora de quilômetros por litro");
        palco.setScene(new Scene(raiz, 480, 260));
        palco.show();
    }

    private void calcular(TextField kmField, TextField litrosField, Label resultado) {
        try {
            double km = lerNumero(kmField.getText());
            double litros = lerNumero(litrosField.getText());
            if (km < 0 || litros <= 0) {
                throw new IllegalArgumentException();
            }
            resultado.setText(String.format("Consumo: %.2f km/L", km / litros));
        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR,
                "Informe quilômetros não negativos e litros maiores que zero.").showAndWait();
        }
    }

    private double lerNumero(String texto) {
        return Double.parseDouble(texto.trim().replace(',', '.'));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
