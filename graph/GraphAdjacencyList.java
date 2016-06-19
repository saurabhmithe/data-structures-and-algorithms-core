package ds.graph;

public class GraphAdjacencyList {
	private int numberOfVertices;
	private Vertex[] vertices;
	private int numberOfEntries;
	private boolean isUndirected;

	public GraphAdjacencyList(int numberOfVertices, boolean isUndirected) {
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		numberOfEntries = 0;
		this.isUndirected = isUndirected;
	}

	public void addVertex(String vertexName) {
		if (!(numberOfEntries >= numberOfVertices)) {
			Vertex newVertex = new Vertex();
			newVertex.setVertexName(vertexName);
			vertices[numberOfEntries] = newVertex;
			numberOfEntries++;
		} else {
			System.out.println("Unable to add vertex. List is full.");
		}
	}

	public boolean addNeighbour(String vertexName, String neighbourName) {
		boolean validNeighbour = false;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] != null && vertices[i].getVertexName().equalsIgnoreCase(neighbourName)) {
				validNeighbour = true;
			}
		}
		if (validNeighbour) {
			
			Neighbour newNeighbour = new Neighbour(neighbourName);
			for (int i = 0; i < vertices.length; i++) {
				if (vertices[i].getVertexName().equalsIgnoreCase(vertexName)) {
					if (vertices[i].getNeighbour() == null) {
						vertices[i].setNeighbour(newNeighbour);
						break;
					} else {
						Neighbour neighbour = vertices[i].getNeighbour();
						while (neighbour.getNeighbour() != null) {
							neighbour = neighbour.getNeighbour();
						}
						neighbour.setNeighbour(newNeighbour);
						break;
					}
				}
			}
			if (isUndirected) {
				String vertex = neighbourName;
				String neighbour = vertexName;
				Neighbour newNeighbourTemp = new Neighbour(neighbour);
				for (int i = 0; i < vertices.length; i++) {
					if (vertices[i].getVertexName().equalsIgnoreCase(vertex)) {
						if (vertices[i].getNeighbour() == null) {
							vertices[i].setNeighbour(newNeighbourTemp);
							break;
						} else {
							Neighbour neighbourTemp = vertices[i].getNeighbour();
							while (neighbourTemp.getNeighbour() != null) {
								neighbourTemp = neighbourTemp.getNeighbour();
							}
							neighbourTemp.setNeighbour(newNeighbour);
							break;
						}
					}
				}
			}
		} else {
			System.out.println(neighbourName + " is not a valid neighbour");
		}
		return false;
	}

	public void printList() {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] != null) {
				System.out.print(vertices[i].getVertexName() + " ");
				if (vertices[i].getNeighbour() != null) {
					Neighbour neighbour = vertices[i].getNeighbour();
					while (neighbour != null) {
						System.out.print(neighbour.getName() + " ");
						neighbour = neighbour.getNeighbour();
					}

				}
			}
			System.out.println("");
		}
	}
}
