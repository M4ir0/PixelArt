package Clases;

public final class TmpResolucion {
	
	public static int getAncho() {
		return ancho;
	}
	public static void setAncho(int ancho) {
		TmpResolucion.ancho = ancho;
	}
	
	public static int getAlto() {
		return alto;
	}
	public static void setAlto(int alto) {
		TmpResolucion.alto = alto;
	}
	
	public static boolean isActualizarUI() {
		return actualizarUI;
	}
	public static void setActualizarUI(boolean actualizarUI) {
		TmpResolucion.actualizarUI = actualizarUI;
	}
	
	private static int ancho;
	private static int alto;
	private static boolean actualizarUI;
}
