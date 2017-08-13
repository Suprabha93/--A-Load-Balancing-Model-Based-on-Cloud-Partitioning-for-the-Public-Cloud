import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;

public class DataOwner extends JFrame implements ActionListener {

 
	
	private static final long serialVersionUID = 1L;
	
	public Font f1 = new Font("Times new roman", Font.BOLD, 25);
	public Font f2 = new Font("Times new roman", Font.BOLD, 15);

	JPanel c;
	JLabel label = new JLabel("File Path :");
	JLabel fpath = new JLabel();
	JButton browse = new JButton("BROWSE");
	JButton submit = new JButton("UPLOAD");
	JTextArea ta = new JTextArea();
	JScrollPane pane = new JScrollPane();
	Cipher encoder = null;
	Key prKey;
	String fname;
	public static Key pubKey;
	JLabel title = new JLabel();
	DataOwner() {

		c=new JPanel();
		setTitle("Data-Owner::A Load Balancing Model Based on Cloud Partitioning for the Public Cloud");

		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
	
		
		
		label.setBounds(50, 125, 100, 25);
		label.setForeground(Color.RED);
		fpath.setBounds(165, 125, 700, 25);
		fpath.setForeground(Color.RED);
		ta.setFont(f2);
		ta.setForeground(Color.magenta);
		ta.setRows(10);
		ta.setColumns(10);
		pane.setViewportView(ta);
		pane.setBounds(100, 200, 400, 400);
		submit.setBounds(150, 620, 150, 35);
		browse.setBounds(350, 620, 150, 35);
		
        ImageIcon banner = new ImageIcon(this.getClass().getResource("LoadB.jpg"));
		title.setIcon(banner);
		title.setBounds(550, 150, 600, 450);
		
		ImageIcon banner1 = new ImageIcon(this.getClass().getResource("DataOwner.png"));
		JLabel title1=new JLabel();
		title1.setIcon(banner1);
		title1.setBounds(50, 0, 1150, 100);
		
		
		c.add(pane);
		c.add(submit);
		c.add(browse);
		c.add(label);
		c.add(fpath);
		c.add(title1);
		c.add(title);
		
		browse.addActionListener(this);
		submit.addActionListener(this);
		setSize(1150, 700);
		setVisible(true);
		add(c);
	}

	public static void main(String[] args) {
		new DataOwner();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == browse) {

			JFileChooser chooser = new JFileChooser();
			try {

				File f1 = new File(new File("xx.txt").getCanonicalPath());

				chooser.setSelectedFile(f1);

			} catch (Exception ex) {
				System.out.println(ex);
			}

			int ret = chooser.showOpenDialog(browse);
			if (ret == JFileChooser.APPROVE_OPTION) {
				try {
					File selFile = chooser.getSelectedFile();

					String path = selFile.getAbsolutePath();
					fname = selFile.getName();

					fpath.setText(path);

					FileInputStream fis = new FileInputStream(selFile);
					DataInputStream dis = new DataInputStream(fis);
					BufferedReader br = new BufferedReader(
							new InputStreamReader(dis));

					String strline = "";
					StringBuffer bf = new StringBuffer();

					while ((strline = br.readLine()) != null) {
						bf.append(strline + "\n");
					}

					ta.setText(bf.toString());

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		}

		if (e.getSource() == submit) {

			String data = ta.getText();

			String ip = JOptionPane.showInputDialog(null,
					"Enter Cloud Server IPAddress");
			try {

				KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
				encoder = Cipher.getInstance("RSA");
				KeyPair kp = kg.generateKeyPair();
				prKey = kp.getPrivate();

				pubKey = kp.getPublic();
				byte[] pub = pubKey.getEncoded();

				int x = new KeyGenerator().getKeys();

				Socket client = new Socket(ip, 1000);
				DataOutputStream dos = new DataOutputStream(
						client.getOutputStream());

				dos.writeUTF(fname);
				dos.writeUTF(String.valueOf(pub));
				dos.writeUTF(String.valueOf(x));
				dos.writeUTF(data);

				JOptionPane.showMessageDialog(null,
						"File Uploaded SuccessFully", "Message from Server",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception ex) {
				System.out.println(ex);
			}

		}
	}
}
