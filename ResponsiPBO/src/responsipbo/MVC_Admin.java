/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

public class MVC_Admin {
    ViewAdmin viewAdmin = new ViewAdmin();
    ModelResponsi modelResponsi = new ModelResponsi();
    ControllerAdmin controllerAdmin = new ControllerAdmin(viewAdmin, modelResponsi);
}
