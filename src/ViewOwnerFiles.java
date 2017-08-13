import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewOwnerFiles {

	JFrame jf = new JFrame("Owner Files");
	Container c;
	JScrollPane pane = new JScrollPane();
	public Font f = new Font("Times new roman", Font.PLAIN, 15);
	private static Connection connect;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ViewOwnerFiles() {
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.lightGray);

		try {

			Vector heading = new Vector();

			heading.addElement("File-Name");
			heading.addElement("Balancer");
			heading.addElement("B-Node");
			heading.addElement("Public Key");
			heading.addElement("Secret-Key");

			Vector data = new Vector();
			connect = DBConnection.getConnection();
			Statement stmt = connect.createStatement();

			String ex = "select * from ServerFiles";

			ResultSet rs = stmt.executeQuery(ex);

			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();

			while (rs.next()) {

				Vector row = new Vector();
				for (int i = 1; i <= col; i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}

			JTable table = new JTable(data, heading);
			table.setForeground(Color.blue);
			table.setFont(f);
			pane = new JScrollPane(table);

			pane.setBounds(40, 30, 350, 200);
			c.add(pane);

		} catch (Exception exx) {
			System.out.println(exx.getMessage());
		}

		jf.setSize(450, 300);
		jf.setResizable(false);
		jf.setVisible(true);

	}
}
