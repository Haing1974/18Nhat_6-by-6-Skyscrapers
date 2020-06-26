package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Algorithm.Skyscraper;

import Algorithm.Skyscraper;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class testSkyscraper extends JFrame {

	private JPanel contentPane;
	static testSkyscraper frame  ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new testSkyscraper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JLabel lblINPUT;
	private JLabel lblOUTPUT;
	
	private JTextField txtInput;
	private JTextArea txtOutPut;
	
	public testSkyscraper() {
		setTitle("6 BY 6 SKYSCRAPERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblINPUT = new JLabel("INPUT");
		lblINPUT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblINPUT.setHorizontalAlignment(SwingConstants.CENTER);
		lblINPUT.setBounds(22, 22, 83, 25);
		contentPane.add(lblINPUT);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStart.setBounds(794, 229, 168, 39);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = txtInput.getText();
				String[] lines = input.split("\\s+");
				
				int[] clues = new int[24];
				for (int i = 0; i < 24; i++) clues[i] = 0;
				
				try {
					for (int i = 0; i < 24; i++) {
						clues[i] = Integer.parseInt(lines[i]);
					}
				} catch (Exception ex) {
					System.out.println("Array out of bound.");
				}				
				
				Skyscraper sky = new Skyscraper(clues);
				sky.solve();
				txtOutPut.setText(sky.solvedMessage);
			}
		});
		
		contentPane.add(btnStart);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				history Lo = new history();
				Lo.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnHistory.setBounds(794, 295, 168, 39);
		contentPane.add(btnHistory);
		
		JButton btnThongTin = new JButton("Th\u00F4ng tin nh\u00F3m");
		btnThongTin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThongTin.setBounds(794, 355, 168, 39);
		contentPane.add(btnThongTin);
		JButton btnNewButton_3= new JButton("New button");
		btnThongTin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				thongTinNhom Lo = new thongTinNhom();
				Lo.setVisible(true);
				frame.setVisible(false);
				
			}
		});

		
		txtInput = new JTextField();
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInput.setBounds(21, 66, 667, 49);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		lblOUTPUT = new JLabel("OUTPUT");
		lblOUTPUT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOUTPUT.setBounds(22, 159, 83, 29);
		contentPane.add(lblOUTPUT);
		
		txtOutPut = new JTextArea();
		txtOutPut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOutPut.setColumns(10);
		txtOutPut.setBounds(22, 210, 666, 381);
		contentPane.add(txtOutPut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExit.setBounds(794, 415, 168, 39);
		contentPane.add(btnExit);
	}
}
