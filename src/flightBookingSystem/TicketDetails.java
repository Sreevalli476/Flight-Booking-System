package flightBookingSystem;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TicketDetails extends JFrame {

    JTable table;
    DefaultTableModel model;

    public TicketDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Column Names
        String[] columns = {
                "PNR", "Ticket No", "Aadhaar", "Name",
                "Nationality", "Flight Name", "Flight Code",
                "Source", "Destination", "Date"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10, 10, 960, 500);
        add(jsp);

        // Fetch data from database
        try {

            Conn c = new Conn();

            String query = "select * from reservation";

            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {

                Vector<String> row = new Vector<String>();

                row.add(rs.getString("pnr"));
                row.add(rs.getString("ticket"));
                row.add(rs.getString("aadhar"));
                row.add(rs.getString("name"));
                row.add(rs.getString("nationality"));
                row.add(rs.getString("flightname"));
                row.add(rs.getString("flightcode"));
                row.add(rs.getString("src"));
                row.add(rs.getString("des"));
                row.add(rs.getString("ddate"));

                model.addRow(row);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        setSize(1000, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public static void main(String[] args) {

        new TicketDetails();
    }
}