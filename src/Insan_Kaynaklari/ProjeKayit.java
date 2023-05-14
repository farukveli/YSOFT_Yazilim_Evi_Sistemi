package Insan_Kaynaklari;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ProjeKayit extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField isim;
	private JTextField enAz;
	private JTextField enCok;
	
	public ProjeKayit(Connection c, JPanel AnaMenu) {
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
		
		JLabel enAzTxt = new JLabel("En Az");
		enAzTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		enAzTxt.setHorizontalAlignment(SwingConstants.CENTER);
		enAzTxt.setForeground(new Color(0, 139, 139));
		enAzTxt.setBounds(30, 271, 116, 44);
		panel.add(enAzTxt);
		
		JLabel isimTxt = new JLabel("Proje \u0130smi");
		isimTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		isimTxt.setHorizontalAlignment(SwingConstants.CENTER);
		isimTxt.setForeground(new Color(0, 139, 139));
		isimTxt.setBounds(30, 136, 116, 40);
		panel.add(isimTxt);
		
		isim = new JTextField();
		isim.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		isim.setForeground(new Color(176, 224, 230));
		isim.setColumns(10);
		isim.setBackground(new Color(0, 139, 139));
		isim.setBounds(156, 136, 183, 40);
		panel.add(isim);
		
		JLabel enCokTxt = new JLabel("En \u00C7ok");
		enCokTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		enCokTxt.setHorizontalAlignment(SwingConstants.CENTER);
		enCokTxt.setForeground(new Color(0, 139, 139));
		enCokTxt.setBounds(30, 312, 116, 44);
		panel.add(enCokTxt);
		
		
		enAz = new JTextField();
		enAz.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		enAz.setForeground(new Color(176, 224, 230));
		enAz.setColumns(10);
		enAz.setBackground(new Color(0, 139, 139));
		enAz.setBounds(192, 273, 116, 40);
		panel.add(enAz);
		
		JLabel soyisimTxt = new JLabel("Gerekli \u00C7al\u0131\u015Fan Say\u0131s\u0131");
		soyisimTxt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		soyisimTxt.setHorizontalAlignment(SwingConstants.CENTER);
		soyisimTxt.setForeground(new Color(0, 139, 139));
		soyisimTxt.setBounds(91, 220, 194, 40);
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
					int durum= new Proje().Proje_Ekle(c, isim.getText(), Integer.parseInt(enAz.getText()), Integer.parseInt(enCok.getText()));
					if(durum==0) {
						uyari.setText(isim.getText() +" Ýsimli Proje Kaydedildi");
						uyari.setForeground(Color.CYAN);
						uyari.setVisible(true);
						isim.setText("");
						enAz.setText("");
						enCok.setText("");
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
		
		enCok = new JTextField();
		enCok.setForeground(new Color(176, 224, 230));
		enCok.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		enCok.setColumns(10);
		enCok.setBackground(new Color(0, 139, 139));
		enCok.setBounds(192, 314, 116, 40);
		panel.add(enCok);
		
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
