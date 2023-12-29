package com.AluraHotel.pruebas;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Prueba1 {

    // Declarar una instancia de PropertyChangeSupport
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        // Notificar a los escuchadores antes de cambiar la propiedad
        String antiguoNombre = this.nombre;
        this.nombre = nuevoNombre;
        propertyChangeSupport.firePropertyChange("nombre", antiguoNombre, nuevoNombre);
    }

    // Método para agregar un PropertyChangeListener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // Método para quitar un PropertyChangeListener
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
//
//public class EjemploPropertyChangeListener {
//    public static void main(String[] args) {
//        MiBean miBean = new MiBean();
//
//        // Crear un PropertyChangeListener e implementar el método propertyChange
//        PropertyChangeListener listener = new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                System.out.println("La propiedad '" + evt.getPropertyName() + "' ha cambiado. Nuevo valor: " + evt.getNewValue());
//            }
//        };
//
//        // Agregar el PropertyChangeListener al objeto MiBean
//        miBean.addPropertyChangeListener(listener);
//
//        // Cambiar el valor de la propiedad, lo que debería notificar al PropertyChangeListener
//        miBean.setNombre("NuevoNombre");
//    }


