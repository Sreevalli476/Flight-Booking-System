package flightBookingSystem;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Flightinfo extends JFrame {

	public Flightinfo() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		String[] columnNames = {
				"Flight Code",
				"Flight Name",
				"Source",
				"Destination"
		};

		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		JTable table = new JTable(model);

		try {

			Conn conn = new Conn();

			ResultSet rs = conn.s.executeQuery("select * from flight");

			while (rs.next()) {

				String code = rs.getString(1);
				String name = rs.getString(2);
				String source = rs.getString(3);
				String destination = rs.getString(4);

				model.addRow(new Object[] {
						code,
						name,
						source,
						destination
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 800, 500);
		add(jsp);

		setSize(800, 500);
		setLocation(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Flightinfo();
	}
}