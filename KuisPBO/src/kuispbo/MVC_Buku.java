/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

public class MVC_Buku {
     ViewBuku viewBuku = new ViewBuku();
     ModelPerpus modelPerpus = new ModelPerpus();
     ControllerBuku controllerBuku = new ControllerBuku(viewBuku, modelPerpus);
}
