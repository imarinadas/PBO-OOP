/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

public class MVC_Karyawan {
    ViewKaryawan viewKaryawan = new ViewKaryawan();
    ModelPerpus modelPerpus = new ModelPerpus();
    ControllerKaryawan controllerKaryawan = new ControllerKaryawan(viewKaryawan, modelPerpus);
}
