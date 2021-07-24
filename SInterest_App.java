import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends Component {
    public static void main(String[] args) {
        Component oo = new Component();
        oo.run();
    } 
}
class Component extends Thread implements ActionListener {
    JLabel lab[] = new JLabel[5];
    JTextField fid[] = new JTextField[3];
    JButton btn[] = new JButton[2];

    public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(510,290);
        frame.setTitle("Simple Interest");

        frame.setLayout(null);
        Font font = new Font(Font.SERIF, Font.BOLD,  15);
        for(int i=0; i<5; i++) {
            lab[i] = new JLabel();
            lab[i].setFont(font);
        }
        for(int i=0; i<3; i++) {
            fid[i] = new JTextField();
            fid[i].setFont(font);
        }
        for(int i=0; i<2; i++) {
            btn[i] = new JButton();
        }
        lab[0].setText("Opening Balance");
        lab[0].setBounds(55, 15, 200, 50);
        lab[1].setText("Yearly Interest");
        lab[1].setBounds(55, 45, 200, 50);
        lab[2].setText("No of Years");
        lab[2].setBounds(55, 75, 200, 50);
        lab[3].setText("Final Balance");
        lab[3].setBounds(55, 105, 200, 50);
        lab[4].setText("0.00");
        lab[4].setBounds(250, 110, 200, 50);

        fid[0].setBounds(250, 30, 170, 22);
        fid[1].setBounds(250, 60, 170, 22);
        fid[2].setBounds(250, 90, 170, 22);

        btn[0].setText("Calculate");
        btn[0].setBounds(165, 190, 90, 30);
        btn[1].setText("Exit");
        btn[1].setBounds(275, 190, 60, 30);

        for(int i=0; i<5; i++) {
            frame.add(lab[i]);
        }
        for(int i=0; i<3; i++) {
            frame.add(fid[i]);
        }
        for(int i=0; i<2; i++) {
            frame.add(btn[i]);
            btn[i].addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if(s.equals("Exit")) System.exit(0);
        else if(s.equals("Calculate")) {
            try {
                double opening = Double.parseDouble(fid[0].getText());
                double rate = Double.parseDouble(fid[1].getText());
                double year = Double.parseDouble(fid[2].getText());
                double ans = opening + (opening * (rate/100)) * year;
                lab[4].setText(Double.toString(ans));
            }
            catch (Exception e) {
                lab[4].setText("Wrong Input");
            }
            
        }
    }
}
