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
        opeButton[5] = new JButton("%");
        opeButton[6] = new JButton("1/x");
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
        if(e.getSource() == opeButton[7]){
            opeTxtF.setText("Se presiono C");
        }

        //c++;
        //opeTxtF.setText("Popo "+c);
    }

}
