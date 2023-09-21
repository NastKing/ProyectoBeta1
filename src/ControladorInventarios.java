import java.util.*;
public class ControladorInventarios {
    public static void main(String[] args) {

        HashMap<String, Integer> inventarioMateriales = new HashMap<>();
        inventarioMateriales.put("Tabla", 0);
        inventarioMateriales.put("Clavo", 0);
        inventarioMateriales.put("Pegamento", 0);


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("|Bienvenido a la fabrica de sillas:       |");
            System.out.println("|1. Crear Un Pedido de Sillas             |");
            System.out.println("|2. Mostrar inventario de materiales      |");
            System.out.println("|3. Salir                                 |");
            System.out.println("|---->Seleccione una opción:              |");
            System.out.println("-------------------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("----------Hola me llamo Saltarin-------------");
                    System.out.println("             (\\(\\");
                    System.out.println("             (-.-)");
                    System.out.println("            o_(\")(\")");
                    System.out.println("-----Sere Tu Asistente Duarante proceso-----");
                    System.out.println("---------------De Fabricacion---------------");

                    System.out.println("**Para Iniciar***");
                    System.out.print("Ingresa la cantidad de sillas que el cliente neceista: ");
                    int cantidadSillas = scanner.nextInt();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");

                    // Verificar si es posible crear la cantidad deseada de sillas
                    if (puedeCrearSillas(inventarioMateriales, cantidadSillas)) {
                        // Si es posible, crear las sillas y actualizar el inventario de materiales
                        inventarioMateriales = crearSillas(inventarioMateriales, cantidadSillas);



                        double precioSilla = 50.0;
                        Producto silla = new Producto("Silla", precioSilla);
                        silla.setCantidadSolicitada(cantidadSillas);
                        // Crear una factura para el cliente
                        if (puedeCrearSillas(inventarioMateriales, cantidadSillas)) {
                            // Solicitar al usuario el nombre y apellido del cliente
                            scanner.nextLine();
                            System.out.print("Ingrese el nombre del cliente: ");
                            String nombreCliente = scanner.nextLine();
                            System.out.print("Ingrese el apellido del cliente: ");
                            String apellidoCliente = scanner.nextLine();
                            System.out.println("Ingrese el nit del cliente");
                            int nit = scanner.nextInt();
                            scanner.nextLine();
                            //guardar cliente
                            Cliente cliente = new Cliente(nombreCliente, apellidoCliente,nit);
                            //crear factura con datos cliente
                            Factura factura = new Factura(cliente);
                            factura.agregarProducto(silla);
                            System.out.println("Ingrese la descripcion del producto");
                            String Descripcion = scanner.nextLine();
                            factura.setDescripcion(Descripcion);
                            System.out.println("Espere 05 Segundos se esta creando el numero de orden");
                            try {
                                Thread.sleep(5000); // Pausa la ejecución durante 10 segundos (10000 milisegundos)
                            } catch (InterruptedException e) {
                                // Manejo de excepción en caso de interrupción del hilo
                                e.printStackTrace();
                            }
                            System.out.println("Se han comprado " + cantidadSillas + " sillas.");
                            // Imprimir la factura
                            System.out.println("\nResumen de la factura:");
                            factura.imprimirFactura();
                        }

                    } else {
                        System.out.println("             (\\(\\");
                        System.out.println("             (-.-)");
                        System.out.println("            o_(\")(\")");
                        System.out.println("¡No Puede ser! No Tenemos Los Materiales Necesarios. ");
                        System.out.println(" Para Crear La cantidad de: "+cantidadSillas + " sillas debido a la falta de materiales.");
                        System.out.println("-->Tendremos que crearlos \uD83E\uDDBE \uD83E\uDDBE \uD83E\uDDBE");
                        System.out.println("Presiona una tecla para continuar!");
                        scanner.nextLine();
                        scanner.nextLine();

                        // Pedir al usuario que cree más materiales
                        crearMateriales(inventarioMateriales, scanner,cantidadSillas);
                    }


                    break;

                case 2:
                    // Mostrar el inventario de materiales
                    System.out.println("\nInventario de materiales:");
                    for (String material : inventarioMateriales.keySet()) {
                        int cantidad = inventarioMateriales.get(material);
                        System.out.println(material + ": " + cantidad);
                    }
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    scanner.close(); // Cerrar el objeto Scanner
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Función para verificar si es posible crear la cantidad deseada de sillas

    public static boolean puedeCrearSillas(Map<String, Integer> inventarioMateriales, int cantidadSillas) {
        // Suponemos que la silla utiliza los siguientes materiales por unidad
        int tablasNecesariasPorSilla = 5;
        int clavosNecesariosPorSilla = 10;
        int pegamentoNecesarioPorSilla = 4;

        int tablasNecesarias = tablasNecesariasPorSilla * cantidadSillas;
        int clavosNecesarios = clavosNecesariosPorSilla * cantidadSillas;
        int pegamentoNecesario = pegamentoNecesarioPorSilla * cantidadSillas;

        return inventarioMateriales.getOrDefault("Tabla", 0) >= tablasNecesarias &&
                inventarioMateriales.getOrDefault("Clavo", 0) >= clavosNecesarios &&
                inventarioMateriales.getOrDefault("Pegamento", 0) >= pegamentoNecesario;
    }

    // Función para crear sillas y actualizar el inventario de materiales
    public static  HashMap<String, Integer> crearSillas(HashMap<String, Integer> inventarioMateriales, int cantidadSillas) {
        Scanner scanner = new Scanner(System.in);
        // Suponemos que la silla utiliza los siguientes materiales por unidad
        int tablasNecesariasPorSilla = 5;
        int clavosNecesariosPorSilla = 10;
        int pegamentoNecesarioPorSilla = 4;

        int tablasNecesarias = tablasNecesariasPorSilla * cantidadSillas;
        int clavosNecesarios = clavosNecesariosPorSilla * cantidadSillas;
        int pegamentoNecesario = pegamentoNecesarioPorSilla * cantidadSillas;
        System.out.println("");
        System.out.println("            *Saltarin*");
        System.out.println("                         ");
        System.out.println("             (\\(\\");
        System.out.println("             (-.-)");
        System.out.println("            o_(\")(\")");

        // Actualizar el inventario restando los materiales utilizados
        String entradaUsuario="";
        do {
            System.out.println("|¡Genial! Tenemos los materiales necesario Empecemos");
            System.out.println(".....................................................");
            System.out.println("|---->Presiona "+"S"+" para cortar y preparar la madera<---------");
            //centrar despues de borrar
            System.out.println("");
            //guardar lo ingresado
            entradaUsuario = scanner.nextLine();


            if (entradaUsuario.equalsIgnoreCase("S")) {
                // El usuario presionó 'S', continúa con el proceso

                System.out.println("¡Genial! \uD83E\uDE9A Madera cortada y preparada. \uD83E\uDE9A.");
                inventarioMateriales.put("Tabla", inventarioMateriales.get("Tabla") - tablasNecesarias);
                System.out.println("");

                String entrada2;
                do{


                    System.out.println("Tenemos la madera lista pero necesitamos clavarla con clavos");
                    System.out.println("Presione 'S' para clavar la madera");

                    System.out.println("");
                    entrada2 = scanner.nextLine();
                    if (!entrada2.equalsIgnoreCase("s")){
                        System.out.println("¿Qué haces? \uD83D\uDE15 Necesitamos terminar el pedido, ya hemos iniciado el proceso.");
                        System.out.println("No te pongas quisquilloso y ven a terminar esto. \uD83D\uDE04");
                        System.out.println("-->Presiona 's'");
                    }else{
                        System.out.println("¡Genial! \uD83D\uDD28 Madera clavada correctamente. \uD83D\uDD28");
                        inventarioMateriales.put("Clavo", inventarioMateriales.get("Clavo") - clavosNecesarios);
                        System.out.println("");
                        String entrada3;
                        do{
                            System.out.println("Solo nos falta Pegar las ultimas piezas ");
                            System.out.println("Presiona 'S' para pegar las partes faltantes. \uD83E\uDDE1 ");
                            entrada3 = scanner.nextLine();
                            if (!entrada3.equalsIgnoreCase("s")){
                                System.out.println("¿Pero qué haces? \uD83D\uDE06 Puedes dejar de jugar. \uD83D\uDE1C");
                                System.out.println("Necesitamos terminar la silla, ¡presiona 'S'! \uD83E\uDE91");
                            }else {
                                System.out.println("¡Hemos terminado nuestro trabajo! \uD83C\uDF89 Solo falta imprimir la factura. \uD83E\uDDFE");

                                inventarioMateriales.put("Pegamento", inventarioMateriales.get("Pegamento") - pegamentoNecesario);
                            }
                        }while (!entrada3.equalsIgnoreCase("s"));





                    }
                }while(!entrada2.equalsIgnoreCase("S"));


            } else {
                // El usuario no presionó 'S', puedes mostrar un mensaje o manejarlo según tus necesidades
                System.out.println("No me hagas perder mi tiempo.\uD83D\uDE1E Estamos tratando de Completar un pedido.");
                System.out.println("¡Venga va, dale a la 'S'\uD83D\uDE01");
            }
        }while (!entradaUsuario.equalsIgnoreCase("s"));



        return inventarioMateriales;
    }

    // Función para crear materiales adicionales
    public static void crearMateriales(HashMap<String, Integer> inventarioMateriales, Scanner scanner,int catidadsilla) {
        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("           Bienvenido  :D  ");
            System.out.println("             (\\(\\");
            System.out.println("             (-.-)");
            System.out.println("            o_(\")(\")");
            //mostrar materiales si no hay para que el usuario vea cuantos hay de cada material
            System.out.println("Para "+catidadsilla+" sillas se necesita");
            System.out.println(+(catidadsilla*5)+" Tablas, "+(catidadsilla*10)+" Clavos y "+(catidadsilla*4)+" Pegamentos");
            System.out.println("");
            System.out.println("Este es nuestro Inventario de materiales:");
            //aqui imprime al inverso de lo que está más abajo
            //pegamento 0
            //clavo 0
            //tabla
            List<String> materialesInvertidos = new ArrayList<>(inventarioMateriales.keySet());
            Collections.reverse(materialesInvertidos);

            for (String material : materialesInvertidos) {
                int cantidad = inventarioMateriales.get(material);
                System.out.println(material + ": " + cantidad);
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.println("Cuando tengas los materiasl Vuelve a inciar el proceso Recuerda cuantas silla Vas a Crear ===>"+(catidadsilla)+"<====");
            System.out.println("");
            System.out.println("¿Qué material Faltan para crear "+catidadsilla+" Sillas?");
            //aqui en esta mira el orden que tiene esta lista
            System.out.println("1. Tabla");
            System.out.println("2. Clavo");
            System.out.println("3. Pegamento");
            System.out.println("4.Tengo los materiales ");
            System.out.print("Seleccione una opción: ");

            int opcionMaterial = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer del teclado

            switch (opcionMaterial) {
                case 1:
                    System.out.print("Ingrese la cantidad de tablas que desea crear: ");
                    int cantidadTablas = scanner.nextInt();
                    EnsambleMaterial tabla = new Tabla();
                    tabla.crearMaterial(cantidadTablas);
                    inventarioMateriales.put("Tabla", inventarioMateriales.getOrDefault("Tabla", 0) + cantidadTablas);

                    break;

                case 2:
                    System.out.print("Ingrese la cantidad de clavos que desea crear: ");
                    int cantidadClavos = scanner.nextInt();
                    EnsambleMaterial clavo = new Clavo();
                    clavo.crearMaterial(cantidadClavos);
                    inventarioMateriales.put("Clavo", inventarioMateriales.getOrDefault("Clavo", 0) + cantidadClavos);

                    break;

                case 3:
                    System.out.print("Ingrese la cantidad de pegamento que desea crear: ");
                    int cantidadPegamento = scanner.nextInt();
                    EnsambleMaterial pegamento = new Pegamento();
                    pegamento.crearMaterial(cantidadPegamento);
                    inventarioMateriales.put("Pegamento", inventarioMateriales.getOrDefault("Pegamento", 0) + cantidadPegamento);

                    break;

                case 4:
                    return; // Volver al menú principal

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

}

