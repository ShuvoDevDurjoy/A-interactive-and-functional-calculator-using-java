
import javax.swing.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

class CustomButton extends JButton
{
    public static boolean b = false;
    Toolkit toolkit;
    CustomButton (TextField t , JLabel l , String s)
    {
        super(s);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFocusable(false);
        this.setBorder(null);
        this.setFont(new Font("MV Boli",Font.PLAIN,34));
        toolkit = getToolkit();
        addActionListener((ae)->onClick(t,l,ae));
    }


    public void onClick(TextField t , JLabel l ,  ActionEvent ae )
    {
        String ac = ae.getActionCommand();
        String text = t.getText();
        String tb="", lt="", lg=l.getText();


        if(ac.equals("C"))
        {
            tb="0";
            lt="";
            b=false;
        }
        else if(ac.equals("DEL"))
        {
            if(text.endsWith("."))
            { b=false;
                tb = text.substring(0, text.length() - 1);}
            else if(text.length()>1) {
                tb = text.substring(0, text.length() - 1);
            }
            else
            {
                tb="0";
                lt="";
            }
        }
        else if(ac.equals("%"))
        {
            tb=""+ (Double.parseDouble(signOff(t)))/100;
            b=true;
        }
        else if(ac.equals("ANS"))
        {
            tb=signOff(t);
        }
        else if(ac.equals("="))
        {
            if(text.equals("ERROR"))
            {
                tb=lg.substring(0,lg.length()-2);
                lt="";
            }
            else if(lg.endsWith("="))
            {
                tb=lg.substring(0,lg.length()-1);
                lt="";
            }
            else {
                lt=text + "=";
                tb=signOff(t);
            }

        }
        else if(text.equals("0")|| text.isEmpty()||text.equals("0.0"))
        {
            if((ac.charAt(0)>=48&&ac.charAt(0)<=57)||ac.equals("-")||ac.equals("."))
            {
                text="";
                tb=ac;
                if(ac.equals("."))
                {
                    b=true;
                }
            }
            else
            {
                tb="0";
            }
        }
        else if(ac.equals("."))
        {
            if(b)
            {
                tb = text;
            }
            else {
                //System.out.println("here we are ");
                tb = text+ac;
                b=true;
            }
        }
        else if((text.charAt(text.length()-1)<48||text.charAt(text.length()-1)=='x')&&(ac.charAt(0)<48||ac.charAt(0)=='x'))
        {
            if(text.endsWith("-")||text.endsWith("."))
            {
                if(text.endsWith("-")&&ac.equals("."))
                    tb=text+ac;
                else
                    tb = text;
            }
            else if((ac.length()!=1)&&(text.charAt(text.length()-2)<48||text.charAt(text.length()-2)=='x'))
            {
                //System.out.println("here in if");
                tb = text;
            }
            else if((text.endsWith("x")||text.endsWith("/")||text.endsWith("+"))&&(ac.equals("-")||ac.equals(".")))
            {
                tb=text+ac;
            }
            else{
                char[] d = text.toCharArray();
                d[d.length-1]=ac.charAt(0);
                tb=new String(d);}

        }
        else
        {
            if(lg.endsWith("=")&&ac.compareTo("0")>=0&&!ac.equals("x"))
            {
                if((lg.charAt(lg.length()-2)<48||lg.charAt(lg.length()-2)=='x')) {
                    tb=lg.substring(0, lg.length() - 1)+ac;
                    lt="";
                }
                else {
                    tb=ac;
                    lt="";
                }
            }
            else if(lg.endsWith("=")&&(ac.compareTo("0")<0||ac.equals("x")))
            {
                if((lg.charAt(lg.length()-2)<48||lg.charAt(lg.length()-2)=='x')) {
                    tb=lg.substring(0, lg.length() - 2)+ac;
                    lt="";
                }
                else
                {
                    tb=text+ ac;
                    lt="";
                }
            }

            else {
                if((ac.charAt(0)<48||ac.charAt(0)=='x'))
                {
                    b=false;
                }
                tb=text + ac;
                lt="";
            }
        }

        t.setText(tb);
        l.setText(lt);
    }
    public String signOff(TextField t)
    {
        char[] c = {'/','x'};
        String s = t.getText();
        for(int i = 0 ; i < 2 ; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == c[i]) {
                    s = solve(s, j);
                    if(s.equals("ERROR"))
                    {
                        return "ERROR";
                    }
                    j = 0;
                }
            }
        }
        for(int j = 0 ; j< s.length();++j)
        {
            if(s.charAt(j)=='+'||s.charAt(j)=='-')
            {
                s=solve(s,j);
                j=0;
            }
        }

        return s;
    }

    public String solve(String s , int n)
    {
        double value1 =0, value2 =0;int i , j , m=1;
        double a=10,x =1;
        int c = - 1,d=-1;
        for(i= n-1;i>=0&&(s.charAt(i)>=48||s.charAt(i)=='-'||s.charAt(i)=='.')&&s.charAt(i)!='x';--i)
        {
            d=0;
            if(i==0&&s.charAt(i)=='-')
            {
                value1*=-1;
            }
            else if(s.charAt(i)=='.')
            {
                value1 = value1/(m*1.0);
                m=1;
            }
            else if(s.charAt(i)=='-'&&s.charAt(i-1)<48)
            {
                value1*=-1;
            }
            else if(s.charAt(i)=='-'&&s.charAt(i-1)>=48) {
                break;
            }
            else {
                value1 = value1 + (s.charAt(i)-48.0)*m;
                m*=10;
            }
        }
        if(n+2<s.length()&&s.charAt(n+1)=='-')
        {
            j=n+2;
        }
        else {
            j=n+1;
        }
        for(;j<s.length()&&((s.charAt(j)>=48||s.charAt(j)=='.')&&s.charAt(j)!='x');++j)
        {c=0;
            if(s.charAt(j)=='.')
            {x=0.1;
                m=2;}
            a=a*x;
            if(s.charAt(j)=='.')
                continue;
            else if(m==2)
                value2 = value2+(s.charAt(j)-48)*a;
            else
                value2 = value2 * a + (s.charAt(j) - 48);
            //System.out.println("here value2 is : "+value2);

        }
        if(c==0&&value2==0&&s.charAt(n)=='/')
        {
            return "ERROR";
        }
        if(n+1<s.length()&&s.charAt(n+1)=='-')
        {
            value2*=-1;
        }
        if((c==-1||d==-1)&&(s.charAt(n)=='x'||s.charAt(n)=='/'))
        {
            if(value1==0)
                value1 = 1;
            if(value2==0)
                value2 =1;
        }
        String t = new String(s.toCharArray(), j, s.length() - j);
        switch (s.charAt(n)) {
            case '/' ->
                    s = s.substring(0, i + 1) + (double)Math.round((value1 / value2)*10000000)/10000000 +t;
            case 'x' ->
                    s = s.substring(0, i + 1) + (double)Math.round((value1 * value2)*10000000)/10000000+t;
            case '+' ->
                    s = s.substring( 0, i + 1) + (double)Math.round((value1 + value2)*10000000)/10000000+t;
            case '-' ->
                    s = s.substring(0, i + 1) +(double)Math.round((value1 - value2)*1000000)/1000000+t;
        }
        return s ;
    }

}