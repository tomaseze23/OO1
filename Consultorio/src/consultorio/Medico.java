package consultorio;

public class Medico {
	//atributos
	private String nombre;
	private String apellido;
	private String especialidad;
	private Paciente[] pacientesFrecuentes= {};
	
	//constructor
	public Medico(String nombre, String apellido, String especialidad, Paciente[]pacientesFrecuentes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.pacientesFrecuentes = pacientesFrecuentes;
	}
	//metodos getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public Paciente[] getPacientesFrecuentes() {
		return pacientesFrecuentes;
	}
	public void setPacientesFrecuentes(Paciente[] pacientesFrecuentes) {
		this.pacientesFrecuentes = pacientesFrecuentes;
	}
	public float calcularIMC(Paciente paciente) {
		float peso = paciente.getPeso();
		float estatura = paciente.getEstatura();
		return (peso/(estatura*estatura));
	}
	public String traerNombreCompleto() {
		return nombre+" "+apellido;
	}
	public void mostrarPacientes() {
		if(pacientesFrecuentes==null) {
			System.out.println("el array no pudo ser cargado");
		}else {
			for (int i = 0; i < pacientesFrecuentes.length; i++) {
				System.out.print(pacientesFrecuentes[i].toString()+"\n");
			}
		}
	}
	public double traerPromedioPeso() {
		double sumaPesos=0;
		for(int i=0;i<pacientesFrecuentes.length;i++) {
			sumaPesos+=pacientesFrecuentes[i].getPeso();
		}
		return sumaPesos/pacientesFrecuentes.length;
	}
	public Paciente traerPacienteMayorEstatura() {
		Paciente pacienteMayorEstatura = pacientesFrecuentes[0];
		for(int i=0;i<pacientesFrecuentes.length;i++) {
			if(pacientesFrecuentes[i].getEstatura()>pacienteMayorEstatura.getEstatura()) {
				pacienteMayorEstatura=pacientesFrecuentes[i];
			}
		}
		return pacienteMayorEstatura;
	}
	public Paciente traerPacienteMenorIMC() {
		Paciente pacienteMenorIMC= pacientesFrecuentes[0];
		for(int i=0;i<pacientesFrecuentes.length;i++) {
			if(calcularIMC(pacientesFrecuentes[i])<calcularIMC(pacienteMenorIMC)) {
				pacienteMenorIMC=pacientesFrecuentes[i];
			}
		}
		return pacienteMenorIMC;
	}
}
