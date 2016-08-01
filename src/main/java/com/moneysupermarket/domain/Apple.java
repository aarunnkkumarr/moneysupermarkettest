package com.moneysupermarket.domain;

public class Apple extends Fruit{
	
	private Color color;
	private double weight;
	private Taste taste;
	private boolean isInfected;

	
	public Apple(Color appleColor, double weight, Taste taste, boolean isInfected) {
		super();
		this.color = appleColor;
		this.weight = weight;
		this.taste = taste;
		this.isInfected = isInfected;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color appleColor) {
		this.color = appleColor;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	public boolean isInfected() {
		return isInfected;
	}

	public void setInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (isInfected ? 1231 : 1237);
		result = prime * result + ((taste == null) ? 0 : taste.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (color != other.color)
			return false;
		if (isInfected != other.isInfected)
			return false;
		if (taste != other.taste)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

}
