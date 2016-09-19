package application;

import java.util.List;

import javax.swing.JOptionPane;

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
import javafx.scene.control.cell.PropertyValueFactory;
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
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, silver 0%, blue 100%)");
		
		btConfirmarCompra = new Button("Confirmar compra");
		btExcluirItem = new Button("Excluir item");
		btVoltarVitrine = new Button("Voltar para vitrine");
		
		tbCarrinho = new TableView<Pokemon>();
		tbCarrinho.setPrefSize(600, 600);
		
		columnPokemon = new TableColumn<Pokemon, String>("Pokemon");
		columnPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nome"));
		
		columnForca = new TableColumn<Pokemon, Double>("Força");
		columnForca.setCellValueFactory(new PropertyValueFactory<Pokemon, Double>("forca"));
		
		tbCarrinho.getColumns().addAll(columnPokemon, columnForca);
		
		pane.getChildren().addAll(btConfirmarCompra, btExcluirItem, btVoltarVitrine, tbCarrinho);
		
		initItens();
	
	}
	
	public void initItens(){
		List<Pokemon> pokemons = VitrineApp.getCarrinho().getPokemons();
		listItens.clear();
		for (Pokemon p: pokemons){
			listItens.add(p);
		}
		tbCarrinho.setItems(listItens);
	}
	
	public void deleteItens(Pokemon pkm){
		initItens();
		for (Pokemon p: listItens){
			if (p.getNome() == pkm.getNome()){
				listItens.remove(p);
			}
		}
		tbCarrinho.setItems(listItens);
	}
	
	public void initListeners(){
		btVoltarVitrine.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				CarrinhoApp.getStage().close();
				ItemVitrineApp.getStage().close();
				
			}
		});
		
		btConfirmarCompra.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Compra realizada com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btExcluirItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				CarrinhoApp.getStage().close();
				ItemVitrineApp.getStage().close();
				
			}
		});
	}
	
	public void initLayout(){
		btConfirmarCompra.setLayoutX(pane.getWidth() - btConfirmarCompra.getWidth() - 10);
		btConfirmarCompra.setLayoutY(7);

		btExcluirItem.setLayoutX(pane.getWidth() - btConfirmarCompra.getWidth() - 10);
		btExcluirItem.setLayoutY(27);

		btVoltarVitrine.setLayoutX(pane.getWidth() - btConfirmarCompra.getWidth() - 10);
		btVoltarVitrine.setLayoutY(47);

		tbCarrinho.setLayoutX(40);
		tbCarrinho.setLayoutX(67);
		
		columnPokemon.prefWidthProperty().bind(tbCarrinho.widthProperty().multiply(0.2));;
		columnForca.prefWidthProperty().bind(tbCarrinho.widthProperty().multiply(0.2));;

	}
	
	public static Stage getStage(){
		return stage;
	}
	
	@Override
	public void start(Stage stage) {
		initComponents();
		initListeners();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Carrinho");
		stage.show();
		ItemVitrineApp.stage = stage;
		initLayout();

		
	}

}
