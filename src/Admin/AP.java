package Admin;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import Default.FileManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AP extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();

	private JPanel contentPane;

	public AP(String name) {

		setBounds(100, 100, 368, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("AP Tests");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 315, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 279, 331);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();


		ArrayList<String> apList = new ArrayList();
		
		apList = file.getApList();
		
		final String[] apLists = apList.toArray(new String[0]);
		
		for(String a : apLists) {
			listModel.addElement(a);
		}
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		JButton btnPickAp = new JButton("Pick AP");
		btnPickAp.setBounds(220, 412, 89, 23);
		contentPane.add(btnPickAp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(30, 412, 89, 23);
		contentPane.add(btnCancel);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}