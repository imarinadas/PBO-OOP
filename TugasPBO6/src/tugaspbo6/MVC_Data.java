/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */

package tugaspbo6;

public class MVC_Data {
    ViewData viewData = new ViewData();
    ModelData modelData = new ModelData();
    ControllerData controllerData = new ControllerData(viewData, modelData);
}
