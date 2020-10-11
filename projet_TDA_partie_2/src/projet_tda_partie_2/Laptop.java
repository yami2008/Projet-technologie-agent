/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tda_partie_2;

import jade.core.Agent ;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azur Computer
 */
public class Laptop {
    
    String marqueDuPC ;
    String processeur ;
    String RAM ;
    String disqueDur ;
    String ecran ;
    int prix ;

    public Laptop(String marqueDuPC, String processeur, String RAM, String disqueDur, String ecran, int prix) {
        this.marqueDuPC = marqueDuPC;
        this.processeur = processeur;
        this.RAM = RAM;
        this.disqueDur = disqueDur;
        this.ecran = ecran;
        this.prix = prix;
    }
    
    public static void read(String file){
        
    }
    
    
}
