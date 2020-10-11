package projet_tda_partie_2;

import jade.core.AID;
import jade.core.Agent ;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage ;


public class AgentPrincipal extends Agent {
    
    @Override
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() { 
                String marque = (String) Acheteur.marque.getSelectedItem();   
                String processeur = (String) Acheteur.processeur.getSelectedItem();
                String ram = (String) Acheteur.ram.getSelectedItem();
                String dd = (String) Acheteur.disque_dur.getSelectedItem();
                String ecran = (String) Acheteur.ecran.getSelectedItem();
                String prixMin = (String) Acheteur.prix_min.getSelectedItem();
                String prixMax = (String) Acheteur.prix_max.getSelectedItem();
                String requete = marque+","+processeur+","+ram+","+dd+","+ecran+","+prixMin+","+prixMax;
                System.out.println(requete);
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM) ;
                msg.setContent(requete);
                msg.addReceiver(new AID("annexe", AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
}
