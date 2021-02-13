import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class Calculadora implements ActionListener {
    private int c = 0;
    private JFrame frame;
    private JPanel txtPanel, numPanel;
    private JTextField resTxtF, opeTxtF;
    private JButton numButton[], opeButton[], pButton;
    private double res;
    
    public Calculadora(){
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 430);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        //Panel de los textos
        txtPanel = new JPanel(new BorderLayout());
        txtPanel.setSize(300,100);
        txtPanel.setPreferredSize(new Dimension(280, 100));

        resTxtF = new JTextField("Resultado");
        opeTxtF =new JTextField("Operación");

        txtPanel.add(resTxtF, BorderLayout.CENTER);
        txtPanel.add(opeTxtF, BorderLayout.SOUTH);

        //Panel de los botones
        numPanel = new JPanel(new GridLayout(5,4, 2, 2));
        numPanel.setPreferredSize(new Dimension(280, 280));
        
        frame.add(txtPanel);
        frame.add(numPanel);
        

        numButton = new JButton[10];
        opeButton = new JButton[9];
        pButton = new JButton(".");
        pButton.addActionListener(this);

        opeButton[0] = new JButton("=");
        opeButton[1] = new JButton("+");
        opeButton[2] = new JButton("-");
        opeButton[3] = new JButton("*");
        opeButton[4] = new JButton("/");
        opeButton[5] = new JButton("π");
        opeButton[6] = new JButton("√");
        opeButton[7] = new JButton("C");
        opeButton[8] = new JButton("^");
        //Añadimos a todos el ActionListener
        for (int i = 0; i < opeButton.length; i++) {
            opeButton[i].addActionListener(this);
        }
        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = new JButton(""+i);
            numButton[i].addActionListener(this);
        }

        numPanel.add(opeButton[7]);
        numPanel.add(opeButton[5]);
        numPanel.add(opeButton[4]);
        numPanel.add(opeButton[6]);
        numPanel.add(numButton[7]);
        numPanel.add(numButton[8]);
        numPanel.add(numButton[9]);
        numPanel.add(opeButton[3]);

        numPanel.add(numButton[4]);
        numPanel.add(numButton[5]);
        numPanel.add(numButton[6]);

        numPanel.add(opeButton[2]);

        numPanel.add(numButton[1]);
        numPanel.add(numButton[2]);
        numPanel.add(numButton[3]);
        numPanel.add(opeButton[1]);

        numPanel.add(numButton[0]);
        numPanel.add(pButton);
        numPanel.add(opeButton[0]);

        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Calculadora();
    }

    public void actionPerformed(ActionEvent e) {
        JButton s = (JButton) e.getSource();
        String temp = "";
        //Evaluando cada botón
        if(s == numButton[0]){
            //0

        }
        if(s == numButton[1]){
            //1

        }
        if(s == numButton[2]){
            //2

        }
        if(s == numButton[3]){
            //3

        }
        if(s == numButton[4]){
            //4

        }
        if(s == numButton[5]){
            //5

        }
        if(s == numButton[6]){
            //6

        }
        if(s == numButton[7]){
            //7

        }
        if(s == numButton[8]){
            //8

        }
        if(s == numButton[9]){
            //9

        }
        if(s == opeButton[0]){
            //=

        }
        if(s == opeButton[1]){
            //+

        }
        if(s == opeButton[2]){
            //-

        }
        if(s == opeButton[3]){
            //*

        }
        if(s == opeButton[4]){
            //÷ 

        }
        if(s == opeButton[5]){
            //π
            temp = temp + 3.1416;
        }
        if(s == opeButton[6]){
            //√

        }
        if(s == opeButton[7]){
            //C

        }
        if(s == opeButton[8]){
            //^

        }
        if(s == pButton){
            //.
            
        }


        //c++;
        opeTxtF.setText(temp);
    }

}
