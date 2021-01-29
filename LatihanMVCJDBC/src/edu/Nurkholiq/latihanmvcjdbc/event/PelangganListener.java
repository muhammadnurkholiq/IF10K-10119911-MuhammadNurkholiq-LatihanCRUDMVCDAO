/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Nurkholiq.latihanmvcjdbc.event;

import edu.Nurkholiq.latihanmvcjdbc.entity.Pelanggan;
import edu.Nurkholiq.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Muhammad Nurkholiq
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onUpdate(Pelanggan pelanggan);
    public void onDelete();
    public void onInsert(Pelanggan pelanggan);
    
}
