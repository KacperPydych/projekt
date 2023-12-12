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
public class gui extends JFrame  {
    JButton goToZapis, przegladaj,goToOdczyt, browse,save, searchB ;
    JPanel  panel, panel2, panel3;//panel 3 - odczyt, panel 2 - zapis
    JTextArea firmaOdczyt, ocenaOdczyt, uwagiOdczyt, produktOdczyt, firmaZapis, ocenaZapis, uwagiZapis, produktZapis,search;
    JFrame rama ;
    JLabel labelFirma, labelProdukt, labelOcena, labelUwagi,labelFirma1, labelProdukt1, labelOcena1, labelUwagi1;

    DefaultListModel<String> modelListy = new DefaultListModel<>();
    JList<String> jList = new JList<>(modelListy);
    JScrollPane scrollPane = new JScrollPane(jList);
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
        browse = new JButton("wczytaj dane ");
        save = new JButton("zapisz dane ");
        searchB = new JButton("szukaj");
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
        produktOdczyt = new JTextArea();
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
        panel3.add(labelFirma1);
        panel3.add(labelProdukt1);
        panel3.add(labelOcena1);
        panel3.add(labelUwagi1);

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

        goToOdczyt.setBounds(500,50,100,50);
        goToZapis.setBounds(500,50,100,50);
        browse.setBounds(650,50,200,50);
        save.setBounds(650,50,200,50);
        przegladaj.setBounds(1250,125,250,80);
        searchB.setBounds(200, 80, 300, 50);

        search.setBounds(200, 140, 300, 50);

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
