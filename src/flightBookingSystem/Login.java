package flightBookingSystem;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	JButton reset, submit, close;
	JTextField tfusername;
	JPasswordField tfpassword;

	public Login() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(20, 20, 100, 20);
		add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(130, 20, 200, 20);
		add(tfusername);

		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(20, 60, 100, 20);
		add(lblpassword);

		tfpassword = new JPasswordField();
		tfpassword.setBounds(130, 60, 200, 20);
		add(tfpassword);

		reset = new JButton("Reset");
		reset.setBounds(40, 120, 120, 30);
		reset.addActionListener(this);
		add(reset);

		submit = new JButton("Submit");
		submit.setBounds(190, 120, 120, 30);
		submit.addActionListener(this);
		add(submit);

		close = new JButton("Close");
		close.setBounds(120, 170, 120, 30);
		close.addActionListener(this);
		add(close);

		setSize(400, 300);
		setLocation(600, 250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == submit) {

			try {

				String username = tfusername.getText();
				String password = tfpassword.getText();

				Conn c = new Conn();

				String query = "select * from login where username = '" + username
						+ "' and password = '" + password + "'";

				ResultSet rs = c.s.executeQuery(query);

				if (rs.next()) {

					JOptionPane.showMessageDialog(null, "Login Successful");

					setVisible(false);

					new Home();

				} else {

					JOptionPane.showMessageDialog(null,
							"Invalid Username or Password");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (ae.getSource() == close) {

			System.exit(0);

		}

		else if (ae.getSource() == reset) {

			tfusername.setText("");
			tfpassword.setText("");
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}