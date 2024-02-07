package org.example.gtgwebmanagement.seeds;

import org.example.gtgwebmanagement.models.dao.BowlDAOImpl;
import org.example.gtgwebmanagement.models.dao.IngredienteDAOImpl;
import org.example.gtgwebmanagement.models.dao.MenuDAOImpl;
import org.example.gtgwebmanagement.models.entity.Bowl;
import org.example.gtgwebmanagement.models.entity.Ingrediente;
import org.example.gtgwebmanagement.models.entity.Menu;

public class Seeds {
    private IngredienteDAOImpl ingredienteService;
    private BowlDAOImpl bowlService;
    private MenuDAOImpl menuService;

    public Seeds(IngredienteDAOImpl ingredienteService, BowlDAOImpl bowlService, MenuDAOImpl menuService) {
        this.ingredienteService = ingredienteService;
        this.bowlService = bowlService;
        this.menuService = menuService;
    }

    public void generateSeeds() {
        seedIngredientes();
        seedBowls();
        seedMenus();
    }

    private void seedIngredientes() {
        if (ingredienteService.findAll().length == 0) {
            Ingrediente tomate = new Ingrediente("Tomate", 5.0, "Vegetal", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente pollo = new Ingrediente("Pollo", 10.0, "Carne", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente lechuga = new Ingrediente("Lechuga", 15.0, "Vegetal", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente arroz = new Ingrediente("Arroz", 20.0, "Legumbre", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente salmon = new Ingrediente("Salmón", 25.0, "Pescado", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente pepino = new Ingrediente("Pepino", 30.0, "Vegetal", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente frijoles = new Ingrediente("Frijoles", 25.0, "Legumbre", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente aguacate = new Ingrediente("Aguacate", 20.0, "Vegetal", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente queso = new Ingrediente("Queso", 15.0, "Lacteo", 1.0f, 1.2f, 1.4f, 1.6f, 2f);
            Ingrediente maiz = new Ingrediente("Maíz", 10.0, "Vegetal", 1.0f, 1.2f, 1.4f, 1.6f, 2f);

            ingredienteService.save(tomate);
            ingredienteService.save(pollo);
            ingredienteService.save(lechuga);
            ingredienteService.save(arroz);
            ingredienteService.save(salmon);
            ingredienteService.save(pepino);
            ingredienteService.save(frijoles);
            ingredienteService.save(aguacate);
            ingredienteService.save(queso);
            ingredienteService.save(maiz);
        }
    }

    private void seedBowls() {
        if (bowlService.findAll().length == 0) {
            Ingrediente[] ingredientes = ingredienteService.findAll();

            Bowl ensaladaPollo = new Bowl("Ensalada de Pollo", "Deliciosa ensalada con pollo");
            ensaladaPollo.getIngredientesAsociados().add(ingredientes[0]);
            ensaladaPollo.getIngredientesAsociados().add(ingredientes[1]);
            bowlService.save(ensaladaPollo);

            Bowl arrozSalmon = new Bowl("Arroz con Salmón", "Arroz con salmón al estilo asiático");
            arrozSalmon.getIngredientesAsociados().add(ingredientes[2]);
            arrozSalmon.getIngredientesAsociados().add(ingredientes[3]);
            bowlService.save(arrozSalmon);

            Bowl ensaladaVegana = new Bowl("Ensalada Vegana", "Ensalada fresca y nutritiva");
            ensaladaVegana.getIngredientesAsociados().add(ingredientes[4]);
            ensaladaVegana.getIngredientesAsociados().add(ingredientes[5]);
            bowlService.save(ensaladaVegana);
        }
    }

    private void seedMenus() {
        if (menuService.findAll().length == 0) {
            Bowl[] bowls = bowlService.findAll();

            Menu menuSaludable = new Menu("Menú Saludable", "Menú equilibrado para una alimentación saludable");
            menuSaludable.getBowlsAsociados().add(bowls[0]);
            menuService.save(menuSaludable);

            Menu menuGourmet = new Menu("Menú Gourmet", "Exquisitas combinaciones gourmet");
            menuGourmet.getBowlsAsociados().add(bowls[1]);
            menuGourmet.getBowlsAsociados().add(bowls[2]);
            menuService.save(menuGourmet);

        }
    }


}
