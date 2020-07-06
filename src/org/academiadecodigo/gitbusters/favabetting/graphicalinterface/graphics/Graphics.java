package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.graphics;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics implements ActionListener {
    JFrame frame=new JFrame("FAVA");
    Container mainContainer;
    JButton betBnt;
    JLabel[] horseLabel=new JLabel[6];
    JPanel topPanel=new JPanel();

    JTextField textfield;
    public Graphics(){
        setLayout();
    }

    private void setLayout(){

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));

        mainContainer=frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        topPanel.setLayout(new FlowLayout(5));
        topPanel.setBorder(new LineBorder(Color.BLACK,2));

        mainContainer.add(topPanel,BorderLayout.NORTH);

        topButtons();
        //textfield = new JTextField("chat",60);
        //frame.getContentPane().add(textfield);


        frame.setVisible(true);
        initialiseLabels();

    }

    private void initialiseLabels(){
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
        for (int i = 0; i < horseLabel.length; i++) {
            horseLabel[i]=new JLabel("Horse "+i);
        }
    }

    private void topButtons(){
        JButton topBnt1=new JButton("chat");
        JButton topBnt2=new JButton("Bet");
        JButton topBnt3=new JButton("Quit");
        JTextField text1=new JTextField(20);
        topPanel.add(topBnt1);
        topPanel.add(topBnt2);
        topPanel.add(topBnt3);
        topPanel.add(text1);
        text1.addActionListener(this);
        topBnt1.addActionListener(this);
        topBnt2.addActionListener(this);
        topBnt3.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getID());
        System.out.println(e.paramString());
        if(e.getActionCommand().equals("Quit")){
            topPanel.setVisible(false);
        }
    }
}
