import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Random extends JPanel { // This is the random number grid space
										// class
	public Random(int i) {
		JTextArea area = new JTextArea(); // This will contain the number
		area.setText(Integer.toString(i)); // This puts the number in place
		area.setOpaque(true);
		if (i == 0) {
			area.setBackground(Color.gray);
		} else {
			area.setBackground(Color.orange);
		}
		area.setPreferredSize(new Dimension(20, 30));
		area.setEditable(false); // This prevents the user from changing the
									// matrix
		this.add(area); // This puts the number into the gridspace
	}
}