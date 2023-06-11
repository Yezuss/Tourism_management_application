package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import connectDB.ConnectDB;
import dao.DAO_Ve;
import dao.Tour_DAO;
import entity.Tour;
import entity.Ve;

public class QuanLiVe extends JPanel implements ActionListener, MouseListener {
	public static QuanLiVe qlVe;
	JTextField txtTim;
	JButton btnTim;
	JPanel pnCenter;

	JTree tree;
	DefaultMutableTreeNode nodeTinhThanh;

	DefaultMutableTreeNode nodeTour;
	DefaultTableModel modeltable;
	DefaultTableModel modeltable1;
	public JTable table;
	JTable table1;
	JPanel pnTree;
	JPanel pnTab2;

	private Tour_DAO tour_dao;
	private DAO_Ve ve_dao;

	ArrayList<Tour> listTour;
	ArrayList<Ve> listVe;
	ArrayList<Tour> listTourKhaDung;
	Tour tour;

	JScrollPane sc;

	public QuanLiVe() {
		qlVe = this;
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		tour_dao = new Tour_DAO();
		ve_dao = new DAO_Ve();

		listTour = tour_dao.LayHetTour();
		listTourKhaDung = tour_dao.DSTCoTheDatVe(LocalDate.now());
		//
		Border blackline = BorderFactory.createLineBorder(Color.gray);
		setBorder(blackline);
		setLayout(new BorderLayout());
		setBackground(new Color(230, 247, 255));

		JTabbedPane tab = new JTabbedPane();

		JPanel pnTab1 = new JPanel();
		pnTab1.setBackground(new Color(230, 247, 255));
		pnTab1.setLayout(new BorderLayout());
		pnTab2 = new JPanel();
		JScrollPane sp1 = new JScrollPane(pnTab1);

		tab.add(sp1, "Giá vé");
		tab.add(pnTab2, "Quản lí vé");
		pnTab2.setBackground(Color.WHITE);
		add(tab, BorderLayout.CENTER);

		JPanel pnTim = new JPanel();
		pnTim.setBackground(new Color(230, 247, 255));
		JLabel lblTim = new JLabel("Tìm giá");
		lblTim.setIcon(new ImageIcon("Icon/find1.png"));
		txtTim = new JTextField(25);
		btnTim = new JButton("Tìm giá");
		pnTim.add(lblTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);
		pnTab1.add(pnTim, BorderLayout.NORTH);

		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.setBackground(new Color(230, 247, 255));

		TaiTourLen();
		//
		pnTab1.add(pnCenter, BorderLayout.CENTER);
		btnTim.addActionListener(this);

		// tab2
		pnTab2.setLayout(new BorderLayout());
		UIManager.put("Tree.rendererFillBackground", false);
		pnTab2.setBackground(new Color(230, 247, 255));

		pnTree = new JPanel();
		pnTree.setBackground(new Color(230, 247, 255));
		pnTree.setLayout(new BorderLayout());

		// TaoHinh
		ImageIcon leafIcon = new ImageIcon("Icon/start.png");
		ImageIcon openIcon = new ImageIcon("Icon/open2.png");
		ImageIcon closedIcon = new ImageIcon("Icon/close.png");
		if (leafIcon != null) {
			DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			renderer.setClosedIcon(closedIcon);
			renderer.setOpenIcon(openIcon);
			renderer.setLeafIcon(leafIcon);
			tree.setCellRenderer(renderer);
		}

		// CENTER
		String[] chuoi = { "Mã vé", "Ngày �?ặt Vé", "Tên Tour", "Tên Khách Hàng", "Tên Nhân Viên" };
		modeltable = new DefaultTableModel(chuoi, 0);
		table = new JTable(modeltable);
		JScrollPane sc1 = new JScrollPane(table);

		pnTree.add(sc1, BorderLayout.CENTER);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sc, sc1);
		pnTree.add(split, BorderLayout.CENTER);
		pnTab2.add(pnTree, BorderLayout.CENTER);

		tree.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnTim)) {
		/*	
			 * ArrayList<Tour> tourTimDuoc =
			 * tour_dao.TimTour(txtTim.getText().toString().trim().toLowerCase(),false);
			 
			if(tourTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Ngày khởi hành");
			}
			else {
				TaiTourTimKiem(tourTimDuoc);
			}	
		}*/
		}
	}

	public void TaiTourLen() {

	}

	private void TaiTourTimKiem(ArrayList<Tour> tourTimDuoc) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (nodeSelected != null && nodeSelected.getLevel() == 1) {
			pnTree.removeAll();
			pnTree.revalidate();
			String[] chuoi1 = { "Mã tour", "Tên tour", "Giá tour", "Ngày khởi hành", "Ngày kết thúc" };
			modeltable1 = new DefaultTableModel(chuoi1, 0);
			table1 = new JTable(modeltable1);
			table1.getColumnModel().getColumn(1).setPreferredWidth(250);

			JScrollPane sc2 = new JScrollPane(table1);
			// sc.setPreferredSize(new Dimension(200, 0));
			pnTree.add(sc2, BorderLayout.CENTER);
			pnTree.add(sc, BorderLayout.WEST);
			JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sc, sc2);
			pnTree.add(split, BorderLayout.CENTER);
			pnTree.revalidate();
			pnTree.repaint();

		}

		if (nodeSelected != null && nodeSelected.getLevel() == 2) {
			pnTree.removeAll();
			pnTree.revalidate();
			String[] chuoi = { "Mã vé", "Ngày mua vé", "Tên tour", "Tên khách hàng", "Tên nhân viên" };
			modeltable = new DefaultTableModel(chuoi, 0);
			table = new JTable(modeltable);
			table.getColumnModel().getColumn(2).setPreferredWidth(160);

			// celltour.getTableCellRendererComponent(table,
			// table.getColumnModel().getColumn(1), true, true, 10, 15);
			// table.getColumnModel().getColumn(1).setCellRenderer(new
			// DefaultTableCellTour());

			table.setAutoCreateRowSorter(true);

			JScrollPane sc1 = new JScrollPane(table);
			pnTree.add(sc1, BorderLayout.CENTER);
			pnTree.add(sc, BorderLayout.WEST);
			// sc.setPreferredSize(new Dimension(200, 0));
			JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sc, sc1);
			pnTree.add(split, BorderLayout.CENTER);
			pnTree.revalidate();
			pnTree.repaint();

			tour = (Tour) nodeSelected.getUserObject();
			modeltable.setRowCount(0);
			listVe = ve_dao.getVeTheoMaTour(tour.getMaTour());

			for (Ve ve : listVe) {
				modeltable.addRow(new Object[] { ve.getMaVe(), ve.getNgayDatVe(), ve.getTour().getTenTour(),
						ve.getKhachhang().getTenKH(), ve.getNhanvien().getTenNV() });
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
