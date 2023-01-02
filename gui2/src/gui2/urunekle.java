package gui2;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui2.urunlerbaglanti;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;

public class urunekle extends JFrame {
	int EkranX, EkranY;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Container c;
	static ResultSet rs;
	private JPanel contentPane;
	private JTextField id;
	private JTextField isim;
	private JTextField fiyat;
	private JTable table_1;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"ÜRÜN ID","ÜRÜN ADI","FİYAT"};
	Object[] satirlar= new Object[3];
	JComboBox comboBox;
	private JButton btnNewButton_1;
	private JTextField degistirid;
	private JTextField degistirfiyat;
	private JTextField sillid;
	static urunekle frame;
	int data2;
	String idd;
	JOptionPane jp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new urunekle();
					frame.setVisible(true);
					frame.setTitle("ÜRÜNLER");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public urunekle() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 493);
		ekraniortala();
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"YEMEK", "İÇECEK", "TATLI"}));
		comboBox.setBounds(36, 13, 160, 21);
		contentPane.add(comboBox);
		
		table_1 = new JTable();
		//table_1.setEnabled(false);//Tıklayamayız ve değiştiremeyiz.
		table_1.setDefaultEditor(Object.class, null);
		table_1.setBounds(10, 140, 383, 229);
		listele();
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(37, 44, 307, 402);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u00DCR\u00DCN EKLE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(392, 10, 286, 133);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ÜRÜN ID");
		lblNewLabel.setBounds(10, 34, 50, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ÜRÜN ADI");
		lblNewLabel_1.setBounds(10, 57, 77, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FİYAT");
		lblNewLabel_2.setBounds(10, 81, 45, 13);
		panel.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(97, 31, 85, 19);
		panel.add(id);
		id.setColumns(10);
		
		isim = new JTextField();
		isim.setBounds(97, 54, 85, 19);
		panel.add(isim);
		isim.setColumns(10);
			
				JButton btnNewButton = new JButton("EKLE");
				btnNewButton.setBounds(159, 102, 104, 21);
				panel.add(btnNewButton);
				btnNewButton.setBackground(new Color(216, 191, 216));
				
				fiyat = new JTextField();
				fiyat.setBounds(97, 78, 85, 19);
				panel.add(fiyat);
				fiyat.setColumns(10);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String a=id.getText();
						String b=isim.getText();
						String c=fiyat.getText();
						
						
						
						if(a.length()==0||b.length()==0|c.length()==0) {
							jp.showMessageDialog(frame, "Ürün eklenemedi.Lütfen boş alanları doldurunuz.");
						}
						else if(comboBox.getSelectedItem().toString()=="YEMEK") {
							int number1 =Integer.parseInt(a);
							int number2=Integer.parseInt(c);
							int cc=1;
							
							try {
								rs=urunlerbaglanti.yemekbaglanti();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								while(rs.next()) {
									int aid=rs.getInt("idurunlerr");
									if(aid==number1) {
										jp.showMessageDialog(frame, "Aynı idye sahip 2 ürün olamaz.");
										cc=0;
									}
								}
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							if(cc==1) {
							try {
								urunlerbaglanti.yemekverigir(number1, b, number2);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						}
						else if(comboBox.getSelectedItem().toString()=="İÇECEK"){
							int number1 =Integer.parseInt(a);
							int number2=Integer.parseInt(c);
							try {
								urunlerbaglanti.icecekverigir(number1, b, number2);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if(comboBox.getSelectedItem().toString()=="TATLI") {
							int number1 =Integer.parseInt(a);
							int number2=Integer.parseInt(c);
							try {
								urunlerbaglanti.tatliverigir(number1, b, number2);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}	
					try {
						listele();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					isim.setText("");
					fiyat.setText("");
					id.setText("");
				}});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u00DCR\u00DCN G\u00DCNCELLE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(392, 160, 286, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		degistirfiyat = new JTextField();
		degistirfiyat.setBounds(98, 62, 85, 19);
		panel_1.add(degistirfiyat);
		degistirfiyat.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ÜRÜN ID");
		lblNewLabel_3.setBounds(10, 36, 50, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("FİYAT");
		lblNewLabel_2_1.setBounds(10, 65, 45, 13);
		panel_1.add(lblNewLabel_2_1);
		
		btnNewButton_1 = new JButton("GÜNCELLE");
		btnNewButton_1.setBounds(159, 102, 104, 21);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		
		degistirid = new JTextField();
		degistirid.setBounds(98, 33, 85, 19);
		panel_1.add(degistirid);
		degistirid.setColumns(10);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a=degistirid.getText();
				String b=degistirfiyat.getText();
				
				if(b.length()==0 || a.length()==0) {
					jp.showMessageDialog(frame, "Ürün güncellenemedi.Lütfen boş alanları doldurunuz.");
				
				}
				
				else if(comboBox.getSelectedItem().toString()=="YEMEK") {
					int bb=Integer.parseInt(b);
					try {
						urunlerbaglanti.yemekguncelle(a, bb);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedItem().toString()=="İÇECEK"){
					int bb=Integer.parseInt(b);
					try {
						urunlerbaglanti.icecekguncelle(a, bb);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().toString()=="TATLI") {
					int bb=Integer.parseInt(b);
					try {
						urunlerbaglanti.tatliguncelle(a, bb);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}	
				try {
					listele();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				degistirid.setText("");
				degistirfiyat.setText("");
				sillid.setText("");
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u00DCR\u00DCN S\u0130L", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(392, 303, 286, 133);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		sillid = new JTextField();
		sillid.setColumns(10);
		sillid.setBounds(101, 39, 85, 19);
		panel_2.add(sillid);
		
		JLabel lblNewLabel_4 = new JLabel("ÜRÜN ID");
		lblNewLabel_4.setBounds(10, 42, 50, 13);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ÜRÜNLER");
		lblNewLabel_5.setBounds(238, 10, 106, 24);
		contentPane.add(lblNewLabel_5);
		
		JOptionPane jp=new JOptionPane();
		
		table_1.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
	            	if(table_1.getSelectedColumn()==0) {
	            		
	            		
	            		data2 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn());
	            		String idd=Integer.toString(data2);
	            		degistirid.setText(idd);
	            		sillid.setText(idd);
	            	}
	            	else if(table_1.getSelectedColumn()==1) {
	            		
	            		data2 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()-1);
	            		String idd=Integer.toString(data2);
	            		degistirid.setText(idd);
	            		sillid.setText(idd);
	            	}
	            	else if(table_1.getSelectedColumn()==2) {
	            		data2 = (int) table_1.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn()-2);
	            		String idd=Integer.toString(data2);
	            		degistirid.setText(idd);
	            		sillid.setText(idd);
	            	}
	            	
	            }
	        }

	    });
		
		
		JButton btnNewButton_2 = new JButton("SİL");
		btnNewButton_2.setBackground(new Color(255, 228, 181));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String silid=sillid.getText();
				if(silid.length()==0) {
					jp.showMessageDialog(frame, "Ürün silinemedi.Lütfen boş alanları doldurunuz.");
					
				}
				else if(comboBox.getSelectedItem().toString()=="YEMEK") {
					int number1 =Integer.parseInt(silid);
					try {
						urunlerbaglanti.yemeksil(number1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedItem().toString()=="İÇECEK"){
					int number1 =Integer.parseInt(silid);
					try {
						urunlerbaglanti.iceceksil(number1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().toString()=="TATLI") {
					int number1 =Integer.parseInt(silid);
					try {
						urunlerbaglanti.tatlisil(number1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}	
			try {
				listele();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			degistirid.setText("");
			degistirfiyat.setText("");
			sillid.setText("");
				
			}
		});
		btnNewButton_2.setBounds(159, 81, 104, 21);
		panel_2.add(btnNewButton_2);
		
		

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
	else if(secenek.equals("TATLI")) {
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
	
	table_1.setModel(modelim);
		
	}
void ekraniortala() {
	c = this.getContentPane();
    EkranX = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
    EkranY = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
    this.setSize(702, 502); // Pencere boyutunu belirliyoruz...
    this.setLocation((EkranX - 702) / 2, (EkranY - 493) / 2);
}
}
