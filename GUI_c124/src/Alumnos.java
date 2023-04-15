
public class Alumnos {
	public int DNI;
	public String Nombre;

	public boolean GuardarAlumnos(int d, String n) {
		try {
		this.DNI=d;
		this.Nombre=n;
		return true;
		}
		catch(Exception Error) {
			return false;
		}
	}
	public String MostrarAlumnos() {
		try {
			if(this.DNI>0) {
				return "Dni: " + this.DNI +"\n" +"nombre: "  + this.Nombre; 
			} 
			else {
				return "No hay alumnos para mostrar";
			}
			
		}
		catch(Exception Error) {
			System.out.println("Hubo un error");
			return "Hubo un error";
		}
	}

}
