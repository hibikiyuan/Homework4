package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(6, 26, 438, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 438, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(6, 85, 438, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		username = new JTextField();
		username.setBounds(216, 29, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(216, 60, 96, 21);
		panel_1.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(125, 29, 79, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(125, 60, 79, 15);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Member member = new MemberServiceImpl().login(Username, Password);
				
				if(member != null) {
					JOptionPane.showMessageDialog(null, "登入成功!!\n"+member.getName()+" 歡迎您~");
					Tool.save(member, "member.txt");
					PorderMainUI pmi=new PorderMainUI();
					pmi.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "無此帳號，請先註冊吧~");
					AddMemberUI addmemner=new AddMemberUI();
					addmemner.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(114, 102, 96, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddMemberUI addmember = new AddMemberUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(216, 102, 96, 23);
		panel_1.add(btnNewButton_1);
	}
}
