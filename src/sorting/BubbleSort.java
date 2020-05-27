package sorting;

import java.util.Random;

public class BubbleSort {
	
	private static int index = 0;
	private static boolean swapsMade = false;
	
	private static void quickSort(Pixel[] A, int low, int high) {
		if (low < high+1) {
			int p = partition(A, low, high);
			quickSort(A, low, p-1);
			quickSort(A, p+1, high);
		}
	}
	
	private static void swap(Pixel[] A, int index1, int index2) {
		Pixel p1 = A[index1];
		Pixel p2 = A[index2];
		A[index1] = p2;
		A[index2] = p1;
	}
	
	private static int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}
	
	private static int partition(Pixel[] A, int low, int high) {
		swap(A, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			Pixel p1 = A[i];
			Pixel p2 = A[low];
			if(p1.id < p2.id)
				swap(A, i, border++);
		}
		swap(A, low, border-1);
		return border-1;
	}
	
	public static boolean sort(Pixel[] pixels) {
//		if(index+1 >= pixels.length) {
//			if(swapsMade) {
//				index = 0;
//				swapsMade = false;
//			}
//			else {
//				return true;
//			}
//		}
//		Pixel p1 = pixels[index];
//		Pixel p2 = pixels[index + 1];
//		if(p1.id > p2.id) {
//			pixels[index] = p2;
//			pixels[index + 1] = p1;
//			swapsMade = true;
//		}
//		
//		index++;
		Pixel p1 = pixels[pixels.length - 1];
		quickSort(pixels, 0, p1.id);
		
		return true;
	}


}
