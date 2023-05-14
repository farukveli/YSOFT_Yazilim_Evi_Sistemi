package Insan_Kaynaklari;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CalisanKayit extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField isim;
	private JTextField soyisim;
	
	public CalisanKayit(Connection c, JPanel AnaMenu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel pozisyonTxt = new JLabel("Pozisyon");
		pozisyonTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		pozisyonTxt.setHorizontalAlignment(SwingConstants.CENTER);
		pozisyonTxt.setForeground(new Color(0, 139, 139));
		pozisyonTxt.setBounds(10, 249, 116, 44);
		panel.add(pozisyonTxt);
		
		JLabel isimTxt = new JLabel("\u0130sim");
		isimTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		isimTxt.setHorizontalAlignment(SwingConstants.CENTER);
		isimTxt.setForeground(new Color(0, 139, 139));
		isimTxt.setBounds(10, 136, 116, 40);
		panel.add(isimTxt);
		
		isim = new JTextField();
		isim.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		isim.setForeground(new Color(176, 224, 230));
		isim.setColumns(10);
		isim.setBackground(new Color(0, 139, 139));
		isim.setBounds(181, 136, 183, 40);
		panel.add(isim);
		
		JComboBox position = new JComboBox();
		position.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		position.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Y\u00F6netici", "Analist", "Tasar\u0131mc\u0131", "Programc\u0131"}));
		position.setSelectedIndex(0);
		position.setForeground(new Color(176, 224, 230));
		position.setBackground(new Color(0, 139, 139));
		position.setBounds(181, 249, 183, 44);
		panel.add(position);
		
		JLabel progTxt = new JLabel("Muhasebe Prog.");
		progTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		progTxt.setHorizontalAlignment(SwingConstants.CENTER);
		progTxt.setForeground(new Color(0, 139, 139));
		progTxt.setBounds(10, 314, 151, 44);
		panel.add(progTxt);
		
		JComboBox muhasebe = new JComboBox();
		muhasebe.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		muhasebe.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Muhasebe Prog-1", "Muhasebe Prog-2"}));
		muhasebe.setSelectedIndex(0);
		muhasebe.setForeground(new Color(176, 224, 230));
		muhasebe.setBackground(new Color(0, 139, 139));
		muhasebe.setBounds(182, 314, 182, 44);
		panel.add(muhasebe);
		
		
		soyisim = new JTextField();
		soyisim.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		soyisim.setForeground(new Color(176, 224, 230));
		soyisim.setColumns(10);
		soyisim.setBackground(new Color(0, 139, 139));
		soyisim.setBounds(181, 197, 183, 40);
		panel.add(soyisim);
		
		JLabel soyisimTxt = new JLabel("Soyisim");
		soyisimTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		soyisimTxt.setHorizontalAlignment(SwingConstants.CENTER);
		soyisimTxt.setForeground(new Color(0, 139, 139));
		soyisimTxt.setBounds(10, 197, 116, 40);
		panel.add(soyisimTxt);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 16));
		uyari.setBounds(10, 52, 364, 50);
		panel.add(uyari);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pozisyon= new String();
					if (position.getSelectedIndex()==1) {
						pozisyon ="Yönetici";
					}else if(position.getSelectedIndex()==2) {
						pozisyon ="Analist";
					}else if(position.getSelectedIndex()==3) {
						pozisyon ="Tasarýmcý";
					}else if(position.getSelectedIndex()==4) {
						pozisyon ="Programcý";
					}
					int durum= new Calisan().Calisan_Ekle(c, isim.getText()+" "+ soyisim.getText(), pozisyon, muhasebe.getSelectedIndex());
					int durum2 =new InsanKaynaklari().assignEmployeeToProject();
					if(durum==0) {
						uyari.setText(isim.getText() + soyisim.getText() +" Ýsimli Çalýþan Kaydedildi");
						uyari.setForeground(Color.CYAN);
						uyari.setVisible(true);
						isim.setText("");
						soyisim.setText("");
						position.setSelectedIndex(0);
						muhasebe.setSelectedIndex(0);
					}
				} catch (Exception e1 ) {
					uyari.setText("Lütfen Bütün Alanlarý Doldurunuz!!!");
					uyari.setForeground(Color.RED);
				}
			}
		});
		kaydet.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		kaydet.setForeground(new Color(176, 224, 230));
		kaydet.setBackground(new Color(0, 128, 0));
		kaydet.setBounds(237, 406, 116, 40);
		panel.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				AnaMenu.setVisible(true);
			}
		});
		geri_don.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.setBackground(new Color(255, 99, 71));
		geri_don.setBounds(237, 457, 116, 40);
		panel.add(geri_don);
		
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	
}
