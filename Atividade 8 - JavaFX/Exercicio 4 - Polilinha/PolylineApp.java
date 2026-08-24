import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/** Mantém uma trilha de até 50 posições recentes do cursor. */
public class PolylineApp extends Application {
    private static final int MAXIMO_DE_PONTOS = 50;

    @Override
    public void start(Stage palco) {
        Pane area = new Pane();
        Polyline linha = new Polyline();
        // Aparência semelhante à referência: um traço cinza grosso e um círculo
        // no ponto mais recente do movimento do mouse.
        linha.setStroke(Color.web("#66666b"));
        linha.setStrokeWidth(10);
        linha.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linha.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.ROUND);
        Circle cursor = new Circle(10, Color.web("#66666b"));
        area.getChildren().addAll(linha, cursor);

        area.setOnMouseMoved(evento -> {
            double x = evento.getX();
            double y = evento.getY();
            cursor.setCenterX(x);
            cursor.setCenterY(y);

            ObservableList<Double> pontos = linha.getPoints();
            pontos.add(0, y);
            pontos.add(0, x);
            while (pontos.size() / 2 > MAXIMO_DE_PONTOS) {
                pontos.remove(pontos.size() - 1);
                pontos.remove(pontos.size() - 1);
            }
        });

        palco.setTitle("Polilinha seguindo o cursor");
        palco.setScene(new Scene(area, 700, 500, Color.web("#f7fbff")));
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
