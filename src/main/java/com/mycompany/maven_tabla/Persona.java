/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven_tabla;

/**
 *
 * @author valde
 */
public class Persona {
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    
    public Persona(String nombre, String apellido1, String apellido2, int edad){
    
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        
    }
    
    public Persona(){
    
        nombre = "Manolo";
        apellido1 = "García";
        apellido2 = "López";
        edad = 18;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String toString(){
        return "\n" + getNombre() + 
            "-" + getApellido1() + 
            "-" + getApellido2() + 
            "-" + String.valueOf(getEdad());
    }
    
    public Object getColumn(int columna){
        
        Object valor = "";
        
        switch(columna) {
            case 0:
              valor = getNombre();
              break;
            case 1:
              valor = getApellido1();
              break;
            case 2:
              valor = getApellido2();
              break;
            case 3:
              valor = getEdad();
              break;
            default:
          }
        
        return valor;
        
    }
    
}
