package stancu.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * Created by Stefan on 2015-03-17.
 */
public class OrderSheet extends JPanel {

    JLabel donut = new JLabel("Donuts");
    JLabel boxes = new JLabel("Boxes");
    JLabel fives = new JLabel("Half-Box");
    JLabel total = new JLabel("Total");

    JFormattedTextField donutsField = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField boxesField = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField fivesField = new JFormattedTextField(NumberFormat.getIntegerInstance());

    JButton confirm = new JButton("Confirm");
    JButton cancel = new JButton("Cancel");

    public OrderSheet(){

        final JFrame win = new JFrame("Order Sheet");
        win.setLocation(200,200);
        win.setResizable(false);
        win.setSize(500, 350);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setIconImage(Main.icon);
        win.setVisible(true);

        setLayout(null);
        donut.setLocation(30, 50);
        boxes.setLocation(30, 150);
        fives.setLocation(30,100);
        total.setLocation(30,210);
        confirm.setLocation(75,250);
        cancel.setLocation(300,250);
        donutsField.setLocation(85,56);
        boxesField.setLocation(85,156);
        fivesField.setLocation(85,106);

        donut.setSize(70,30);
        boxes.setSize(70,30);
        fives.setSize(70,30);
        total.setSize(70,30);
        confirm.setSize(100,30);
        cancel.setSize(100,30);
        donutsField.setSize(40,20);
        fivesField.setSize(40,20);
        boxesField.setSize(40,20);

        donutsField.setValue(0);
        boxesField.setValue(0);
        fivesField.setValue(0);

        //donutsField
        donutsField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                donutsField.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
        donutsField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        donutsField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        donutsField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        //boxesField
        boxesField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        boxesField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        boxesField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                boxesField.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
        boxesField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        //fivesField
        fivesField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        fivesField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        fivesField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                fivesField.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
        boxesField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(donutsField.getText().equals("0")&&boxesField.getText().equals("0")&&fivesField.getText().equals("0")){
                    JButton ok = new JButton("OK");
                    JLabel msg = new JLabel("You must enter at least one value");
                    final JFrame error = new JFrame("Error Message");
                    error.getContentPane().setLayout(null);
                    ok.setSize(70, 20);
                    ok.setLocation(80, 50);
                    msg.setSize(300, 40);
                    msg.setLocation(20, 10);
                    error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    error.setResizable(false);
                    error.setSize(230, 130);
                    error.setIconImage(Main.icon);
                    error.setLocationRelativeTo(win);
                    //error.setLocation(290, 290);
                    ok.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            error.dispose();
                        }
                    });
                    error.getContentPane().add(ok);
                    error.getContentPane().add(msg);
                    error.setVisible(true);
                }
                else {
                    final JFrame jf = new JFrame("Confirm order");
                    jf.setSize(400,350);
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jf.setLocationRelativeTo(win);
                    jf.setResizable(false);
                    jf.getContentPane().setLayout(null);
                    jf.setVisible(true);
                    JButton confirmTwo = new JButton("Confirm");
                    JButton cancelTwo = new JButton("Cancel");
                    JLabel donutTwo = new JLabel();
                    JLabel boxesTwo = new JLabel();
                    JLabel fivesTwo = new JLabel();
                    JLabel totalTwo = new JLabel();

                    donutTwo.setLocation(30,50);
                    fivesTwo.setLocation(30,100);
                    boxesTwo.setLocation(30,150);
                    totalTwo.setLocation(30,210);
                    confirmTwo.setLocation(75,260);
                    cancelTwo.setLocation(200,260);

                    donutTwo.setText("Single Donuts:        "+donutsField.getText()+"         $ "+donutsField.getText()+".00");
                    boxesTwo.setText("Boxes:                      "+boxesField.getText()+"         $ "+Integer.parseInt(boxesField.getText())*10+".00");
                    fivesTwo.setText("Half-Box:                  "+fivesField.getText()+"         $ "+Integer.parseInt(fivesField.getText())*5+".00");
                    totalTwo.setText("Total Sale:                           $ "+(Integer.parseInt(donutsField.getText())+Integer.parseInt(boxesField.getText())*10+Integer.parseInt(fivesField.getText())*5)+".00");

                    boxesTwo.setSize(200, 30);
                    donutTwo.setSize(200, 30);
                    fivesTwo.setSize(200, 30);
                    totalTwo.setSize(200,30);
                    confirmTwo.setSize(100,30);
                    cancelTwo.setSize(100,30);

                    confirmTwo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Main.orderBox = Integer.parseInt(boxesField.getText());
                            Main.orderDonuts = Integer.parseInt(donutsField.getText());
                            Main.orderFives = Integer.parseInt(fivesField.getText());
                            Main.singleSales += Main.orderDonuts;
                            Main.boxSales += Main.orderBox;
                            Main.fiveSales+= Main.orderFives;
                            Main.ordernum++;
                            ExcelReader.log();
                            win.dispose();
                            jf.dispose();
                            Main.panel.repaint();
                        }
                    });
                    cancelTwo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.dispose();
                        }
                    });
                    JLabel trademark = new JLabel("WOSS Mutual 2015");
                    trademark.setLocation(310,300);
                    trademark.setFont(new Font("Bodoni", Font.ITALIC, 9));
                    trademark.setSize(100, 30);
                    jf.add(trademark);
                    jf.add(donutTwo);
                    jf.add(boxesTwo);
                    jf.add(totalTwo);
                    jf.add(fivesTwo);
                    jf.add(confirmTwo);
                    jf.add(cancelTwo);
                    win.repaint();
                }
            }
        });

        JLabel trademark = new JLabel("WOSS Mutual 2015");
        trademark.setLocation(410, 300);
        trademark.setFont(new Font("Bodoni", Font.ITALIC, 9));
        trademark.setSize(100, 30);
        add(trademark);
        add(donut);
        add(boxes);
        add(fives);
        add(total);
        add(confirm);
        add(cancel);
        add(donutsField);
        add(boxesField);
        add(fivesField);
        win.add(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawString("$ "+donutsField.getText()+".00", 200,70);
        g2d.drawString("$ "+Integer.parseInt(fivesField.getText())*5+".00", 200,120);
        g2d.drawString("$ "+Integer.parseInt(boxesField.getText())*10+".00", 200,170);
        g2d.drawString("$ "+(Integer.parseInt(boxesField.getText())*10+Integer.parseInt(donutsField.getText())+Integer.parseInt(fivesField.getText())*5)+".00", 200,230);

        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.black);
        g2d.drawLine(15,200,485,200);

    }
}
