/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Nurkholiq.latihanmvcjdbc.main;

import edu.Nurkholiq.latihanmvcjdbc.entity.Pelanggan;
import edu.Nurkholiq.latihanmvcjdbc.error.PelangganException;
import edu.Nurkholiq.latihanmvcjdbc.service.PelangganDAO;
import edu.Nurkholiq.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Muhammad Nurkholiq
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws edu.Nurkholiq.latihanmvcjdbc.error.PelangganException
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
                }
}