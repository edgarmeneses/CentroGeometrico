package com.centro.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.centro.logica.ImageArea;

import java.awt.Font;

public class MainFrame extends JFrame implements ChangeListener {

	JSpinner tolerancia;
	ImageArea image;
	JPanel filter;
	JTextField puntos;
	JTextField ancho;
	JTextField experimentos;
	JLabel result;
	JLabel  label;
	private JLabel lblResultadoCentroMedio;
	private JLabel lblX;
	private JLabel lblResultadoX;
	private JLabel lblY;
	private JLabel lblResultadoY;
	private JLabel lblImgAcerca;
	private JLabel lblAcercaDe;
	private JLabel lblImgGenerar;
	private JLabel lblGenarar;
	private JLabel lblImgSalir;
	private JLabel lblSalir;
	private JLabel lblImgencargarImagen;
	private JLabel lblCargarImagen;
	private JLabel lblSalir1;


	public MainFrame() throws HeadlessException {
		init();
		setVisible(true);
	}

	private void init(){
		setTitle("Centro Geometrico");
		this.setSize(974,654);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setResizable(false);
		ImageIcon icono = new ImageIcon(getClass().getResource("../img/icono.png")); 
		this.setIconImage(icono.getImage());

		JLabel lbl_tolerancia = new JLabel("Tolerancia:");
		lbl_tolerancia.setBounds(10,558,100,30);
		lbl_tolerancia.setVisible(false);
		getContentPane().add(lbl_tolerancia);

		tolerancia = new JSpinner();
		tolerancia.addChangeListener(this);
		tolerancia.setBounds(99, 558, 100, 30);
		tolerancia.setValue(75);
		tolerancia.setVisible(false);
		getContentPane().add(tolerancia);

		filter = new JPanel(null);
		filter.setBounds(10, 11, 520, 520);
		filter.setBorder(new TitledBorder("Imagen"));
		getContentPane().add(filter);


		result=new JLabel("Resultado:");
		result.setBounds(540, 279, 418, 30);
		getContentPane().add(result);
		result.setVisible(false);

		JLabel lbl_puntos = new JLabel("Puntos:");
		lbl_puntos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_puntos.setBounds(540,27,80,30);
		getContentPane().add(lbl_puntos);

		puntos = new JTextField("100");
		puntos.setBounds(651,27,100,30);
		getContentPane().add(puntos);

		JLabel lbl_ancho = new JLabel("Ancho:");
		lbl_ancho.setBounds(209,558,80,30);
		lbl_ancho.setVisible(false);
		getContentPane().add(lbl_ancho);

		ancho = new JTextField("100");
		ancho.setBounds(289,558,100,30);
		ancho.setVisible(false);
		getContentPane().add(ancho);

		JLabel lbl_expermientos = new JLabel("Experimentos:");
		lbl_expermientos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_expermientos.setBounds(540,68,100,30);
		lbl_expermientos.setVisible(false);
		getContentPane().add(lbl_expermientos);

		experimentos = new JTextField("1");
		experimentos.setBounds(651,70,100,30);
		experimentos.setVisible(false);
		getContentPane().add(experimentos);

		lblResultadoCentroMedio = new JLabel("Resultado Centro Medio");
		lblResultadoCentroMedio.setForeground(new Color(139, 0, 0));
		lblResultadoCentroMedio.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 16));
		lblResultadoCentroMedio.setBounds(540, 207, 211, 30);
		getContentPane().add(lblResultadoCentroMedio);

		lblX = new JLabel("X: ");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setBounds(540, 248, 46, 14);
		getContentPane().add(lblX);

		lblResultadoX = new JLabel();
		lblResultadoX.setBounds(566, 247, 127, 21);
		getContentPane().add(lblResultadoX);

		lblY = new JLabel("Y:");
		lblY.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblY.setBounds(750, 248, 46, 14);
		getContentPane().add(lblY);

		lblResultadoY = new JLabel();
		lblResultadoY.setBounds(782, 247, 127, 21);
		getContentPane().add(lblResultadoY);

		lblCargarImagen = new JLabel("Cargar Imagen");
		lblCargarImagen.setBounds(673, 502, 88, 14);
		getContentPane().add(lblCargarImagen);

		lblImgencargarImagen = new JLabel("");
		lblImgencargarImagen.setBounds(679, 437, 60, 60);
		getContentPane().add(lblImgencargarImagen);
		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("../img/cargar.png"));
		lblImgencargarImagen.setIcon(icon2);
		lblImgencargarImagen.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser chooser= new JFileChooser();
				FileNameExtensionFilter fn= new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
				chooser.setFileFilter(fn);
				int returnVal = chooser.showOpenDialog(lblCargarImagen);
				
			    if(returnVal == chooser.APPROVE_OPTION) {
			       System.out.println("Nombre: " + chooser.getSelectedFile().getName());
			       try {
					image= new ImageArea(chooser.getSelectedFile());
			    	   update();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(lblCargarImagen, "Error al cargar la imagen");
				}
				if (chooser.getSelectedFile().exists()) {
						System.out.println("Si sirveeeee");
					}else{
						System.out.println("No seirviiooo");
					}
						
			    }
			}

		});

		lblAcercaDe = new JLabel("Acerca De");
		lblAcercaDe.setBounds(567, 502, 60, 14);
		getContentPane().add(lblAcercaDe);

		lblImgAcerca = new JLabel();
		lblImgAcerca.setBounds(567, 432, 60, 60);
		getContentPane().add(lblImgAcerca);
		ImageIcon icon1 = new ImageIcon(this.getClass().getResource("../img/acercade.png"));
		lblImgAcerca.setIcon(icon1);

		lblGenarar = new JLabel("Ejecutar");
		lblGenarar.setBounds(821, 97, 60, 14);
		getContentPane().add(lblGenarar);

		lblImgGenerar = new JLabel();
		lblImgGenerar.setBounds(811, 27, 60, 60);
		getContentPane().add(lblImgGenerar);
		ImageIcon icon3 = new ImageIcon(this.getClass().getResource("../img/ejecutar.png"));
		lblImgGenerar.setIcon(icon3);
		lblImgGenerar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				calcular();
				System.out.println("Esta ejecutandooo");
				
			}
		});

		lblSalir1 = new JLabel("Salir");
		lblSalir1.setBounds(825, 502, 46, 14);
		getContentPane().add(lblSalir1);
		
		lblImgSalir = new JLabel();
		lblImgSalir.setBounds(798, 433, 60, 60);
		getContentPane().add(lblImgSalir);
		ImageIcon icon4 = new ImageIcon(this.getClass().getResource("../img/salir.png"));
		lblImgSalir.setIcon(icon4);
		lblImgSalir.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "salida",  JOptionPane.YES_NO_OPTION);
				if(option==0){
					System.exit(0);
				}
			}
		});
	}
	public void update(){

		double factor=0;
		if ((double)(500.0/(double)image.getImage().getHeight()) <(double)(500.0/(double)image.getImage().getWidth())){
			factor=(double)(500.0/(double)image.getImage().getHeight());
		}else{
			factor=(double)(500.0/(double)image.getImage().getWidth());
		}
		int h = (int)(factor * (double)image.getImage().getHeight());
		int w = (int)(factor * (double)image.getImage().getWidth());

		image.blackAndWhite(Double.parseDouble(tolerancia.getValue().toString()));

		JLabel lbl_filter=new JLabel();
		lbl_filter.setIcon(new ImageIcon(image.getImageResult().getScaledInstance(w,h, 100)));
		lbl_filter.setBounds(10,10,w,h);
		filter.removeAll();
		filter.repaint();
		filter.add(lbl_filter);
		filter.repaint();

		repaint();
	}

	public void calcular(){

		update();
		image.clear();
		int exp = Integer.parseInt(experimentos.getText());
		int cant_puntos = Integer.parseInt(puntos.getText());
		double area_acum=image.randomPoint(exp, cant_puntos);
		lblResultadoX.setText(image.getCoordinateX()+"");
		lblResultadoY.setText(image.getCoordinateY()+"");
		System.out.println(image.getImage().getWidth()+"ancho") ;
		double ancho_img = Double.parseDouble(ancho.getText());
		double alto_img = (ancho_img * (double)image.getImage().getWidth()) /  (double)image.getImage().getHeight();


		result.setText("Resultado, Area: "+area_acum*(ancho_img *alto_img));


		double factor=0;
		if ((double)(500.0/(double)image.getImage().getHeight()) <(double)(500.0/(double)image.getImage().getWidth())){
			factor=(double)(500.0/(double)image.getImage().getHeight());
		}else{
			factor=(double)(500.0/(double)image.getImage().getWidth());
		}
		int h = (int)(factor * (double)image.getImage().getHeight());
		int w = (int)(factor * (double)image.getImage().getWidth());
		JLabel lbl_filter=new JLabel();
		lbl_filter.setIcon(new ImageIcon(image.getImageResult().getScaledInstance(w,h, 100)));
		lbl_filter.setBounds(10,10,w,h);

		label = new JLabel("Hol");
		label.setForeground(Color.MAGENTA);
		label.setBounds(275, 281, 20, 20);

		int x = image.getCoordinateX();
		int y =image.getCoordinateY();
		//image.center(x,y );
		//System.out.println("x= "+ x+" y= "+y);

		filter.removeAll();

		//int x = image.getCoordinateX();
		//int y =image.getCoordinateY();
		//image.center(x,y );
		//System.out.println("x= "+ x+" y= "+y);
		filter.repaint();
		//filter.add(label);
		filter.add(lbl_filter);
		filter.repaint();
		repaint();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource().equals(tolerancia)){

		}
	}
}
