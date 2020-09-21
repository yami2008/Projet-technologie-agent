package projet_techno_agent;

import java.awt.*;
import java.applet.*;
import java.util.* ;

public class RuleAppletLogement extends Applet{
    
    //{{DECLARE_CONTROLS
    java.awt.Button button1;
    java.awt.Button button2;
    java.awt.Button button3;
    java.awt.TextArea textArea1;
    java.awt.TextArea textArea2;
    java.awt.Label label2;
    java.awt.Label label1;
    java.awt.Choice choice1;
    java.awt.Checkbox radioButton1;
    CheckboxGroup Group1;
    java.awt.Choice choice3;
    java.awt.Label label5;
    java.awt.Choice choice2;
    java.awt.TextArea textArea3;
    java.awt.Label label4;
    java.awt.Checkbox radioButton2;
    java.awt.TextField textField1;
    java.awt.Label label3;
    //}
    
    static Frame frame ;
    static RuleVarDialog dlg ;
    //....
    static RuleBase logement ;
    static RuleBase currentRuleBase ;
    
    void choice1_Clicked() {
        String rbName = choice1.getSelectedItem() ;
        if (rbName.equals("Logements")) currentRuleBase = logement ;
        currentRuleBase.reset() ;
        Enumeration vars = currentRuleBase.variableList.elements() ;
        while (vars.hasMoreElements()) {
            choice2.addItem(((RuleVariable)vars.nextElement()).name) ;
        }
        currentRuleBase.displayVariables(textArea3) ;
    }
    
    void choice2_Clicked(Event event) {
        String varName = choice2.getSelectedItem() ; 
        choice3.removeAll() ;
        RuleVariable rvar = (RuleVariable)currentRuleBase.variableList.get(varName);
        Enumeration labels = rvar.labels.elements();
        while (labels.hasMoreElements()) {
            choice3.addItem(((String)labels.nextElement())) ;
        }
    }
    
    void choice3_Clicked(Event event) {
        String varName = choice2.getSelectedItem() ;
        String varValue = choice3.getSelectedItem() ;
        RuleVariable rvar = (RuleVariable)currentRuleBase.variableList.get(varName);
        rvar.setValue(varValue) ;
        textArea3.appendText("\n"+ rvar.name + " set to "+ varValue) ;
    }
    
    void button1_Clicked(Event event) {
        String goal = textField1.getText() ;
        textArea2.appendText("\n --- Starting Inferencing Cycle --- \n");
        currentRuleBase.displayVariables(textArea2) ;
        if (radioButton1.getState() == true)
            currentRuleBase.forwardChain();
        if (radioButton2.getState() == true)
            currentRuleBase.backwardChain(goal);
        currentRuleBase.displayVariables(textArea2) ;
        textArea2.appendText("\n --- Ending Inferencing Cycle --- \n");
    }
    
    void button2_Clicked(Event event) {
        String rbName = choice1.getSelectedItem() ;
        if (rbName.equals("Logement")) {
            if (radioButton1.getState() == true)
                demoLogementFC(logement);
            if (radioButton2.getState() == true)
                demoLogementBC(logement);
        }
    }
    
    void button3_Clicked(Event event) {
        textArea1.setText("");
        textArea2.setText("");
        textArea3.setText("");
        currentRuleBase.reset() ;
        currentRuleBase.displayRules(textArea1);
        currentRuleBase.displayVariables(textArea3) ;
    }
    
    
    public void init() {
        super.init();
        setLayout(null);
        addNotify();
        resize(624,527);
        button1 = new java.awt.Button("Find Goal");
        button1.reshape(36,468,108,30);
        add(button1);
        button2 = new java.awt.Button("Run Demo");
        button2.reshape(228,468,108,30);
        add(button2);
        button3 = new java.awt.Button("Reset");
        button3.reshape(444,468,108,30);
        add(button3);
        textArea1 = new java.awt.TextArea();
        textArea1.reshape(12,48,312,144);
        add(textArea1);
        textArea2 = new java.awt.TextArea();
        textArea2.reshape(12,216,600,168);
        add(textArea2);
        label2 = new java.awt.Label("Trace Log");
        label2.reshape(24,192,168,24);
        add(label2);
        label1 = new java.awt.Label("Rule Base");
        label1.reshape(24,12,96,24);
        add(label1);
        choice1 = new java.awt.Choice();
        add(choice1);
        choice1.reshape(132,12,192,24);
        Group1 = new CheckboxGroup();
        radioButton1 = new java.awt.Checkbox("Forward Chain", Group1, false);
        radioButton1.reshape(36,396,156,21);
        add(radioButton1);
        choice3 = new java.awt.Choice();
        add(choice3);
        choice3.reshape(480,36,135,24);
        label5 = new java.awt.Label("Value");
        label5.reshape(480,12,95,24);
        add(label5);
        choice2 = new java.awt.Choice();
        add(choice2);
        choice2.reshape(336,36,137,24);
        textArea3 = new java.awt.TextArea();
        textArea3.reshape(336,72,276,122);
        add(textArea3);
        label4 = new java.awt.Label("Variable");
        label4.reshape(336,12,109,24);
        add(label4);
        radioButton2 = new java.awt.Checkbox("Backward Chain", Group1, false);
        radioButton2.reshape(36,420,156,24);
        add(radioButton2);
        textField1 = new java.awt.TextField();
        textField1.reshape(324,420,142,27);
        add(textField1);
        label3 = new java.awt.Label("Goal");
        label3.reshape(324,384,80,30);
        add(label3);
        
        // initialize the rule applet
        frame = new Frame("Ask User") ;
        frame.resize(50,50) ;
        frame.setLocation(100,100) ;
        choice1.addItem("Logement") ;
        
        logement = new RuleBase("Logements Rule Base" ) ;
        logement.setDisplay(textArea2) ;
        initLogementRuleBase(logement) ;
        currentRuleBase = logement ;
        
        currentRuleBase.displayRules(textArea1) ;
        currentRuleBase.displayVariables(textArea3) ;
        radioButton1.setState(true) ;
        choice1_Clicked() ;
    }
    
