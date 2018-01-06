package ihm;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;

public class Login extends JFrame {

    JPanel jPAll = new JPanel();
    JPanel jP = new JPanel();
    JPanel jPlog = new JPanel();
    JPanel jPsign = new JPanel();
    JPanel jPcenter = new JPanel();
    JPanel jPcenterlog = new JPanel();
    JPanel jpcentersign = new JPanel();
    JPanel jptop = new JPanel();
    ArrayList<Etud> arrayLogin = new ArrayList();

    int i = 0;
    JPanel jPanel22 = new JPanel();
    Thread t;
    JTextField nom, prenom, pass, email, emaillogin, passwordlogin;
    Font font = new Font("Tahoma", Font.PLAIN, 20);
    Font font1 = new Font("Tahoma", Font.PLAIN, 28);
        Font font2 = new Font("Tahoma", Font.PLAIN, 22);

int pX,pY;

    Login() {
        this.setTitle("First project ");
        this.setSize(600, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setUndecorated(true);
         ImageIcon img = new ImageIcon(".//src//group-of-males (1).png");
            setIconImage(img.getImage());
 JLabel help= new JLabel();
         jPAll.add(help);
        help.setLayout(null);
        help.setBackground(Color.white);
        help.setBounds(560,5,32,32);
        help.setIcon(new ImageIcon(".//src//question (1).png"));
        help.setToolTipText("Help");
        help.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  try {
                Desktop.getDesktop().open(new File(".//src//help.docx"));
		} catch (Exception ex) {
					// TODO Auto-generated catch block
		ex.printStackTrace();
	}
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                help.setIcon(new ImageIcon(".//src//question (3).png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                help.setIcon(new ImageIcon(".//src//question (1).png"));
            }
        });

       
        jPAll.setBounds(0, 50, 600, 720);
        jptop.setBounds(0, 0, 600, 50);
        this.add(jptop);
        jptop.setBackground(new Color(66, 80, 88));
        jptop.setLayout(null);
        JButton minimize = new JButton("-");
        JButton exit = new JButton("X");
        exit.setBounds(550, 0, 50, 45);
        exit.setFont(font);
        exit.setForeground(Color.WHITE);
        exit.setBackground(new Color(66, 80, 88));
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jptop.add(exit);
        
        minimize.setBounds(500, 0, 50, 45);
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
              setState(Login.this.ICONIFIED);               
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

        jptop.add(minimize);
         JLabel logo = new JLabel();
        jptop.add(logo);
        logo.setLayout(null);
        logo.setBackground(Color.white);
        logo.setBounds(15, 5, 32, 32);
        logo.setIcon(new ImageIcon(".//src//group-of-males (1).png"));
         JLabel logo1 = new JLabel("Students Club Manager");
        jptop.add(logo1);
        logo1.setLayout(null);
        logo1.setFont(font2);
        logo1.setForeground(Color.BLACK);
        logo1.setBounds(60, 7, 300, 35);
        jPAll.setLayout(null);
        this.add(jPAll);
        jP.setBounds(0, 0, 600, 720);
        jP.setLayout(null);
        jP.setBackground(new Color(36, 48, 60));
        jPAll.add(jP);
        jPlog.setBounds(50, 50, 250, 70);
        jPlog.setBackground(new Color(26, 177, 137));
        jPlog.setLayout(null);
        JLabel log = new JLabel("Log In");
        log.setFont(font);
        log.setForeground(Color.WHITE);

        log.setBounds(70, 20, 65, 30);
        jPlog.add(log);

        jPsign.setBounds(300, 50, 250, 70);
        jPsign.setBackground(new Color(66, 80, 88));
        jPsign.setLayout(null);
        JLabel sign = new JLabel("Sign Up");
        sign.setFont(font);
        sign.setForeground(Color.WHITE);

        sign.setBounds(70, 20, 75, 30);
        jPsign.add(sign);
       
        nom = new Hint("FirstName");
        prenom = new Hint("LastName");
        email = new Hint("Email");
        pass = new Hint("Password");
        emaillogin = new Hint("Email");
        passwordlogin = new Hint("Password");
        jPcenterlog.add(emaillogin);
        jPcenterlog.add(passwordlogin);
        jpcentersign.add(nom);
        jpcentersign.add(prenom);
        jpcentersign.add(email);
        jpcentersign.add(pass);
         jPcenter.add(jpcentersign);

        nom.setFont(font);
        prenom.setFont(font);
        emaillogin.setFont(font);
        passwordlogin.setFont(font);
        email.setFont(font);
        pass.setFont(font);
        nom.setBounds(65, 170, 160, 40);
        nom.setBackground(new Color(36, 48, 60));
        nom.setForeground(new Color(148, 150, 151));
        prenom.setBounds(265, 170, 160, 40);
        prenom.setBackground(new Color(36, 48, 60));
        prenom.setForeground(new Color(148, 150, 151));
        email.setBounds(65, 240, 360, 40);
        email.setBackground(new Color(36, 48, 60));
        email.setForeground(new Color(148, 150, 151));
        pass.setBounds(65, 310, 360, 40);
        pass.setBackground(new Color(36, 48, 60));
        pass.setForeground(new Color(148, 150, 151));
        emaillogin.setBounds(75, 190, 320, 40);
        emaillogin.setToolTipText("Email");
        emaillogin.setBackground(new Color(36, 48, 60));
        emaillogin.setForeground(new Color(148, 150, 151));
        passwordlogin.setBounds(75, 260, 320, 40);
        passwordlogin.setBackground(new Color(36, 48, 60));
        passwordlogin.setForeground(new Color(148, 150, 151));
        jPcenter.setBounds(50, 140, 600, 720);
        jPcenter.setBackground(new Color(36, 48, 60));
        jPcenter.setLayout(null);
        jP.add(jPlog);
        jP.add(jPsign);
        jP.add(jPcenter);
        JButton login = new JButton("LOGIN");
        login.setBounds(0, 400, 500, 70);
        login.setFont(font);
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(26, 177, 137));
        JLabel textlogin = new JLabel("WELCOME BACK .");
        textlogin.setBounds(130, 0, 500, 70);
        textlogin.setFont(font1);
        textlogin.setForeground(Color.WHITE);
        textlogin.setBackground(new Color(26, 177, 137));
        JLabel textsign = new JLabel("SIGN UP FOR FREE.");
        textsign.setBounds(130, 0, 500, 70);
        textsign.setFont(font1);
        textsign.setForeground(Color.WHITE);
        textsign.setBackground(new Color(26, 177, 137));
        JButton signbutton = new JButton("REGISTER");
        signbutton.setBounds(0, 400, 500, 70);
        signbutton.setFont(font);
        signbutton.setForeground(Color.WHITE);
        signbutton.setBackground(new Color(26, 177, 137));
        signbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println(pass.getText().length());
              System.out.println(nom.getText().length());
              System.out.println(prenom.getText().length());
              System.out.println(email.getText().length());
                  
