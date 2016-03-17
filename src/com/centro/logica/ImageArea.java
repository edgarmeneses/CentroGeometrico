package com.centro.logica;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.statistics.logic.Statistics;

public class ImageArea {
	
	BufferedImage image;
    BufferedImage imageResult;
    int BLACK_RGB=-16777216;
    int WHITE_RGB=-1;
    File input;
    ArrayList<Double> coordendasX;
    ArrayList<Double> coordenadasY;

    public ImageArea(File input) throws IOException {
        image=ImageIO.read(input);
        imageResult=ImageIO.read(input);
        this.input = input;
        this.coordenadasY = new ArrayList<Double>();
        this.coordendasX = new ArrayList<Double>();
        
    }
    public void blackAndWhite(double porcentaje){
        int aux;
        try {
            setImageResult(ImageIO.read(input));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        porcentaje = (255.0/100.0)*porcentaje;
        for (int i = 0; i < imageResult.getWidth(); i++) {
            for (int j = 0; j < imageResult.getHeight(); j++) {
                Color c=new Color(imageResult.getRGB(i, j));
                aux=(c.getRed()+c.getGreen()+c.getBlue())/3;
                
                if(aux>porcentaje)imageResult.setRGB(i, j, -1);
                else imageResult.setRGB(i, j, BLACK_RGB);
            }
        }
    }
    
    public double randomPoint(int experimentos, int cant_puntos){
    	double area_acum=0;
		for (int e = 0; e < experimentos; e++) {
			int acum = 0;
			for (int i = 0; i < cant_puntos; i++) {
				if(randomPoint()){
					acum++;
				}
			}
			area_acum+=(double)acum/(double)cant_puntos;

		}

		area_acum = area_acum/cant_puntos;
		 center(getCoordinateX(), getCoordinateY());
		return area_acum;
    }
    
    public boolean randomPoint(){
        int x = (int)(Math.random() * (double) imageResult.getWidth());
        int y = (int)(Math.random() * (double) imageResult.getHeight());
        boolean intersects = false;
        if(imageResult.getRGB(x,y) == BLACK_RGB){
            imageResult.setRGB(x, y, Color.ORANGE.getRGB());
            
            if(x>0 && y > 0 && x<imageResult.getWidth() && y <imageResult.getHeight() ){
                imageResult.setRGB(x-1, y, Color.ORANGE.getRGB());
                imageResult.setRGB(x-1, y-1, Color.ORANGE.getRGB());
                imageResult.setRGB(x, y-1, Color.ORANGE.getRGB());
            }
            
            coordendasX.add((double)x);
            coordenadasY.add((double)y);
            intersects = true;
        }else{
            imageResult.setRGB(x, y, Color.BLUE.getRGB());
            
            if(x>0 && y > 0 && x<imageResult.getWidth() && y <imageResult.getHeight() ){
                imageResult.setRGB(x-1, y, Color.BLUE.getRGB());
                imageResult.setRGB(x-1, y-1, Color.BLUE.getRGB());
                imageResult.setRGB(x, y-1, Color.BLUE.getRGB());
            }
        }
       
        //center(getCoordinateX(), getCoordinateY());
        return intersects;
    }
    
    public void center(int x, int y){
    	for (int i = x-5; i < x+5; i++) {
			for (int j = y-5; j < y+5; j++) {
				imageResult.setRGB(i, j, Color.magenta.getRGB());
			}
		}
    	 
    	 //imageResult.setRGB(x, y, 50, 50, rgb, 1, 1);
    }
    
    public void clear(){
    	coordenadasY.removeAll(coordenadasY);
    	coordendasX.removeAll(coordendasX);
    }
    
    
    public int getCoordinateY(){
    	return (int) (Statistics.average(coordenadasY));
    }
    
    public int getCoordinateX(){
    	return (int) (Statistics.average(coordendasX));
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImageResult() {
        return imageResult;
    }

    public void setImageResult(BufferedImage imageResult) {
        this.imageResult = imageResult;
    }


}
