package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rose;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField lavander;
	private JLabel lblNewLabel_5;
	private JTextField babysbreath;
	private JLabel lblNewLabel_6;
	private JTextField deleteId;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JLabel lblNewLabel_7;
	private JTextField updateId;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextArea output;
	private JScrollPane scrollPane;
	private JTextField recipient;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rose = new JTextField();
		rose.setBounds(338, 269, 88, 21);
		rose.setColumns(10);
		contentPane.add(rose);
		
		lblNewLabel_3 = new JLabel("玫瑰花");
		lblNewLabel_3.setBounds(297, 273, 46, 15);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("薰衣草");
		lblNewLabel_4.setBounds(12, 273, 46, 15);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_7 = new JLabel("訂單編號");
		lblNewLabel_7.setBounds(0, 246, 57, 15);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("送花日期");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(0, 297, 57, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("y-M-d");
		dateChooser.setBounds(60, 297, 120, 26);
		contentPane.add(dateChooser);
		
		updateId = new JTextField();
		updateId.setBounds(60, 243, 232, 21);
		updateId.setColumns(10);
		contentPane.add(updateId);
		
		lavander = new JTextField();
		lavander.setBounds(61, 270, 88, 21);
		lavander.setColumns(10);
		contentPane.add(lavander);
		
		lblNewLabel_5 = new JLabel("滿天星");
		lblNewLabel_5.setBounds(152, 273, 46, 15);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		babysbreath = new JTextField();
		babysbreath.setBounds(204, 269, 88, 21);
		babysbreath.setColumns(10);
		contentPane.add(babysbreath);
		
		lblNewLabel_6 = new JLabel("訂單編號");
		lblNewLabel_6.setBounds(0, 364, 52, 15);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		deleteId = new JTextField();
		deleteId.setBounds(60, 360, 232, 21);
		deleteId.setColumns(10);
		contentPane.add(deleteId);
		
		btnNewButton = new JButton("查詢");
		btnNewButton.setBounds(502, 180, 85, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(porderserviceimpl.AllPorder());
				
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(502, 290, 85, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date date = dateChooser.getDate();
				//int Id=Integer.parseInt(updateId.getText());
				String order_no=updateId.getText();
				String Recipient = recipient.getText();
				int Rose=Integer.parseInt(rose.getText());
				int Lavander=Integer.parseInt(lavander.getText());
				int Babysbreath=Integer.parseInt(babysbreath.getText());
				String Delivery_Date=new SimpleDateFormat("yyyy-MM-dd").format(date);
				porderserviceimpl.updatePorder(Recipient,Delivery_Date,Lavander, Babysbreath, Rose, order_no);
				if(porderserviceimpl != null) {
					JOptionPane.showMessageDialog(null, "資料修改完成");
				}
				else {
					JOptionPane.showMessageDialog(null, "資料修改失敗");
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setBounds(502, 361, 85, 23);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//int Id=Integer.parseInt(deleteId.getText());
				String order_no=updateId.getText();
				porderserviceimpl.deletePorderByOrderNo(order_no);
				if(porderserviceimpl != null) {
					JOptionPane.showMessageDialog(null, "資料刪除完成");
				}
				else {
					JOptionPane.showMessageDialog(null, "資料刪除失敗");
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		panel = new JPanel();
		panel.setBounds(0, 323, 587, 29);
		panel.setBackground(new Color(204, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("訂單刪除");
		lblNewLabel_2.setBounds(6, 6, 52, 16);
		panel.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 211, 587, 29);
		panel_1.setBackground(new Color(204, 204, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("訂單修改");
		lblNewLabel_1.setBounds(6, 6, 52, 16);
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 587, 29);
		panel_2.setBackground(new Color(204, 204, 204));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單查詢");
		lblNewLabel.setBounds(6, 6, 52, 16);
		panel_2.add(lblNewLabel);
		
		
		
		btnNewButton_3 = new JButton("回主選單");
		btnNewButton_3.setBounds(467, 4, 114, 23);
		panel_2.add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 586, 134);
		contentPane.add(scrollPane);
		
		output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JLabel lblNewLabel_3_2 = new JLabel("收件人");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(297, 250, 46, 15);
		contentPane.add(lblNewLabel_3_2);
		
		recipient = new JTextField();
		recipient.setColumns(10);
		recipient.setBounds(338, 246, 88, 21);
		contentPane.add(recipient);
		
		
		
		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
				
			}
		});
		
	}
}
