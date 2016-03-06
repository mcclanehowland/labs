import java.awt.Graphics;
import java.awt.Color;

public class Song {

    String name;
    String artist;
    String album;
    boolean visible;
    
    public Song(String name,String artist,String album, boolean visible) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.visible = visible;
    }
    public void drawMe(Graphics g,int x,int y) {
        if(visible) {
            g.setColor(Color.black);
            g.drawString(name+", Artist: "+artist+", Album: "+album,x,y);
        }
    }
    public boolean getVisible() {
        return visible;
    }
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
        
    
}
