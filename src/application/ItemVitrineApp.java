package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;

public class ItemVitrineApp extends Application {
	
	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbForca, lbNome;
	private Button btAddCarrinho;
	static Stage stage;
	private static Pokemon pokemon;
	private static int index;
	private static String imgPokemons[];
	
	public void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
		initItens();
		imgItem = new ImageView(imgPokemons[index]);
		lbForca = new Label("Força: " + pokemon.getForca());
		lbNome = new Label(("Nome: " + pokemon.getNome()));
		btAddCarrinho = new Button("Adicionar ao carrinho");
		pane.getChildren().addAll(imgItem, lbForca, lbNome, btAddCarrinho);
	}
	
	public void initLayout(){
		
	}
	
	public void initListeners(){
		
	}
	
	public static Stage getStage(){
		return stage;
	}
	
	public static void setPokemon(Pokemon pokemon){
		ItemVitrineApp.pokemon = pokemon;
	}
	
	public static void setIndex(int index){
		ItemVitrineApp.index = index;
	}
	
	public void initItens(){
		imgPokemons = new String[] {
				"http://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/250px-025Pikachu.png",
				"http://cdn.bulbagarden.net/upload/thumb/7/73/004Charmander.png/250px-004Charmander.png",
				"http://cdn.bulbagarden.net/upload/thumb/d/da/041Zubat.png/250px-041Zubat.png",
				"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTai-KTh6dA1gC-Lh7NzhF2QNt4U-5Or67ecwmRV1kvohaYK8HhBSLqX7E",
				"http://cdn.bulbagarden.net/upload/thumb/5/55/016Pidgey.png/250px-016Pidgey.png"
				
		};
	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListeners();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Detalhe Pokemon");
		stage.show();
		ItemVitrineApp.stage = stage;
		initLayout();
		
	}

}
