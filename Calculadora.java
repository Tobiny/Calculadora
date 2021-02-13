import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class Calculadora implements ActionListener {

    private JFrame frame;
    private JPanel txtPanel;
    private JPanel numJPanel;
    private JTextField resTxtF;
    private JTextField opeTxtF;
    
    
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
        txtPanel.add(txtPanel, BorderLayout.CENTER);

        //Panel de los botones
        numJPanel = new JPanel(new GridLayout(5,4, 2, 2));
        numJPanel.setPreferredSize(new Dimension(280, 280));
        
        frame.add(textJPanel);
        frame.add(numJPanel);
        

        JButton numButton[] = new JButton[10];
        JButton opeButton[] = new JButton[9];
        JButton pButton = new JButton(".");

        opeButton[0] = new JButton("=");
        opeButton[1] = new JButton("+");
        opeButton[2] = new JButton("-");
        opeButton[3] = new JButton("*");
        opeButton[4] = new JButton("/");
        opeButton[5] = new JButton("%");
        opeButton[6] = new JButton("1/x");
        opeButton[7] = new JButton("C");
        opeButton[8] = new JButton("^");


        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = new JButton(""+i);
        }

        numJPanel.add(opeButton[7]);
        numJPanel.add(opeButton[5]);
        numJPanel.add(opeButton[4]);
        numJPanel.add(opeButton[6]);
        numJPanel.add(numButton[7]);
        numJPanel.add(numButton[8]);
        numJPanel.add(numButton[9]);
        numJPanel.add(opeButton[3]);

        numJPanel.add(numButton[4]);
        numJPanel.add(numButton[5]);
        numJPanel.add(numButton[6]);

        numJPanel.add(opeButton[2]);

        numJPanel.add(numButton[1]);
        numJPanel.add(numButton[2]);
        numJPanel.add(numButton[3]);
        numJPanel.add(opeButton[1]);

        numJPanel.add(numButton[0]);
        numJPanel.add(pButton);
        numJPanel.add(opeButton[0]);

        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Calculadora();
    }
}
