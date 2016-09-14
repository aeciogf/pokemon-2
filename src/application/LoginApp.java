package application;



import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LoginApp extends Application {
	
	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar;
	private Button btSair;
	public static Stage stage;
	
	public void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, silver 0%, blue 100%)");
		
		txLogin = new TextField();
		txLogin.setPromptText("Seu login");
		
		
		txSenha = new PasswordField();
		txSenha.setPromptText("Sua senha");
		
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		
		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
		
	}
	
	public void initLayout(){
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth())/2);
		txLogin.setLayoutY(50);
		
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth())/2);
		txSenha.setLayoutY(100);
		
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth())/2);
		btEntrar.setLayoutY(150);
		
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth())/2);
		btSair.setLayoutY(200);
	}

	public void logar(){
		if (txLogin.getText().equals("admin") && txSenha.getText().equals("123")){
			try {
				new VitrineApp().start(new Stage());
				LoginApp.getStage().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Credenciais inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void fecharAplicacao(){
		System.out.println("Exit");
		System.exit(0);
	}

	public void initListeners(){
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				logar();
				
			}
		});
		
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				fecharAplicacao();
				
			}
		});
	}
	
	
	
	private static Stage getStage() {
		return stage;
	}

	@Override
	public void start(Stage stage) {
		try {
			initComponents();
			initListeners();

			Scene scene = new Scene(pane);
					
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Login - Loja Pokemon");
			stage.show();
			initLayout();
			LoginApp.stage = stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
