package co.edu.uptc.presenter;

import co.edu.uptc.model.AlgorithmsSorting;
import co.edu.uptc.view.*;


public class Presenter {
    private AlgorithmsSorting sorting;
    private View view;
 
    public Presenter() {
        this.sorting = new AlgorithmsSorting();
        this.view = new View();
    }

    public void run() {
    	showMenu();
    }
    
    public void selection() {
        int[] sortedArray = sorting.selectionMethod();
        long timeTrascurred = sorting.measureSelectionMethodTime();
        String sortedValues = "";
        for (int i = 0; i < sortedArray.length; i++) {
            sortedValues += sortedArray[i] + ",";
        }
        view.showInformation(sortedValues + "\nEl tiempo transcurrido es: " + timeTrascurred + "ms" + "\n\nPresiona enter para continuar");
  
    }
    
    public void exchange() {
    	int[] sortedArray = sorting.exchangeMethod();
    	long timeTrascurred = sorting.measureExchangeMethodTime();
        String sortedValues = "";
        for (int i = 0; i < sortedArray.length; i++) {
            sortedValues += sortedArray[i] + ",";
        }
        view.showInformation(sortedValues + "\nEl tiempo transcurrido es: " + timeTrascurred + "ms" + "\n\nPresiona enter para continuar");
    }
    
    public void burbble() {
    	int[] sortedArray = sorting.burbbleMethod();
    	long timeTrascurred = sorting.measureBurbbleMethodTime();
        String sortedValues = "";
    	for (int i = 0; i < sortedArray.length; i++) {
            sortedValues += sortedArray[i] + ",";
        }
        view.showInformation(sortedValues + "\nEl tiempo transcurrido es: " + timeTrascurred + "ms" + "\n\nPresiona enter para continuar");
    }
   
    public void mergeSort() {
    	int[] sortedArray = sorting.mergeSortMethod();
      	long timeTrascurred = sorting.measureMergeSortMethodTime();
        String sortedValues = "";
    	for (int i = 0; i < sortedArray.length; i++) {
    		sortedValues += sortedArray[i] + ",";
        }
        view.showInformation(sortedValues + "\nEl tiempo transcurrido es: " + timeTrascurred + "ms" + "\n\nPresiona enter para continuar");
    }
    
    public void calculateRanking() {
    	view.showInformation("La eficiencia de los metodos de mejor a menor es:\n1. Metodo de Intercambio\n2. Metodo MergeSort\n3. Metodo de Selección\n4. Metodo de Burbuja");
    }

    
    public void showMenu() {
		int option = 0;
		do {
			String menu = "Bienvenido al programa de Ordenamiento\n1. Metodo de Selección\n2. Metodo de Intercambio\n3. Metodo de Burbuja\n4. Metodo de Mergesort\n5. Calcular el ranking\n6. Salir";
			option = Integer.parseInt(view.readData(menu + "\n\nDigite la opción que desee: "));
			switch(option) {
			case 1:
				selection();
				break;
			case 2:
				exchange();
				break;
			case 3:
				burbble();
				break;
			case 4:
				mergeSort();
				break;
			case 5:
				calculateRanking();
				break;
			case 6:
				view.showInformation("Hecho por \nKevin Johann Jimenez\nFredy Oswaldo Lopez\nLuis Hernandez\nWalter Alfonso Martinez\nNicolas Danilo Muñoz ");
				System.exit(0);
			default:
				view.showInformation("La opción es invalida");
				break;
			}
		} while (option != 6);
	}
    
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.run();
    }
}

