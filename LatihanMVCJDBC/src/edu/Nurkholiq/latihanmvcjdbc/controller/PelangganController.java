/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Nurkholiq.latihanmvcjdbc.controller;

import edu.Nurkholiq.latihanmvcjdbc.model.PelangganModel;
import edu.Nurkholiq.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Nurkholiq
 */
public class PelangganController {
    private PelangganModel model;
    
    
    public void setModel(PelangganModel model) {
        
        this.model = model;
    }
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan(); 
    }
    public void updatePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silahkan Pilih Baris Data Yang Akan DiUbah .");
            return;
        }
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong ..");
        } else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter ..");
        }else if (telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor Telepon Tidak Boleh Lebih Dari 12 Digit ..");
        }else if (!email.contains("@")){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid..");
        }else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();    
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil DiUbah..");
            } catch (Throwable z) {
                JOptionPane.showMessageDialog(view, "Terjadi Error Di DataBase Dengan Pesan "+ z.getMessage());
            }
        }
        
    } 
    
    public void insertPelanggan(PelangganView view){
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong ..");
        } else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter ..");
        }else if (telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor Telepon Tidak Boleh Lebih Dari 12 Digit ..");
        }else if (!email.contains("@")||!email.contains(".") ){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid..");
        }else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();    
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil DiTambahkan..");
            } catch (Throwable z) {
                JOptionPane.showMessageDialog(view, "Terjadi Error Di DataBase Dengan Pesan "+ z.getMessage());
            }
        }
    }
    public void deletePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silahkan Pilih Baris Data Yang Akan Di Hapus .");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Apakah Anda Yakin Akan Menghapus ini ? ")==JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();    
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil DiHapus..");
                model.resetPelanggan();
            } catch (Throwable z) {
                JOptionPane.showMessageDialog(view, "Terjadi Error Di DataBase Dengan Pesan "+ z.getMessage());
            }
            
            
        }
    }
}
