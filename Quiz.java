
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener{
    
    String questions[][] = new String[10][5];
    String answers [][] = new String[10][2];
    String useranswers [][] = new String [10][1];
    JLabel qno,question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next,lifeline,submit;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0; 
    
    String name;
    
    Quiz(String name)
    {
        this.name = name;
        setBounds(30,0,1300,850);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/Quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1300,350);
        add(image); 
        
        qno = new JLabel();
        qno.setBounds(100,400,50,30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150,400,900,30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "HashSet internally uses?";
        questions[0][1] = "Set";
        questions[0][2] = "HashMap";
        questions[0][3] = "List";       
        questions[0][4] = "Collection";
        
        questions[1][0] = "The most used interfaces from the collection framework are?";
        questions[1][1] = "Map";
        questions[1][2] = "List.";      
        questions[1][3] = "Set";
        questions[1][4] = "Interfaces";        
                
        questions[2][0] = "What guarantees type-safety in a collection?";        
        questions[2][1] = "Generics";        
        questions[2][2] = "Abstract classes";        
        questions[2][3] = "Interfaces";        
        questions[2][4] = "Collection";        
                
        questions[3][0] = "Which of those is synchronized?";        
        questions[3][1] = "Vector";        
        questions[3][2] = "LinkedList";        
        questions[3][3] = "ArrayList";        
        questions[3][4] = "None of the above";        
                
        questions[4][0] = "The root interface of Java collection framework hierarchy is ";        
        questions[4][1] = "List/Set";      
        questions[4][2] = "Root";        
        questions[4][3] = "Collection";        
        questions[4][4] = "Collections";  
                
        questions[5][0] = "ArrayList implements that of the following?";        
        questions[5][1] = "All of these";        
        questions[5][2] = "RandomAccess" ;         
        questions[5][3] = "Cloneable";        
        questions[5][4] = "List";        
                
        questions[6][0] = "Which of those permits the storage of the many null values?";        
        questions[6][1] = "All of these";  
        questions[6][2] = "List";        
        questions[6][3] = "Set";        
        questions[6][4] = "None of these";        
                
        questions[7][0] = "nextIndex() and previousIndex() are methods of which interface?";        
        questions[7][1] = "Iterator";        
        questions[7][2] = "NextPreviousIterator";        
        questions[7][3] = "ListIterator";        
        questions[7][4] = "IndexIterator";        
                
        questions[8][0] = "Vector extends that of these?";        
        questions[8][1] = "AbstractList";        
        questions[8][2] = "ArrayList";        
        questions[8][3] = "LinkedList";        
        questions[8][4] = "None";
        
        questions[9][0] = "LinkedList implements?";
        questions[9][1] = "Both of above";
        questions[9][2] = "List";
        questions[9][3] = "Deque";
        questions[9][4] = "None of the above";
                
        answers[0][1] = "Set";
        answers[1][1] = "Map";
        answers[2][1] = "Generics";
        answers[3][1] = "Vector";
        answers[4][1] = "List/Set";
        answers[5][1] = "All of these";
        answers[6][1] = "All of these";
        answers[7][1] = "Iterator";
        answers[8][1] = "AbstractList";
        answers[9][1] = "Both of above";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170,450,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);  
        
        opt2 = new JRadioButton();
        opt2.setBounds(170,500,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2); 
        
        opt3 = new JRadioButton();
        opt3.setBounds(170,550,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3); 
        
        opt4 = new JRadioButton();
        opt4.setBounds(170,600,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4); 
        
        //choose any one option thats why we using buttongroup 
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);        
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(950,470,200,40);
        next.setFont(new Font("Tahome", Font.PLAIN, 22));
        next.setBackground(new Color(0,171,240));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        
        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(950,530,200,40);
        lifeline.setFont(new Font("Tahome", Font.PLAIN, 22));
        lifeline.setBackground(new Color(0,171,240));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);
        
        
        submit = new JButton("Submit");
        submit.setBounds(950,590,200,40);
        submit.setFont(new Font("Tahome", Font.PLAIN, 22));
        submit.setBackground(new Color(0,171,240));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);     
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next){
            repaint();
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if(groupoptions.getSelection() == null){
                useranswers[count][0] = ""; //if you dont select any option it will empty " " 
            }else{
                //get.ActionCommand is used for store the value in the username
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        }else if(ae.getSource() == lifeline){
            if(count == 1 || count == 2 || count == 3 || count == 4 || count == 5 || count == 6 || count == 7 ||count == 8 || count == 9  || count == 10 )
            {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else {
                opt1.setEnabled(true);
                opt4.setEnabled(true);
            }
            lifeline.setEnabled(false);
        }else if(ae.getSource() == submit){ 
            ans_given = 1;
            if(groupoptions.getSelection() == null){
               useranswers[count][0] = ""; //if you dont select any option it will empty " " 
            }else{
                     //get.ActionCommand is used for store the value in the username
               useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            for(int i=0; i < useranswers.length; i++)
                {
                    if(useranswers[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }else{
                        score += 0;
                    }
                }
                setVisible(false);//score
                new Score(name, score);
        }
               
        } 

    public void paint(Graphics g){
        super.paint(g);
        
        String time = " Time Left- " + timer + " seconds ";//15
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 22));
        
        if(timer > 0)
        {
            g.drawString(time, 950, 450);
        }
        else
        {
            g.drawString("Times up!!", 950, 450);
        }
        
        timer--; //14 
        
        //thread.sleep is used for pause the current thread execution 
        //thats the time here used 
        try{
            Thread.sleep(1000);//1000 millisecond = 1 second
            repaint();//its calling paint again
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(ans_given == 1)
        {
            ans_given = 0;
            timer = 15;
        }
        else if(timer < 0){
            timer = 15;
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){//submit button
                if(groupoptions.getSelection() == null){
                    useranswers[count][0] = ""; //if you dont select any option it will empty " " 
                }else{
                    //get.ActionCommand is used for store the value in the username
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for(int i=0; i < useranswers.length; i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score += 10;
                    }else{
                        score += 0;
                    }
                }
                setVisible(false);//score
            }else { //next button          
                if(groupoptions.getSelection() == null){
                    useranswers[count][0] = ""; //if you dont select any option it will empty " " 
                }else{
                    //get.ActionCommand is used for store the value in the username
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;//0 //1 .......
                start(count); 
            }
        }        
    }
    
    
    
    public void start(int count){
    
        qno.setText("" + (count + 1) + " . ");
        question.setText(questions[count][0]);
        //setActionCommand each and every option would be stored 
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();// next question won't be same option 
    }
    
    public static void main(String[] args)
    {
         new Quiz("user");
    }

   
}
