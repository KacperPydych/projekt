import com.sun.jdi.Field;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class gui extends JFrame  {
    JButton goToZapis, przegladaj,goToOdczyt, browse,save, searchB ;
    JPanel  panel, panel2, panel3;//panel 3 - odczyt, panel 2 - zapis
    JTextArea firmaOdczyt, ocenaOdczyt, uwagiOdczyt, produktOdczyt, firmaZapis, ocenaZapis, uwagiZapis, produktZapis,search;
    JFrame rama ;
    JLabel labelFirma, labelProdukt, labelOcena, labelUwagi,labelFirma1, labelProdukt1, labelOcena1, labelUwagi1;
    JCheckBox panelSwitch;

    DefaultListModel<String> model = new DefaultListModel<String>();

    private JList<String> jlist;
    private DefaultListModel<String> jlistModel;



    DefaultListModel<String> modelListy = new DefaultListModel<>();


    JList<String> jList = new JList<>(modelListy);
    JScrollPane scrollPane = new JScrollPane(jList);




    public void menju(){
        rama = new JFrame();
        goToZapis = new JButton("Przejdź do zapisu");
        przegladaj = new JButton("przegladaj");
        goToOdczyt = new JButton("powrot");

        browse = new JButton("wczytaj dane ");
        save = new JButton("zapisz dane ");
        panel = new JPanel();
        search = new JTextArea();
        searchB = new JButton("szukaj");

        panel2 = new JPanel();//zapis
        panel3 = new JPanel();//odczyt
        labelFirma = new JLabel("firma");
        labelOcena= new JLabel("ocena");
        labelProdukt= new JLabel("produkt");
        labelUwagi= new JLabel("uwagi");
        labelFirma1 = new JLabel("firma");
        labelOcena1= new JLabel("ocena");
        labelProdukt1= new JLabel("produkt");
        labelUwagi1= new JLabel("uwagi");
        firmaOdczyt = new JTextArea();
        uwagiOdczyt = new JTextArea();
        ocenaOdczyt = new JTextArea();
        produktOdczyt = new JTextArea();
        firmaZapis = new JTextArea();
        uwagiZapis = new JTextArea();
        ocenaZapis = new JTextArea();
        produktZapis = new JTextArea();
        panelSwitch = new JCheckBox();

        firmaZapis.setPreferredSize(new Dimension(200, 100));
        firmaOdczyt.setPreferredSize(new Dimension(200, 100));
        ocenaZapis.setPreferredSize(new Dimension(200, 100));
        ocenaOdczyt.setPreferredSize(new Dimension(200, 100));
        uwagiZapis.setPreferredSize(new Dimension(200, 100));
        uwagiOdczyt.setPreferredSize(new Dimension(200, 100));
        produktZapis.setPreferredSize(new Dimension(200, 100));
        produktOdczyt.setPreferredSize(new Dimension(200, 100));


        firmaZapis.setFont(new Font("Arial", Font.BOLD, 30));
        firmaOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        ocenaZapis.setFont(new Font("Arial", Font.BOLD, 30));
        ocenaOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        uwagiZapis.setFont(new Font("Arial", Font.BOLD, 30));
        uwagiOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        produktZapis.setFont(new Font("Arial", Font.BOLD, 30));
        produktOdczyt.setFont(new Font("Arial", Font.BOLD, 30));


        rama.setResizable(false);




        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setFont(new Font("Arial", Font.BOLD, 30));
        scrollPane.setBounds(200,200,300,600);
        panel3.add(scrollPane);

        panel3.add(firmaOdczyt);
        panel3.add(uwagiOdczyt);
        panel3.add(ocenaOdczyt);
        panel3.add(produktOdczyt);
        panel3.add(przegladaj);
        panel3.add(goToZapis);
        panel3.add(search);
        panel3.add(searchB);

        panel2.add(firmaZapis);
        panel2.add(produktZapis);
        panel2.add(ocenaZapis);
        panel2.add(uwagiZapis);




        goToOdczyt.setBounds(500,50,100,50);
        goToZapis.setBounds(500,50,100,50);
        browse.setBounds(650,50,200,50);
        save.setBounds(650,50,200,50);
        przegladaj.setBounds(1250,125,250,80);
        search.setBounds(200, 140, 300, 50);
        searchB.setBounds(200, 80, 300, 50);

        firmaOdczyt.setBounds(850,250,500,50);
        produktOdczyt.setBounds(850,350,500,50);
        ocenaOdczyt.setBounds(850,450,500,50);
        uwagiOdczyt.setBounds(850,550,500,50);

        firmaZapis.setBounds(850,350,500,50);
        produktZapis.setBounds(850,250,500,50);
        ocenaZapis.setBounds(850,450,500,50);
        uwagiZapis.setBounds(850,550,500,50);

        labelFirma.setBounds(800,250,100,50);
        labelProdukt.setBounds(800,350,100,50);
        labelOcena.setBounds(800,450,100,50);
        labelUwagi.setBounds(800,550,100,50);

        labelProdukt1.setBounds(800,250,100,50);
        labelFirma1.setBounds(800,350,100,50);
        labelOcena1.setBounds(800,450,100,50);
        labelUwagi1.setBounds(800,550,100,50);





        panel.setBounds(0,0,1980,1080);
        panel2.setBounds(0,0,1980,1080);
        panel3.setBounds(0,0,1980,1080);

        firmaOdczyt.setEditable(false);
        produktOdczyt.setEditable(false);
        ocenaOdczyt.setEditable(false);
        uwagiOdczyt.setEditable(false);



        goToZapis.addActionListener(new guzikListener());
        przegladaj.addActionListener(new guzikListener());
        goToOdczyt.addActionListener(new guzikListener());
        searchB.addActionListener(new guzikListener());


        browse.addActionListener(new guzikListener());
        save.addActionListener(new guzikListener());



        panel.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(true);

        rama.getContentPane().add(panel);
        rama.setLayout(null);
        panel.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);



        panel.add(panel2);
        panel.add(panel3);
        panel.setBackground(Color.lightGray);



        panel2.add(goToOdczyt);
        panel2.setBackground(Color.CYAN);

        panel3.setBackground(Color.GREEN);


        panel2.add(save);




        panel2.add(labelFirma);
        panel2.add(labelProdukt);
        panel2.add(labelOcena);
        panel2.add(labelUwagi);

        panel3.add(labelFirma1);
        panel3.add(labelProdukt1);
        panel3.add(labelOcena1);
        panel3.add(labelUwagi1);


        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.setSize(1880,1000);
        rama.setVisible(true);
        rama.setLocationRelativeTo(null);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int wybranaPozycja = (int) jList.getSelectedIndex() + 1;
                Connection con = null;
                String ch = "SELECT * FROM produkty WHERE ID = "+Integer.toString(wybranaPozycja);
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery(ch);
                    String produkt = "";
                    while (load.next()){
                        produkt = load.getString("produkt");
                        String firma = load.getString("firma");
                        int ocena = load.getInt("ocena");
                        String uwagi = load.getString("uwagi");
                        produktOdczyt.setText(produkt);
                        firmaOdczyt.setText(firma);
                        ocenaOdczyt.setText(Integer.toString(ocena));
                        uwagiOdczyt.setText(uwagi);

                    }

                }

                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


    }

    class guzikListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object zrodlo = e.getSource();
            if(zrodlo == goToZapis){
                panel2.setVisible(true);
                panel3.setVisible(false);
                modelListy.clear();
            }

            else if (zrodlo == searchB){
                modelListy.clear();
                Connection con = null;
                String l ="SELECT * FROM produkty WHERE produkt LIKE '%"+ search.getText() + "%' OR firma LIKE '%" + search.getText() +  "%'";
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery(l);
                    while (load.next()){
                        String nazwa = load.getString("produkt")+ "                        " + load.getString("firma");
                        modelListy.addElement(nazwa);

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
            else if (zrodlo == przegladaj){
                modelListy.clear();

                Connection con = null;
                String l = "SELECT produkt, firma FROM produkty";
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery(l);
                    while (load.next()){
                        String nazwa = load.getString("produkt")+ "                        " + load.getString("firma");
                        modelListy.addElement(nazwa);

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
            else if (zrodlo == goToOdczyt){
                panel2.setVisible(false);
                panel3.setVisible(true);

            }

            else if(zrodlo == save) {
                try {
                    int parsedValue = Integer.parseInt(ocenaZapis.getText());

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                        Statement stmt = con.createStatement();
                        String produkt = produktZapis.getText();
                        String firma = firmaZapis.getText();
                        int ileID = 0;

                        String ile = "SELECT COUNT(*) FROM produkty";
                        // String s = "INSERT INTO produkty VALUES(6, 'tefgdgdfst', 'gdfgdgtest', 35, 'tefsdfsdfsst') ";


                        ResultSet lW = stmt.executeQuery(ile);
                        while (lW.next()) {
                            ileID = lW.getInt(1) + 1;
                        }
                        String b = "INSERT INTO produkty VALUES('" + ileID + "','" + produktZapis.getText() + "','" + firmaZapis.getText() + "','" + ocenaZapis.getText() + "','" + uwagiZapis.getText() + "')";

                        produktZapis.setText(null);
                        firmaZapis.setText(null);
                        ocenaZapis.setText(null);
                        uwagiZapis.setText(null);

                        stmt.execute(b);
                        con.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                catch (Exception b){
                    JOptionPane.showMessageDialog(null, "Niepoprawne dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }

    public static void main(String[] args)  {

        gui lol = new gui();
        lol.menju();

    }
}
