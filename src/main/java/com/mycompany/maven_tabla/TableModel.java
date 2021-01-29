/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven_tabla;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author valde
 */
public class TableModel extends AbstractTableModel{
    
    ArrayList<Persona> personas;
    
    public TableModel(File archivo){
        
        ManejoDeDatos a = new ManejoDeDatos();
        personas = a.filePersonasToArrayList(archivo);
        
    }
    
    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return personas.get(rowIndex).getColumn(columnIndex);
    }
    
}
