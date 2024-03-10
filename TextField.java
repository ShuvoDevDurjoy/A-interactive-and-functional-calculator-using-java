
import javax.swing.*;
import java.awt.*;

class TextField extends JTextField
{
    TextField()
    {
        setBorder(null);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setHorizontalAlignment(JTextField.RIGHT);
        setFont(new Font(null,Font.PLAIN,50));
        setAlignmentY(56);
        setText("0");
    }
}

