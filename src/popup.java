import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class popup {

    JFrame ramaP = new JFrame();
    JPanel panelP = new JPanel();
    JTextArea firma =new JTextArea();
    JTextArea produkt =new JTextArea();

    JButton szukaj = new JButton("szukaj");
    popup(){
        ramaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramaP.setSize(1680,850);
        ramaP.setVisible(true);
        ramaP.setLocationRelativeTo(null);

        firma.setBounds(100,100,300,100);
        produkt.setBounds(800,100,300,100);
        szukaj.setBounds(600,300,100,100);
        panelP.setBounds(0,0,1900, 1000);

        ramaP.getContentPane().add(panelP);
        panelP.add(firma);
        panelP.add(produkt);
        panelP.add(szukaj);

        ramaP.setLayout(null);
        panelP.setLayout(null);


        firma.setBackground(Color.lightGray);
        produkt.setBackground(Color.lightGray);


    }

    class guzikListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==szukaj){
               // Connection con = null;
                String ch = "SELECT * FROM produkty WHERE ID = ";
                String check = "";
               if(firma.getText().trim().isEmpty()==false&&produkt.getText().trim().isEmpty()==false){
                   Connection con = null;

                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "kacper");
                    Statement stmt = con.createStatement();
                    ResultSet load = stmt.executeQuery("SELECT ");
                    while (load.next()){
                        String nazwa = load.getString("produkt")+ "                        " + load.getString("firma");


                    }
                }



                catch (SQLException ex) {
                    throw new RuntimeException(ex);

                    }

             }

        }
    }

}
}
