package application;

import controller.Carrinho;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;

public class CarrinhoApp extends Application {
	private AnchorPane pane;
	private TableView<Pokemon> tbCarrinho;
	private TableColumn<Pokemon, String> columnPokemon;
	private TableColumn<Pokemon, Double> columnForca;
	private Button btExcluirItem, btVoltarVitrine, btConfirmarCompra;
	private static ObservableList<Pokemon> listItens = FXCollections.observableArrayList();
	public static Stage stage;

	public void initComponents(){
		
	}
	
	public void initItens(){
		List<Pokemon> pokemons = VitrineApp.getCarrinho().getPokemons();
		listItens.clear();
		for (Pokemon p: pokemons){
			listItens.add(p);
		}
		tbCarrinho.setItems(listItens);
	}
	
	public void initLayout(){
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
