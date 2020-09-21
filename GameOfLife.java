public class GameOfLife {

	public static void main(String[] args) {

	 	final int NUMBER_OF_NEIGHBORS = 8;

		int generationCounter = 0;
		Canvas[] arrayOfCanvases = new Canvas[2];

		for (int j = 0; j < arrayOfCanvases.length; j++) {

			arrayOfCanvases[j] = new Canvas();
		}

		arrayOfCanvases[0].initializeCanvas();
		arrayOfCanvases[0].printCanvas();

		while(true) {

			int aliveNeighbors;
			int currentRow, currentColumn;
			int currentNeighborX, currentNeighborY;

			for (int rowCounter = 0; rowCounter < arrayOfCanvases[generationCounter % 2].canvas.length; rowCounter++) {

				for (int colCounter = 0; colCounter < arrayOfCanvases[generationCounter % 2].canvas[0].length; colCounter++) {

					aliveNeighbors = 0;

					currentRow = rowCounter;
					currentColumn = colCounter;

					for (int moveCounter = 0; moveCounter < NUMBER_OF_NEIGHBORS; moveCounter++) {

							currentNeighborX = (arrayOfCanvases[generationCounter % 2].canvas.length + (currentRow + arrayOfCanvases[generationCounter % 2].horizontal[moveCounter]) ) % arrayOfCanvases[generationCounter % 2].canvas.length;
							currentNeighborY = (arrayOfCanvases[generationCounter % 2].canvas[0].length + (currentColumn + arrayOfCanvases[generationCounter % 2].vertical[moveCounter]) ) % arrayOfCanvases[generationCounter % 2].canvas[0].length;

						if (arrayOfCanvases[generationCounter % 2].canvas[currentNeighborX][currentNeighborY])

							aliveNeighbors++;
					}

					if ((arrayOfCanvases[generationCounter % 2].canvas[currentRow][currentColumn] == true) && ((aliveNeighbors < 2) || (aliveNeighbors > 3))) {

						arrayOfCanvases[(generationCounter + 1) % 2].canvas[currentRow][currentColumn] = false;
					}

					else if ((arrayOfCanvases[generationCounter % 2].canvas[currentRow][currentColumn] == true) && (aliveNeighbors == 2 || aliveNeighbors == 3)) {

						arrayOfCanvases[(generationCounter + 1) % 2].canvas[currentRow][currentColumn] = true;
					}

					else if ((arrayOfCanvases[generationCounter % 2].canvas[currentRow][currentColumn] == false) && (aliveNeighbors == 3) ) {

						arrayOfCanvases[(generationCounter + 1) % 2].canvas[currentRow][currentColumn] = true;
					}
				}
			}
		
			arrayOfCanvases[(generationCounter + 1) % 2].printCanvas();

			System.out.println(" Generation: " + generationCounter);

			arrayOfCanvases[generationCounter % 2] = arrayOfCanvases[(generationCounter + 1) % 2];

			generationCounter++;

			try {
    			Thread.sleep(500);
			}
			catch(InterruptedException ex) {
   				Thread.currentThread().interrupt();
			}
		}

	}
}