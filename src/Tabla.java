import java.util.Scanner;

class Tabla implements EnsambleMaterial {
    @Override
    public void crearMaterial(int cantidad) {
        Scanner sn = new Scanner(System.in);
        System.out.println("             (\\(\\");
        System.out.println("             (-.-)");
        System.out.println("            o_(\")(\")");
        System.out.println("Cantidad de: " + cantidad + " tablas Fabricadas \uD83D\uDEE0 \uD83D\uDEE0.");
        sn.nextLine();
    }
}