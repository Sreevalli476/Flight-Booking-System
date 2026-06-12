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

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel lblname, lblfcode, lbldate;
    JButton fetchButton, cancelButton;

    public Cancel() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("CANCEL TICKET");
        heading.setBounds(220, 20, 350, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(50, 80, 100, 25);
        add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(180, 80, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Fetch Details");
        fetchButton.setBounds(360, 80, 130, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname1 = new JLabel("Passenger Name");
        lblname1.setBounds(50, 150, 120, 25);
        add(lblname1);

        lblname = new JLabel();
        lblname.setBounds(180, 150, 200, 25);
        add(lblname);

        JLabel lblfcode1 = new JLabel("Flight Code");
        lblfcode1.setBounds(50, 200, 120, 25);
        add(lblfcode1);

        lblfcode = new JLabel();
        lblfcode.setBounds(180, 200, 200, 25);
        add(lblfcode);

        JLabel lbldate1 = new JLabel("Date Of Travel");
        lbldate1.setBounds(50, 250, 120, 25);
        add(lbldate1);

        lbldate = new JLabel();
        lbldate.setBounds(180, 250, 200, 25);
        add(lbldate);

        cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(220, 330, 150, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(700, 450);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // FETCH DETAILS
        if (ae.getSource() == fetchButton) {

            try {

                Conn c = new Conn();

                String query = "select * from reservation where pnr='"
                        + tfpnr.getText().trim() + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    lblname.setText(rs.getString("name"));
                    lblfcode.setText(rs.getString("flightcode"));
                    lbldate.setText(rs.getString("ddate"));

                } else {

                    JOptionPane.showMessageDialog(null,
                            "No Ticket Found");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        // CANCEL TICKET
        else if (ae.getSource() == cancelButton) {

            try {

                if (tfpnr.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Please Enter PNR Number");

                    return;
                }

                Conn c = new Conn();

                String query = "delete from reservation where pnr='"
                        + tfpnr.getText().trim() + "'";

                int result = c.s.executeUpdate(query);

                if (result > 0) {

                    JOptionPane.showMessageDialog(null,
                            "Ticket Cancelled Successfully");

                    tfpnr.setText("");
                    lblname.setText("");
                    lblfcode.setText("");
                    lbldate.setText("");

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

        new Cancel();
    }
}