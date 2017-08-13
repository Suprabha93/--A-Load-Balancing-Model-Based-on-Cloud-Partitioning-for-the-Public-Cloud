import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CloudServer extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x;

	public Font f1 = new Font("Times new roman", Font.BOLD, 25);

	JPanel c = new JPanel();

	JLabel image1, image2, image3, image5, image4;
	ImageIcon im1, im2, im3, im4;

	JLabel b11 = new JLabel();
	JLabel b12 = new JLabel();

	JLabel b21 = new JLabel();
	JLabel b22 = new JLabel();

	JLabel b31 = new JLabel();
	JLabel b32 = new JLabel();

	JLabel b41 = new JLabel();
	JLabel b42 = new JLabel();

	JButton view = new JButton("VIEW LOAD STATUS");
	JButton owner = new JButton("VIEW OWNER FILES");
	JButton block = new JButton("BLOCKED USER");
	JButton update = new JButton("UPDATE BALANCER STATUS");

	JLabel b1, b2, b3, b4, h1, h2, h3, h4;
	ImageIcon ln1, ln2;

	ImageIcon s1, s2, s3, s4, s5;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;

	ImageIcon im, green1, green;
	JLabel img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11,
			img12;

	private static Connection con;
	
	
	JLabel ba = new JLabel("BALANCER-A");
	JLabel bb = new JLabel("BALANCER-B");
	JLabel bc = new JLabel("BALANCER-C");
	JLabel bd = new JLabel("BALANCER-D");
	

	@SuppressWarnings("deprecation")
	CloudServer() {

		setTitle("Cloud Server::A Load Balancing Model Based on Cloud Partitioning for the Public Cloud ");
		c.setLayout(null);
		setSize(850, 700);
		setVisible(true);
		setResizable(false);
		c.setBackground(Color.ORANGE);

		b11.setFont(f1);
		b21.setFont(f1);
		b31.setFont(f1);
		b41.setFont(f1);

		view.setBounds(600, 200, 200, 35);
		owner.setBounds(600, 300, 200, 35);
		block.setBounds(600, 400, 200, 35);
		update.setBounds(600, 500, 200, 35);

		view.setBackground(Color.gray);
		view.setForeground(Color.yellow);

		owner.setBackground(Color.gray);
		owner.setForeground(Color.yellow);

		block.setBackground(Color.gray);
		block.setForeground(Color.yellow);

		update.setBackground(Color.gray);
		update.setForeground(Color.yellow);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("CloudServer.png"));
		JLabel title=new JLabel();
		title.setIcon(banner);
		title.setBounds(0, -15, 850, 100);
		

		green = new ImageIcon(this.getClass().getResource("balancer1.png"));

		im = new ImageIcon(this.getClass().getResource("node.png"));

		green1 = new ImageIcon(this.getClass().getResource("computer.jpeg"));

		img1 = new JLabel();
		img2 = new JLabel();
		img3 = new JLabel();
		img4 = new JLabel();
		img5 = new JLabel();
		img6 = new JLabel();
		img7 = new JLabel();
		img8 = new JLabel();
		img9 = new JLabel();
		img10 = new JLabel();
		img11 = new JLabel();
		img12 = new JLabel();

		img1.setIcon(im);
		img2.setIcon(im);
		img3.setIcon(im);
		img4.setIcon(im);
		img5.setIcon(im);
		img6.setIcon(im);
		img7.setIcon(im);
		img8.setIcon(im);
		img9.setIcon(im);
		img10.setIcon(im);
		img11.setIcon(im);
		img12.setIcon(im);

		ba.setBounds(155, 220, 150, 50);
		bb.setBounds(520, 220, 150, 50);
		bc.setBounds(200, 520, 150, 50);
		bd.setBounds(540, 520, 150, 50);
		
		
		
		
		img1.setBounds(55, 90, 50, 50);
		img2.setBounds(110, 90, 50, 50);
		img3.setBounds(160, 90, 50, 50);

		img4.setBounds(405, 90, 50, 50);
		img5.setBounds(460, 90, 50, 50);
		img6.setBounds(510, 90, 50, 50);

		img7.setBounds(55, 590, 50, 50);
		img8.setBounds(110, 590, 50, 50);
		img9.setBounds(160, 590, 50, 50);

		img10.setBounds(405, 590, 50, 50);
		img11.setBounds(460, 590, 50, 50);
		img12.setBounds(510, 590, 50, 50);

		s1 = new ImageIcon(this.getClass().getResource("line1.png"));
		s2 = new ImageIcon(this.getClass().getResource("line2.png"));
		s3 = new ImageIcon(this.getClass().getResource("line3.png"));
		s4 = new ImageIcon(this.getClass().getResource("line4.png"));
		s5 = new ImageIcon(this.getClass().getResource("line5.png"));

		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		l10 = new JLabel();
		l11 = new JLabel();
		l12 = new JLabel();

		l1.setIcon(s1);
		l2.setIcon(s5);
		l3.setIcon(s2);

		l4.setIcon(s1);
		l5.setIcon(s5);
		l6.setIcon(s2);

		l7.setIcon(s4);
		l8.setIcon(s5);
		l9.setIcon(s3);

		l10.setIcon(s4);
		l11.setIcon(s5);
		l12.setIcon(s3);

		l1.setBounds(80, 110, 25, 125);
		l2.setBounds(128, 127, 25, 80);
		l3.setBounds(140, 127, 75, 90);

		l4.setBounds(428, 110, 25, 125);
		l5.setBounds(480, 127, 25, 80);
		l6.setBounds(490, 127, 75, 90);

		l7.setBounds(80, 515, 75, 90);
		l8.setBounds(128, 527, 25, 80);
		l9.setBounds(140, 510, 75, 100);

		l10.setBounds(428, 500, 25, 125);
		l11.setBounds(480, 527, 25, 80);
		l12.setBounds(490, 510, 75, 90);

		im1 = new ImageIcon(this.getClass().getResource("balancer.png"));
		im2 = new ImageIcon(this.getClass().getResource("controller.png"));

		image1 = new JLabel();
		image1.setIcon(im2);
		image1.setBounds(250, 275, 150, 200);

		image2 = new JLabel();
		image2.setIcon(im1);
		image2.setBounds(100, 150, 100, 150);

		b11.setBounds(100, 130, 100, 30);

		image3 = new JLabel();
		image3.setIcon(im1);
		image3.setBounds(100, 450, 100, 150);

		b31.setBounds(100, 425, 100, 30);

		image4 = new JLabel();
		image4.setIcon(im1);
		image4.setBounds(450, 450, 100, 150);

		b41.setBounds(450, 425, 100, 30);

		image5 = new JLabel();
		image5.setIcon(im1);
		image5.setBounds(450, 150, 100, 150);
		b21.setBounds(450, 130, 100, 30);

		ln1 = new ImageIcon(this.getClass().getResource("str.png"));
		ln2 = new ImageIcon(this.getClass().getResource("vert.png"));

		h1 = new JLabel();
		h1.setIcon(ln1);
		h1.setBounds(140, 350, 100, 25);

		h2 = new JLabel();
		h2.setIcon(ln1);
		h2.setBounds(360, 350, 100, 25);

		h3 = new JLabel();
		h3.setIcon(ln1);
		h3.setBounds(140, 370, 100, 25);

		h4 = new JLabel();
		h4.setIcon(ln1);
		h4.setBounds(360, 370, 100, 25);

		b1 = new JLabel();
		b1.setIcon(ln2);
		b1.setBounds(138, 248, 25, 150);

		b2 = new JLabel();
		b2.setIcon(ln2);
		b2.setBounds(456, 245, 25, 150);

		b3 = new JLabel();
		b3.setIcon(ln2);
		b3.setBounds(138, 350, 25, 150);

		b4 = new JLabel();
		b4.setIcon(ln2);
		b4.setBounds(456, 350, 25, 150);

		c.add(h1);
		c.add(h2);
		c.add(h3);
		c.add(h4);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b11);
		c.add(b21);
		c.add(b31);
		c.add(b41);

		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(l7);
		c.add(l8);
		c.add(l9);
		c.add(l10);
		c.add(l11);
		c.add(l12);

		c.add(img1);
		c.add(img2);
		c.add(img3);
		c.add(img4);
		c.add(img5);
		c.add(img6);
		c.add(img7);
		c.add(img8);
		c.add(img9);
		c.add(img10);
		c.add(img11);
		c.add(img12);

		c.add(image1);
		c.add(image2);
		c.add(image3);
		c.add(image4);
		c.add(image5);
		c.add(view);
		c.add(owner);
		c.add(block);
		c.add(update);
		c.add(title);
		c.add(ba);
		c.add(bb);
		c.add(bc);
		c.add(bd);
		
		add(c);

		view.addActionListener(this);
		owner.addActionListener(this);
		block.addActionListener(this);
		update.addActionListener(this);

		int[] ports = new int[] { 100, 101, 1000, 3333 };
		for (int i = 0; i < 4; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.start();
		}

		try {

			String idle = "Idle";
			String normal = "Normal";
			String over = "Overload";

			con = DBConnection.getConnection();

			x = 20;
			String A1 = "A1";
			String A2 = "A2";
			String A3 = "A3";

			Statement stA1 = con.createStatement();
			Statement stA2 = con.createStatement();
			Statement stA3 = con.createStatement();

			String sqlA1 = "update Balancer set Status = '" + idle
					+ "' where BNode = '" + A1 + "'  ";

			String sqlA2 = "update Balancer set Status = '" + normal
					+ "' where BNode = '" + A2 + "'  ";

			String sqlA3 = "update Balancer set Status = '" + over
					+ "' where BNode = '" + A3 + "'  ";

			stA1.executeUpdate(sqlA1);
			stA2.executeUpdate(sqlA2);
			stA3.executeUpdate(sqlA3);

			System.out.println(x);

			String B1 = "B1";
			String B2 = "B2";
			String B3 = "B3";

			Statement stB1 = con.createStatement();
			Statement stB2 = con.createStatement();
			Statement stB3 = con.createStatement();

			String sqlB1 = "update Balancer set Status = '" + idle
					+ "' where BNode = '" + B1 + "'  ";

			String sqlB2 = "update Balancer set Status = '" + normal
					+ "' where BNode = '" + B2 + "'  ";

			String sqlB3 = "update Balancer set Status = '" + over
					+ "' where BNode = '" + B3 + "'  ";

			stB1.executeUpdate(sqlB1);
			stB2.executeUpdate(sqlB2);
			stB3.executeUpdate(sqlB3);

			String C1 = "C1";
			String C2 = "C2";
			String C3 = "C3";

			Statement stC1 = con.createStatement();
			Statement stC2 = con.createStatement();
			Statement stC3 = con.createStatement();

			String sqlC1 = "update Balancer set Status = '" + idle
					+ "' where BNode = '" + C1 + "'  ";

			String sqlC2 = "update Balancer set Status = '" + normal
					+ "' where BNode = '" + C2 + "'  ";

			String sqlC3 = "update Balancer set Status = '" + over
					+ "' where BNode = '" + C3 + "'  ";

			stC1.executeUpdate(sqlC1);
			stC2.executeUpdate(sqlC2);
			stC3.executeUpdate(sqlC3);

			String D1 = "D1";
			String D2 = "D2";
			String D3 = "D3";

			Statement stD1 = con.createStatement();
			Statement stD2 = con.createStatement();
			Statement stD3 = con.createStatement();

			String sqlD1 = "update Balancer set Status = '" + idle
					+ "' where BNode = '" + D1 + "'  ";

			String sqlD2 = "update Balancer set Status = '" + normal
					+ "' where BNode = '" + D2 + "'  ";

			String sqlD3 = "update Balancer set Status = '" + over
					+ "' where BNode = '" + D3 + "'  ";

			stD1.executeUpdate(sqlD1);
			stD2.executeUpdate(sqlD2);
			stD3.executeUpdate(sqlD3);

			Thread t1 = new Thread();
			Thread t2 = new Thread();
			Thread t3 = new Thread();
			Thread t4 = new Thread();

			while (true) {

				t1.resume();
				x = 0;
				t2.suspend();
				t3.suspend();
				t4.suspend();

				b11.setText("ON");
				b21.setText("OFF");
				b31.setText("OFF");
				b41.setText("OFF");

				img1.setIcon(green1);
				img2.setIcon(green1);
				img3.setIcon(green1);

				b41.setForeground(Color.red);
				b21.setForeground(Color.red);
				b31.setForeground(Color.red);
				// b11.setForeground(Color.GREEN);
				b11.setForeground(new Color(0, 255, 0));

				Thread.sleep(5000);

				t2.resume();
				x = 1;
				t1.suspend();
				t3.suspend();
				t4.suspend();

				b11.setText("OFF");
				b21.setText("ON");
				b31.setText("OFF");
				b41.setText("OFF");

				img1.setIcon(im);
				img2.setIcon(im);
				img3.setIcon(im);

				img10.setIcon(im);
				img11.setIcon(im);
				img12.setIcon(im);

				img4.setIcon(green1);
				img5.setIcon(green1);
				img6.setIcon(green1);

				b41.setForeground(Color.red);
				b11.setForeground(Color.red);
				b31.setForeground(Color.red);
				// b21.setForeground(Color.GREEN);
				b21.setForeground(new Color(0, 255, 0));

				Thread.sleep(5000);
				t3.resume();
				x = 2;
				t2.suspend();
				t3.suspend();
				t4.suspend();

				b11.setText("OFF");
				b21.setText("OFF");
				b31.setText("ON");
				b41.setText("OFF");

				img4.setIcon(im);
				img5.setIcon(im);
				img6.setIcon(im);

				img7.setIcon(green1);
				img8.setIcon(green1);
				img9.setIcon(green1);

				b41.setForeground(Color.red);
				b21.setForeground(Color.red);
				b11.setForeground(Color.red);
				// b31.setForeground(Color.GREEN);
				b31.setForeground(new Color(0, 255, 0));

				Thread.sleep(5000);
				t4.resume();
				x = 3;
				t1.suspend();
				t3.suspend();
				t2.suspend();

				b41.setText("ON");
				b21.setText("OFF");
				b31.setText("OFF");
				b11.setText("OFF");

				img7.setIcon(im);
				img8.setIcon(im);
				img9.setIcon(im);

				img10.setIcon(green1);
				img11.setIcon(green1);
				img12.setIcon(green1);

				b11.setForeground(Color.red);
				b21.setForeground(Color.red);
				b31.setForeground(Color.red);
				// b41.setForeground(Color.GREEN);
				b41.setForeground(new Color(0, 255, 0));

				Thread.sleep(5000);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

		if (e.getSource() == view) {
			new BalancerDetails();
		}
		if (e.getSource() == owner) {
			new ViewOwnerFiles();
		}
		if (e.getSource() == block) {
			new ViewBlockedUsers();
		}
		if (e.getSource() == update) {

			String[] Balancer = new String[] { "Select Balancer", "BalancerA",
					"BalancerB", "BalancerC", "BalancerD" };

			String selBlnc = (String) JOptionPane.showInputDialog(null,
					"Select Router", "Select", JOptionPane.QUESTION_MESSAGE,
					null, Balancer, Balancer[0]);

			String x = selBlnc;
			if (x.equals("BalancerA")) {

				String[] Node = new String[] { "Select Node", "A1", "A2", "A3" };

				String selAnode = (String) JOptionPane.showInputDialog(null,
						"Select Router", "Select",
						JOptionPane.QUESTION_MESSAGE, null, Node, Node[0]);

				String n = selAnode;
				// /////////////
				if (n.equals("A1")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "A2";
						String a3 = "A3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "A2";
						String a3 = "A3";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "A2";
						String a3 = "A3";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

				}

				// //////
				if (n.equals("A2")) {

					System.out.println("A2 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "A1";
						String a3 = "A3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "A3";
						String a3 = "A1";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "A3";
						String a3 = "A1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

				}
				// ////////
				if (n.equals("A3")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "A1";
						String a3 = "A2";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "A1";
						String a3 = "A2";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "A2";
						String a3 = "A1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

				}
			}
			// ///////////////

			if (x.equals("BalancerB")) {

				String[] Node = new String[] { "Select Node", "B1", "B2", "B3" };

				String selAnode = (String) JOptionPane.showInputDialog(null,
						"Select Router", "Select",
						JOptionPane.QUESTION_MESSAGE, null, Node, Node[0]);

				String n = selAnode;

				if (n.equals("B1")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "B2";
						String a3 = "B3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "B2";
						String a3 = "B3";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "B2";
						String a3 = "B3";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}

				if (n.equals("B2")) {

					System.out.println("A2 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "B1";
						String a3 = "B3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "B3";
						String a3 = "B1";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "B3";
						String a3 = "B1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

				}
				// ////////
				if (n.equals("B3")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "B1";
						String a3 = "B2";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "B1";
						String a3 = "B2";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "B2";
						String a3 = "B1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

				}
			}
			// /////////////////////
			if (x.equals("BalancerC")) {

				String[] Node = new String[] { "Select Node", "C1", "C2", "C3" };

				String selAnode = (String) JOptionPane.showInputDialog(null,
						"Select Router", "Select",
						JOptionPane.QUESTION_MESSAGE, null, Node, Node[0]);

				String n = selAnode;

				if (n.equals("C1")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "C2";
						String a3 = "C3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "C2";
						String a3 = "C3";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "C2";
						String a3 = "C3";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}

				if (n.equals("C2")) {

					System.out.println("A2 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "C1";
						String a3 = "C3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "C3";
						String a3 = "C1";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "C3";
						String a3 = "C1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}

				if (n.equals("C3")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "C1";
						String a3 = "C2";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "C1";
						String a3 = "C2";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "C2";
						String a3 = "C1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}
			}

			if (x.equals("BalancerD")) {

				String[] Node = new String[] { "Select Node", "D1", "D2", "D3" };

				String selAnode = (String) JOptionPane.showInputDialog(null,
						"Select Router", "Select",
						JOptionPane.QUESTION_MESSAGE, null, Node, Node[0]);

				String n = selAnode;

				if (n.equals("D1")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "D2";
						String a3 = "D3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "D2";
						String a3 = "D3";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "D2";
						String a3 = "D3";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}

				if (n.equals("D2")) {

					System.out.println("A2 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "D1";
						String a3 = "D3";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "D3";
						String a3 = "D1";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "D3";
						String a3 = "D1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}

				if (n.equals("D3")) {

					System.out.println("A1 selected");
					String[] Status = new String[] { "Select Node", "Idle",
							"Normal", "Overload" };

					String selStat = (String) JOptionPane.showInputDialog(null,
							"Select Router", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Status,
							Status[0]);

					String st = selStat;

					if (st.equals("Normal")) {

						System.out.println(st);

						String a2 = "D1";
						String a3 = "D2";

						String idle = "Idle";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
					if (st.equals("Idle")) {

						System.out.println(st);

						String a2 = "D1";
						String a3 = "D2";

						String idle = "Normal";
						String over = "Overload";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";
						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}

					if (st.equals("Overload")) {

						System.out.println(st);

						String a2 = "D2";
						String a3 = "D1";

						String idle = "Idle";
						String over = "Normal";

						String sql = "update Balancer set Status = '" + st
								+ "' where BNode = '" + n + "' ";
						String sql2 = "update Balancer set Status = '" + idle
								+ "' where BNode = '" + a2 + "' ";
						String sql3 = "update Balancer set Status = '" + over
								+ "' where BNode = '" + a3 + "' ";

						try {

							Statement upa1 = con.createStatement();
							upa1.executeUpdate(sql);

							Statement upa2 = con.createStatement();
							upa2.executeUpdate(sql2);

							Statement upa3 = con.createStatement();
							upa3.executeUpdate(sql3);

							System.out.println("updated");

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}
			}
		}
	}

	class PortListener implements Runnable {

		int port;

		PortListener(int port) {
			this.port = port;
		}

		public void run() {

			if (this.port == 100) {

				System.out.println("running 100");

				try {
					ServerSocket server = new ServerSocket(100);
					Socket con;
					while (true) {
						con = server.accept();
						DataInputStream dis = new DataInputStream(
								con.getInputStream());
						System.out.println(dis.readUTF());

					}

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

			if (this.port == 101) {

				try {

					ServerSocket server = new ServerSocket(101);
					Socket con;
					while (true) {
						con = server.accept();
						DataInputStream dis = new DataInputStream(
								con.getInputStream());
						System.out.println(dis.readUTF());

					}

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

			if (this.port == 1000) {

				try {

					ServerSocket server = new ServerSocket(1000);
					Socket socket;

					con = DBConnection.getConnection();
					Statement stmt = con.createStatement();
					while (true) {
						socket = server.accept();
						DataInputStream dis = new DataInputStream(
								socket.getInputStream());
						if (x == 0) {

							System.out.println("running balancer A");

							String blncr = "BLA";
							String status = "Normal";

							String balancer = "BalancerA";
							String query = " select * from Balancer where Balancer = '"
									+ blncr
									+ "' and Status ='"
									+ status
									+ "'  ";

							String node = "'";
							Statement s = con.createStatement();
							ResultSet rs = s.executeQuery(query);
							if (rs.next() == true) {
								node = rs.getString(2);
							}

							String fname = dis.readUTF();
							String pk = dis.readUTF();
							String sk = dis.readUTF();
							String data = dis.readUTF();

							String sql = " insert into ServerFiles values('"
									+ fname + "','" + balancer + "', '" + node
									+ "' , '" + pk + "','" + sk + "')  ";
							stmt.executeUpdate(sql);

							FileOutputStream fos = new FileOutputStream(
									"CloudServer/" + fname);
							fos.write(data.getBytes());
							fos.close();
						}

						if (x == 1) {
							String balancer = "BalancerB";
							System.out.println("running balancer B");

							String blncr = "BLB";
							String status = "Normal";

							String query = " select * from Balancer where Balancer = '"
									+ blncr
									+ "' and Status ='"
									+ status
									+ "'  ";

							String node = "'";
							Statement s = con.createStatement();
							ResultSet rs = s.executeQuery(query);
							if (rs.next() == true) {
								node = rs.getString(2);
							}

							String fname = dis.readUTF();
							String pk = dis.readUTF();
							String sk = dis.readUTF();
							String data = dis.readUTF();

							String sql = " insert into ServerFiles values('"
									+ fname + "','" + balancer + "', '" + node
									+ "', '" + pk + "','" + sk + "')  ";
							stmt.executeUpdate(sql);

							FileOutputStream fos = new FileOutputStream(
									"CloudServer/" + fname);
							fos.write(data.getBytes());
							fos.close();

						}

						if (x == 2) {
							String balancer = "BalancerC";
							System.out.println("running balancer C");

							String blncr = "BLC";
							String status = "Normal";

							String query = " select * from Balancer where Balancer = '"
									+ blncr
									+ "' and Status ='"
									+ status
									+ "'  ";

							String node = "'";
							Statement s = con.createStatement();
							ResultSet rs = s.executeQuery(query);
							if (rs.next() == true) {
								node = rs.getString(2);
							}

							String fname = dis.readUTF();
							String pk = dis.readUTF();
							String sk = dis.readUTF();
							String data = dis.readUTF();

							String sql = " insert into ServerFiles values('"
									+ fname + "','" + balancer + "', '" + node
									+ "' , '" + pk + "','" + sk + "')  ";
							stmt.executeUpdate(sql);

							FileOutputStream fos = new FileOutputStream(
									"CloudServer/" + fname);
							fos.write(data.getBytes());
							fos.close();

						}

						if (x == 3) {
							String balancer = "BalancerD";
							System.out.println("running balancer D");

							String blncr = "BLD";
							String status = "Normal";

							String query = " select * from Balancer where Balancer = '"
									+ blncr
									+ "' and Status ='"
									+ status
									+ "'  ";

							String node = "'";
							Statement s = con.createStatement();
							ResultSet rs = s.executeQuery(query);
							if (rs.next() == true) {
								node = rs.getString(2);
							}

							String fname = dis.readUTF();
							String pk = dis.readUTF();
							String sk = dis.readUTF();
							String data = dis.readUTF();

							String sql = " insert into ServerFiles values('"
									+ fname + "','" + balancer + "','" + node
									+ "' , '" + pk + "','" + sk + "')  ";
							stmt.executeUpdate(sql);

							FileOutputStream fos = new FileOutputStream(
									"CloudServer/" + fname);
							fos.write(data.getBytes());
							fos.close();

						}
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

			if (this.port == 3333) {

				try {
					con = DBConnection.getConnection();
					ServerSocket server = new ServerSocket(3333);
					Socket socket;
					while (true) {
						socket = server.accept();

						DataInputStream dis = new DataInputStream(
								socket.getInputStream());

						String uname = dis.readUTF();
						String fname = dis.readUTF();
						String sk = dis.readUTF();

						Statement stmt = con.createStatement();
						String sql = "Select * from BlockedUsers where UName = '"
								+ uname + "' ";
						ResultSet rs = stmt.executeQuery(sql);
						if (rs.next() == true) {
							DataOutputStream dos = new DataOutputStream(
									socket.getOutputStream());
							dos.writeUTF("block");
						} else {

							Statement st = con.createStatement();
							String query = "select * from ServerFiles where FileName = '"
									+ fname
									+ "' and Secretkey = '"
									+ sk
									+ "'  ";

							ResultSet rss = st.executeQuery(query);
							if (rss.next() == true) {

								FileInputStream fis = new FileInputStream(
										"CloudServer/" + fname);
								byte b[] = new byte[fis.available()];

								fis.read(b);
								String content = new String(b);
								DataOutputStream ds = new DataOutputStream(
										socket.getOutputStream());
								ds.writeUTF("success");
								ds.writeUTF(content);

							} else {
								SimpleDateFormat sdfDate = new SimpleDateFormat(
										"dd/MM/yyyy");
								SimpleDateFormat sdfTime = new SimpleDateFormat(
										"HH:mm:ss");

								java.util.Date now = new Date();

								String strDate = sdfDate.format(now);
								String strTime = sdfTime.format(now);
								String dt = strDate + "   " + strTime;
								Statement stmblock = con.createStatement();
								String blockquery = "insert into BlockedUsers values ('"
										+ uname
										+ "', '"
										+ fname
										+ "' ,'"
										+ sk
										+ "', '" + dt + "' )";
								stmblock.executeUpdate(blockquery);

								DataOutputStream ds = new DataOutputStream(
										socket.getOutputStream());
								ds.writeUTF("false");
							}
						}
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		}
	}

	public static void main(String[] args) {
		new CloudServer();
	}
}
