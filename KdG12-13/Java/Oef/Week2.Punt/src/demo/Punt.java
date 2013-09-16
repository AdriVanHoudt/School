package demo;

public class Punt implements Comparable<Punt> {
	private int x;
	private int y;
	
	public Punt(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Punt other = (Punt) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public double distance(Punt p)
	{
		double dx = p.x - this.x;
		double dy = p.y - this.y;
		return Math.sqrt((dx*dx)+(dy*dy));
	}

	public double distanceToCenter() {
		return Math.sqrt(((this.x)*(this.x))+((this.y)*(this.y)));
	}

	public int compareTo(Punt p) {
		if(this.distanceToCenter() == p.distanceToCenter())
		{
		return 0;
		}else if(this.distanceToCenter() > p.distanceToCenter()){
			return 1;
		}else{
			return -1;
		}
	}
	
	
}
