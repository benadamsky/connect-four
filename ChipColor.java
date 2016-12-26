/* Copyright (c) 2016, Ben Adamsky */

import java.awt.Color;

public enum ChipColor {
	
	RED, BLACK, BLUE, GREEN, PURPLE;

	public Color getColor() {
		if(this == BLACK){
			return Color.BLACK;
		}
		if(this==BLUE){
			return Color.BLUE;
		}
		if(this==GREEN){
			return Color.GREEN;
		}
		if(this==PURPLE){
			return Color.MAGENTA;
		}
		return Color.RED;
	}

}
