package ihm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Talha_FNC
 */
public class Ihm extends JFrame {

    Thread t;
    int i = 470;
    Font font = new Font("Tahoma", Font.PLAIN, 16);
    Font font1 = new Font("Tahoma", Font.PLAIN, 28);
    Font font2 = new Font("Tahoma", Font.PLAIN, 22);
                JPanel panelsearch = new JPanel();

    JButton add, del, edit;
    ArrayList<Etud> arrayList = new ArrayList();
    JPanel jPADD = new JPanel();
    JPanel jPSHOW = new JPanel();
    JPanel jPSearch = new JPanel();
    JTextField nom, prenom, email, id, emaillogin, passwordlogin;
    JPanel jptop = new JPanel();
int pX,pY;

    Ihm() {
        this.setSize(600, 720);
        this.setTitle("Ihm");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setUndecorated(true);
            ImageIcon img = new ImageIcon(".//src//group-of-males (1).png");
            setIconImage(img.getImage());
        JPanel All = new JPanel();

        All.setBounds(0, 50, 600, 720);
        this.add(All);
        All.setLayout(null);
        All.setBackground(new Color(36, 48, 60));
        jptop.setBounds(0, 0, 600, 50);
        this.add(jptop);
        ////////////////////
        JLabel help = new JLabel();
        All.add(help);
        help.setLayout(null);
        help.setBackground(Color.white);
        help.setBounds(560, 5, 32, 32);
        help.setIcon(new ImageIcon(".//src//question (1).png"));
        help.setToolTipText("Help");
        help.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 // TODO Auto-generated method stub
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
        minimize.setBackground(new Color(66, 80, 88));
        minimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(Ihm.this.ICONIFIED);
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
        minimize.setBorderPainted(false);
        minimize.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        pX=getLocation().x;
        pY=getLocation().y;
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
        add = new JButton("ADD");
        JButton Show = new JButton("SHOW");
        JButton Search1 = new JButton("SEARCH");

        add.setFont(font1);
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(26, 177, 137));
        Show.setBounds(215, 50, 165, 70);
        Show.setFont(font1);
        Show.setForeground(Color.WHITE);
        Show.setBackground(new Color(66, 80, 88));

        /////
        Search1.setBackground(new Color(66, 80, 88));
        Search1.setBounds(380, 50, 165, 70);
        Search1.setFont(font1);
        Search1.setForeground(Color.WHITE);

        add.setBounds(50, 50, 165, 70);
        All.add(add);
        All.add(Show);
        All.add(Search1);
        jPADD.setBounds(50, 140, 500, 600);
        jPSearch.setBounds(0, 140, 600, 600);
        jPADD.setLayout(null);
        /////////////////////////////////
        nom = new Hint("FirstName");
        prenom = new Hint("LastName");
        email = new Hint("Email ");
        id = new Hint("ID");
        emaillogin = new JTextField();
        passwordlogin = new JTextField();
        jPADD.add(emaillogin);
        jPADD.add(passwordlogin);
        jPADD.add(nom);
        jPADD.add(prenom);
        jPADD.add(email);
        jPADD.add(id);
        nom.setFont(font);
        prenom.setFont(font);
        emaillogin.setFont(font);
        passwordlogin.setFont(font);
        email.setFont(font);
        id.setFont(font);

        nom.setBounds(65, 70, 160, 40);
        nom.setBackground(new Color(36, 48, 60));
        nom.setForeground(new Color(148, 150, 151));
        prenom.setBounds(265, 70, 160, 40);
        prenom.setBackground(new Color(36, 48, 60));
        prenom.setForeground(new Color(148, 150, 151));
        email.setBounds(65, 140, 360, 40);
        email.setBackground(new Color(36, 48, 60));
        email.setForeground(new Color(148, 150, 151));
        id.setBounds(65, 210, 360, 40);
        id.setBackground(new Color(36, 48, 60));
        id.setForeground(new Color(148, 150, 151));
        JButton rebutton = new JButton("REGISTER");
        rebutton.setBounds(0, 390, 500, 70);
        rebutton.setFont(font1);
        rebutton.setForeground(Color.WHITE);
        rebutton.setBackground(new Color(26, 177, 137));//#1AB189
        jPADD.add(rebutton);

