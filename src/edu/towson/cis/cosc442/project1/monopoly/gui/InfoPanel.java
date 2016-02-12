package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import edu.towson.cis.cosc442.project1.monopoly.GameMaster;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoPanel.
 */
public class InfoPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Display info.
	 */
	public void displayInfo() {
		GameMaster master = GameMaster.instance();
		setLayout(new GridLayout(1, master.getNumberOfPlayers()));
		for (int i = 0; i< master.getNumberOfPlayers(); i++){
			PlayerPanel panel = new PlayerPanel(master.getPlayer(i));
			add(panel);
			panel.displayInfo();
		}
	}
}
