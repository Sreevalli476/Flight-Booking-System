package flightBookingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {

    JMenuItem flightDetails, addCustomerDetails, bookFlight,
            journeyDetails, cancelTicket, boardingPass, ticketDetails;

    public Home() {

        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource(
                        "flightBookingSystem/icons/front.jpg"));

        Image i2 = i1.getImage().getScaledInstance(
                1600, 800, Image.SCALE_SMOOTH);

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);

        image.setBounds(0, 0, 1600, 800);

        add(image);

        // Heading
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");

        heading.setBounds(450, 40, 700, 50);

        heading.setForeground(new Color(179, 0, 0));

        heading.setFont(new Font("Serif", Font.BOLD, 42));

        image.add(heading);

        // Menu Bar
        JMenuBar menubar = new JMenuBar();

        menubar.setBackground(new Color(255, 248, 240));

        setJMenuBar(menubar);

        // DETAILS MENU
        JMenu details = new JMenu("Details");

        details.setFont(new Font("Tahoma", Font.BOLD, 15));

        details.setForeground(new Color(153, 0, 0));

        menubar.add(details);

        flightDetails = new JMenuItem("Flight Details");
        flightDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        addCustomerDetails = new JMenuItem(
                "Add Customer Details");
        addCustomerDetails.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        addCustomerDetails.addActionListener(this);
        details.add(addCustomerDetails);

        bookFlight = new JMenuItem("Book Flight");
        bookFlight.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        journeyDetails = new JMenuItem(
                "Journey Details");
        journeyDetails.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        cancelTicket = new JMenuItem(
                "Cancel Ticket");
        cancelTicket.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        cancelTicket.addActionListener(this);
        details.add(cancelTicket);

        // TICKETS MENU
        JMenu tickets = new JMenu("Tickets");

        tickets.setFont(new Font("Tahoma", Font.BOLD, 15));

        tickets.setForeground(new Color(153, 0, 0));

        menubar.add(tickets);

        boardingPass = new JMenuItem(
                "Boarding Pass");
        boardingPass.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        boardingPass.addActionListener(this);
        tickets.add(boardingPass);

        ticketDetails = new JMenuItem(
                "Ticket Details");
        ticketDetails.setFont(
                new Font("Tahoma", Font.PLAIN, 14));
        ticketDetails.addActionListener(this);
        tickets.add(ticketDetails);

        // Frame Settings
        setTitle("Air India Reservation System");

        getContentPane().setBackground(
                new Color(255, 248, 240));

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == flightDetails) {

            new Flightinfo();

        } else if (ae.getSource()
                == addCustomerDetails) {

            new AddCustomer();

        } else if (ae.getSource()
                == bookFlight) {

            new Bookflight();

        } else if (ae.getSource()
                == journeyDetails) {

            new JourneyDetails();

        } else if (ae.getSource()
                == cancelTicket) {

            new Cancel();

        } else if (ae.getSource()
                == boardingPass) {

            new BoardingPass();

        } else if (ae.getSource()
                == ticketDetails) {

            new TicketDetails();
        }
    }

    public static void main(String[] args) {

        new Home();
    }
}