package application;

import controller.Carrinho;
import controller.Vitrine;
import model.Pokemon;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class VitrineApp extends Application {

	private AnchorPane pane;
	private TextField txPesquisa;
	private TableView<Pokemon> tbVitrine;
	private TableColumn<Pokemon, String> columnPokemon;
	private TableColumn<Pokemon, Double> columnForca;
	private static ObservableList<Pokemon> listItens = FXCollections.observableArrayList();
	private static Carrinho carrinho;
	public static Stage stage;
	
	public void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, silver 0%, blue 100%)");
		
		txPesquisa = new TextField();
		txPesquisa.setPromptText("Item para pesquisa");
		
		tbVitrine = new TableView<Pokemon>();
		tbVitrine.setPrefSize(500, 500);
		
		columnPokemon = new TableColumn<Pokemon, String>("Pokemon");
		columnPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nome"));
		
		columnForca = new TableColumn<Pokemon, Double>("Força");
		columnForca.setCellValueFactory(new PropertyValueFactory<Pokemon, Double>("forca"));
		
		tbVitrine.getColumns().addAll(columnPokemon, columnForca);
		
		pane.getChildren().addAll(txPesquisa, tbVitrine);
		
		carrinho = new Carrinho();
		
		initItens();
	}
	
	public void initItens(){
		Vitrine vitrine = new Vitrine();
		vitrine.addProdutos(new Pokemon("Pikachu", 12.00), 
							new Pokemon("Zubat", 9.00), 
							new Pokemon("Ratata", 11.00), 
							new Pokemon("Pidgey", 10.00), 
							new Pokemon("Charmander", 19.00));
		
		for (Pokemon p: vitrine.getPokemons()){
			listItens.add(p);
		}
		
		tbVitrine.setItems(listItens);
			
	}
	
	private ObservableList<Pokemon> encontrarItens(){
		ObservableList<Pokemon> itensEncontrados = FXCollections.observableArrayList();
		
		for (Pokemon p: listItens){
			if (p.getNome().contains(txPesquisa.getText())){
				itensEncontrados.add(p);
			}
		}
		return itensEncontrados;
	}
	
	public void initListeners(){
		txPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (!txPesquisa.getText().equals("")){
					tbVitrine.setItems(encontrarItens());
				} else {
					tbVitrine.setItems(listItens);
				}
				
			}
		});
		
		tbVitrine.setOnMousePressed(new EventHandler<MouseEvent>() {
//teste
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2){
					int indexSelectPokemon = tbVitrine.getSelectionModel().getSelectedIndex();
					ItemVitrineApp.setPokemon(listItens.get(indexSelectPokemon));
					ItemVitrineApp.setIndex(indexSelectPokemon);
					try {
						new ItemVitrineApp().start(new Stage());
					} catch (Exception e){
						e.printStackTrace();
					}
				}
				
			}
			
		});
	}

	public void initLayout(){
		txPesquisa.setLayoutX(pane.getWidth() - txPesquisa.getWidth() - 10);
		txPesquisa.setLayoutY(7);
		
		tbVitrine.setLayoutX(40);
		tbVitrine.setLayoutX(10);
		
		columnPokemon.prefWidthProperty().bind(tbVitrine.widthProperty().multiply(0.6));;
		columnForca.prefWidthProperty().bind(tbVitrine.widthProperty().multiply(0.4));;
		
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
		stage.setTitle("Detalhe Pokemon");
		stage.show();
		ItemVitrineApp.stage = stage;
		initLayout();
		
	}
	
	
	
}
