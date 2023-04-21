package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score){
        setBounds(30,0,1300,750);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/score.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,0,300,250);
        add(image); 
        
        JLabel heading = new JLabel("Thankyou " + name + " for playing Trivia Quiz ");
        heading.setBounds(400,250,600,100);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 28));
        add(heading);
        
        //score display
        JLabel dscore = new JLabel("Your score is " + score);
        dscore.setBounds(550,350,600,100);
        dscore.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(dscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(525,450,200,40);
        submit.setFont(new Font("Tahome", Font.PLAIN, 22));
        submit.setBackground(new Color(143,0,255));
        submit.setForeground(Color.white);
        submit.addActionListener(this);            
        add(submit);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args)
    {
        new Score("user", 0);
    }

    
}