        ////////////////////////////
        jPADD.setBackground(new Color(36, 48, 60));
        All.add(jPADD);
        jPSHOW.setVisible(false);
        jPSearch.setVisible(false);
        jPSearch.setBackground(new Color(36, 48, 60));
        All.add(jPSearch);
        jPSHOW.setLayout(null);
        jPSearch.setLayout(null);
        JTextField Search = new Hint("WRITE ANYTHING HERE");
        Search.setFont(font);
        Search.setBounds(95, 40, 300, 40);
        Search.setBackground(new Color(36, 48, 60));
        Search.setForeground(new Color(148, 150, 151));
        jPSearch.add(Search);
        JButton Searchbutton = new JButton("Search");
        Searchbutton.setBounds(395, 40, 80, 40);
        Searchbutton.setBackground(new Color(66, 80, 88));
        Searchbutton.setForeground(new Color(148, 150, 151));
        jPSearch.add(Searchbutton);
        jPSearch.setBackground(new Color(36, 48, 60));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPADD.setVisible(true);
                jPSearch.setVisible(false);
                jPSHOW.setVisible(false);
                Show.setBackground(new Color(66, 80, 88));
                add.setBackground(new Color(26, 177, 137));
                Search1.setBackground(new Color(66, 80, 88));

            }
        });

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jPADD.setVisible(false);
                jPSearch.setVisible(false);
                jPSHOW.setVisible(true);
                // jPSHOW=new JPanel();
                jPSHOW.removeAll();
                All.add(jPSHOW);

                jPSHOW.setBounds(0, 140, 600, 600);
                jPSHOW.setLayout(null);
                jPSHOW.setBackground(new Color(36, 48, 60));

                ////////////////////////////////////////////////////
                JLabel idlabel = new JLabel("ID");
                JLabel nomlabel = new JLabel("FirstName");
                JLabel prenomlabel = new JLabel("LastName");
                JLabel emaillabel = new JLabel("Email");

                idlabel.setBounds(45, 0, 50, 60);
                jPSHOW.add(idlabel);

                prenomlabel.setBounds(145, 0, 100, 60);
                jPSHOW.add(prenomlabel);

                nomlabel.setBounds(285, 0, 100, 60);
                jPSHOW.add(nomlabel);

                emaillabel.setBounds(455, 0, 100, 60);

                jPSHOW.add(emaillabel);
                emaillabel.setFont(font2);
                idlabel.setFont(font2);
                nomlabel.setFont(font2);
                prenomlabel.setFont(font2);
                idlabel.setForeground(Color.white);
                nomlabel.setForeground(Color.white);
                prenomlabel.setForeground(Color.white);
                emaillabel.setForeground(Color.white);
                ////////////////////////////////////////////////////
                int i = 0;
                while (i < arrayList.size()) {
                    System.err.println(arrayList.get(i).nom);
                    JLabel id = new JLabel(i + 1 + "-   " + arrayList.get(i).id);
                    JLabel nom = new JLabel(arrayList.get(i).nom);
                    JLabel prenom = new JLabel(arrayList.get(i).pre);
                    JLabel email = new JLabel(arrayList.get(i).Email);
                    JPanel aff = new JPanel();
                    aff.setLayout(null);
                    aff.setBounds(0, 60 + (i * 30), 600, 30);
                    jPSHOW.add(aff);

                    id.setBounds(0, 0, 170, 30);
                    aff.add(id);

                    prenom.setBounds(145, 0, 170, 30);
                    aff.add(prenom);

                    nom.setBounds(285, 0, 170, 30);
                    aff.add(nom);

                    email.setBounds(405, 0, 170, 30);

                    aff.add(email);

                    email.setFont(font);
                    id.setFont(font);
                    nom.setFont(font);
                    prenom.setFont(font);
                    id.setForeground(Color.white);
                    nom.setForeground(Color.white);
                    prenom.setForeground(Color.white);
                    email.setForeground(Color.white);

                    if (i % 2 == 0) {
                        aff.setBackground(new Color(66, 80, 88));
                    } else {
                        aff.setBackground(new Color(36, 48, 60));
                    }
                    i++;
                }
                add.setBackground(new Color(66, 80, 88));
                Show.setBackground(new Color(26, 177, 137));
                Search1.setBackground(new Color(66, 80, 88));

            }
        });
        Search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPADD.setVisible(false);
                jPSearch.setVisible(true);
                jPSHOW.setVisible(false);
                add.setBackground(new Color(66, 80, 88));
                Show.setBackground(new Color(66, 80, 88));
                Search1.setBackground(new Color(26, 177, 137));
            }
        });
        ////////////////
        rebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nom.getText().length() != 0 && prenom.getText().length() != 0
                        && email.getText().length() != 0 && id.getText().length() != 0) {
                    arrayList.add(new Etud(id.getText(), nom.getText(), prenom.getText(), email.getText()));
                    new message("تم").setVisible(true);

                } else {
                    new message( "اكمل ادخال البيانات").setVisible(true);
                }

            }
        });
        Searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelsearch.removeAll();
                panelsearch.repaint();
                panelsearch.setLayout(null);
                if (Search.getText().length() != 0) {
                    JLabel idlabel = new JLabel("ID");
                    JLabel nomlabel = new JLabel("LastName");
                    JLabel prenomlabel = new JLabel("FirstName");
                    JLabel emaillabel = new JLabel("Email");

                    idlabel.setBounds(110, 0, 50, 60);
                    panelsearch.add(idlabel);

                    prenomlabel.setBounds(210, 0, 100, 60);
                    panelsearch.add(prenomlabel);

                    nomlabel.setBounds(310, 0, 100, 60);
                    panelsearch.add(nomlabel);

                    emaillabel.setBounds(410, 0, 100, 60);
                    panelsearch.add(emaillabel);
                    JScrollBar bar = new JScrollBar();
                    panelsearch.setBounds(0, 100, 600, 500);
                    jPSearch.add(panelsearch);
                    panelsearch.setBackground(new Color(36, 48, 60));
                    emaillabel.setFont(font);
                    idlabel.setFont(font);
                    nomlabel.setFont(font);
                    prenomlabel.setFont(font);
                    idlabel.setForeground(Color.white);
                    nomlabel.setForeground(Color.white);
                    prenomlabel.setForeground(Color.white);
                    emaillabel.setForeground(Color.white);
                } else {
                                        new message("املأ خانة البحث ").setVisible(true);


                }
                ArrayList<Etud> s = new ArrayList<>();
                int i = 0;
                while (i < arrayList.size()) {
                    System.err.println(arrayList.get(i).id);
                    if (arrayList.get(i).id.equals(Search.getText())
                            || arrayList.get(i).nom.equals(Search.getText())
                            || arrayList.get(i).pre.equals(Search.getText())
                            || arrayList.get(i).Email.equals(Search.getText())) {
                        s.add(new Etud("" + i,
                                arrayList.get(i).nom,
                                arrayList.get(i).pre,
                                arrayList.get(i).Email));

                    }
                    i++;
                }

                if (s.size() == 0) {
                      panelsearch.removeAll();
                      panelsearch.repaint();
                 new message("Is Empty").setVisible(true);

                       
                } else {
                    i = 0;
                    while (i < s.size()) {
                        System.err.println(s.get(i).id);
                        int con = Integer.parseInt(s.get(i).id);
                        JLabel id = new JLabel(arrayList.get(con).id);
                        JLabel nom = new JLabel(arrayList.get(con).nom);
                        JLabel prenom = new JLabel(arrayList.get(con).pre);
                        JLabel email = new JLabel(arrayList.get(con).Email);
                        JButton edit = new JButton();
                          panelsearch.add(edit);

                        edit.setIcon(new ImageIcon(".//src//user (6).png"));
                        JButton del = new JButton();
                       panelsearch.add(del);

                        del.setIcon(new ImageIcon(".//src//user (5).png"));
                        del.setBounds(20, 50 + (i * 30), 28, 22);
                        del.setVisible(true);
                        edit.setVisible(true);
                        del.setContentAreaFilled(false);
                        del.setFocusPainted(true);
                        del.setBorderPainted(true);
                        del.setToolTipText("delete");
                        edit.setBounds(50, 50 + (i * 30), 28, 22);
                        edit.setToolTipText("Edite");
                        edit.setContentAreaFilled(false);
                        edit.setFocusPainted(true);
                        edit.setBorderPainted(true);
                        panelsearch.add(edit);
                        Etud et = arrayList.get(con);
                        del.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                if (JOptionPane.showConfirmDialog(null, "هل انت متاكد") == 0) {
                                    arrayList.remove(et);
                                    id.setVisible(false);
                                    nom.setVisible(false);
                                    prenom.setVisible(false);
                                    email.setVisible(false);
                                    edit.setVisible(false);
                                    del.setVisible(false);
                                }

                            }
                        });
                        edit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame editf = new JFrame();
                                editf.setLayout(null);
                                editf.setLocation(200,0);
                                editf.setResizable(false);
                                editf.setSize(600, 450);
                                editf.setUndecorated(true);
                                    JPanel jptop = new JPanel();

                                 jptop.setBounds(0, 0, 600, 50);
                                editf.add(jptop);
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
                                            editf.setVisible(false);
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
                                      setState(editf.ICONIFIED);               
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

                                JPanel jPedit = new JPanel();
                                jPedit.setLayout(null);
                                jPedit.setBounds(0, 0, 600, 600);

                                JTextField nom, prenom, email, id, emaillogin, passwordlogin;

                                /////////////////////////////////
                                nom = new JTextField("FirstName");
                                prenom = new JTextField("LastName");
                                email = new JTextField("Email ");
                                id = new JTextField("ID");
                                emaillogin = new JTextField();
                                passwordlogin = new JTextField();
                                jPedit.add(emaillogin);
                                jPedit.add(passwordlogin);
                                jPedit.add(nom);
                                jPedit.add(prenom);
                                jPedit.add(email);
                                jPedit.add(id);
                                nom.setFont(font);
                                prenom.setFont(font);
                                emaillogin.setFont(font);
                                passwordlogin.setFont(font);
                                email.setFont(font);
                                id.setFont(font);
                                nom.setBounds(110, 70, 160, 40);
                                nom.setBackground(new Color(36, 48, 60));
                                nom.setForeground(new Color(148, 150, 151));
                                prenom.setBounds(310, 70, 160, 40);
                                prenom.setBackground(new Color(36, 48, 60));
                                prenom.setForeground(new Color(148, 150, 151));
                                email.setBounds(110, 140, 360, 40);
                                email.setBackground(new Color(36, 48, 60));
                                email.setForeground(new Color(148, 150, 151));
                                id.setBounds(110, 210, 360, 40);
                                id.setBackground(new Color(36, 48, 60));
                                id.setForeground(new Color(148, 150, 151));
                                nom.setText(et.nom);
                                prenom.setText(et.pre);
                                id.setText(et.id);
                                email.setText(et.Email);
                                JButton rebutton = new JButton("SAVE");
                                rebutton.setBounds(45, 300, 500, 70);
                                rebutton.setFont(font1);
                                rebutton.setForeground(Color.WHITE);
                                rebutton.setBackground(new Color(26, 177, 137));
                                jPedit.add(rebutton);
                                rebutton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (nom.getText().length() != 0
                                                || id.getText().length() != 0
                                                || prenom.getText().length() != 0
                                                || email.getText().length() != 0) {
                                            et.nom = nom.getText();
                                            et.pre = prenom.getText();
                                            et.id = id.getText();
                                            et.Email = email.getText();
                                            
                                        message  s= new message("تم");
                                        s.setVisible(true);
                                            try {
                                                Thread.sleep(2000);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(Ihm.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            editf.setVisible(false);
                                            s.setVisible(false);
                                            
                                        } else {
                                            new message("Is Empty").setVisible(true);
                                        }

                                    }
                                });
                                ////////////////////////////
                                jPedit.setBackground(new Color(36, 48, 60));
                                editf.add(jPedit);
                                editf.setVisible(true);

                            }
                        });
                        id.setBounds(100, 30 + (i * 30), 100, 60);
                        panelsearch.add(id);
                        prenom.setBounds(210, 30 + (i * 30), 100, 60);
                        panelsearch.add(prenom);
                        nom.setBounds(310, 30 + (i * 30), 100, 60);
                        panelsearch.add(nom);
                        email.setBounds(410, 30 + (i * 30), 170, 60);
                        panelsearch.add(email);
                        email.setFont(font);
                        id.setFont(font);
                        nom.setFont(font);
                        prenom.setFont(font);
                        id.setForeground(Color.white);
                        nom.setForeground(Color.white);
                        prenom.setForeground(Color.white);
                        email.setForeground(Color.white);

                        i++;
                    }

                }

            }

        });
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        Show.setBorderPainted(false);
        Show.setFocusPainted(false);
        Search1.setBorderPainted(false);
        Search1.setFocusPainted(false);
        rebutton.setBorderPainted(false);
        rebutton.setFocusPainted(false);

    }

    public static void main(String[] args) {
        Ihm e = new Ihm();
        e.setVisible(true);

    }
}