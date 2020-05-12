/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

public class MVC_Pegawai {
    ViewPegawai viewPegawai = new ViewPegawai();
    ModelResponsi modelResponsi = new ModelResponsi();
    ControllerPegawai controllerPegawai = new ControllerPegawai(viewPegawai, modelResponsi);
}
