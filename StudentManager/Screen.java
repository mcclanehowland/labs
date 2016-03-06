import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener {

    Student[] students;
    JButton displayAll;
    JButton searchFirst;
    JButton searchSubject;
    JButton searchID;
    JTextField input;
    int selection;
    boolean display = false;

  	public Screen() {
        setLayout(null); 
        students = new Student[4];
        students[0] = new Student("Aaron", "Smith", 1234, 1, "US History", "A", 2, "Geometry", "B", 3, "Physics", "A","face1");

        students[1] = new Student("Jane","Doe",4321,2,"Geometry","A",3,"Physics","C",4,"Computer Science","A","face2");
        students[2] = new Student("Ben","Washington",3021,1,"US History","B",3,"Physics","B",4,"Computer Science","A","face3");
        students[3] = new Student("Carly","Jones",1001,4,"Geometry","B",5,"Physics","B",6,"English","A","face4");

        displayAll = new JButton("Display All");
        displayAll.setBounds(100,100,200,30);
        add(displayAll);
        displayAll.addActionListener(this);
        
        searchFirst = new JButton("Search by First Name");
        searchFirst.setBounds(400,100,200,30);
        add(searchFirst);
        searchFirst.addActionListener(this);
        
        searchSubject = new JButton("Search by Subject");
        searchSubject.setBounds(100,200,200,30);
        searchSubject.addActionListener(this);
        add(searchSubject);

        searchID = new JButton("Search by ID");
        searchID.setBounds(400,200,200,30);
        searchID.addActionListener(this);
        add(searchID);

        input = new JTextField(500);
        input.setBounds(250,150,200,30);
        input.addActionListener(this);
        add(input);
    }
	public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,0,800,600);
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		g.setColor(Color.blue);
        int x = 100;
        int y = 300;
        int i = 0;
        if(selection == 0) {
            removeAll();
            add(searchFirst);
            add(displayAll);
            add(searchSubject);
            add(searchID);
            add(input);
        }
        if(selection == 1) {
            for(Student each : students) {
                i++;
                each.drawMe(g,x,y);
                x += 300;
                if(i%2 == 0) {
                    y = 450;
                    x = 100;
                }
            }
        }
        if(selection == 2) {
            x = 100;
            y = 300;
            i = 0;
            for(Student each : students) {
                 i++;
                 if(input.getText().equals(each.firstName())) {
                     each.drawMe(g,x,y);
                 }
                x += 300;
                if(i%2 == 0) {
                    y = 450;
                    x = 100;
                }
           }
        }
        if(selection == 3) {
            x = 100;
            y = 300;
            i = 0;
            for(Student each : students) {
                i++;
                if(each.getSubject(input.getText())) {
                    each.drawMe(g,x,y);
                }
                x += 300;
                if(i%2 == 0) {
                    y = 450;
                    x = 100;
                }
            }
        }
        if(selection == 4) {
            x = 100;
            y = 300;
            i = 0;
            for(Student each : students) {
                i++;
                try {
                    if(each.getID() == Integer.parseInt(input.getText())) {
                        each.drawMe(g,x,y);
                    }
                }
                catch(Exception e) {
                    System.out.println("Please enter a number when searching by ID");
                }
                x += 300;
                if(i%2 == 0) {
                    x = 100;
                    y = 450;
                }
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == displayAll) 
            selection = 1;
        else if(e.getSource() == searchFirst) 
            selection = 2;
        else if(e.getSource() == searchSubject) 
            selection = 3;
        else if(e.getSource() == searchID) 
            selection = 4;
        repaint();
    }
}
