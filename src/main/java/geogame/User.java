package geogame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class User implements GeoInterface{
    private int score;
    
    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void save(String filename, int poengSum) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("src/main/java/geogame/saves/" + filename)) {
            score = poengSum;
            writer.println(score);
        }
    }

    @Override
    public void load(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/geogame/saves/" + filename));
        
        if (scanner.hasNextInt()) {
            score = scanner.nextInt();
        }

        scanner.close();
    }

}