package ds.graph;

public class GraphAdjacencyMatrix {
	private int[][] matrix;
	private boolean isUndirected;

	public GraphAdjacencyMatrix(int numberOfVertices, boolean isUndirected) {
		matrix = new int[numberOfVertices][numberOfVertices];
		this.isUndirected = isUndirected;
	}

	public void addEdge(int startVertex, int endVertex) {
		matrix[startVertex][endVertex] = 1;
		if (isUndirected) {
			matrix[endVertex][startVertex] = 1;
		}
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
