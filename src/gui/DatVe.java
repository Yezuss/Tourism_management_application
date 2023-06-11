package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class DatVe extends JFrame implements ActionListener {
public static DatVe qlVe;
	
	
	
	JPanel pnCenter;
	private JButton btnThemTour;
	private JTextField txtTim;
	private JButton btnTim;



	private JPanel pnNorth;



	private JTextField txtTenTour;



	private JTextField txtMaVe;



	private JTextField txtTenKH;



	private JTextField txtDiaChi;



	private JTextField txtSoDT;



	private JTextField txtEmail;



	private JRadioButton radNam;



	private JRadioButton radNu;



	private JButton btnLamMoi;



	private JButton btnLuu;



	private JButton btnThoat;
	
	public DatVe() {
	// TODO Auto-generated constructor stub
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setSize(100,100);
		setLocationRelativeTo(null);
		setVisible(true);

		setLayout(new BorderLayout());
		 pnNorth = new JPanel();
			JLabel lblTieuDe = new JLabel("Nháº­p thÃ´ng tin khÃ¡ch hÃ ng");
			Font font =new Font("Arial",Font.BOLD,15);
			lblTieuDe.setFont(font);
			lblTieuDe.setForeground(Color.RED);
			pnNorth.add(lblTieuDe);
			add(pnNorth, BorderLayout.NORTH);
			JPanel pnThongTin = new JPanel();
			pnThongTin.setLayout(new GridLayout(8,1));
			JPanel pnChucNang = new JPanel();
			pnChucNang.setLayout(new FlowLayout(FlowLayout.RIGHT));
					
			
			//TÃªn Tour
			JPanel pnTenTour = new JPanel();
			JLabel lblTenTour = new JLabel("TÃªn Tour");
			txtTenTour = new JTextField(18);
			
			txtTenTour.setEnabled(false);
			pnTenTour.add(lblTenTour);
			pnTenTour.add(txtTenTour);
			pnThongTin.add(pnTenTour);
			
			//MÃ£ vÃ©
			JPanel pnMaVe = new JPanel();
			JLabel lblMaVe = new JLabel("MÃ£ vÃ©");
			txtMaVe = new JTextField(18);
			
			
			pnMaVe.add(lblMaVe);
			pnMaVe.add(txtMaVe);
			pnThongTin.add(pnMaVe);
			
			
			//Ten
			JPanel pnTenKH = new JPanel();
			JLabel lblTenKH = new JLabel("Há»� vÃ  TÃªn");
			txtTenKH = new JTextField(18);
			pnTenKH.add(lblTenKH);
			pnTenKH.add(txtTenKH);
			pnThongTin.add(pnTenKH);		
			
			//DiaChi
			JPanel pnDiaChi = new JPanel();
			JLabel lblDiaChi = new JLabel("Ä�á»‹a Chá»‰");
			txtDiaChi = new JTextField(18);
			pnDiaChi.add(lblDiaChi);
			pnDiaChi.add(txtDiaChi);
			pnThongTin.add(pnDiaChi);
			
			//SDT
			JPanel pnSDT = new JPanel();
			JLabel lblSDT = new JLabel("Sá»‘ Ä�T");
			txtSoDT = new JTextField(18);
			pnSDT.add(lblSDT);
			pnSDT.add(txtSoDT);
			pnThongTin.add(pnSDT);
			
			//Email
			JPanel pnEmail = new JPanel();
			JLabel lblEmail = new JLabel("Email");
			txtEmail = new JTextField(18);
			pnEmail.add(lblEmail);
			pnEmail.add(txtEmail);
			pnThongTin.add(pnEmail);
			
			//GioiTinh
			JPanel pnGioiTinh = new JPanel();
			radNam = new JRadioButton("Nam");
			radNu = new JRadioButton("Ná»¯");
			ButtonGroup groupGioitinh = new ButtonGroup();
			
			radNam.setSelected(true);
			groupGioitinh.add(radNam);
			groupGioitinh.add(radNu);
			JLabel lblGioiTinh = new JLabel("Giá»›i tÃ­nh");
			pnGioiTinh.add(lblGioiTinh);
			pnGioiTinh.add(radNam);pnGioiTinh.add(radNu);
			pnThongTin.add(pnGioiTinh);	

		
			lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
			lblEmail.setPreferredSize(lblTenKH.getPreferredSize());
			lblMaVe.setPreferredSize(lblTenKH.getPreferredSize());
			lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
			lblTenTour.setPreferredSize(lblTenKH.getPreferredSize());
			lblGioiTinh.setPreferredSize(new Dimension(74,30));
			radNam.setPreferredSize(new Dimension(90,30));
			radNu.setPreferredSize(new Dimension(90,30));
			
			pnThongTin.validate();
			pnThongTin.repaint();
			add(pnThongTin, BorderLayout.CENTER);
			add(pnChucNang,BorderLayout.SOUTH);
			
			
			btnLamMoi = new JButton("Lam moi");
			
			btnLuu = new JButton("LÆ°u");
			
			btnThoat = new JButton("ThoÃ¡t");
			
			
			pnChucNang.add(btnLamMoi);
			pnChucNang.add(btnLuu);
			pnChucNang.add(btnThoat);
	        
			btnThoat.addActionListener(this);
			btnLamMoi.addActionListener(this);
			btnLuu.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


