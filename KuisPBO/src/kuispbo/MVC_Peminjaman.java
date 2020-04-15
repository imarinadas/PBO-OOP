/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

public class MVC_Peminjaman {
    ViewPeminjaman viewPeminjaman = new ViewPeminjaman();
    ModelPerpus modelPerpus = new ModelPerpus();
    ControllerPeminjaman controllerPeminjaman = new ControllerPeminjaman(viewPeminjaman, modelPerpus);
}
