package graph;

public class Neighbour {
	private String name;
	private Neighbour neighbour;

	public Neighbour(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String vertexName) {
		this.name = vertexName;
	}

	public Neighbour getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(Neighbour neighbour) {
		this.neighbour = neighbour;
	}

}
