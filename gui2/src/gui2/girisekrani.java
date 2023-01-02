package gui2;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class girisekrani extends JFrame {
	int EkranX, EkranY;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Container c;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	static ResultSet rs=null;
	static girisekrani frame;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new girisekrani();
					frame.setVisible(true);
					frame.setTitle("Cafe Otomasyonu");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public girisekrani() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 440);
		
		c = this.getContentPane();
        EkranX = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
        EkranY = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
        this.setSize(284, 440); // Pencere boyutunu belirliyoruz...
        this.setLocation((EkranX - 284) / 2, (EkranY - 440) / 2); // Pencerenin ekranın tam ortasında açılması için pencere yüksekliği ve genişliğinin yarısı kadar geri çekme işlemi uyguluyoruz...
		//https://forum.turkishcode.com/konu-ekranin-ortasinda-acilan-pencere-uygulamasi-java.html
        
        //https://stackoverflow.com/questions/17865465/how-do-i-draw-an-image-to-a-jpanel-or-jframe
        //Arka plana resim bastırmak için.
		final BufferedImage image = ImageIO.read(new File("C:\\Users\\seyme\\Desktop\\zz.jpg"));
		contentPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//design kisminda olusturdugumuz aracların kodları
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
		lblNewLabel.setBounds(45, 171, 70, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 172, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(null);
		
		JLabel lblNewLabel2 = new JLabel("Şifre");
		lblNewLabel2.setBounds(45, 200, 70, 21);
		contentPane.add(lblNewLabel2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(96, 231, 101, 13);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 201, 96, 19);
		contentPane.add(passwordField);

		JOptionPane jf=new JOptionPane();
		
		JButton bt1=new JButton("GİRİŞ");
		bt1.setForeground(Color.WHITE);
		bt1.setBackground(new Color(128, 91, 91));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				String adi=textField.getText();
				
				if(passwordField.getPassword().length==0||textField.getText().length()==0) 
				{
					jf.showMessageDialog(frame, "Giriş başarısız.Kullanıcı adı veya şifre boş olamaz.");
				}
				else 
				{
					try {
					rs=Baglanti.bul();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					int c=1;
					while (rs.next()) {
						if(adi.equals(rs.getString("username"))&&password.equals(rs.getString("password"))) 
						{
							anaekran np=new anaekran();
							np.setVisible(true);
							frame.dispose();
							c=0;	
						}
					}
					if(c==1) 
					{
						jf.showMessageDialog(frame, "Kullanıcı adı veya şifre yanlış.");
						lblNewLabel_1.setText("Giriş başarısız.");
						textField.setText("");
						passwordField.setText("");
					}	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		bt1.setBounds(85, 259, 101, 21);
		contentPane.add(bt1);
		
		
		JButton bt2 = new JButton("KAYIT OL");
		bt2.setForeground(Color.WHITE);
		bt2.setBackground(new Color(128, 91, 91));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				String adi=textField.getText();
				
				if(passwordField.getPassword().length==0||textField.getText().length()==0) 
				{
					jf.showMessageDialog(frame, "Kayıt başarısız.Kullanıcı adı veya şifre boş olamaz.");
				}
				else 
				{
					Baglanti bg=new Baglanti();
				try {
					bg.KayitOl(adi, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jf.showMessageDialog(frame, "Başarıyla kayıt oldunuz.");
				lblNewLabel_1.setText("Kayıt oldunuz.");
				}
				
			}
		});
		//(x,y,en,boy)
		bt2.setBounds(85, 290, 101, 21);
		contentPane.add(bt2);
		
		JButton bt3 = new JButton("ÇIK");
		bt3.setForeground(Color.WHITE);
		bt3.setBackground(new Color(128, 91, 91));
		bt3.setBounds(85, 321, 101, 21);
		contentPane.add(bt3);
		
		
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}	
		});
		
	}
}
