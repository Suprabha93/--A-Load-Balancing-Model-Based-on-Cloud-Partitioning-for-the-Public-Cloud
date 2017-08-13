import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Reciever implements ActionListener {

	JFrame jf;
	Container c;
	public JTextField t1, t2, t3;
	public JLabel l1, l2, l3;
	public JButton b1, b2;
	String fname;
	public JTextArea tf = new JTextArea();

	public Reciever() {

		jf = new JFrame("Reciever::A Load Balancing Model Based on Cloud Partitioning for the Public Cloud");

		c = jf.getContentPane();
		c.setLayout(null);

		l1 = new JLabel("Enter username");
		l2 = new JLabel("Enter File-name");
		l3 = new JLabel("Secret Key");

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);

		b1 = new JButton("Submit");
		b2 = new JButton("Exit");

		l1.setBounds(50, 200, 100, 25);
		l2.setBounds(50, 250, 100, 25);
		l3.setBounds(50, 300, 100, 25);

		t1.setBounds(200, 200, 150, 25);
		t2.setBounds(200, 250, 150, 25);
		t3.setBounds(200, 300, 150, 25);

		ImageIcon im = new ImageIcon(this.getClass().getResource("Receiver.png"));

		JLabel image = new JLabel();
		image.setIcon(im);

		image.setBounds(0, -10, 1200, 120);

		JScrollPane pane = new JScrollPane();
		pane.setName("pane");

		tf.setColumns(20);
		tf.setRows(5);

		pane.setViewportView(tf);

		pane.setBounds(370, 200, 400, 380);
		b1.setBounds(50, 400, 125, 30);
		b2.setBounds(220, 400, 125, 30);

		jf.add(l1);
		jf.add(l2);
		jf.add(l3);
		jf.add(t1);
		jf.add(t2);
		jf.add(t3);
		jf.add(b1);
		jf.add(b2);
		jf.add(pane);
		c.add(image);

		b1.addActionListener(this);
		b2.addActionListener(this);
		c.add(image);
		c.setBackground(new Color(100, 150, 100));
		jf.setSize(830, 650);
		jf.setResizable(false);
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b2) {

			System.exit(0);

		}

		if (e.getSource() == b1) {

			try {

				String uname = t1.getText();
				fname = t2.getText();
				String sk = t3.getText();

				String ip = JOptionPane.showInputDialog(null,
						"Enter IP Address ");

				System.out.println(fname + sk + uname);

				Socket socket1 = new Socket(ip, 3333);
				DataOutputStream dos1 = new DataOutputStream(
						socket1.getOutputStream());

				dos1.writeUTF(uname);
				dos1.writeUTF(fname);
				dos1.writeUTF(sk);

				DataInputStream dis = new DataInputStream(
						socket1.getInputStream());

				String content = dis.readUTF();

				if (content.equals("false")) {

					JOptionPane
							.showMessageDialog(null,
									"You are Try to Attack the file '\n' You are blocked ");
				}

				if (content.equals("success")) {

					tf.setText(dis.readUTF());

					FileOutputStream outFile = new FileOutputStream(
							"Reciever\\" + fname);
					outFile.flush();
					outFile.close();
					JOptionPane.showMessageDialog(null,
							"File Received and Stored in Receiver Folder");

					System.gc();

				}

				if (content.equals("block")) {

					JOptionPane
							.showMessageDialog(
									null,
									"You are currently blocked"
											+ " \n To Access Request to Cloudd Server ");

				}

			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {
		new Reciever();
	}

}
