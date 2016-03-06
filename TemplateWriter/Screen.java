import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.*;

public class Screen extends JPanel implements ActionListener {
    JButton storyButton; //JButtons
    JButton createStory;
    JButton resumeButton;
    JButton createResumeButton;
    JButton exit;
    JButton createFile; //Write to file
    int fileNum; //will change name of file to create a new file each time;
    boolean fileCreated = false;
    JTextField resumeNameText; //JTextFields 
    JTextField contact;
    JTextField objective;
    JTextField education;
    JTextField skills;
    JTextField work;
    JTextField storyNoun;
    JTextField storyAdjective;
    JTextField storyVerb;
    JTextField storyPerson;
    JTextField storyNumber;
    JTextField storyPluralNoun;
    int menu; //ints
    boolean story = false; //booleans
    boolean resume = false;
    String phone = ""; //Strings
    String email = "";
    String skill1 = "";
    String skill2 = "";
    String wrk = "";
    String ed1  = "";
    String ed2 = "";
    String obj = "";
    String resumeName = "";
    String noun = "";
    String adjective = "";
    String verb = "";
    String person = "";
    String number = "";
    String pluralNoun = "";

	public Screen() {
        setLayout(null); 
        createFile = new JButton("Write to File");
        createFile.addActionListener(this);
        createFile.setBounds(600,500,200,30);
        //story
        storyButton = new JButton("Story"); //Story JButtons 
        storyButton.setBounds(100,100,200,30);
        add(storyButton);
        storyButton.addActionListener(this);
        createStory = new JButton("create");
        createStory.addActionListener(this);
        createStory.setBounds(400,550,200,30);
        storyNoun = new JTextField(500); //Story JTextFields
        storyNoun.setBounds(185,50,200,30);
        storyAdjective = new JTextField(500);
        storyAdjective.setBounds(185,100,200,30);
        storyVerb = new JTextField(500);
        storyVerb.setBounds(185,150,200,30);
        storyPerson = new JTextField(500);
        storyPerson.setBounds(185,200,200,30);
        storyNumber = new JTextField(500);
        storyNumber.setBounds(185,250,200,30);
        storyPluralNoun = new JTextField(500);
        storyPluralNoun.setBounds(185,300,200,30);
        exit = new JButton("Exit");//Exit JButton
        exit.setBounds(700,570,100,30);
        exit.addActionListener(this);
        //resume
        resumeButton = new JButton("Resume");//Resume JButtons
        resumeButton.setBounds(400,100,200,30);
        add(resumeButton);
        resumeButton.addActionListener(this); 
        createResumeButton = new JButton("Create");
        createResumeButton.setBounds(100,500,200,30);
        createResumeButton.addActionListener(this);
        resumeNameText = new JTextField(500);//Resume JTextFields
        resumeNameText.setBounds(185,50,200,30);
        contact = new JTextField(500);
        contact.setBounds(185,100,200,30);
        objective = new JTextField(500);
        objective.setBounds(185,150,200,30);
        skills = new JTextField(500);
        skills.setBounds(185,200,200,30);
        work = new JTextField(500);
        work.setBounds(185,250,200,30);
        education = new JTextField(500);
        education.setBounds(185,300,200,30);
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
        if(menu == 2){//resume
            g.drawString("Name: ",120,75);
            g.drawString("Please enter two items separated by a semi-colon in contact, education, and skills ",0,20); 
            g.drawString("Contact Info (email and Phone): ",50,100);
            g.drawString("Objective: ",80,150);
            g.drawString("Skills: ",80,200);
            g.drawString("Work Experience: ",80,250);
            g.drawString("Education: ",80,300);
            if(resume) {//if resume is created (button clicked)
                g.drawString(resumeName,450,50);
                g.drawString(email,450,75);
                g.drawString(phone,450,100);
                g.drawString("Objective:",400,125);
                g.drawString(obj,425,150);
                g.drawString("Education:",400,200);
                g.drawString("- "+ed1,425,225);
                g.drawString("- "+ed2,425,250);
                g.drawString("Work Experience:",400,300);
                g.drawString("- "+wrk,425,325);
                g.drawString("Skills:",400,375);
                g.drawString("- "+skill1,425,400);
                g.drawString("- "+skill2,425,425);
                add(createFile);
                if(fileCreated) {
                    g.setColor(Color.red);
                    g.drawString("Your file is called Resume"+fileNum+".txt",500,555);
                }
            }
        }
        else if(menu == 1) {//story
            g.drawString("Noun: ",120,50);
            g.drawString("Adjective: ",120,100);
            g.drawString("Verb: ",120,150);
            g.drawString("Person: ",120,200);
            g.drawString("Number: ",120,250);
            g.drawString("Plural Noun: ",120,300);
            if(story) {//if story is created
                g.drawString("The "+noun+" was walking down the street.", 400,50);
                g.drawString("Suddenly, a group of wild "+pluralNoun,400,100);
                g.drawString(" appeared in front of the "+noun+".",400,150);
                g.drawString("The "+noun+" began quickly "+verb+" away.",400,200);
                g.drawString("Once the "+noun+" was safely away from the ",400,250);
                g.drawString(adjective+" "+pluralNoun+" the "+noun+" sighed in relief.",400,300);
                g.drawString("But soon, the "+noun+" ran into "+number+" clones of ",400,350);
                g.drawString(person+"!",400,400);
            }
        }
        else if(menu == 0) {//select story or resume
            add(storyButton);
            add(resumeButton);
            resume = false;
            story = false;
        }
        if(menu == 1 || menu == 2) //if in story or resume, add the exit button
            add(exit);
    }
    public void createFile() {
        try {
        File file = new File("Resume"+fileNum+".txt");
      // creates the file
      file.createNewFile();
      // creates a FileWriter Object
      FileWriter writer = new FileWriter(file); 
      //text body
      writer.write(resumeName);
      writer.write("\r\n"+email);
      writer.write("\r\n"+phone);
      writer.write("\r\nObjective:\r\n "+obj);
      writer.write("\r\nEducation: \r\n - "+ed1+"\r\n - "+ed2);
      writer.write("\r\nWork Experience:");
      writer.write("\r\n- "+wrk);
      writer.write("\r\nSkills: \r\n - "+skill1+"\r\n - "+skill2);
      writer.flush();
      writer.close();
      //Creates a FileReader Object
      FileReader fr = new FileReader(file); 
      char [] a = new char[50];
      fr.read(a); // reads the content to the array
      //for(char c : a)
        //  System.out.print(c); //prints the characters one by one
      fr.close();
        }
        catch(Exception e) {
            System.out.print("exception");
        }
    }
    public void print() {
        System.out.print("ehllo");
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resumeButton) { //resume
            menu = 2;
            removeAll();
            add(resumeNameText);
            add(createResumeButton);
            add(contact);
            add(objective);
            add(skills);
            add(work);
            add(education);
        }
        else if(e.getSource() == createResumeButton) {//create resume
            resume = true;
            wrk = work.getText();
            obj = objective.getText();
            ed1 = education.getText();
            if(ed1.contains(";"))                    //does it contain ";"? if so, substring. So it does not throw error when semi colon is not included 
                ed1 = ed1.substring(0,ed1.indexOf(';'));
            ed2 = education.getText();
            if(ed2.contains(";")) 
                ed2 = ed2.substring(ed2.indexOf(';')+1);
            skill1 = skills.getText();
            if(skill1.contains(";")) 
                skill1 = skill1.substring(0,skill1.indexOf(';'));
            skill2 = skills.getText();
            if(skill2.contains(";")) 
                skill2 = skill2.substring(skill2.indexOf(';')+1);
            email = contact.getText();
            if(email.contains(";")) 
                email = email.substring(0,email.indexOf(';'));
            phone = contact.getText();
            if(phone.contains(";")) 
                phone = phone.substring(phone.indexOf(';')+1); 
            resumeName = resumeNameText.getText();
        }
        else if(e.getSource() == storyButton) { //story
            menu = 1;
            removeAll();
            add(storyNoun);
            add(storyAdjective);
            add(storyVerb);
            add(storyPerson);
            add(storyNumber);
            add(storyPluralNoun);
            add(createStory);
        }
        else if(e.getSource() == createStory) {//create story
           noun = storyNoun.getText();
           adjective = storyAdjective.getText();
           verb = storyVerb.getText();
           person = storyPerson.getText();
           number = storyNumber.getText();
           pluralNoun = storyPluralNoun.getText();
           story = true;
        }
        else if(e.getSource() == exit) {//back to main menu
            removeAll(); 
            menu = 0;
        }
        else if(e.getSource() == createFile) {
            fileNum++;
            createFile();
            fileCreated = true;
            
        }
        repaint();
    }
}
