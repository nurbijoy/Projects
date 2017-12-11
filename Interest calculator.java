import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sum_alt {

	private JFrame frame;
	private JTextField txtP;
	private JTextField txtT;
	private JTextField txtR;
	private JTextField txtSint;
	private JTextField txtCint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sum_alt window = new Sum_alt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sum_alt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.CYAN);
		frame.getContentPane().setBackground(new Color(153, 51, 153));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Principal");
		lblNewLabel.setForeground(new Color(255, 255, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setBounds(10, 43, 445, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(255, 255, 51));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTime.setBackground(Color.MAGENTA);
		lblTime.setBounds(10, 80, 445, 46);
		frame.getContentPane().add(lblTime);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(new Color(255, 255, 51));
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRate.setBackground(Color.MAGENTA);
		lblRate.setBounds(10, 120, 445, 46);
		frame.getContentPane().add(lblRate);
		
		JLabel lblSimpleInterest = new JLabel("Simple interest");
		lblSimpleInterest.setForeground(new Color(204, 255, 102));
		lblSimpleInterest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSimpleInterest.setBackground(Color.MAGENTA);
		lblSimpleInterest.setBounds(10, 259, 396, 46);
		frame.getContentPane().add(lblSimpleInterest);
		
		JLabel lblCompoundInterest = new JLabel("Compound interest");
		lblCompoundInterest.setForeground(new Color(102, 204, 0));
		lblCompoundInterest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCompoundInterest.setBackground(Color.MAGENTA);
		lblCompoundInterest.setBounds(10, 304, 435, 46);
		frame.getContentPane().add(lblCompoundInterest);
		
		txtP = new JTextField();
		txtP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtP.setBounds(497, 44, 177, 35);
		frame.getContentPane().add(txtP);
		txtP.setColumns(10);
		
		txtT = new JTextField();
		txtT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtT.setColumns(10);
		txtT.setBounds(497, 92, 177, 35);
		frame.getContentPane().add(txtT);
		
		txtR = new JTextField();
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtR.setColumns(10);
		txtR.setBounds(497, 132, 177, 35);
		frame.getContentPane().add(txtR);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(485, 11, 1, 339);
		frame.getContentPane().add(separator_1);
		
		txtSint = new JTextField();
		txtSint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSint.setColumns(10);
		txtSint.setBounds(497, 258, 177, 35);
		frame.getContentPane().add(txtSint);
		txtCint = new JTextField();
		txtCint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCint.setColumns(10);
		txtCint.setBounds(497, 308, 177, 35);
		frame.getContentPane().add(txtCint);
		// Setting not editable
		txtSint.setEditable(false);
		txtCint.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Interest Calculator");
		lblNewLabel_1.setForeground(new Color(51, 204, 255));
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(189, 0, 221, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.setBackground(new Color(0, 153, 102));
		btnCalc.setForeground(new Color(255, 255, 0));
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					double P = Double.parseDouble(txtP.getText());
					double T = Double.parseDouble(txtT.getText());
					double R = Double.parseDouble(txtR.getText());
					R /= 100 ;
					double Sint = P * T * R ;
					double Cint = (P * Math.pow((1+R), T) )- P ;
					String SintS = String.format("%.2f TK", Sint); // main logic
					String CintS = String.format("%.2f TK", Cint);
					txtSint.setText(SintS);
					txtCint.setText(CintS);
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null,"Enter a Valid amount","Invalid amount",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCalc.setBounds(0, 190, 272, 45);
		frame.getContentPane().add(btnCalc);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 153, 153));
		btnReset.setBackground(new Color(0, 153, 102));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtP.setText(null);
				txtT.setText(null);
				txtR.setText(null);
				txtSint.setText(null);
				txtCint.setText(null);
				txtSint.setEditable(false);
				txtCint.setEditable(false);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnReset.setBounds(282, 189, 208, 46);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(153, 204, 0));
		btnExit.setBackground(new Color(0, 153, 102));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm Yes to Exit", "Are you sure?..",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(497, 189, 177, 46);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 259, 664, -17);
		frame.getContentPane().add(separator_2);
		frame.setBounds(10, 10, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
