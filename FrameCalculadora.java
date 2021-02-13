

public class FrameCalculadora extends JFrame {

    public FrameCalculadora() { 
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 430);
        setResizable(false);
        setLayout(new FlowLayout());
    

        JPanel textJPanel = new JPanel(new BorderLayout());
        textJPanel.setSize(300,100);
        textJPanel.setPreferredSize(new Dimension(280, 100));

        JTextField rJTextField = new JTextField("Resultado");
        JTextField oJTextField = new JTextField("Operación");
        textJPanel.add(rJTextField, BorderLayout.CENTER);
        textJPanel.add(oJTextField, BorderLayout.SOUTH);
        
        JPanel numJPanel = new JPanel(new GridLayout(5,4, 2, 2));
        numJPanel.setPreferredSize(new Dimension(280, 280));
        
        add(textJPanel);
        add(numJPanel);
        

        JButton numButton[] = new JButton[10];
        JButton opeButton[] = new JButton[9];
        JButton pButton = new JButton(".");
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
        for (int i = 0; i < opeButton.length; i++) {
            opeButton[i].addActionListener(this);
        }

        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = new JButton(""+i);
            numButton[i].addActionListener(this);
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


    }

}
