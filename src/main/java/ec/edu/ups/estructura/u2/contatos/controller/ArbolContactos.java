/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.estructura.u2.contatos.controller;

import ec.edu.ups.estructura.u2.contatos.modelo.Contacto;
import ec.edu.ups.estructura.u2.contatos.modelo.Node;

/**
 *
 * @author aroon
 */
public class ArbolContactos {
    private Node raiz;

    public ArbolContactos() {
        this.raiz=null;
    }
    public void insert(Contacto newContacto){
        if(raiz== null){
            raiz= new Node (newContacto);
            System.out.println("");
        }else{
            insertRecursivo(raiz, newContacto);
        }
    }
    private void insertRecursivo(Node node, Contacto newContacto){
        if(newContacto.getNombre().compareTo(node.getContacto().getNombre())<0){
            if(node.getLeft()==null){
                node.setLeft(new Node(newContacto));
            }else{
                insertRecursivo(node.getLeft(), newContacto);
            }
        }else if(newContacto.getNombre().compareTo(node.getContacto().getNombre())>0){
             if(node.getRight()==null){
                node.setRight(new Node(newContacto));
            }else{
                insertRecursivo(node.getRight(), newContacto);
            }
        }else{
            //Si el nombre del contacto nuevo es igual a uno existente puede actulizar o no 
        }
    }
    public boolean estadoEquilibrado(){
        return verificarBalance(raiz);
    }
    //Equilibrido del arbol si esta desiquilibrado
    private boolean verificarBalance(Node node){
        if(node == null){
            return true; //Arbol se concidera equilibrado
        }
        int alturaIzquierda = obtenerAltura(node.getLeft());
        int alturaDerecha =obtenerAltura(node.getRight());
        int diferencia = Math.abs(alturaIzquierda- alturaDerecha);
        // verificar la diferencia de altura
        if(diferencia >1){
            return false;
        }
        return verificarBalance(node.getLeft())&& verificarBalance(node.getRight());
    }
    
    private int obtenerAltura(Node node){
        if(node== null){
            return 0;
        }
        // llama al metodo para ver su altura
        int alturaIzquierda = obtenerAltura(node.getLeft());
        int alturaDerecha =obtenerAltura(node.getRight());
        return Math.max(alturaIzquierda, alturaDerecha)+1;
    }
}
