import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** Cria uma colagem com quatro lugares icônicos do mundo. */
public class ScrapbookingApp extends Application {
    private static final String[] LUGARES = {
        "Torre Eiffel — Paris, França",
        "Cristo Redentor — Rio de Janeiro, Brasil",
        "Taj Mahal — Agra, Índia",
        "Estátua da Liberdade — Nova York, EUA"
    };

    // Imagens incluídas no projeto: não dependem de conexão com a internet.
    private static final String[] IMAGENS = {
        "eiffel.png",
        "cristo-redentor.png",
        "taj-mahal.png",
        "estatua-liberdade.png"
    };

    @Override
    public void start(Stage palco) {
        GridPane colagem = new GridPane();
        colagem.setPadding(new Insets(18));
        colagem.setHgap(16);
        colagem.setVgap(16);
        colagem.setAlignment(Pos.CENTER);

        for (int i = 0; i < LUGARES.length; i++) {
            colagem.add(criarCartao(IMAGENS[i], LUGARES[i]), i % 2, i / 2);
        }

        Label titulo = new Label("Meu álbum de lugares icônicos");
        titulo.setFont(Font.font(24));
        titulo.setTextFill(Color.web("#23395d"));
        BorderPane raiz = new BorderPane(colagem, titulo, null, null, null);
        BorderPane.setAlignment(titulo, Pos.CENTER);
        BorderPane.setMargin(titulo, new Insets(16, 0, 0, 0));

        palco.setTitle("Scrapbooking");
        palco.setScene(new Scene(raiz, 760, 650));
        palco.show();
    }

    private StackPane criarCartao(String arquivoDaImagem, String legenda) {
        String caminho = new File("assets", arquivoDaImagem).toURI().toString();
        ImageView imagem = new ImageView(new Image(caminho, 340, 240, true, true, false));
        imagem.setFitWidth(340);
        imagem.setFitHeight(240);
        imagem.setPreserveRatio(false);

        Label texto = new Label(legenda);
        texto.setTextFill(Color.WHITE);
        texto.setStyle("-fx-background-color: rgba(0, 0, 0, 0.65); -fx-padding: 8px;");
        texto.setMaxWidth(Double.MAX_VALUE);
        texto.setAlignment(Pos.CENTER);

        StackPane cartao = new StackPane(imagem, texto);
        StackPane.setAlignment(texto, Pos.BOTTOM_CENTER);
        cartao.setStyle("-fx-border-color: #d0d7de; -fx-border-width: 3px;");
        return cartao;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
