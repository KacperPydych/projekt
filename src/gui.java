import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class gui extends JFrame  {
    JButton goToZapis, przegladaj,goToOdczyt, browse,save, searchB, delete ;
    JPanel  panel, panel2, panel3;//panel 3 - odczyt, panel 2 - zapis
    JTextArea firmaOdczyt, ocenaOdczyt, uwagiOdczyt, firmaZapis, ocenaZapis, uwagiZapis, produktZapis,search;
    JTextPane produktOdczyt;
    JFrame rama ;
    JLabel labelFirma, labelProdukt, labelOcena, labelUwagi,labelFirma1, labelProdukt1, labelOcena1, labelUwagi1;

    DefaultListModel<String> modelListy = new DefaultListModel<>();
    JList<String> jList = new JList<>(modelListy);
    JScrollPane scrollPane = new JScrollPane(jList);
    int ID = 0;
    public void menu(){
        rama = new JFrame();
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.setSize(1880,1000);
        rama.setVisible(true);
        rama.setLocationRelativeTo(null);
        rama.setResizable(false);



        goToZapis = new JButton("Przejdź do zapisu");
        przegladaj = new JButton("przegladaj");
        goToOdczyt = new JButton("powrot");
        browse = new JButton("Wczytaj dane ");
        save = new JButton("Zapisz dane ");
        searchB = new JButton("szukaj");
        delete = new JButton("usuń");
        panel = new JPanel();
        panel2 = new JPanel();//zapis
        panel3 = new JPanel();//odczyt
        labelFirma = new JLabel("firma");
        labelFirma1 = new JLabel("firma");
        labelOcena= new JLabel("ocena");
        labelOcena1= new JLabel("ocena");
        labelProdukt= new JLabel("produkt");
        labelProdukt1= new JLabel("produkt");
        labelUwagi= new JLabel("uwagi");
        labelUwagi1= new JLabel("uwagi");
        firmaOdczyt = new JTextArea();
        uwagiOdczyt = new JTextArea();
        ocenaOdczyt = new JTextArea();
        produktOdczyt = new JTextPane();
        firmaZapis = new JTextArea();
        uwagiZapis = new JTextArea();
        ocenaZapis = new JTextArea();
        produktZapis = new JTextArea();
        search = new JTextArea();

        firmaZapis.setFont(new Font("Arial", Font.BOLD, 30));
        firmaOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        ocenaZapis.setFont(new Font("Arial", Font.BOLD, 30));
        ocenaOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        uwagiZapis.setFont(new Font("Arial", Font.BOLD, 30));
        uwagiOdczyt.setFont(new Font("Arial", Font.BOLD, 30));
        produktZapis.setFont(new Font("Arial", Font.BOLD, 30));
        produktOdczyt.setFont(new Font("Arial", Font.BOLD, 30));


        panel3.add(scrollPane);
        panel3.add(firmaOdczyt);
        panel3.add(uwagiOdczyt);
        panel3.add(ocenaOdczyt);
        panel3.add(produktOdczyt);
        panel3.add(przegladaj);
        panel3.add(goToZapis);
        panel3.add(search);
        panel3.add(searchB);
        panel3.add(labelFirma1);
        panel3.add(labelProdukt1);
        panel3.add(labelOcena1);
        panel3.add(labelUwagi1);
        panel3.add(delete);

        panel2.add(firmaZapis);
        panel2.add(produktZapis);
        panel2.add(ocenaZapis);
        panel2.add(uwagiZapis);
        panel2.add(goToOdczyt);
        panel2.add(save);
        panel2.add(labelFirma);
        panel2.add(labelProdukt);
        panel2.add(labelOcena);
        panel2.add(labelUwagi);

        scrollPane.setBounds(150,200,250,650);

        goToOdczyt.setBounds(1650,15,200,150);
        goToZapis.setBounds(1650,15,200,150);
        browse.setBounds(650,50,200,50);
        save.setBounds(970,50,250,80);
        delete.setBounds(500, 80, 250, 50);
        przegladaj.setBounds(970,50,250,80);
        searchB.setBounds(150, 80, 250, 50);

        delete.setVisible(false);

        search.setBounds(150, 140, 250, 50);

        StyledDocument style = produktOdczyt.getStyledDocument();
        SimpleAttributeSet align= new SimpleAttributeSet();
        StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
        style.setParagraphAttributes(0, style.getLength(), align, false);
        StyleConstants.setSpaceAbove(align, 30);
        StyleConstants.setSpaceBelow(align, 30);

        firmaOdczyt.setBounds(500,200,600,300);
        produktOdczyt.setBounds(1150,200,600,300);
        ocenaOdczyt.setBounds(500,550,600,300);
        uwagiOdczyt.setBounds(1150,550,600,300);

        firmaZapis.setBounds(500,200,600,300);
        produktZapis.setBounds(1150,200,600,300);
        ocenaZapis.setBounds(500,550,600,300);
        uwagiZapis.setBounds(1150,550,600,300);

        labelFirma.setBounds(1450,150,100,50);
        labelProdukt.setBounds(770,150,100,50);
        labelOcena.setBounds(770,500,100,50);
        labelUwagi.setBounds(1450,500,100,50);

        labelFirma1.setBounds(1450,150,100,50);
        labelProdukt1.setBounds(770,150,100,50);
        labelOcena1.setBounds(770,500,100,50);
        labelUwagi1.setBounds(1450,500,100,50);

        panel.setBounds(0,0,1980,1080);
        panel2.setBounds(0,0,1980,1080);
        panel2.setBackground(Color.lightGray);
        panel3.setBounds(0,0,1980,1080);
        panel3.setBackground(Color.lightGray);

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
        delete.addActionListener(new guzikListener());



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





        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {

                boolean isItemSelected = jList.getSelectedValue() != null;
                delete.setVisible(isItemSelected);

                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery("SELECT * FROM produkty WHERE ID = "+Integer.toString(jList.getSelectedIndex() + 1));



                    while (load.next())
                    {
                        String produkt = load.getString("produkt");
                        String firma = load.getString("firma");
                        int ocena = load.getInt("ocena");
                        String uwagi = load.getString("uwagi");
                        produktOdczyt.setText(produkt);
                        firmaOdczyt.setText(firma);
                        ocenaOdczyt.setText(Integer.toString(ocena));
                        uwagiOdczyt.setText(uwagi);
                        ID = load.getInt("ID");
                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    class guzikListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == goToZapis){
                panel2.setVisible(true);
                panel3.setVisible(false);
                modelListy.clear();
            }

            else if(e.getSource() == delete){

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    int deletedID = stmt.executeUpdate("DELETE FROM produkty WHERE ID = "+ID);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }



            else if (e.getSource() == searchB){
                modelListy.clear();
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery("SELECT * FROM produkty WHERE produkt LIKE '%"+ search.getText() + "%' OR firma LIKE '%" + search.getText() +  "%'");
                    while (load.next()){
                        String nazwa = load.getString("produkt")+ "                        " + load.getString("firma");
                        modelListy.addElement(nazwa);

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
            else if (e.getSource() == przegladaj){
                modelListy.clear();
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery("SELECT produkt, firma FROM produkty");

                    while (load.next()){
                        String nazwa = load.getString("produkt")+ "                        " + load.getString("firma");
                        modelListy.addElement(nazwa);

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
            else if (e.getSource() == goToOdczyt){
                panel2.setVisible(false);
                panel3.setVisible(true);

            }

            else if(e.getSource() == save) {
                try {
                    int parsedValue = Integer.parseInt(ocenaZapis.getText());

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                        Statement stmt = con.createStatement();
                        int ileID = 0;
                        String ile = "SELECT COUNT(*) FROM produkty";

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
        gui inf = new gui();
        inf.menu();
    }
}
