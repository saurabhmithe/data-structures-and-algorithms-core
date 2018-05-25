package graph;

public class Vertex {
	private String vertexName;
	private Neighbour neighbour;

	public String getVertexName() {
		return vertexName;
	}

	public void setVertexName(String vertexName) {
		this.vertexName = vertexName;
	}

	public Neighbour getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(Neighbour neighbour) {
		this.neighbour = neighbour;
	}

}
