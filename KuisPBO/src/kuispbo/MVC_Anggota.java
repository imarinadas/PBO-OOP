/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

public class MVC_Anggota {
        ViewAnggota viewAnggota = new ViewAnggota();
        ModelPerpus modelPerpus = new ModelPerpus();
        ControllerAnggota controllerAnggota = new ControllerAnggota(viewAnggota, modelPerpus);
}
