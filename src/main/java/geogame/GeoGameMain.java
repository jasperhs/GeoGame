package geogame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeoGameMain {

    private List<File> files = new ArrayList<>();
    private Random rand = new Random();
    private int riktigInt;
    private int score = 0;
    private String riktigNavn;
    private String feilNavn;

    
   
    public GeoGameMain(){
        try{
        File folder = new File("src/main/java/geogame/flagg");
        File[] fileList = folder.listFiles((d, name) -> name.endsWith(".png"));
        

        if (fileList != null) {
            for (File file : fileList) {
                files.add(file);
            }
        }
    }
    catch (Exception e){
        System.out.println("filer ikke funnet");
    }


    }

    public List<File> liste(){
        return files;
    }

    public File riktigFil(){

        riktigInt = rand.nextInt(files.size());
        File file = files.get(riktigInt);
        return file;
       
        
    }

    public String riktigNavn(File file){
        riktigNavn = file.getName().substring(0, file.getName().indexOf('.'));
        return riktigNavn;
    }

    public String feilNavn(){
        
        File file = files.get(rand.nextInt(files.size()));
        String tempFeilNavn = file.getName().substring(0, file.getName().indexOf('.'));
        if(tempFeilNavn.equals(riktigNavn)  | tempFeilNavn.equals(feilNavn)){
            System.out.println("LIKE NAVN");
            return feilNavn();
        }
            feilNavn = tempFeilNavn;
            return feilNavn;
        }




    public void setScore(int poeng){
        if (poeng>=0) {
        score = poeng;
        System.out.println("main poeng er " + score);
        }
        else{
            throw new IllegalArgumentException("score må være positiv");    
        }
    }

    public int getScore() {
        return score;
    }

    




    

    
}
