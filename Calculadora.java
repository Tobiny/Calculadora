import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.math.*;

public class Calculadora implements ActionListener {

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


    private String n[] = {"", ""};
    private String t = "";
    private int c = 0;
    private int ope = 0;
    private int resuelto = 0;
    private int contPunto[] = {0, 0};
    public void actionPerformed(ActionEvent e) {
        JButton s = (JButton) e.getSource();
        
        //Evaluando cada botón
        if (resuelto != 1) {
            if(s == numButton[0]){
                //0
                n[c] = n[c] + 0;
                t = t + '0';
            }
            if(s == numButton[1]){
                //1
                n[c] = n[c] + 1;
                t = t.concat("1");
            }
            if(s == numButton[2]){
                //2
                n[c] = n[c] + 2;
                t = t + '2';
            }
            if(s == numButton[3]){
                //3
                n[c] = n[c] + 3;
                t = t + '3';
            }
            if(s == numButton[4]){
                //4
                n[c] = n[c] + 4;
                t = t + 4;
            }
            if(s == numButton[5]){
                //5
                n[c] = n[c] + 5;
                t = t + 5;
            }
            if(s == numButton[6]){
                //6
                n[c] = n[c] + 6;
                t = t + 6;
            }
            if(s == numButton[7]){
                //7
                n[c] = n[c] + 7;
                t = t + 7;
            }
            if(s == numButton[8]){
                //8
                n[c] = n[c] + 8;
                t = t + 8;
            }
            if(s == numButton[9]){
                //9
                n[c] = n[c] + 9;
                t = t + 9;
            }
        }
        if(s == opeButton[0]){
            //=
            efectuaOp(n, ope);
            resuelto = 1;
        }
        if(s == opeButton[1]){
            //+
            
            if(valida(t, c)){
                t = t + '+';
                c++;
                ope = 1;
            }
        }
        if(s == opeButton[2]){
            //-

            if(t.isEmpty()){
                t = t + '-';
            } else if(valida(t, c)){
                t = t + '-';
                c++;
                ope = 2;
            }

        }
        if(s == opeButton[3]){
            //*
            ope = 3;
            if(valida(t, c)){
                t = t + '*';
                c++;
            }

        }
        if(s == opeButton[4]){
            //÷ 
            ope = 4;
            if(valida(t, c)){
                t = t + '/';
                c++;
            }
        }
        if(s == opeButton[5]){
            //π
            n[c] = "3.14159265359";
            if (c==1) {
                t = n[0] + operando() + n[1];
            } else {
                t = n[0];
            }
            
        }
        if(s == opeButton[6]){
            //√
            
            if(valida(t, c) && ope != 5){
                if(c!=1){
                    t = '√' + t;
                    ope = 5;
                    efectuaOp(n, ope);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, la raíz es de un solo número", "Error - Raíz", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            
        }
        if(s == opeButton[7]){
            //C
            //borrar();
            t ="";
            c = 0;
            n[0] = "";
            n[1] = "";
            resTxtF.setText("");
            resuelto = 0;
            contPunto[0] = 0;
            contPunto[1] = 0;
        }
        if(s == opeButton[8]){
            //^
            ope = 6;
            t = t + '^';
        }
        if(s == pButton){
            //.

            if(!t.isEmpty()){
                if((!(t.charAt(t.length()-1) == '-' ||  t.charAt(t.length()-1) == '+' || t.charAt(t.length()-1) == '*' || t.charAt(t.length()-1) == '/' || t.charAt(t.length()-1) == '-' || t.charAt(t.length()-1) == '^' ||  t.charAt(t.length()-1) == '√')) && contPunto[c]!=1){
                    n[c] = n[c] + '.';
                    t = t + '.';
                    contPunto[c] = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en su escritura del punto", "Error - Punto", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        }


        //c++;
        opeTxtF.setText(t);
        
    }
    private void efectuaOp(String[] n, int ope){
        double a, b;
        a = Double.parseDouble(n[0]);
        b = 0;
        if(ope != 5) b = Double.parseDouble(n[1]);
        switch (ope) {
            case 1:
                resTxtF.setText(Double.toString(a+b));
                
                break;
            case 2:
                resTxtF.setText(Double.toString(a-b));
                break;
            case 3:
                resTxtF.setText(Double.toString(a*b));
                break;
            case 4:
                resTxtF.setText(Double.toString(a/b));
                break;
            case 5:
                resTxtF.setText(Double.toString(Math.sqrt(a)));
                break;
            case 6:
                resTxtF.setText(Double.toString(Math.pow(a,b)));
                break;
        
            default:
                break;
        }
    }
    private char operando(){
        char opera ='-';
        switch (ope) {
            case 1:
                opera = '+';

                break;
            case 2:
                opera = '-';
                break;
            case 3:
                opera = '*';
                break;
            case 4:
                opera = '/';
                break;
            case 6:
                opera = 'r';
                break;
        
            default:
                break;
        }
        return opera;
    }
    private boolean valida(String a, int l){
        boolean c = false;
        if(!t.isEmpty()){
            if((!(a.charAt(a.length()-1) == '-' ||  a.charAt(a.length()-1) == '+' || a.charAt(a.length()-1) == '*' || a.charAt(a.length()-1) == '/' || a.charAt(a.length()-1) == '-' || a.charAt(a.length()-1) == '^')) && l != 1){
                c = true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo algún error en su escritura", "Error - Escritura", JOptionPane.WARNING_MESSAGE);
            }
        } else JOptionPane.showMessageDialog(null, "Hubo algún error en su escritura", "Error - Escritura", JOptionPane.WARNING_MESSAGE);
        return c;
    }

}
