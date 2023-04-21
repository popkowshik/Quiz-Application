
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
    
    String name;
    JButton start,back;
    
    Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel(" Welcome " + name + " to Trivia Quiz ");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Verdana", Font.BOLD, 20));
        heading.setForeground(new Color (191, 87, 0));
        add(heading);
         
        JLabel rules = new JLabel();
        rules.setBounds(20,50,900,350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));  
        rules.setText(
            "<html>"+
                 "1.Top three teams will qualify for the final round based on the highest scores obtained." + "<br><br>"+  
                 "2.If there is a tie, then team with maximum number of correct starred questions is considered." + "<br><br>"+
                 "3.In case of any disputes, the decision taken by the quizmaster or the quiz organizers shall be considered final." + "<br><br>"+
                 "4.No electronic gadgets or equipment is allowed during the preliminary round." + "<br><br>"+
                 "5.Any kind of written or printed material is not allowed." + "<br><br>"+
                 "6.Any team found using unfair means shall be immediately disqualified." + "<br><br><br>"+
                 "Final Round" + "<br>"+
                 "-------------------------------------------------------------------------------------------------------------------------------------------------"+ "<br>"+
                 "A dynamic quiz will be conducted. Format will be conveyed only to the qualified team." +  
            "<html>"        
            );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(400,450,120,30);
        back.setBackground(new Color (191, 87, 0));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("start");
        start.setBounds(600,450,120,30);
        start.setBackground(new Color (191, 87, 0));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);
        
        setSize(1100,600);
        setLocation(150,100);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == start)
        {
            setVisible(false);
            new Quiz(name);
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
   
    public static void main(String[] args)
    {
        //user is a default
        new Rules("User");
    }

   
}

