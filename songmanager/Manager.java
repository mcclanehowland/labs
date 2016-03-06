import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Manager extends JPanel implements ActionListener{

    ArrayList<Song> song; //song ArrayList
    JButton shuffle; //JButtons
    JButton sortArtist;
    JButton sortName;
    JButton sortAlbum;
    JButton displayAll;
    JButton searchName;
    JButton searchArtist;
    JButton add;

    JTextField input; //Textfield
    JTextField name;
    JTextField artist;
    JTextField album;


    public Manager() {

        setLayout(null); //set layout
        song = new ArrayList<Song>();    //set song values
        song.add(new Song("Stitches","Shawn Mendes","Handwritten",true));
        song.add(new Song("Hotline Bling","Drake","Single",true));
        song.add(new Song("What Do You Mean?","Justin Bieber","Purpose",true));
        song.add(new Song("Wrecking Ball","Miley Cyrus","Bangerz",true));
        song.add(new Song("Hello","Adele","25",true));
        song.add(new Song("Sorry","Justin Bieber","Purpose",true));
        song.add(new Song("Baby","Justin Bieber","My World 2.0",true));
        song.add(new Song("Blank Space","Taylor Swift","1989",true));
        song.add(new Song("Style","Taylor Swift","1989",true));
        song.add(new Song("Roar","Katy Perry","Prism",true));

        shuffle = new JButton("Shuffle");//shuffle
        shuffle.setBounds(100,100,200,30);
        shuffle.addActionListener(this);
        add(shuffle);
        sortArtist = new JButton("Sort by Artist");//sort Artist
        sortArtist.setBounds(310,100,200,30);
        sortArtist.addActionListener(this);
        add(sortArtist);
        sortName = new JButton("Sort by Name"); //sort Name
        sortName.setBounds(520,100,200,30);
        sortName.addActionListener(this);
        add(sortName);
        sortAlbum = new JButton("Sort by Album"); //sort Album
        sortAlbum.setBounds(730,100,200,30);
        sortAlbum.addActionListener(this);
        add(sortAlbum);
        displayAll = new JButton("Display All"); //display All
        displayAll.setBounds(100,150,200,30);
        displayAll.addActionListener(this);
        add(displayAll);
        searchName = new JButton("Search by Name"); //search by name
        searchName.setBounds(310,150,200,30);
        searchName.addActionListener(this);
        add(searchName);
        searchArtist = new JButton("Search by Artist"); //search by artis
        searchArtist.setBounds(520,150,200,30);
        searchArtist.addActionListener(this);
        add(searchArtist);
        input = new JTextField(500); //input textfield
        input.setBounds(730,150,200,30);
        input.addActionListener(this);
        add(input);
        name = new JTextField(500); //name textfield
        name.setBounds(730,300,200,30);
        name.addActionListener(this);
        add(name);
        artist = new JTextField(500); //artist textfield
        artist.setBounds(730,370,200,30);
        artist.addActionListener(this);
        add(artist);
        album = new JTextField(500); //album textfield
        album.setBounds(730,440,200,30);
        album.addActionListener(this);
        add(album);
        add = new JButton("Add Song"); //add new song JButton
        add.setBounds(730,510,200,30);
        add.addActionListener(this);
        add(add);
    }
    public Dimension getPreferredSize() {
        return new Dimension(1000,1000); //size
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,1000,1000);
        Font font = new Font("Arial",Font.PLAIN,20);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Name",730,300);
        g.drawString("Artist",730,370);
        g.drawString("Album",730,440);
        int x = 100; // display all with x and y coordinates
        int y = 250;
        for(Song each : song) {
            if(each.getVisible()) {
                each.drawMe(g,x,y);
                y+=50;
            }
        }
    }
    public void scramble() {
        for(int i = 0; i < song.size();i++) {
            int swap = (int)(Math.random()*song.size());
            Song temp = song.get(i);
            song.set(i,song.get(swap));
            song.set(swap,temp);
        }
    }
    public void search(String method, String query) {
        for(Song each : song) {
            each.setVisible(false);
            try {
                Method m = Song.class.getMethod(method); //create method with name passed in
                for(int i = 0; i < song.size();i++) 
                    if(m.invoke(song.get(i)).toString().equals(query)) { 
                        song.get(i).setVisible(true);
                    }
            }
            catch(Exception e) {}
        }
    }
    public void sort(String method) {
        try {
            Method m = Song.class.getMethod(method); //create method with name passed in
            for(int i = 0; i < song.size()-1;i++) {
                int currentIndex = i;
                int minIndex = i;
                for(int j = i+1; j < song.size();j++) {
                    if(m.invoke(song.get(minIndex)).toString().compareTo(m.invoke(song.get(j)).toString()) > 0) //compare values returned by method created above
                        minIndex = j;
                }
                if(minIndex != currentIndex) {
                    Song temp = song.get(minIndex); //swap
                    song.set(minIndex,song.get(currentIndex));
                    song.set(currentIndex,temp);
                }
            }
        }
        catch(Exception e) {}
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shuffle) 
            scramble();
        if(e.getSource() == sortArtist) 
            sort("getArtist"); //call sort with name of method
        if(e.getSource() == sortName) 
            sort("getName"); 
        if(e.getSource() == sortAlbum) 
            sort("getAlbum");
        if(e.getSource() == displayAll) 
            for(Song each : song) 
                each.setVisible(true);
        if(e.getSource() == searchName) 
            search("getName",input.getText());
        if(e.getSource() == searchArtist) 
            search("getArtist",input.getText());
        if(e.getSource() == add) 
            song.add(new Song(name.getText(),artist.getText(),album.getText(),true));
        repaint();
    }
}
