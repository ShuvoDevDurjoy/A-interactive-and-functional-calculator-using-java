import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;;

public class Main extends JFrame
{

    JPanel jp;
    TextField t ;
    JLabel l ;

    CustomButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bp,bm,bs,bd,be,bc,bb,bpoint,bper,bans;
    Main()
    {
        //initializing all the variables (buttons , textfield )
        l = new JLabel("");
        t = new TextField();
        jp = new JPanel();
        b1 = new CustomButton(t,l,"1");
        b2 = new CustomButton(t,l,"2");
        b3 = new CustomButton(t,l,"3");
        b4 = new CustomButton(t,l,"4");
        b5 = new CustomButton(t,l,"5");
        b6 = new CustomButton(t,l,"6");
        b7 = new CustomButton(t,l,"7");
        b8 = new CustomButton(t,l,"8");
        b9 = new CustomButton(t,l,"9");
        b0 = new CustomButton(t,l,"0");
        bp = new CustomButton(t,l,"+");
        bs = new CustomButton(t,l,"-");
        bm = new CustomButton(t,l,"x");
        bd = new CustomButton(t,l,"/");
        be = new CustomButton(t,l,"=");
        bc = new CustomButton(t,l,"C");
        bb = new CustomButton(t,l,"DEL");
        bans = new CustomButton(t,l,"ANS");
        bper = new CustomButton(t,l,"%");
        bpoint = new CustomButton(t,l,".");

        //setting the main frame property
        setTitle("Calculator");
        setSize(427,625);
        setLocation(500,50);
        setLayout(null);
        //using different color from here color can be changed
        getContentPane().setBackground(Color.cyan);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //setting bounds of label ( that is the output area )
        l.setBounds(13,15,400,50);
        l.setBackground(Color.BLACK);
        l.setForeground(Color.WHITE);
        l.setOpaque(true);
        l.setFont(new Font(null, Font.PLAIN,24));
        l.setHorizontalAlignment(JLabel.RIGHT);
        l.setHorizontalTextPosition(JLabel.LEFT);
        l.setVerticalAlignment(JLabel.BOTTOM);
        

        //grid layout for the buttons 
        GridLayout g = new GridLayout(5,4);
        
        //
        g.setHgap(5);
        g.setVgap(5);
        jp.setLayout(g);
        jp.add(bc);
        jp.add(bb);
        jp.add(bans);
        jp.add(bper);
        jp.add(b9);
        jp.add(b8);
        jp.add(b7);
        jp.add(bp);
        jp.add(b6);
        jp.add(b5);
        jp.add(b4);
        jp.add(bs);
        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(bm);
        jp.add(bpoint);
        jp.add(b0);
        jp.add(be);
        jp.add(bd);
        jp.setBackground(Color.BLACK);
        jp.setBounds(13,125,400,450);
        t.setBounds(13,65,400,50);

        //adding the text field that is input field
        this.add(t);
        //adding the output area that is a label
        this.add(l);
        //adding the button panel to the main frame
        this.add(jp);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
