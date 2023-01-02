package gui2;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class siparismasa7 extends JFrame {
	
	int EkranX, EkranY;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Container c;
	private JPanel contentPane;
	private JTable table;
	JOptionPane jp;
	DefaultTableModel modelim=new DefaultTableModel();
	DefaultTableModel modelim2=new DefaultTableModel();
	Object[] kolonlarsiparis= {"ÜRÜN ADEDİ","ÜRÜN ADI","FİYAT"};
	Object[] satirlarsiparis= new Object[3];
	Object[] kolonlar= {"ÜRÜN ID","ÜRÜN ADI","FİYAT"};
	Object[] satirlar= new Object[3];
	static ResultSet rs;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	static siparismasa7 frame;
	int data0,data2;
	String data1;
	int data22;
	String data11;
	JLabel fiyatt;
	private JTable table_1;
	int adet=0;
	float fiyat=0;
	double toplam=0.00;
	String toplamstring;
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new siparismasa7();
					frame.setVisible(true);
					frame.setTitle("MASA 1");
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
	public siparismasa7() throws IOException {
		setTitle("MASA 1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 513);
		c = this.getContentPane();
        EkranX = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
        EkranY = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
        this.setSize(1088, 613); // Pencere boyutunu belirliyoruz...
        this.setLocation((EkranX - 1088) / 2, (EkranY - 613) / 2);
        
       final BufferedImage image = ImageIO.read(new File("C:\\Users\\seyme\\Desktop\\zad1.jpg"));
		contentPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
        comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					listele();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"YEMEK", "TATLI", "İÇECEK"}));
		comboBox.setBounds(45, 78, 281, 21);
		contentPane.add(comboBox);
        
		
		jp=new JOptionPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(748, 78, 281, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		fiyatt = new JLabel("0,00");
		fiyatt.setBounds(0, 0, 281, 41);
		panel.add(fiyatt);
		fiyatt.setBackground(new Color(255, 255, 255));
		fiyatt.setForeground(new Color(0, 0, 0));
		fiyatt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		fiyatt.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 95, 281, 371);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table.setModel(modelim);
		table.setDefaultEditor(Object.class, null);//Tıklayabiliriz ama değiştiremeyiz.
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ADET SEÇİN");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(413, 18, 232, 50);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("MASA 1");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(56, 14, 248, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("TOPLAM ÜCRET");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Zilla Slab Medium", Font.BOLD, 35));
		lblNewLabel_1.setBounds(748, 19, 281, 40);
		contentPane.add(lblNewLabel_1);
		
		
		btnNewButton_2 = new JButton("1");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2.getText());
			}
		});
		btnNewButton_2.setBounds(388, 142, 77, 74);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_1.getText());
			}
		});
		btnNewButton_1.setBounds(497, 142, 75, 74);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("3");
		btnNewButton_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_1_1.getText());
			}
		});
		btnNewButton_1_1.setBounds(605, 142, 77, 74);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("4");
		btnNewButton_2_1.setBackground(new Color(211, 211, 211));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_1.getText());
			}
		});
		btnNewButton_2_1.setBounds(388, 240, 77, 74);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("5");
		btnNewButton_2_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_2.getText());
			}
		});
		btnNewButton_2_2.setBounds(497, 240, 77, 74);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("6");
		btnNewButton_2_3.setBackground(new Color(211, 211, 211));
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_3.getText());
				
			}
		});
		btnNewButton_2_3.setBounds(605, 240, 77, 74);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_3_1 = new JButton("7");
		btnNewButton_2_3_1.setBackground(new Color(211, 211, 211));
		btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_3_1.getText());
			}
		});
		btnNewButton_2_3_1.setBounds(388, 340, 77, 72);
		contentPane.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_3_2 = new JButton("8");
		btnNewButton_2_3_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_3_2.getText());
			}
		});
		btnNewButton_2_3_2.setBounds(497, 339, 75, 74);
		contentPane.add(btnNewButton_2_3_2);
		
		JButton btnNewButton_2_3_3 = new JButton("9");
		btnNewButton_2_3_3.setBackground(new Color(211, 211, 211));
		btnNewButton_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(btnNewButton_2_3_3.getText());
			}
		});
		btnNewButton_2_3_3.setBounds(605, 339, 77, 74);
		contentPane.add(btnNewButton_2_3_3);
		
		try {
			listele();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(388, 78, 294, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(748, 142, 281, 320);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolonlarsiparis);
		modelim2.addRow(satirlarsiparis);
		table_1.setModel(modelim2);
		scrollPane_1.setViewportView(table_1);
		
	
		
		fiyatgoster();
		try {
			listelemasa1();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		table.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
	            	if(table.getSelectedColumn()==0) {
	            		
	            		data1 = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+1);
	            		data2 = (int) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+2);
	            	}
	            	else if(table.getSelectedColumn()==1) {
	            		data1 = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
	            		data2 = (int) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+1);
	            	}
	            	else if(table.getSelectedColumn()==2) {
	            		data1 = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()-1);
	            		data2 = (int) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		                
	            	}
	               
	            }
	        }

	    });
		
		JButton btnNewButton = new JButton("EKLE");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data1==null) {
					jp.showMessageDialog(frame, "Lütfen bir şey seçiniz.");
				}
				else if(textField.getText().length()==0) {
					
					jp.showMessageDialog(frame, "Adet boş olamaz.Lütfen adet seçiniz.");
				}
				else {
				int c=1;
				try {
					rs=masabaglanti.masa1();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					while(rs.next()) {
						if(rs.getString("adi").equals(data1)&&data1!=null) {
							int adetmasa=rs.getInt("adet");
							int adet=Integer.parseInt(textField.getText());
							masabaglanti.guncellemasa1esit(data1,adet ,adetmasa);
							c=0;
						}
						
					}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			
				
				if(c==1) {
					int adet=Integer.parseInt(textField.getText());
					try {
						masabaglanti.verigirmasa1(adet,data1 ,data2 );
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
					
				try {
					listelemasa1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
				fiyatgoster();
				
				textField.setText("");
			}
		});
		btnNewButton.setBounds(388, 449, 141, 41);
		contentPane.add(btnNewButton);
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("HEPSİNİ ÖDE");
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					masabaglanti.silmasa1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					listelemasa1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fiyatgoster();
				
				
			}
		});
		btnNewButton_3.setBounds(809, 472, 157, 41);
		contentPane.add(btnNewButton_3);
		
		table_1.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
	            	if(table_1.getSelectedColumn()==0) {
	            		
	            		data11 = (String) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()+1);
	            		data22 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn());
	            	}
	            	else if(table_1.getSelectedColumn()==1) {
	            		
	            		data11 = (String) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn());
	            		data22 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()-1);
	            	}
	            	else if(table_1.getSelectedColumn()==2) {
	            		
	            		data11 = (String) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()-1);
	            		data22 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()-2);
		                
	            	}
	               
	            }
	        }

	    });
		
		JButton btnNewButton_3_1 = new JButton("ÖDE");
		btnNewButton_3_1.setBackground(new Color(211, 211, 211));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(data11==null) {
					jp.showMessageDialog(frame, "Lütfen ödenen şeyi seçiniz.");
				}
				else if(textField.getText().length()==0) {
					jp.showMessageDialog(frame, "Adet boş olamaz.Lütfen adet seçiniz.");
					
				}
				else {
				   
					int odeadet=Integer.parseInt(textField.getText());
				try {
					masabaglanti.guncellemasa1(data11,data22,odeadet  );
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					listelemasa1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fiyatgoster();
				textField.setText("");
				
			}
				
			}
		});
		btnNewButton_3_1.setBounds(539, 449, 141, 41);
		contentPane.add(btnNewButton_3_1);
		
	}
	void listele() throws SQLException {
		String secenek=comboBox.getSelectedItem().toString();
		if(comboBox.getSelectedItem().toString()=="YEMEK") {
			try {
				rs=urunlerbaglanti.yemekbaglanti();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(comboBox.getSelectedItem().toString()=="İÇECEK"){
			try {
				rs=urunlerbaglanti.icecekbaglanti();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(comboBox.getSelectedItem().toString()=="TATLI") {
			try {
				rs=urunlerbaglanti.tatlibaglanti();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		modelim.setColumnCount(0);
		modelim.setRowCount(0);
		modelim.setColumnIdentifiers(kolonlar);
		try {
			while(rs.next()) {
				satirlar[0]=rs.getInt("idurunlerr");
				satirlar[1]=rs.getString("urunadi");
				satirlar[2]=rs.getInt("fiyat");
				modelim.addRow(satirlar);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table.setModel(modelim);
			
		}
	
	void listelemasa1() throws SQLException {
		
		try {
			rs=masabaglanti.masa1();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		modelim2.setColumnCount(0);
		modelim2.setRowCount(0);
		modelim2.setColumnIdentifiers(kolonlarsiparis);
		try {
			while(rs.next()) {
				satirlarsiparis[0]=rs.getInt("adet");
				satirlarsiparis[1]=rs.getString("adi");
				satirlarsiparis[2]=rs.getInt("fiyat");
				modelim2.addRow(satirlarsiparis);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table_1.setModel(modelim2);
			
		}
	
	void fiyatgoster() {
		try {
			rs=masabaglanti.masa1();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		toplam=0.00;
		try {
			while(rs.next()) {
				adet=rs.getInt("adet");
				fiyat=rs.getFloat("fiyat");
				toplam+=adet*fiyat;
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		toplamstring=Double.toString(toplam);
		fiyatt.setText(toplamstring);
		
	}
}
