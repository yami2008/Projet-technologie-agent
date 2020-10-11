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

public class AgentAnnexeAcer extends Agent{
    
    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("hhhhhhhhhhhhhhhhh");
                ACLMessage msg = receive();
                if (msg != null){
                    String path = "laptops/acer.txt";
                    File file = new File(path);
                    ArrayList<Laptop> result = new ArrayList<>();
                    String[] data = null ;
                    String marque = null ;
                    String processeur = null ;
                    String ram = null ;
                    String dd = null ;
                    String ecran = null ;
                    String prix = null ;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line = br.readLine().trim();
                        Object[] tabLine = br.lines().toArray();
                        for (int i = 0 ; i < tabLine.length ; i++){
                            line = tabLine[i].toString().trim();
                            
                            data = line.split(",");
                            marque = data[0].trim();
                            processeur = data[1].trim();
                            ram = data[2].trim() ;
                            dd = data[3].trim() ;
                            ecran = data[4].trim() ;
                            prix = data[5].trim() ;
                            
                            System.out.println(marque + processeur + ram + dd + ecran + prix);
                            
                            String[] message = msg.getContent().split(",");
                            String marque_choosen = message[0].trim();
                            String processeur_choosen = message[1].trim();
                            String ram_choosen = message[2].trim();
                            String dd_choosen = message[3].trim();
                            String ecran_choosen = message[4].trim() ;
                            int prixMin_choosen = Integer.parseInt(message[5]);
                            int prixMax_choosen = Integer.parseInt(message[6]);
                            
                            System.out.println(marque_choosen + processeur_choosen + ram_choosen 
                                    + dd_choosen + ecran_choosen + prixMin_choosen + prixMax_choosen);
                            
                            
                            if (marque.equals(marque_choosen) && processeur.equals(processeur_choosen)
                                    && ram.equals(ram_choosen) && dd.equals(dd_choosen) && ecran.equals(ecran_choosen)
                                    && Integer.parseInt(prix) <= prixMax_choosen 
                                    && Integer.parseInt(prix) >= prixMin_choosen){
                                result.add(new Laptop(marque, processeur, ram, dd, ecran, Integer.parseInt(prix))) ;
                            }
                        }
                        System.out.println(result.size());
                        if (result.size() != 0){
                            DefaultTableModel model = (DefaultTableModel) Acheteur.jTable2.getModel() ;
                            for (int i = 0 ; i < result.size() ; i++){
                                model.addRow(new String[]{
                                    result.get(i).marqueDuPC , 
                                    result.get(i).processeur ,
                                    result.get(i).RAM ,
                                    result.get(i).disqueDur ,
                                    result.get(i).ecran ,
                                    String.valueOf(result.get(i).prix)
                                });
                            }
                        
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                    "Aucun Laptop correspendant à vos critères a été trouvé");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AgentPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AgentAnnexeHP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    block();
                }
            }
        });
    }
}