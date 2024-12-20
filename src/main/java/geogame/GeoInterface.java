package geogame;

import java.io.FileNotFoundException;

public interface GeoInterface {

	public void setScore(int score);

	public int getScore();

	public void save (String filename, int poengSum) throws FileNotFoundException;

	public void load (String filename) throws FileNotFoundException;

}
