package test_lmy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.sun.xml.internal.ws.api.server.Container;

public class Control extends JFrame implements ActionListener{
		JButton b1, b2, b3, b4;
		JTable table;
		JTextField  j3;
		String str = JOptionPane.showInputDialog("请输入进程数：");
		int N = Integer.parseInt(str);
		String a[][] = new String[N][7];
		String[] name = { "进程号", "提交时间", "运行时间", "开始时间", "结束时间", "周转时间", "带权周转时间" };
		StringBuffer priority;
		public Control() {
			super("进程调度算法");
			java.awt.Container c = getContentPane();
			GridBagLayout f = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			c.setLayout(f);

			table = new JTable(a, name);
			JScrollPane p1 = new JScrollPane(table);
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 60;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			f.setConstraints(p1, gbc);
			c.add(p1);
			JLabel label3 = new JLabel("进程优先级序列:");
			label3.setFont(new Font("楷体", Font.BOLD, 12));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(label3, gbc);
			c.add(label3);
			gbc.gridheight = 1;

			j3 = new JTextField(1);
			gbc.ipadx = 1;
			gbc.ipady = 1;
			;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			f.setConstraints(j3, gbc);
			j3.setText("" + priority);
			c.add(j3);
	        b1 = new JButton("先来先服务");
			b1.setFont(new Font("楷体", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b1, gbc);
			c.add(b1);

			b2 = new JButton("短作业优先");
			b2.setFont(new Font("楷体", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b2, gbc);
			c.add(b2);

			b3 = new JButton("时间片轮转");
			b3.setFont(new Font("楷体", Font.BOLD, 15));
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			f.setConstraints(b3, gbc);
			c.add(b3);

			b4 = new JButton("高响应比优先");
			b4.setFont(new Font("楷体", Font.BOLD, 15));
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			f.setConstraints(b4, gbc);
			c.add(b4);

			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);

			setSize(500, 580);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			for (int i = 0; i < N; i++)
				for (int j = 0; j < 3; j++) {
					System.out.println(a[i][j]);
				}
		}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b1))//先来先服务
		{
			try {

				String [][] b = new String[N][8];
				priority = new StringBuffer(); 
				FCFS fcfs = new FCFS(N);
				b = fcfs.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);

			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if (e.getSource().equals(b2))//短进程优先
		{
			try {

				String [][] b = new String[N][8];
				priority = new StringBuffer(); 
				SJF sjf = new SJF(N);
				b = sjf.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);
			}
			 catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		if (e.getSource().equals(b3))//时间片轮转
		{

			String [][] b = new String[N][7];
			priority = new StringBuffer();
			JTextField txt = new JTextField(5);
			String val = JOptionPane.showInputDialog("请输入时间片：");
			txt.setText(val);
			int slice = Integer.parseInt(txt.getText());
			RR  rr = new RR(slice, N);
			b = rr.outCome(a);
			priority.append(rr.getPriority());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 7; j++) {
					table.repaint();
					table.setValueAt("" + b[i][j], i, j);
				}
			}
			j3.setText("" + priority);

		}
		if (e.getSource().equals(b4))//高响应比优先调度
		{
			try {

				String [][] b = new String[N][7];
				priority = new StringBuffer();
				HRRN hrrn = new HRRN(N);
				b = hrrn.outCome(a);
				for (int i = 0; i < N; i++) {
					priority.append("-->"+b[i][7]);
					for (int j = 0; j < 7; j++) {
						table.repaint();
						table.setValueAt("" + b[i][j], i, j);
					}
				}
				j3.setText("" + priority);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

	}

	public static void main(String args[]) {
		Control lmy = new Control();

}

}



