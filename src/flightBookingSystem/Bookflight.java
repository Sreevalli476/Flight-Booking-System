package flightBookingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bookflight extends JFrame implements ActionListener {

    JTextField tfaadhar, tfname, tfnationality;
    JTextField tfsource, tfdestination, tfdate;

    JButton fetchUser, bookFlight;

    public Bookflight() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        heading.setBounds(320, 20, 300, 35);
        add(heading);

        JLabel lblaadhar = new JLabel("Aadhaar");
        lblaadhar.setBounds(60, 80, 120, 25);
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);

        fetchUser = new JButton("Fetch User");
        fetchUser.setBounds(390, 80, 120, 25);
        fetchUser.addActionListener(this);
        add(fetchUser);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 120, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 120, 25);
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 230, 120, 25);
        add(lblsource);

        tfsource = new JTextField();
        tfsource.setBounds(220, 230, 150, 25);
        add(tfsource);

        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(60, 280, 120, 25);
        add(lbldestination);

        tfdestination = new JTextField();
        tfdestination.setBounds(220, 280, 150, 25);
        add(tfdestination);

        JLabel lbldate = new JLabel("Date Of Travel");
        lbldate.setBounds(60, 330, 120, 25);
        add(lbldate);

        tfdate = new JTextField();
        tfdate.setBounds(220, 330, 150, 25);
        add(tfdate);

        bookFlight = new JButton("Book Flight");
        bookFlight.setBounds(220, 400, 150, 30);
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.addActionListener(this);
        add(bookFlight);
        
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("flightBookingSystem/icons/details.jpg"));

        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);

		image.setBounds(450, 160, 400, 300);

		add(image);


        setSize(950, 650);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == fetchUser) {

            try {

                Conn c = new Conn();

                String query = "select * from customer where aadhar='"
                        + tfaadhar.getText() + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Customer Not Found");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == bookFlight) {

            try {

                Random random = new Random();

                String pnr = "PNR" + random.nextInt(100000);
                String ticket = "TKT" + random.nextInt(100000);

                Conn c = new Conn();

                String query = "insert into reservation values('"
                        + pnr + "','"
                        + ticket + "','"
                        + tfaadhar.getText() + "','"
                        + tfname.getText() + "','"
                        + tfnationality.getText() + "','"
                        + "Air India','"
                        + "AI101','"
                        + tfsource.getText() + "','"
                        + tfdestination.getText() + "','"
                        + tfdate.getText() + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,
                        "Flight Booked Successfully\nPNR : "
                                + pnr + "\nTicket : " + ticket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Bookflight();
    }
}