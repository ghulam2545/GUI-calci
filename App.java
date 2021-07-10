import java.util.*;
import java.lang.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//<applet code="App.class" width="330" height="380"> </applet>

public class App extends Applet implements ActionListener {
  TextField tf;
  Button[] btn = new Button[10];
  Button zero,equ,plus,minus,mul,div,clear;
  Label lab;
  Font font = new Font("TimesRoman", Font.BOLD, 18);
  public void init() {
    setLayout(null);

    tf = new TextField(" ");
    tf.setFont(new Font("TimesRoman", Font.BOLD, 19));
    tf.setBounds(50, 40, 230, 29);
    add(tf);

    lab = new Label("designed by : Ghulam Mustafa");
    lab.setBounds(100, 310, 300, 30);
    lab.setFont(new Font("TimesRoman", Font.BOLD, 16));

    btn[7] = new Button("7"); btn[7].setBounds(57, 80, 52, 35);
    btn[8] = new Button("8"); btn[8].setBounds(110, 80, 52, 35);
    btn[9] = new Button("9"); btn[9].setBounds(163, 80, 52, 35);
    equ = new Button("="); equ.setBounds(216, 80, 52, 70);

    btn[6] = new Button("6"); btn[6].setBounds(57, 115, 52, 35);
    btn[5] = new Button("5"); btn[5].setBounds(110, 115, 52, 35);
    btn[4] = new Button("4"); btn[4].setBounds(163, 115, 52, 35);

    btn[1] = new Button("1"); btn[1].setBounds(57, 150, 52, 35);
    btn[2] = new Button("2"); btn[2].setBounds(110, 150, 52, 35);
    btn[3] = new Button("3"); btn[3].setBounds(163, 150, 52, 35);
    minus= new Button("-"); minus.setBounds(216, 150, 52, 35);

    btn[0] = new Button("0"); btn[0].setBounds(57, 185, 52, 35);
    plus = new Button("+"); plus.setBounds(110, 185, 105, 35);
    mul = new Button("*"); mul.setBounds(216, 185, 52, 35);

    clear = new Button("clear"); clear.setBounds(57, 220, 158, 35);
    div = new Button("/"); div.setBounds(216, 220, 52, 35);

    for(int i=0; i<=9; i++) {
      add(btn[i]);
      btn[i].setFont(font);
      btn[i].addActionListener(this);
    }

    plus.setFont(font); add(plus); plus.addActionListener(this);
    equ.setFont(font); add(equ); equ.addActionListener(this);
    minus.setFont(font); add(minus); minus.addActionListener(this);
    mul.setFont(font); add(mul); mul.addActionListener(this);
    clear.setFont(font); add(clear); clear.addActionListener(this);
    div.setFont(font); add(div); div.addActionListener(this);
    add(lab);
  }
  String input = "";
  public void actionPerformed(ActionEvent ae) {
    String str = ae.getActionCommand();
    if(str.equals("0") || str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") ||str.equals("6") ||
    str.equals("7") || str.equals("8") || str.equals("9") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
      input += str;
      tf.setText(input);
    }
    else if(str.equals("clear")) {
      tf.setText(""); input = "";
    }
    else if(str.equals("=")) {
      input = tf.getText();
      String answer = Integer.toString(result(input));
      if(answer.equals("-1")) tf.setText("Error !!!");
      else tf.setText(answer);
      input = "";
    }
  }

  // Algorithm
  public int result (String val) {
    String num1="",num2="";
    int ans = 0;
    int gotOprator = 0;
    char oper = 'a';
    for(int i=0; i<val.length(); i++) {
      if(val.charAt(i)>='0' && val.charAt(i)<='9' && gotOprator==0) {
        num1 += val.charAt(i);
      }
      else if(val.charAt(i)>='0' && val.charAt(i)<='9' && gotOprator==1) {
        num2 += val.charAt(i);
      }
      else if(val.charAt(i)=='+' || val.charAt(i)=='-' || val.charAt(i)=='*' || val.charAt(i)=='/') {
        oper = val.charAt(i);
        gotOprator++;
      }
      if(gotOprator >= 2) {
        return -1;
      }
    }
    if(gotOprator == 1) {
      int n1 = Integer.parseInt(num1);
      int n2 = Integer.parseInt(num2);
      switch(oper) {
        case '+' : ans = n1 + n2; break;
        case '-' : ans = n1 - n2; break;
        case '*' : ans = n1 * n2; break;
        case '/' : ans = n1 / n2; break;
      }
    }
  return ans;
  }
}
