package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Algorithm.Skyscraper;
//import jdk.jfr.internal.PrivateAccess;
import Algorithm.Skyscraper;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class testSkyscraper extends JFrame {

	private static final int SIZE = 6;
	private JLayeredPane contentPane;
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
				} 	catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JLabel lblINPUT;
	
	private JTextField txtInput;
	private JTextField txtFileName;
	private JTextArea txtOutPut;
	
	public testSkyscraper() {
		 
		 
		setTitle("6 BY 6 SKYSCRAPERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 762);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Lable Input
		lblINPUT = new JLabel("INPUT");
		lblINPUT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblINPUT.setHorizontalAlignment(SwingConstants.CENTER);
		lblINPUT.setBounds(21, 148, 83, 25);
		contentPane.add(lblINPUT);
		
		txtFileName = new JTextField();
		txtFileName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFileName.setBounds(147, 628, 667, 49);
		contentPane.add(txtFileName);
		txtFileName.setColumns(10);
		//Button
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStart.setBounds(873, 228, 168, 39);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = txtInput.getText();
				String[] lines = input.split("\\s+");
				int N = SIZE*4;
				int[] clues = new int[N];
				for (int i = 0; i < N; i++) clues[i] = 0;
				
				try {
					for (int i = 0; i < N; i++) {
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
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(!txtFileName.getText().equals("")) {
						BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\file\\" + txtFileName.getText() + ".txt"));
					    writer.write("Input: " + txtInput.getText() + "\n\n" + txtOutPut.getText());
					    writer.close();
					}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnSave.setBounds(873, 634, 168, 39);
		contentPane.add(btnSave);
		
		JButton btnThongTin = new JButton("About");
		btnThongTin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThongTin.setBounds(873, 299, 168, 39);
		contentPane.add(btnThongTin);
		btnThongTin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				thongTinNhom Lo = new thongTinNhom();
				Lo.setVisible(true);
				frame.setVisible(false);
				
			}
		});

		//TextField
		txtInput = new JTextField();
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInput.setBounds(147, 136, 667, 49);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtOutPut = new JTextArea();
		txtOutPut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOutPut.setColumns(10);
		txtOutPut.setBounds(147, 213, 666, 388);
		contentPane.add(txtOutPut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExit.setBounds(873, 556, 168, 39);
		contentPane.add(btnExit);
		
		JLabel lblOUTPUT_1 = new JLabel("OUTPUT");
		lblOUTPUT_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOUTPUT_1.setBounds(21, 213, 83, 29);
		contentPane.add(lblOUTPUT_1);
		
		JLabel lblFilename = new JLabel("FILENAME");
		lblFilename.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilename.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFilename.setBounds(21, 640, 108, 25);
		contentPane.add(lblFilename);
		
		JLabel lblNewLabel = new JLabel("6 BY 6 SKYSCRAPERS");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 35));
		lblNewLabel.setBounds(309, 40, 373, 49);
		contentPane.add(lblNewLabel);
		
		
	}
}