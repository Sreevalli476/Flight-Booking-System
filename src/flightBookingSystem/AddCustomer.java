package flightBookingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {

	JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone, tfemail;
	JRadioButton rbmale, rbfemale;
	JButton save;

	public AddCustomer() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
		heading.setBounds(220, 20, 500, 35);
		heading.setForeground(Color.BLUE);
		add(heading);

		// Nationality
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnationality.setBounds(60, 80, 150, 25);
		add(lblnationality);

		tfnationality = new JTextField();
		tfnationality.setBounds(220, 80, 150, 25);
		add(tfnationality);

		// Name
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblname.setBounds(60, 130, 150, 25);
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(220, 130, 150, 25);
		add(tfname);

		// Aadhaar
		JLabel lblaadhar = new JLabel("Aadhaar Number");
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaadhar.setBounds(60, 180, 150, 25);
		add(lblaadhar);

		tfaadhar = new JTextField();
		tfaadhar.setBounds(220, 180, 150, 25);
		add(tfaadhar);

		// Address
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbladdress.setBounds(60, 230, 150, 25);
		add(lbladdress);

		tfaddress = new JTextField();
		tfaddress.setBounds(220, 230, 150, 25);
		add(tfaddress);

		// Gender
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblgender.setBounds(60, 280, 150, 25);
		add(lblgender);

		rbmale = new JRadioButton("Male");
		rbmale.setBounds(220, 280, 80, 25);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);

		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(310, 280, 100, 25);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);

		// Phone
		JLabel lblphone = new JLabel("Phone Number");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblphone.setBounds(60, 330, 150, 25);
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(220, 330, 150, 25);
		add(tfphone);

		// Email
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblemail.setBounds(60, 380, 150, 25);
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(220, 380, 150, 25);
		add(tfemail);

		// Employee Image
		ImageIcon i1 = new ImageIcon(
				ClassLoader.getSystemResource("flightBookingSystem/icons/emp.png"));

		Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);

		ImageIcon i3 = new ImageIcon(i2);

		JLabel image = new JLabel(i3);
		image.setBounds(500, 120, 350, 350);
		add(image);

		// Save Button
		save = new JButton("Save");
		save.setBounds(220, 450, 120, 30);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.addActionListener(this);
		add(save);

		setSize(900, 600);
		setLocation(300, 150);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		try {

			String name = tfname.getText();
			String nationality = tfnationality.getText();
			String aadhar = tfaadhar.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();

			String gender = null;

			if (rbmale.isSelected()) {
				gender = "Male";
			} else if (rbfemale.isSelected()) {
				gender = "Female";
			}

			Conn c = new Conn();

			String query = "insert into customer values('"
					+ name + "','"
					+ nationality + "','"
					+ aadhar + "','"
					+ address + "','"
					+ gender + "','"
					+ phone + "','"
					+ email + "')";

			c.s.executeUpdate(query);

			JOptionPane.showMessageDialog(null,
					"Customer Details Added Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new AddCustomer();
	}
}