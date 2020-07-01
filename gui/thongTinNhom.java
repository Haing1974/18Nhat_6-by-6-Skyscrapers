package GUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class thongTinNhom extends JFrame {

	private JPanel contentPane;

	
	public thongTinNhom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DO AN NHOM 8");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(137, 0, 135, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNguyenVanHai = new JLabel("NGUYEN VAN HAI  :");
		lblNguyenVanHai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNguyenVanHai.setBounds(29, 106, 127, 14);
		contentPane.add(lblNguyenVanHai);
		
		JLabel lblHoangThiXoan = new JLabel("HOANG THI XOAN :");
		lblHoangThiXoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoangThiXoan.setBounds(29, 144, 127, 14);
		contentPane.add(lblHoangThiXoan);
		
		JLabel lblLeThuyNhu = new JLabel("LE THUY NHU Y     :");
		lblLeThuyNhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeThuyNhu.setBounds(29, 181, 127, 14);
		contentPane.add(lblLeThuyNhu);
		
		JLabel lblPhatTrienThuat = new JLabel("PHAT TRIEN THUAT TOAN");
		lblPhatTrienThuat.setBounds(181, 144, 178, 14);
		contentPane.add(lblPhatTrienThuat);
		
		JLabel lblPhatTrienDatabase = new JLabel("PHAT TRIEN DATABASE");
		lblPhatTrienDatabase.setBounds(181, 181, 178, 14);
		contentPane.add(lblPhatTrienDatabase);
		
		JLabel lblCacThanhVien = new JLabel("CAC THANH VIEN");
		lblCacThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCacThanhVien.setBounds(29, 62, 127, 14);
		contentPane.add(lblCacThanhVien);
		
		JLabel lblPhatTrienGui = new JLabel("PHAT TRIEN GUI");
		lblPhatTrienGui.setBounds(181, 106, 178, 14);
		contentPane.add(lblPhatTrienGui);
	}
}