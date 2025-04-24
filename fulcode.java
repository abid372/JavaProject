import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JavaTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2, b3;
    ButtonGroup bg;
    int current = 0, x = 1, y = 1, now = 0, count = 0;
    int m[] = new int[10];

    JavaTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);

        b3 = new JButton("Back");
        b3.setForeground(Color.red);
        b3.setBounds(300, 10, 100, 20);
        add(b3);
        b3.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            this.setVisible(false);
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct answers: " + count);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Ques: Which one among these is not a primitive datatype?");
            jb[0].setText("int");
            jb[1].setText("float");
            jb[2].setText("boolean");
            jb[3].setText("char");
        }
        if (current == 1) {
            l.setText("Ques: Which class is the parent class of all classes in java?");
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Object");
            jb[3].setText("ActionEvent");
        }
        if (current == 2) {
            l.setText("Ques: Which package is directly available to our classes?");
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Get");
            jb[3].setText("lang");
        }
        if (current == 3) {
            l.setText("Ques: String class is defined in __ package.");
            jb[0].setText("lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("Get");
        }
        if (current == 4) {
            l.setText("Ques: Which institute is best for 'java coaching'");
            // Missing options in original code
        }
        if (current == 5) {
            l.setText("Ques: Which one among these is not a keyword?");
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("Ques: Which one among these is not a class?");
            jb[0].setText("Applet");
            jb[1].setText("Actionperformed");
            jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if (current == 7) {
            l.setText("Ques: Which among these is not a function of Object Class?");
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");
            jb[3].setText("setDocumentBase");
        }
        if (current == 9) {
            l.setText("Ques: Which one among these is not a valid component?");
            jb[0].setText("Button");
            jb[1].setText("List");
            jb[2].setText("ButtonGroup");
            jb[3].setText("TextArea");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[3].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[2].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[1].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[1].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new JavaTest("Online Test Of Java");
    }
}