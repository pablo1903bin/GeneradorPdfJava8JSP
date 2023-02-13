package Servicios;

import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class EmpleadoServicio {
	
	//Mi metodo para listar mis empleados
	public static List<Empleado> getEmpleado() {
          Empleado e = new Empleado();
          e.setId(1);
          e.setNombre("Pablo");
          e.setApellido("Rosas");
          e.setEdad(30);
          e.setQr("Si");
          
          List<Empleado> list = new ArrayList<Empleado>();
          
          list.add(e);
          
          Empleado e2 = new Empleado();
          e2.setId(2);
          e2.setNombre("Max");
          e2.setApellido("Rosas");
          e2.setEdad(19);
          e2.setQr("Si");
          list.add(e2);
          
          
          Empleado e3 = new Empleado();
          e3.setId(3);
          e3.setNombre("Luci");
          e3.setApellido("Cinto");
          e3.setEdad(32);
          e3.setQr("Si");
          
          list.add(e3); Empleado e4 = new Empleado();
          e4.setId(4);
          e4.setNombre("Rocio");
          e4.setApellido("Perez");
          e4.setEdad(23);
          e4.setQr("Si");
          list.add(e4);
          
		return list;
	}

}
