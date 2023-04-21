
package quiz.application;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    //globaly declare
    JButton rules, back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/Login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,-150,550,500);
        add(image);
        
        JLabel heading = new JLabel("Trivia Quiz");
        heading.setBounds(500,150,200,250);
        heading.setFont(new Font("Verdana", Font.BOLD, 20));
        heading.setForeground(new Color (191, 87, 0));
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(300,270,200,100);
        name.setFont(new Font("Mangolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(470,310,250,27);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(tfname);
        
        rules = new JButton("Rules");
        rules.setBounds(400,400,120,30);
        rules.setBackground(new Color (191, 87, 0));
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(600,400,120,30);
        back.setBackground(new Color (191, 87, 0));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(1100,600);
        setLocation(150,100);
        setVisible(true);
        
    }
    
    //ae is the object
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == rules)
        {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
            
        }else if(ae.getSource() == back)
        {
            setVisible(false);
        }
    }
    
    public static void main (String[] args){
       new Login();
    }
    
    

}
