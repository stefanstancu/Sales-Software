package stancu.Main;

import javax.imageio.ImageIO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;


/**
 * Created by Stefan on 2015-03-15.
 */
public class Main extends JPanel{

    private static BufferedImage banner;
    private static BufferedImage watermark;
    public static BufferedImage icon;

    public static int singleSales =ExcelReader.getSales("Donut");
    public static int boxSales =ExcelReader.getSales("Box");
    public static int fiveSales =ExcelReader.getSales("Fives");
    public static int ordernum =ExcelReader.getOrder();
    public static int orderDonuts = 0;
    public static int orderBox = 0;
    public static int orderFives = 0;
    JButton order = new JButton("New Order");
    JLabel trademark = new JLabel("WOSS Mutual 2015");

    public static JPanel panel = new JPanel();
    static JLabel l = new JLabel("Inventory Sold");
   public  static JLabel num1 = new JLabel(singleSales+ " single sales");
   public  static JLabel num11 = new JLabel(boxSales+ " box sales");
    public static JLabel num2 = new JLabel(Integer.toString(ordernum));
    static JLabel ord = new JLabel("Orders Completed");


    public Main(){
        panel.setLayout(null);
        panel.setSize(250, 400);
        panel.setLocation(0, 0);
        l.setSize(80, 30);
        l.setLocation(30, 75);
        ord.setSize(120, 30);
        ord.setLocation(30, 155);
        num1.setLocation(30,100);
        num1.setSize(200,30);
        num11.setLocation(30,120);
        num11.setSize(200,30);
        num2.setLocation(30, 180);
        num2.setSize(30,30);
        //panel.add(l);
        //panel.add(num1);
        //panel.add(num11);
        //panel.add(num2);
        //panel.add(ord);
        panel.setBackground(new Color(205, 209, 204));

        trademark.setLocation(510,350);
        trademark.setFont(new Font("Bodoni", Font.ITALIC,9));
        trademark.setSize(100,30);


        try {
            banner = ImageIO.read(new File("banner1.png"));
            watermark = ImageIO.read(new File("title.png"));
            icon = ImageIO.read(new File("icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);

        order.setLocation(30,250);
        order.setSize(150,35);


        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderSheet();
            }
        });


        add(order);
        add(trademark);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(205, 209, 204));
        g2d.fillRect(0, 0, 600, 400);
        g2d.drawImage(banner, getWidth() / 2 - 100 + 100, 75, 200, 100, null);
        g2d.drawImage(watermark, getWidth() / 2 - 150 + 100, 75, 300, 300, null);
    }

    public static void main (String args[]){
        Main m = new Main();
        JFrame window = new JFrame("Krispy Kreme Sale");
        window.setSize(600,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setIconImage(icon);
        window.setVisible(true);

        //window.add(Main.panel);
        m.add(panel);
        window.add(m);




    }

}
