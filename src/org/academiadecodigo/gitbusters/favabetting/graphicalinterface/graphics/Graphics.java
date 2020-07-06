package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.graphics;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Graphics implements ActionListener {
    private Client client;
    JFrame frame=new JFrame("FAVA");
    Container mainContainer;
    JPanel topPanel=new JPanel();
    public JPanel westPanel =new JPanel();
    private JTextArea raceStatus=new JTextArea("",10,10);
    private List<String> textLog =new ArrayList<>();
    private List<HorseMenu>horseList=new ArrayList<>();
    private JTextField balance;

    JTextField textfield;
    public Graphics(Client client){
        this.client=client;
        setLayout();
    }

    private void setLayout(){

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        mainContainer=frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        topPanel.setLayout(new FlowLayout(5));
        topPanel.setBorder(new LineBorder(Color.BLACK,2));

        westPanel.setLayout(new GridLayout(10,1,10,10));
        westPanel.setBorder(new LineBorder(Color.BLACK,2));

        mainContainer.add(topPanel,BorderLayout.NORTH);
        mainContainer.add(westPanel,BorderLayout.CENTER);

        topButtons();
        createHorseMenu();
        //textfield = new JTextField("chat",60);
        //frame.getContentPane().add(textfield);


        frame.setVisible(true);

    }



    private void topButtons(){
        JButton topBnt1=new JButton("chat");
        JButton topBnt2=new JButton("Bet");
        JButton topBnt3=new JButton("Quit");
        balance=new JTextField(20);
        balance.setEnabled(false);
        balance.setDisabledTextColor(Color.black);
        topPanel.add(topBnt1);
        topPanel.add(topBnt2);
        topPanel.add(topBnt3);
        topPanel.add(balance);
        topBnt1.addActionListener(this);
        topBnt2.addActionListener(this);
        topBnt3.addActionListener(this);
    }

    private void createHorseMenu(){
        JPanel horseGrid=new JPanel();
        JLabel horseName=new JLabel("Horse Name");
        JLabel horseDescription=new JLabel("Description");
        JLabel odds=new JLabel("Odd");
        JLabel wins=new JLabel("Wins");
        JLabel races=new JLabel("Races");
        horseGrid.setLayout(new GridLayout(1,7,10,10));
        horseGrid.add(horseName);
        horseGrid.add(horseDescription);
        horseGrid.add(odds);
        horseGrid.add(wins);
        horseGrid.add(races);
        horseGrid.add(new JLabel("Bet Amount"));
        horseGrid.add(new JLabel());
        westPanel.add(horseGrid);
        for (int i = 0; i <6 ; i++) {
            HorseMenu h=new HorseMenu(i);
            horseList.add(h);
        }
        raceStatus.setEnabled(false);
        raceStatus.setDisabledTextColor(Color.BLACK);
        westPanel.add(raceStatus);
    }

    public void writeStatus(String text){
        textLog.add(0,text);
        if (textLog.size()==10){
            textLog.remove(textLog.size()-1);
        }
        StringBuilder builder=new StringBuilder();

        for(String entr:textLog){
            builder.append(entr).append("\n");
        }
        raceStatus.setDisabledTextColor(Color.BLACK);
        raceStatus.setText(builder.toString());
    }

    public void writeStatus(String text,Color color){
        textLog.add(0,text);
        if (textLog.size()==10){
            textLog.remove(textLog.size()-1);
        }
        StringBuilder builder=new StringBuilder();

        for(String entr:textLog){
            builder.append(entr).append("\n");
        }
        raceStatus.setDisabledTextColor(color);
        raceStatus.setText(builder.toString());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getID());
        System.out.println(e.paramString());
        if(e.getActionCommand().equals("Quit")){
            topPanel.setVisible(false);
        }
    }

    //private void

    public class HorseMenu implements ActionListener{
        private int horseN=0;
        private JPanel horseGrid=new JPanel();

        private JLabel horseName=new JLabel("horseName");
        private JLabel horseDescription=new JLabel("description");
        private JLabel odds=new JLabel("odd");
        private JLabel wins=new JLabel("wins");
        private JLabel races=new JLabel("races");
        private JTextField betAmount=new JTextField(5);
        private JButton betBnt=new JButton("Bet");

        HorseMenu(int horseN){
            this.horseN=horseN;
            horseGrid.setLayout(new GridLayout(1,7,10,10));
            horseGrid.add(horseName);
            horseGrid.add(horseDescription);
            horseGrid.add(odds);
            horseGrid.add(wins);
            horseGrid.add(races);
            horseGrid.add(betAmount);
            horseGrid.add(betBnt);
            westPanel.add(horseGrid);
            betBnt.addActionListener(this);
        }

        public void insertHorse(String name,String description,String Odd, String wins,String races, int horseN){
            if(this.horseN!=horseN){
                return;
            }

            horseName.setText(name);
            horseDescription.setText(description);
            odds.setText(Odd);
            this.wins.setText(wins);
            this.races.setText(races);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Bet")){
                int amount=0;
                try {
                    amount=Integer.parseInt(betAmount.getText());
                    int nint=this.horseN+1;
                    client.sendMessage("bet " + nint + " " + amount);
                    client.sendMessage("balance");
                }catch (Exception exception){
                    writeStatus("invalid Bet Amount",Color.RED);
                }

                System.out.println(betAmount.getText());
            }
        }


    }

    public List<HorseMenu> getHorseList() {
        return horseList;
    }

    public JTextField getBalance() {
        return balance;
    }
}