    public void initLogementRuleBase(RuleBase rb) {
        rb.goalClauseStack = new Stack() ;
        rb.variableList = new Hashtable() ;
        
        RuleVariable logement = new RuleVariable("Logement") ;
        logement.setLabels("appartement villa maison studio suite");
        logement.setPromptText("Quel est le type du logement que vous recherchez ?");
        rb.variableList.put(logement.name,logement) ;
        
        RuleVariable type_immobilier = new RuleVariable("Type_immobilier") ;
        type_immobilier.setLabels("vente location colocation") ;
        type_immobilier.setPromptText("Quel type de transactions voulez-vous ?") ;
        rb.variableList.put(type_immobilier.name, type_immobilier) ;
        
        RuleVariable nb_room = new RuleVariable("Nombre_de_chambres") ;
        nb_room.setLabels("1 2 3 4 5 10") ;
        nb_room.setPromptText("Combien de chambres voulez.vous ?") ;
        rb.variableList.put(nb_room.name,nb_room) ;
        
        RuleVariable garage = new RuleVariable("Garage") ;
        garage.setLabels("yes no") ;
        garage.setPromptText("Votre appartement contient-il un garage?") ;
        rb.variableList.put(garage.name,garage) ;
        
        // Note: at this point all variables values are NULL
        Condition cEquals = new Condition("=") ;
        Condition cNotEquals = new Condition("!=") ;
        
        Condition cLessThan = new Condition("<") ;
        Condition cMoreThan = new Condition(">") ;
        
        Condition cLessOrEquals = new Condition("<=") ;
        Condition cMoreOrEquals = new Condition(">=") ;
        
        // define rules
        rb.ruleList = new Vector() ;
        Rule VenteAppartement = new Rule ( 
            rb, 
            "vente_appartement",
            new Clause(logement,cEquals, "appartement") ,
            new Clause(type_immobilier,cEquals, "vente"),
            new Clause(nb_room, cMoreOrEquals, "3"),
            new Clause(garage, cEquals, "no")
        );
        Rule LocationAppartement = new Rule ( 
            rb, 
            "location_appartement",
            new Clause(logement,cEquals, "appartement") ,
            new Clause(type_immobilier,cEquals, "location"),
            new Clause(nb_room, cMoreOrEquals, "3"),
            new Clause(garage, cEquals, "no")
        );
        Rule ColocationAppartement = new Rule ( 
            rb, 
            "colocation_appartement",
            new Clause(logement,cEquals, "appartement") ,
            new Clause(type_immobilier,cEquals, "colocation"),
            new Clause(nb_room, cMoreOrEquals, "3"),
            new Clause(garage, cEquals, "no")
        );
        Rule VenteVilla = new Rule ( 
            rb, 
            "vente_villa",
            new Clause(logement,cEquals, "villa") ,
            new Clause(type_immobilier,cEquals, "vente"),
            new Clause(nb_room, cMoreOrEquals, "4"),
            new Clause(garage, cEquals, "yes")
        );
        Rule LocationVilla = new Rule ( 
            rb, 
            "location_villa",
            new Clause(logement,cEquals, "villa") ,
            new Clause(type_immobilier,cEquals, "location"),
            new Clause(nb_room, cMoreOrEquals, "4"),
            new Clause(garage, cEquals, "yes")
        );
        Rule ColocationVilla = new Rule ( 
            rb, 
            "colocation_villa",
            new Clause(logement,cEquals, "villa") ,
            new Clause(type_immobilier,cEquals, "colocation"),
            new Clause(nb_room, cMoreOrEquals, "4"),
            new Clause(garage, cEquals, "yes")
        );
        Rule VenteMaison = new Rule ( 
            rb, 
            "vente_maison",
            new Clause(logement,cEquals, "maison") ,
            new Clause(type_immobilier,cEquals, "vente"),
            new Clause(nb_room, cMoreOrEquals, "2")
        );
        Rule LocationMaison = new Rule ( 
            rb, 
            "location_maison",
            new Clause(logement,cEquals, "maison") ,
            new Clause(type_immobilier,cEquals, "loaction"),
            new Clause(nb_room, cMoreOrEquals, "2")
        );

        Rule ColocationMaison = new Rule ( 
            rb, 
            "colocation_maison",
            new Clause(logement,cEquals, "maison") ,
            new Clause(type_immobilier,cEquals, "colocation"),
            new Clause(nb_room, cMoreOrEquals, "2")
        ); 
        Rule VenteStudio = new Rule ( 
            rb, 
            "vente_studio",
            new Clause(logement,cEquals, "studio") ,
            new Clause(type_immobilier,cEquals, "vente"),
            new Clause(nb_room, cLessOrEquals, "2"),
            new Clause(garage, cEquals, "no")
        );
        Rule LocationStudio = new Rule ( 
            rb, 
            "location_studio",
            new Clause(logement,cEquals, "studio") ,
            new Clause(type_immobilier,cEquals, "location"),
            new Clause(nb_room, cLessOrEquals, "2"),
            new Clause(garage, cEquals, "no")
        );

        Rule ColocationStudio = new Rule ( 
            rb, 
            "colocation_studio",
            new Clause(logement,cEquals, "studio") ,
            new Clause(type_immobilier,cEquals, "colocation"),
            new Clause(nb_room, cLessOrEquals, "2"),
            new Clause(garage, cEquals, "no")
        );
        Rule VenteSuite = new Rule ( 
            rb, 
            "vente_suite",
            new Clause(logement,cEquals, "suite") ,
            new Clause(type_immobilier,cEquals, "vente"),
            new Clause(nb_room, cEquals, "1"),
            new Clause(garage, cEquals, "no")
        );
        Rule LocationSuite = new Rule ( 
            rb, 
            "location_suite",
            new Clause(logement,cEquals, "suite") ,
            new Clause(type_immobilier,cEquals, "location"),
            new Clause(nb_room, cEquals, "1"),
            new Clause(garage, cEquals, "no")
        );

        Rule ColocationSuite = new Rule ( 
            rb, 
            "colocation_suite",
            new Clause(logement,cEquals, "suite") ,
            new Clause(type_immobilier,cEquals, "colocation"),
            new Clause(nb_room, cEquals, "1"),
            new Clause(garage, cEquals, "no")
        );
    }
    
