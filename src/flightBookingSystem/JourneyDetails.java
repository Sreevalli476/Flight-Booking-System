package flightBookingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JourneyDetails extends JFrame implements ActionListener {

    JTextField tfpnr;
    JButton show;

    public JourneyDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("JOURNEY DETAILS");
        heading.setBounds(230, 20, 350, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(50, 100, 100, 25);
        add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(170, 100, 150, 25);
        add(tfpnr);

        show = new JButton("Show Details");
        show.setBounds(350, 100, 140, 25);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(this);
        add(show);

        setSize(700, 500);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == show) {

            try {

                Conn c = new Conn();

                String query = "select * from reservation where pnr = '"
                        + tfpnr.getText() + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null,
                            "Passenger Name : " + rs.getString("name")
                                    + "\nTicket Number : "
                                    + rs.getString("ticket")
                                    + "\nFlight Name : "
                                    + rs.getString("flightname")
                                    + "\nFlight Code : "
                                    + rs.getString("flightcode")
                                    + "\nSource : "
                                    + rs.getString("src")
                                    + "\nDestination : "
                                    + rs.getString("des")
                                    + "\nDate : "
                                    + rs.getString("ddate"));

                } else {

                    JOptionPane.showMessageDialog(null,
                            "No Journey Found for this PNR");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new JourneyDetails();
    }
}