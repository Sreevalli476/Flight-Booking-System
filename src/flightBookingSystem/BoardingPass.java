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

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JButton fetch;

    JLabel lblname, lblnationality, lblflightname,
            lblflightcode, lblsource, lbldestination,
            lbldate, lblticket;

    public BoardingPass() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA BOARDING PASS");
        heading.setBounds(150, 20, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblpnrno = new JLabel("PNR Number");
        lblpnrno.setBounds(50, 80, 100, 25);
        add(lblpnrno);

        tfpnr = new JTextField();
        tfpnr.setBounds(180, 80, 150, 25);
        add(tfpnr);

        fetch = new JButton("Fetch");
        fetch.setBounds(360, 80, 100, 25);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);

        JLabel name = new JLabel("Passenger Name");
        name.setBounds(50, 150, 150, 25);
        add(name);

        lblname = new JLabel();
        lblname.setBounds(250, 150, 200, 25);
        add(lblname);

        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(50, 190, 150, 25);
        add(nationality);

        lblnationality = new JLabel();
        lblnationality.setBounds(250, 190, 200, 25);
        add(lblnationality);

        JLabel flightname = new JLabel("Flight Name");
        flightname.setBounds(50, 230, 150, 25);
        add(flightname);

        lblflightname = new JLabel();
        lblflightname.setBounds(250, 230, 200, 25);
        add(lblflightname);

        JLabel flightcode = new JLabel("Flight Code");
        flightcode.setBounds(50, 270, 150, 25);
        add(flightcode);

        lblflightcode = new JLabel();
        lblflightcode.setBounds(250, 270, 200, 25);
        add(lblflightcode);

        JLabel source = new JLabel("Source");
        source.setBounds(50, 310, 150, 25);
        add(source);

        lblsource = new JLabel();
        lblsource.setBounds(250, 310, 200, 25);
        add(lblsource);

        JLabel destination = new JLabel("Destination");
        destination.setBounds(50, 350, 150, 25);
        add(destination);

        lbldestination = new JLabel();
        lbldestination.setBounds(250, 350, 200, 25);
        add(lbldestination);

        JLabel date = new JLabel("Date Of Travel");
        date.setBounds(50, 390, 150, 25);
        add(date);

        lbldate = new JLabel();
        lbldate.setBounds(250, 390, 200, 25);
        add(lbldate);

        JLabel ticket = new JLabel("Ticket Number");
        ticket.setBounds(50, 430, 150, 25);
        add(ticket);

        lblticket = new JLabel();
        lblticket.setBounds(250, 430, 200, 25);
        add(lblticket);

        setSize(700, 550);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == fetch) {

            try {

                Conn c = new Conn();

                String query = "select * from reservation where pnr='"
                        + tfpnr.getText() + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    lblname.setText(rs.getString("name"));
                    lblnationality.setText(rs.getString("nationality"));
                    lblflightname.setText(rs.getString("flightname"));
                    lblflightcode.setText(rs.getString("flightcode"));
                    lblsource.setText(rs.getString("src"));
                    lbldestination.setText(rs.getString("des"));
                    lbldate.setText(rs.getString("ddate"));
                    lblticket.setText(rs.getString("ticket"));

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Invalid PNR Number");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new BoardingPass();
    }
}