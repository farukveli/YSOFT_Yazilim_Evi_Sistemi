package Insan_Kaynaklari;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class AnaMenu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Connection conn;
	private JLabel baslik;
	private JButton calisanKayit;
	private CalisanKayit calisan_kayit;
	private JButton projeKayit;
	private ProjeKayit proje_kayit;
/*	private KarneDuzenle karne_duzenle;
	private KarneSil karne_sil;
	private TesisatIslem tesisat_islemleri;
	private TesisatKayit tesisat_kayit;
	private TesisatDuzenle tesisat_duzenle;
	private TesisatSil tesisat_sil;
	private AboneIslem abone_islemleri;
	private AboneKayit abone_kayit;
	private AboneDuzenle abone_duzenle;
	private AboneSil abone_sil;

	/**
	 * Create the frame.
	 */
	public AnaMenu(Connection conn, JPanel Login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);

		
		calisan_kayit= new CalisanKayit(conn,panel);
		contentPane.add(calisan_kayit.getPanel());
		calisan_kayit.getPanel().setLayout(null);
		calisan_kayit.getPanel().setVisible(false);
		
		
		proje_kayit = new ProjeKayit(conn,panel);
		contentPane.add(proje_kayit.getPanel());
		proje_kayit.getPanel().setLayout(null);
		proje_kayit.getPanel().setVisible(false);
		
	/*	karne_kayit = karne_islemleri.getKarne_kayit();
		contentPane.add(karne_kayit.getPanel());
		karne_kayit.getContentPane().setLayout(null);
		karne_kayit.setVisible(false);
		
		karne_duzenle = karne_islemleri.getKarne_duzenle();
		contentPane.add(karne_duzenle.getPanel());
		karne_duzenle.setVisible(false);
		karne_duzenle.getContentPane().setLayout(null);
		
		karne_sil = karne_islemleri.getKarne_sil();
		contentPane.add(karne_sil.getPanel());
		karne_sil.setVisible(false);
		karne_sil.getContentPane().setLayout(null);
		
		
		
		tesisat_kayit = tesisat_islemleri.getTesisat_kayit();
		contentPane.add(tesisat_kayit.getPanel());
		tesisat_kayit.setVisible(false);
		tesisat_kayit.getContentPane().setLayout(null);
		
		tesisat_duzenle = tesisat_islemleri.getTesisat_duzenle();
		contentPane.add(tesisat_duzenle.getPanel());
		tesisat_duzenle.setVisible(false);
		tesisat_duzenle.getContentPane().setLayout(null);
		
		tesisat_sil = tesisat_islemleri.getTesisat_sil();
		contentPane.add(tesisat_sil.getPanel());
		tesisat_sil.setVisible(false);
		tesisat_sil.getContentPane().setLayout(null);
	
		abone_islemleri = new AboneIslem(conn,panel);
		contentPane.add(abone_islemleri.getPanel());
		abone_islemleri.getPanel().setLayout(null);
		abone_islemleri.getPanel().setVisible(false);
		
		abone_kayit = abone_islemleri.getAbone_kayit();
		contentPane.add(abone_kayit.getPanel());
		abone_kayit.setVisible(false);
		abone_kayit.getContentPane().setLayout(null);
		
		abone_duzenle = abone_islemleri.getAbone_duzenle();
		contentPane.add(abone_duzenle.getPanel());
		abone_duzenle.setVisible(false);
		abone_duzenle.getContentPane().setLayout(null);
		
		abone_sil = abone_islemleri.getAbone_sil();
		contentPane.add(abone_sil.getPanel());
		abone_sil.setVisible(false);
		abone_sil.getContentPane().setLayout(null);
	*/		
		baslik = new JLabel();
		baslik.setForeground(new Color(0, 139, 139));
		baslik.setBackground(new Color(176, 196, 222));
		baslik.setFont(new Font("Ubuntu", Font.BOLD, 22));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setText("\u0130\u015ELEMLER");
		baslik.setBounds(10, 42, 364, 66);
		panel.add(baslik);
		
		calisanKayit = new JButton("Yeni \u00C7al\u0131\u015Fan Kay\u0131t");
		calisanKayit.setForeground(new Color(176, 224, 230));
		calisanKayit.setBackground(new Color(0, 139, 139));
		calisanKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calisan_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		calisanKayit.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		calisanKayit.setBounds(102, 184, 169, 48);
		panel.add(calisanKayit);
		
		projeKayit = new JButton("Yeni Proje Kay\u0131t");
		projeKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proje_kayit.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		
		projeKayit.setForeground(new Color(176, 224, 230));
		projeKayit.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		projeKayit.setBackground(new Color(0, 139, 139));
		projeKayit.setBounds(102, 243, 169, 48);
		panel.add(projeKayit);
		
	/*	JButton aboneIslemleri = new JButton("Abone \u0130\u015Flemleri");
		aboneIslemleri.setForeground(new Color(176, 224, 230));
		aboneIslemleri.setBackground(new Color(0, 139, 139));
		aboneIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abone_islemleri.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		aboneIslemleri.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		aboneIslemleri.setBounds(110, 245, 150, 50);
		panel.add(aboneIslemleri);*/
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				Login.setVisible(true);
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
	public CalisanKayit getCalisan_kayit() {
		return calisan_kayit;
	}
	public void setCalisan_kayit(CalisanKayit calisan_kayit) {
		this.calisan_kayit = calisan_kayit;
	}
	public ProjeKayit getProje_kayit() {
		return proje_kayit;
	}
	public void setProje_kayit(ProjeKayit proje_kayit) {
		this.proje_kayit = proje_kayit;
	}
	
	
	
}
