package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class EmailVerificationForm extends JFrame {

	private JPanel contentPane;
	private JPasswordField verificationCodeUser;
	private static String email;
	private static String code;
	public static boolean success = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String email_, String code_) {
		email = email_;
		code = code_;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailVerificationForm frame = new EmailVerificationForm();
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
	public EmailVerificationForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmailVerificationForm.class.getResource("/vendor/verification_.png")));
		setTitle("Verification | STMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel verificationLable = new JLabel("Email Verification");
		verificationLable.setFont(new Font("Consolas", Font.BOLD, 24));
		verificationLable.setBounds(95, 30, 249, 38);
		contentPane.add(verificationLable);
		
		verificationCodeUser = new JPasswordField();
		verificationCodeUser.setBorder(new LineBorder(new Color(153, 153, 153), 2, true));
		verificationCodeUser.setFont(new Font("Consolas", Font.BOLD, 14));
		verificationCodeUser.setBounds(118, 90, 188, 38);
		contentPane.add(verificationCodeUser);
		
		JButton confirm = new JButton("Confirm");
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userGivenCode = new String(verificationCodeUser.getPassword());
				if(userGivenCode.equals(code)) {
					JOptionPane.showMessageDialog(getContentPane(), "Account Created Successfully");
					success = true;
					dispose();
					LoginForm.main(null);
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Failed to verify");
					dispose();
					success = false;
				}
			}
		});
		confirm.setFont(new Font("Consolas", Font.BOLD, 12));
		confirm.setBounds(156, 139, 106, 31);
		contentPane.add(confirm);
	}
}
