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
        JLabel heading = new JLabel("AIR INDIA RESERVATION SYSTEM");

        heading.setBounds(380, 30, 900, 60);

        heading.setForeground(new Color(255,215,0)); // Gold
        heading.setOpaque(true);
        heading.setBackground(new Color(0,0,0,120));
        

        heading.setFont(new Font("Serif", Font.BOLD, 48));
        image.add(heading);
        
        JLabel tagline = new JLabel(
                "••• Connecting Cities, Connecting Dreams••• ");
      

        tagline.setBounds(520, 90, 500, 30);

        tagline.setForeground(Color.WHITE);

        tagline.setFont(
                new Font("Tahoma", Font.BOLD, 20));

        image.add(tagline);
        
        
        JLabel card =
        		new JLabel(
        		"<html><center>Welcome to Air India Reservation System<br>Book • Manage • Travel</center></html>");
        card.setBounds(500, 220, 500, 120);

        		card.setOpaque(true);

        		card.setBackground(new Color(255,255,255,220));
        		card.setHorizontalAlignment(
        		JLabel.CENTER);

        		card.setFont(
        		new Font("Segoe UI",
        		Font.BOLD,
        		22));

        		image.add(card);
        		
        

        // Menu Bar
        JMenuBar menubar = new JMenuBar();

        menubar.setBackground(new Color(153, 0, 0));

        setJMenuBar(menubar);

        // DETAILS MENU
        JMenu details = new JMenu("Details");

        details.setFont(
                new Font("Segoe UI", Font.BOLD, 16));
        details.setForeground(Color.WHITE);

        menubar.add(details);

        flightDetails = new JMenuItem("Flight Details");
        flightDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        flightDetails.setBackground(Color.WHITE);
        flightDetails.setForeground(new Color(153, 0, 0));
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        addCustomerDetails = new JMenuItem("Add Customer Details");
        addCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addCustomerDetails.setBackground(Color.WHITE);
        addCustomerDetails.setForeground(new Color(153, 0, 0));
        addCustomerDetails.addActionListener(this);
        details.add(addCustomerDetails);
        
        bookFlight = new JMenuItem("Book Flight");
        bookFlight.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bookFlight.setBackground(Color.WHITE);
        bookFlight.setForeground(new Color(153, 0, 0));
        bookFlight.addActionListener(this);
        details.add(bookFlight);


        journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        journeyDetails.setBackground(Color.WHITE);
        journeyDetails.setForeground(new Color(153, 0, 0));
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        
        cancelTicket = new JMenuItem("Cancel Ticket");
        cancelTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cancelTicket.setBackground(Color.WHITE);
        cancelTicket.setForeground(new Color(153, 0, 0));
        cancelTicket.addActionListener(this);
        details.add(cancelTicket);
        

        // TICKETS MENU
        JMenu tickets = new JMenu("Tickets");
        tickets.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tickets.setForeground(Color.WHITE);
        menubar.add(tickets);

        boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
        boardingPass.setBackground(Color.WHITE);
        boardingPass.setForeground(new Color(153, 0, 0));
        boardingPass.addActionListener(this);
        tickets.add(boardingPass);

        ticketDetails = new JMenuItem("Ticket Details");
        ticketDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ticketDetails.setBackground(Color.WHITE);
        ticketDetails.setForeground(new Color(153, 0, 0));
        ticketDetails.addActionListener(this);
        tickets.add(ticketDetails);
        // Frame Settings
        setTitle("Air India Reservation System");

        getContentPane().setBackground(
                new Color(255, 248, 240));

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JLabel footer = new JLabel(
        		"© 2026 Air India Reservation System");

        footer.setBounds(600, 700, 900, 90);

        		footer.setForeground(Color.WHITE);

        		footer.setFont(
        				new Font("Segoe UI",
        				Font.BOLD,
        				18));
        		image.add(footer);

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