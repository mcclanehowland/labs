import java.awt.Graphics;
import java.awt.Color;

public class Student {
    String firstName;
    String lastName;
    int id;
    String face;
    Period[] Period;
    int p1,p2,p3;
    String s1,s2,s3;
    String g1,g2,g3;
    Image image;
    
    public Student(String first, String last, int id, int p1,String s1,String g1,int p2,String s2,String g2,int p3,String s3,String g3, String face ){
        firstName = first;
        lastName = last;
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.face = face;
        Period = new Period[3];
        Period[0] = new Period(s1,p1,g1);
        Period[1] = new Period(s2,p2,g2);
        Period[2] = new Period(s3,p3,g3);
        image = new Image();
       
    }
    public void drawMe(Graphics g, int x, int y) {
        g.setColor(Color.blue);
        image.drawMePNG(g,face,x,y);
        g.drawString(firstName+" "+lastName+" ID = "+id,x,y);
        g.drawString("Period "+p1+", "+s1+", "+g1,x,y+30);
        g.drawString("Period "+p2+", "+s2+", "+g2,x,y+60);
        g.drawString("Period "+p3+", "+s3+", "+g3,x,y+90);
    }
    public String firstName() {

        return firstName;
    }
    public int getID() {
        return id;
    }
    public boolean getSubject(String subject) {
        if(subject.equals(s1) || subject.equals(s2) || subject.equals(s3)) 
            return true;
        return false; 
    }
    public String toString() {
        return firstName+" "+lastName+" "+id;
    }

}
