package application;

import java.util.List;

import controller.Carrinho;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		btVoltarVitrine.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				CarrinhoApp.getStage().close();
				ItemVitrineApp.getStage().close();
				
			}
		});
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
	
	public static Stage getStage(){
		return stage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponents();
		//initListeners();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Carrinho");
		stage.show();
		ItemVitrineApp.stage = stage;
		initLayout();

		
	}

}
