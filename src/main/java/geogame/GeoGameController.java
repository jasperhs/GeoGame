package geogame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GeoGameController {

    private GeoGameMain gameMain = new GeoGameMain();
    private User user = new User();
    private int poengSum;
    
    @FXML private ImageView flaggBoks;
    @FXML private Button nextFlagButton;
    @FXML private Button option1;
    @FXML private Button option2;
    @FXML private Button option3;
    @FXML private Label resultLabel;
    @FXML private Label score;
    @FXML private Button playAgainButton;
    @FXML private Label gameOverLabel;
    @FXML private Button loadButton;
    @FXML private Button saveButton;
    @FXML private TextField filNavn;
    @FXML private Label lagringsMelding;


    
    private List<File> files = new ArrayList<>();
    private Random rand = new Random();
    private int riktigInt;
    private boolean trykket = true;

    public GeoGameController() {

    }
    

   
    



        public void initialize() {
        
        files = gameMain.liste();
        playAgainButton.setVisible(false);
        gameOverLabel.setVisible(false);
        poengSum = 0;
        score.setText("Score: " + poengSum);

        option1.setMaxWidth(100);
        option2.setMaxWidth(100);
        option3.setMaxWidth(100);
        option1.setWrapText(true);
        option2.setWrapText(true);
        option3.setWrapText(true);
        nextFlag();

        
        }


    @FXML
    public void nextFlag() {  
        if (trykket == true) {
            
          
        trykket = false;
        //bestemmer hvilken knapp som skal ha riktig svar i seg
        int randomRiktigKnapp = rand.nextInt(1, 4);

        if (randomRiktigKnapp == 1){
            //finner hva som skal være riktig navn på flagget
            File riktig = gameMain.riktigFil();
            //finner index til riktig
            riktigInt = files.indexOf(riktig);

            //setter tekst til riktig navn, i denne funkjsonen er riktig knapp 1
            option1.setText(gameMain.riktigNavn(riktig));
            option2.setText(gameMain.feilNavn());
            option3.setText(gameMain.feilNavn());

            Image image = new Image(riktig.toURI().toString());
            flaggBoks.setImage(image);
            
           
        }

        if (randomRiktigKnapp == 2){
            File riktig = gameMain.riktigFil();
            riktigInt = files.indexOf(riktig);

            option2.setText(gameMain.riktigNavn(riktig));
            option1.setText(gameMain.feilNavn());
            option3.setText(gameMain.feilNavn());

            Image image = new Image(riktig.toURI().toString());
            flaggBoks.setImage(image);
            

        }
        if (randomRiktigKnapp == 3){
            File riktig = gameMain.riktigFil();
            riktigInt = files.indexOf(riktig);

            option3.setText(gameMain.riktigNavn(riktig));
            option1.setText(gameMain.feilNavn());
            option2.setText(gameMain.feilNavn());

            Image image = new Image(riktig.toURI().toString());
            flaggBoks.setImage(image);


        }

        resultLabel.setText("");
        lagringsMelding.setText("");
        }  
        else{
            resultLabel.setText("Du må velge et alternativ");
        } 
    }

    public String getOption1Text() {
        return option1.getText();
    }
    public String getOption2Text() {
        return option2.getText();
    }
    public String getOption3Text() {
        return option3.getText();
    }

  


  
    public void onClickOption1() {
        if (trykket == false) {
            
        trykket = true;
        //finner riktig fil/navn bassert på hva som ble bestemt tidligere. riktigInt
        File file = files.get(riktigInt);
        //System.out.println("her" + file.getName().substring(0, file.getName().indexOf('.')));
        //System.out.println("herr" + option1.getText());

        //sjekker om navnet til den riktige filen er det samme som teksten i knappen.
        if (file.getName().substring(0, file.getName().indexOf('.')).equals(option1.getText())) {
            //endrer stil for å signalisere at det er riktig svar
            resultLabel.setText("Riktig svar!");
            resultLabel.setStyle("-fx-text-fill: green;");
            poengSum += 1;
            gameMain.setScore(poengSum);

            score.setText("Score: " + poengSum);
                            
        }
        else {
            //endrer stil for å signalisere at det er feil svar. Kjører også gameOver funksjon
            resultLabel.setText("Feil svar!");
            resultLabel.setStyle("-fx-text-fill: red;");
            gameOver();
        }
         }
         else{
            resultLabel.setText("Kun et alternativ");
         }
    } 

    public void onClickOption2() {
        if (trykket == false) {
            trykket = true;
      
        File file = files.get(riktigInt);
        //System.out.println(file.getName().substring(0, file.getName().indexOf('.')));
        //System.out.println(option2.getText());
        if (file.getName().substring(0, file.getName().indexOf('.')).equals(option2.getText())) {
            resultLabel.setText("Riktig svar!");
            resultLabel.setStyle("-fx-text-fill: green;");
            poengSum += 1;
            gameMain.setScore(poengSum);

            score.setText("Score: " + poengSum);

        }
        else {
            resultLabel.setText("Feil svar!");
            resultLabel.setStyle("-fx-text-fill: red;");
            gameOver();
        }
          }
          else{
            resultLabel.setText("Kun et alternativ");
         }
    } 


    
    public void onClickOption3() {
        if (trykket == false) {
            trykket = true;
       
        File file = files.get(riktigInt);
        //System.out.println(file.getName().substring(0, file.getName().indexOf('.')));
        //System.out.println(option3.getText());
        if (file.getName().substring(0, file.getName().indexOf('.')).equals(option3.getText())) {
            resultLabel.setText("Riktig svar!");
            resultLabel.setStyle("-fx-text-fill: green;");
            poengSum += 1;
            gameMain.setScore(poengSum);
            score.setText("Score: " + poengSum);

        }
        else {
            resultLabel.setText("Feil svar!");
            resultLabel.setStyle("-fx-text-fill: red;");
            gameOver();

        }
         }
         else{
            resultLabel.setText("Kun et alternativ");
         }
    }
    
    public void gameOver() {
        flaggBoks.setVisible(false);
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);  
        score.setVisible(true);
        nextFlagButton.setVisible(false);
        playAgainButton.setVisible(true);
        gameOverLabel.setVisible(true);
    }

    public void playAgain() {
        flaggBoks.setVisible(true);
        option1.setVisible(true);
        option2.setVisible(true);
        option3.setVisible(true);
        score.setVisible(true);
        nextFlagButton.setVisible(true);
        playAgainButton.setVisible(false);
        gameOverLabel.setVisible(false);
        initialize();

    }

    public int getPoengSum() {
        return poengSum;
    }
    


    @FXML
    public void saveScore() {
        String filename = filNavn.getText();
        try {
            user.save(filename, poengSum);
            lagringsMelding.setText("Fil lagret");
        }
        catch (FileNotFoundException e) {
            lagringsMelding.setText("Feil filnavn");

        }
    }

    @FXML
    public void loadScore() {
        String filename = filNavn.getText();
        try {
            user.load(filename);
            poengSum = user.getScore();
            score.setText("Score: " + poengSum);
            lagringsMelding.setText("Fil lastet");
        }
        catch (FileNotFoundException e) {
            lagringsMelding.setText("Feil filnavn");
        }
    }
    


}
