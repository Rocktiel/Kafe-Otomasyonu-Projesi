package gui2;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Button;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class anaekran extends JFrame {
	static ResultSet rs;
	int EkranX, EkranY;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Container c;
	private JPanel contentPane;
	public JTable table;
	static anaekran frame;
	public JTable getTable() {
		return table;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new anaekran();
					frame.setVisible(true);
					frame.setTitle("ANA SAYFA");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public anaekran() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 540);
		c = this.getContentPane();
        EkranX = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
        EkranY = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
        this.setSize(753, 700); // Pencere boyutunu belirliyoruz...
        this.setLocation((EkranX - 753) / 2, (EkranY - 700) / 2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(64, 128, 128));
		desktopPane.setBounds(0, 0, 750, 57);
		contentPane.add(desktopPane);
		
		JButton btnNewButton_1 = new JButton("ÜRÜN DÜZENLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					urunekle ue=new urunekle();
					ue.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\aa.png"));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Serif",Font.BOLD,20));
		//button.setBackground(new Color(0,51,204));//import java.awt.Color;
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(0, 0, 241, 57);
		desktopPane.add(btnNewButton_1);
		
		ButtonGroup as=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "\u0130\u015ELETME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 67, 720, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("KAFENZO");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(209, 20, 300, 63);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "MASALAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 170, 720, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel m1 = new JLabel("MASA 1");
		m1.setBounds(85, 167, 45, 13);
		panel_1.add(m1);
		
		JLabel lblMasa = new JLabel("MASA 2");
		lblMasa.setBounds(254, 167, 45, 13);
		panel_1.add(lblMasa);
		
		JLabel lblMasa_1 = new JLabel("MASA 3");
		lblMasa_1.setBounds(432, 167, 45, 13);
		panel_1.add(lblMasa_1);
		
		JLabel lblMasa_2 = new JLabel("MASA 4");
		lblMasa_2.setBounds(604, 167, 45, 13);
		panel_1.add(lblMasa_2);
		
		JLabel lblMasa_3 = new JLabel("MASA 5");
		lblMasa_3.setBounds(85, 333, 45, 13);
		panel_1.add(lblMasa_3);
		
		JLabel lblMasa_4 = new JLabel("MASA 6");
		lblMasa_4.setBounds(254, 333, 45, 13);
		panel_1.add(lblMasa_4);
		
		ButtonGroup bg=new ButtonGroup();
		
		JLabel lblMasa_4_1 = new JLabel("MASA 7");
		lblMasa_4_1.setBounds(432, 333, 45, 13);
		panel_1.add(lblMasa_4_1);
		
		JLabel lblMasa_4_2 = new JLabel("MASA 8");
		lblMasa_4_2.setBounds(604, 333, 45, 13);
		panel_1.add(lblMasa_4_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa8 sm8 = null;
				try {
					sm8 = new siparismasa8();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm8.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		btnNewButton_2.setBounds(555, 205, 128, 118);
		panel_1.add(btnNewButton_2);
		
		JButton masa1 = new JButton("New button");
		masa1.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		masa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa1 sm1 = null;
				try {
					sm1 = new siparismasa1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm1.setVisible(true);
				
			}
		});
		masa1.setBounds(37, 40, 128, 117);
		panel_1.add(masa1);
		
		JButton masa2 = new JButton("New button");
		masa2.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		masa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa2 sm2 = null;
				try {
					sm2 = new siparismasa2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm2.setVisible(true);
			}
		});
		masa2.setBounds(206, 40, 128, 117);
		panel_1.add(masa2);
		
		JButton masa3 = new JButton("New button");
		masa3.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		masa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa3 sm3 = null;
				try {
					sm3 = new siparismasa3();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm3.setVisible(true);
			}
		});
		masa3.setBounds(381, 40, 128, 117);
		panel_1.add(masa3);
		
		JButton masa4 = new JButton("New button");
		masa4.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		masa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa4 sm4 = null;
				try {
					sm4 = new siparismasa4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm4.setVisible(true);
			}
		});
		masa4.setBounds(555, 40, 128, 117);
		panel_1.add(masa4);
		
		JButton btnNewButton_3_4 = new JButton("New button");
		btnNewButton_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa5 sm5 = null;
				try {
					sm5 = new siparismasa5();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm5.setVisible(true);
			}
		});
		btnNewButton_3_4.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		btnNewButton_3_4.setBounds(37, 206, 128, 117);
		panel_1.add(btnNewButton_3_4);
		
		JButton btnNewButton_3_5 = new JButton("New button");
		btnNewButton_3_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa6 sm6 = null;
				try {
					sm6 = new siparismasa6();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm6.setVisible(true);
				
			}
		});
		btnNewButton_3_5.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		btnNewButton_3_5.setBounds(206, 206, 128, 117);
		panel_1.add(btnNewButton_3_5);
		
		JButton btnNewButton_3_6 = new JButton("New button");
		btnNewButton_3_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparismasa7 sm7 = null;
				try {
					sm7 = new siparismasa7();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sm7.setVisible(true);
				
			}
		});
		btnNewButton_3_6.setIcon(new ImageIcon("C:\\Users\\seyme\\Desktop\\ff3.jpg.jpeg"));
		btnNewButton_3_6.setBounds(381, 206, 128, 117);
		panel_1.add(btnNewButton_3_6);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Alt Bilgi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 573, 720, 80);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String aylar[]={"Ocak","Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık"};
		Calendar simdi=Calendar.getInstance();

		int a=simdi.get(Calendar.DATE);
		String aString = Integer.toString(a);
		
		int b=simdi.get(Calendar.YEAR);
		String bString=Integer.toString(b);
		
		JLabel lblNewLabel = new JLabel(" "+aString+" "+aylar[simdi.get(Calendar.MONTH)]+" "+bString);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 28, 144, 26);
		panel_2.add(lblNewLabel);
	}
}
