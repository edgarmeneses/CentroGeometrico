package com.centro.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author  NATALIE SANTIAGO TORRES
 *
 */
public class About extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Acerca de";
	private JLabel jLabelImage;
	private MainFrame mainFrame;
	
	/**
	 * constructor de la clase
	 * @param actionListenerQuestion
	 */
	public About(MainFrame mainFrame) {
		super(mainFrame, true);
		init();
		
	}
	
	/**
	 * metodo encargado de inicializar los componentes de la ventana de registro del usuario
	 * @param actionListenerQuestion
	 */
	public void init( ){
		
		this.setSize(1000, 510);
		this.setTitle(TITLE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);	
		
		this.jLabelImage = new JLabel();
		this.jLabelImage.setSize(1000, 500);
		this.jLabelImage.setIcon(new ImageIcon(getClass().getResource("../img/about.png")));
		this.add(jLabelImage, BorderLayout.CENTER);	
		
		JPanel jPanel= new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));
		
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}


}
