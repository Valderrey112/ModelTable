/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven_tabla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valde
 */
public class ManejoDeDatos{
    
    boolean vaciado = false;
    
    public ArrayList<Persona> filePersonasToArrayList(File archivo){
    
        ArrayList<Persona> personas = new ArrayList();
        try{
            File file = archivo;
            BufferedReader br=new BufferedReader(new FileReader(file));
            
            String line;
            while((line = br.readLine()) != null){
                String[ ]persona=line.split("-");
                Persona p = new Persona(persona[0],persona[1],persona[2],Integer.valueOf(persona[3]));
                personas.add(p);
            }
            br.close();
        }catch(IOException e){
            System.err.println("Error: Target File Cannot Be Read");
        }
        
        return personas;
        
    }
    
    public boolean compararPersonas(Persona personaAComparar, Persona personaABuscar){
    
        boolean iguales= false;
        
        if((personaAComparar.getNombre().equals(personaABuscar.getNombre()) | personaABuscar.getNombre().equals("*")) & 
        (personaAComparar.getApellido1().equals(personaABuscar.getApellido1()) | personaABuscar.getApellido1().equals("*")) & 
        (personaAComparar.getApellido2().equals(personaABuscar.getApellido2()) | personaABuscar.getApellido2().equals("*")) & 
        (String.valueOf(personaAComparar.getEdad()).equals(String.valueOf(personaABuscar.getEdad())) | personaABuscar.getEdad() == 0)){
            iguales = true;
        }
        
        return iguales;
    
    }
    
    public void deletePerson(Persona personaABorrar, File archivo){
    
        File temporal = new File("temporal.txt");
        
        try{
            File file = archivo;
            BufferedReader br=new BufferedReader(new FileReader(file));
            FileWriter fileWriter = new FileWriter(temporal, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            
            vaciado = true;
            
                String line;
                while((line = br.readLine()) != null){
                    String[ ]persona=line.split("-");
                    Persona p = new Persona(persona[0],persona[1],persona[2],Integer.valueOf(persona[3]));
                    if(!compararPersonas(p, personaABorrar)){
                        if(vaciado){
                            bw.write("");
                            vaciado = false;
                            String primeraPersona = p.toString();
                            primeraPersona = primeraPersona.substring(1, primeraPersona.length());
                            bw.write(primeraPersona);
                        }else{
                            bw.write(p. toString());
                        }
                    }
                }
            
            bw.close();
            br.close();
            
            archivo.delete();
            temporal.renameTo(archivo);
            
        }catch(IOException e){
            System.err.println("Error: Target File Cannot Be Read");
        }
        
        comprobarSiArchivoVacio(archivo);
        
    }
    
    public void addPerson(Persona persona, File archivo){
    
        
        try{
            
            File file = archivo;
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            comprobarSiArchivoVacio(archivo);
            if(vaciado){
                bw.write("");
                vaciado = false;
                String primeraPersona = persona.toString();
                primeraPersona = primeraPersona.substring(1, primeraPersona.length());
                bw.write(primeraPersona);
            }else{
                bw.write(persona.toString());
            }
            bw.close();
            fileWriter.close();
            
        }catch(IOException e){
            System.err.println("Error: Target File Cannot Be Read");
        }
        
    }
    
    public void vaciarArchivo(File archivo) throws IOException{
    
        Persona persona = new Persona("*", "*", "*", 0);
        
        deletePerson(persona, archivo);
        
    }
    
    public boolean comprobarSiArchivoVacio(File archivo){
    
        try {
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String line;
            if((line = br.readLine()) == null){
                vaciado = true;
                br.close();
            }
            else{
                vaciado = false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return vaciado;
    }
    
}