                if (pass.getText().length() != 0
                        || nom.getText().length() != 0
                        || prenom.getText().length() != 0
                        || email.getText().length() != 0) {
                    new message( "تم التسجيل بنجاح").setVisible(true);
                    arrayLogin.add(new Etud(pass.getText(), nom.getText(), prenom.getText(), email.getText()));
                    

                } else {
                    
                     new message( "املئ جميع الخانات").setVisible(true);

                }

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emaillogin.getText().length() != 0 || passwordlogin.getText().length() != 0) {
                    int i = 0;
                    boolean logintest = false;
                    while (i < arrayLogin.size()) {
                        System.out.println(arrayLogin.get(i).Email + "  " + arrayLogin.get(i).id);
                        if (emaillogin.getText().equals(arrayLogin.get(i).Email)
                                && passwordlogin.getText().equals(arrayLogin.get(i).id)) {
                            logintest = true;
                        }
                        i++;
                    }
                    if (logintest) {
                        Ihm etud = new Ihm();
                        etud.arrayList.add(new Etud("12345", "KHALIL", "Bencheikh", "khalil0401@gamil.com"));
                        etud.arrayList.add(new Etud("54321", "TALHA", "Bettaybe", "talha@gamil.com"));

                        etud.setVisible(true);
                        Login.this.setVisible(false);

                    } else {
                                          new message("البريد الالكتروني و كلمة السر غير صحيحتين").setVisible(true);

                    }
                } else {
                    new message( "الرجاء ملئ كل البيانات").setVisible(true);

                }

            }
        });
         login.setBorderPainted(false);
        login.setFocusPainted(false);
         signbutton.setBorderPainted(false);
        signbutton.setFocusPainted(false);

        jpcentersign.add(signbutton);

        jpcentersign.add(textsign);
         JPanel photo=new JPanel();
        jpcentersign.add(photo);
        photo.setBounds(120, 45,250, 120);
        photo.setBackground(new Color(36, 48, 60));
        JButton bphoto=new JButton();
        bphoto.setBackground(new Color(36, 48, 60));
        
         bphoto.setIcon(new ImageIcon(".//src//user (3).png"));
         photo.add(bphoto);
         bphoto.setFocusPainted(false);
        bphoto.setBorderPainted(false);
        bphoto.setContentAreaFilled(false);
        JPanel photo1=new JPanel();
        jPcenterlog.add(photo1);
        photo1.setBounds(120, 45,250, 120);
        photo1.setBackground(new Color(36, 48, 60));
        JButton bphoto2=new JButton();
        bphoto2.setBackground(new Color(36, 48, 60));
        
         bphoto2.setIcon(new ImageIcon(".//src//user (4).png"));
         photo1.add(bphoto2);
         bphoto2.setFocusPainted(false);
        bphoto2.setBorderPainted(false);
        bphoto2.setContentAreaFilled(false);
     
        jPcenterlog.add(textlogin);

        jPcenterlog.add(login);
        jPcenterlog.setBounds(0, 0, 600, 720);
        jPcenterlog.setBackground(new Color(36, 48, 60));
        jPcenterlog.setLayout(null);
        jPcenter.add(jPcenterlog);
        jpcentersign.setBounds(0, 0, 600, 720);
        jpcentersign.setBackground(new Color(36, 48, 60));
        jpcentersign.setLayout(null);
        jpcentersign.setVisible(false);
        jPlog.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPlog.setBackground(new Color(26, 177, 137));
                jPsign.setBackground(new Color(66, 80, 88));

                jPcenterlog.setVisible(true);
                jpcentersign.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        jPsign.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPlog.setBackground(new Color(66, 80, 88));
                jPsign.setBackground(new Color(26, 177, 137));

                jpcentersign.setVisible(true);
                jPcenterlog.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public static void main(String[] args) {
        Login e = new Login();
        e.setVisible(true);

    }
}
