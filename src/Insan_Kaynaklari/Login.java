package Insan_Kaynaklari;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField kullanici;
	private AnaMenu anaMenu;
	private CalisanKayit calisanKayit;
	private ProjeKayit projeKayit;
	private JPasswordField sifre;

	public Login(Connection c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		anaMenu = new AnaMenu(c,panel);
		contentPane.add(anaMenu.getPanel());
		anaMenu.getPanel().setLayout(null);
		anaMenu.getPanel().setVisible(false);
		
		calisanKayit = anaMenu.getCalisan_kayit();
		contentPane.add(calisanKayit.getPanel());
		calisanKayit.getContentPane().setLayout(null);
		calisanKayit.setVisible(false);
		
		projeKayit = anaMenu.getProje_kayit();
		contentPane.add(projeKayit.getPanel());
		projeKayit.getContentPane().setLayout(null);
		projeKayit.setVisible(false);
		
		
		kullanici = new JTextField();
		kullanici.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		kullanici.setBounds(127, 191, 216, 35);
		panel.add(kullanici);
		kullanici.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 195, 107, 27);
		panel.add(lblNewLabel);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setHorizontalAlignment(SwingConstants.CENTER);
		lblifre.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblifre.setBounds(10, 259, 107, 27);
		panel.add(lblifre);
		
		JLabel lblNewLabel_1 = new JLabel("YSOFT Yaz\u0131l\u0131m Evi");
		lblNewLabel_1.setFont(new Font("Ubuntu", Font.BOLD, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 51, 364, 56);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130nsan Kaynaklar\u0131 Departman\u0131 Kullan\u0131c\u0131 Sistemi");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 98, 364, 45);
		panel.add(lblNewLabel_2);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 16));
		uyari.setBounds(10, 395, 364, 50);
		panel.add(uyari);
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(kullanici.getText().equals("admin") && sifre.getText().equals("admin")) {
						anaMenu.getPanel().setVisible(true);
						panel.setVisible(false);
					}else {
						uyari.setText("Kullanýcý Adý veya Þifre Hatalý");
						uyari.setForeground(Color.RED);
					}
				} catch (Exception e1) {
					uyari.setText("Kullanýcý Adý ve Þifre Boþ Býrakýlamaz");
					uyari.setForeground(Color.RED);
				}
			}
		});
		btnNewButton.setFont(new Font("Ubuntu", Font.PLAIN, 26));
		btnNewButton.setBounds(230, 322, 113, 45);
		btnNewButton.setForeground(new Color(176, 224, 230));
		btnNewButton.setBackground(new Color(0, 139, 139));
		panel.add(btnNewButton);
		
		sifre = new JPasswordField();
		sifre.setBounds(127, 257, 216, 35);
		panel.add(sifre);
	}

	public CalisanKayit getCalisanKayit() {
		return calisanKayit;
	}

	public void setCalisanKayit(CalisanKayit calisanKayit) {
		this.calisanKayit = calisanKayit;
	}
}