    public void demoLogementFC(RuleBase rb) {
        textArea2.appendText("\n --- Starting Demo ForwardChain ---\n ") ;
        ((RuleVariable)rb.variableList.get("Logement")).setValue("appartement") ;
        ((RuleVariable)rb.variableList.get("Type_immobilier")).setValue("vente") ;
        ((RuleVariable)rb.variableList.get("Nombre_de_chambres")).setValue("3") ;
        ((RuleVariable)rb.variableList.get("Garage")).setValue("no") ;
        rb.displayVariables(textArea2) ;
        rb.forwardChain();
        textArea2.appendText("\n --- Stopping Demo ForwardChain! ---\n") ;
        rb.displayVariables(textArea2);
    }
    
    public void demoLogementBC(RuleBase rb) {
        textArea2.appendText("\n --- Starting Demo BackwardChain ---\n ") ;
        ((RuleVariable)rb.variableList.get("Logement")).setValue("appartement") ;
        ((RuleVariable)rb.variableList.get("Type_immobilier")).setValue("vente") ;
        ((RuleVariable)rb.variableList.get("Nombre_de_chambres")).setValue("3") ;
        ((RuleVariable)rb.variableList.get("Garage")).setValue("no") ;
        rb.displayVariables(textArea2) ;
        rb.backwardChain("Logement") ; // chain until quiescence...
        textArea2.appendText("\n --- Stopping Demo BackwardChain! ---\n ") ;
        rb.displayVariables(textArea2) ;
    }
    public boolean handleEvent(Event event) {
        if (event.target == button1 && event.id == Event.ACTION_EVENT) {
            button1_Clicked(event);
            return true;
        }
        if (event.target == button2 && event.id == Event.ACTION_EVENT) {
            button2_Clicked(event);
            return true;
        }
        if (event.target == button3 && event.id == Event.ACTION_EVENT) {
            button3_Clicked(event);
            return true;
        }
        if (event.target == dlg && event.id == Event.ACTION_EVENT) {
            return dlg.handleEvent(event);
        }
        if (event.target == choice1 && event.id == Event.ACTION_EVENT) {
            choice1_Clicked();
            return true;
        }
        if (event.target == choice2 && event.id == Event.ACTION_EVENT) {
            choice2_Clicked(event);
            return true;
        }
        if (event.target == choice3 && event.id == Event.ACTION_EVENT) {
            choice3_Clicked(event);
            return true;
        }
        return super.handleEvent(event);
    }
     static public String waitForAnswer(String prompt, String labels) {
        Point p = frame.getLocation() ;
        dlg = new RuleVarDialog(frame, true) ;
        dlg.label1.setText(" "  + prompt + "\n (" + labels + ")");
        dlg.setLocation(400, 250) ;
        dlg.show() ;
        String ans = dlg.getText() ;
        return ans ;
    }
}
