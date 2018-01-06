package ihm;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author khalil
 */
public class message extends JFrame{
    
    JPanel jPAll = new JPanel();
    JPanel jP = new JPanel();
    JPanel jPlog = new JPanel();
    JPanel jPsign = new JPanel();
    JPanel jPcenter = new JPanel();
    JPanel jPcenterlog = new JPanel();
    JPanel jpcentersign = new JPanel();
    JPanel jptop = new JPanel();
   

    int i = 0;
    JPanel jPanel22 = new JPanel();
    Thread t;
   
    Font font = new Font("Tahoma", Font.PLAIN, 12);
    Font font1 = new Font("Tahoma", Font.PLAIN, 6);
int pX,pY;


    message(String s){
        this.setTitle("Message ");
        this.setSize(300,140);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setUndecorated(true);
       
        
        
        JLabel message=new JLabel("       "+s);
        jP.add(message);
        
        message.setBounds(0,85,290,50);
        message.setLocation(180,10);
        message.setLayout(null);
        message.setFont(font);
        message.setForeground(Color.white);
        jptop.setBounds(1, 1, 297, 25);
        this.add(jptop);
        jptop.setBackground(new Color(66, 80, 88));
        jptop.setLayout(null);
        JButton minimize = new JButton("-");
        JButton exit = new JButton("X");
        exit.setBounds(249, 0, 50, 25);
        exit.setFont(font);
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(66, 80, 88));
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                message.this.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 exit.setBackground(new Color(26, 177, 137));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 exit.setBackground(new Color(66, 80, 88));
            }
        });
        jptop.add(exit);
        minimize.setBounds(208, 0, 40, 25);
        minimize.setFont(font);
        minimize.setForeground(Color.WHITE);
        minimize.setBorderPainted(false);
        minimize.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        minimize.setBackground(new Color(66, 80, 88));
        minimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                          message.this.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimize.setBackground(new Color(26, 177, 137));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimize.setBackground(new Color(66, 80, 88));
            }
        });
        jptop.add(minimize);
                jptop.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me)
            {
                // Set the location
                // get the current location x-co-ordinate and then get
                // the current drag x co-ordinate, add them and subtract most recent
                // mouse pressed x co-ordinate
                // do same for y co-ordinate
                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });

        this.add(jP);
        jP.setBounds(1, 26, 297, 113);
        jP.setLayout(null);
        jP.setBackground(new Color(36, 48, 60));
         JButton ok = new JButton();
         jP.add(ok);
         
        ok.setBounds(130,70,55, 30);
        //ok.setFont(font);
        ok.setForeground(Color.WHITE);
        ok.setBackground(Color.green);
         ok.setFocusPainted(false);
        ok.setBorderPainted(false);
        ok.setContentAreaFilled(false);
                 ok.setIcon(new ImageIcon(".//src//Capture.png"));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              message.this.setVisible(false);
            }
        });
        
         ////////////////////////////////////
         jPAll.setBounds(0,0,300,140);
        this.add(jPAll);
       
        jPAll.setLayout(null);
        jPAll.setFont(font);
        jPAll.setBackground(new Color(26, 177, 137));
        ////////////////////////////
       
        
    }

    public static void main(String[] args) {
      message e = new message("هههههههههههههههfffffffffffffffffffffffffffffffffffffffffffffffffffffffه");
        e.setVisible(true);

    }
    
}
