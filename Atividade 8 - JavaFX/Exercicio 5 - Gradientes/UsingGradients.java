import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Aplica gradientes lineares ou radiais usando duas cores RGBA. */
public class UsingGradients extends Application {
    private final Rectangle retangulo = new Rectangle(520, 240);
    private final TextField[] inicio = criarCampos("30", "144", "255", "255");
    private final TextField[] fim = criarCampos("255", "99", "71", "255");
    private final RadioButton linear = new RadioButton("Linear");
    private final RadioButton radial = new RadioButton("Radial");

    @Override
    public void start(Stage palco) {
        retangulo.setArcWidth(18);
        retangulo.setArcHeight(18);
        retangulo.setStroke(Color.DARKGRAY);

        ToggleGroup grupo = new ToggleGroup();
        linear.setToggleGroup(grupo);
        radial.setToggleGroup(grupo);
        linear.setSelected(true);
        Button aplicar = new Button("Aplicar gradiente");
        aplicar.setOnAction(evento -> aplicarGradiente());

        GridPane cores = new GridPane();
        cores.setHgap(7);
        cores.setVgap(8);
        String[] canais = {"R", "G", "B", "A"};
        cores.add(new Label("Canal"), 0, 0);
        cores.add(new Label("Início"), 1, 0);
        cores.add(new Label("Fim"), 2, 0);
        for (int i = 0; i < canais.length; i++) {
            inicio[i].setPrefColumnCount(4);
            fim[i].setPrefColumnCount(4);
            cores.add(new Label(canais[i]), 0, i + 1);
            cores.add(inicio[i], 1, i + 1);
            cores.add(fim[i], 2, i + 1);
        }

        HBox tipo = new HBox(15, new Label("Tipo:"), linear, radial, aplicar);
        tipo.setAlignment(Pos.CENTER);
        VBox raiz = new VBox(18, retangulo, tipo, cores);
        raiz.setPadding(new Insets(22));
        raiz.setAlignment(Pos.CENTER);
        aplicarGradiente();

        palco.setTitle("UsingGradients");
        palco.setScene(new Scene(raiz, 620, 490));
        palco.show();
    }

    private TextField[] criarCampos(String r, String g, String b, String a) {
        return new TextField[] {new TextField(r), new TextField(g), new TextField(b), new TextField(a)};
    }

    private void aplicarGradiente() {
        try {
            Color corInicial = lerCor(inicio);
            Color corFinal = lerCor(fim);
            Stop[] paradas = {new Stop(0, corInicial), new Stop(1, corFinal)};
            if (linear.isSelected()) {
                retangulo.setFill(new LinearGradient(0, 0, 1, 1, true,
                    CycleMethod.NO_CYCLE, paradas));
            } else {
                retangulo.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.55, true,
                    CycleMethod.NO_CYCLE, paradas));
            }
        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR,
                "Cada canal RGBA deve ser um número inteiro entre 0 e 255.").showAndWait();
        }
    }

    private Color lerCor(TextField[] campos) {
        int r = Integer.parseInt(campos[0].getText().trim());
        int g = Integer.parseInt(campos[1].getText().trim());
        int b = Integer.parseInt(campos[2].getText().trim());
        int a = Integer.parseInt(campos[3].getText().trim());
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || a < 0 || a > 255) {
            throw new IllegalArgumentException();
        }
        return Color.rgb(r, g, b, a / 255.0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
