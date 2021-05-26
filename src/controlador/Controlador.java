
package controlador;

/**
 * @author Cortinez Juan José
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener{
    
    public Modelo m1;
    public Vista v1;
    private String valorA = "";
    private String valorB = "";
    private int operacion = 0;
    
    public Controlador(Modelo m1, Vista v1) {
        this.m1 = m1;
        this.v1 = v1;
        
        v1.setVisible(true);
        
        v1.jB0.addActionListener(this);
        v1.jB1.addActionListener(this);
        v1.jB2.addActionListener(this);
        v1.jB3.addActionListener(this);
        v1.jB4.addActionListener(this);
        v1.jB5.addActionListener(this);
        v1.jB6.addActionListener(this);
        v1.jB7.addActionListener(this);
        v1.jB8.addActionListener(this);
        v1.jB9.addActionListener(this);
        v1.jBpunto.addActionListener(this);
        v1.jBigual.addActionListener(this);
        v1.jBsuma.addActionListener(this);
        v1.jBresta.addActionListener(this);
        v1.jBmultiplicacion.addActionListener(this);
        v1.jBdivision.addActionListener(this);
        v1.jBpotencia.addActionListener(this);
        v1.jBraiz.addActionListener(this);
        v1.jBporcentaje.addActionListener(this);
        v1.jBreset.addActionListener(this);
        v1.jRon.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(v1.jRon.isSelected()==true){
            if(ae.getSource().equals(v1.jB0)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB1)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB2)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB3)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB4)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB5)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB6)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB7)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB8)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jB9)){
                v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jBpunto)){
                if(decimal(terminoCorrespondiente()))
                    v1.jTF1.setText(concatenar(ae.getActionCommand(), terminoCorrespondiente()));
            }else if(ae.getSource().equals(v1.jBsuma)){
                operacion = 1;
            }else if(ae.getSource().equals(v1.jBresta)){
                operacion = 2;
            }else if(ae.getSource().equals(v1.jBmultiplicacion)){
                operacion = 3;
            }else if(ae.getSource().equals(v1.jBdivision)){
                operacion = 4;
            }else if(ae.getSource().equals(v1.jBpotencia)){
                operacion = 5;
            }else if(ae.getSource().equals(v1.jBraiz)){
                operacion = 6;
                v1.jTF1.setText(realizarOperacion(valorA, operacion, valorB));
            }else if(ae.getSource().equals(v1.jBporcentaje)){
                operacion = 7;
                
            }else if(ae.getSource().equals(v1.jBigual)){
                v1.jTF1.setText(realizarOperacion(valorA, operacion, valorB));
            }else if(ae.getSource().equals(v1.jBreset)){
                resetAll();
            }
        }else {
            
            v1.jTF1.setText("");
            
        }
    }
    
    public String concatenar(String con, Boolean term){
        if(term){
            this.valorA = this.valorA + con;
            return valorA;
        }else{
            this.valorB = this.valorB + con;
            return valorB;
        }
    }
    
    public boolean terminoCorrespondiente(){
        return operacion == 0;
    }
    
    public String realizarOperacion(String numA, int op, String numB){
        switch (op) {
            case 1:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                   resetVar(); 
                   return String.valueOf(m1.suma(Double.parseDouble(numA), Double.parseDouble(numB)));
                }
                return "Falta ingresar un término.";
            case 2:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                    resetVar();
                    return String.valueOf(m1.resta(Double.parseDouble(numA), Double.parseDouble(numB)));
                }
                return "Falta ingresar un término.";
            case 3:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                    resetVar();
                    return String.valueOf(m1.multiplicacion(Double.parseDouble(numA), Double.parseDouble(numB))); 
                }
                return "Falta ingresar un término.";
            case 4:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                    if(m1.validarCero(numB)){
                        resetVar();
                        return String.valueOf(m1.division(Double.parseDouble(numA), Double.parseDouble(numB)));
                    }else{
                        resetAll();
                        JOptionPane.showMessageDialog(v1, "No se dividir por cero.");
                        return " ";
                    } 
                }
                return "Falta ingresar un término.";
            case 5:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                    resetVar();
                    return String.valueOf(m1.potencia(Double.parseDouble(numA), Double.parseDouble(numB)));
                }
                return "Falta ingresar un término.";
            case 6:
                if(m1.validarDouble(numA)){
                    if(m1.validarNegativo(numA)){
                        resetVar();
                        return String.valueOf(m1.raiz(Double.parseDouble(numA)));
                    }else{
                        resetAll();
                        JOptionPane.showMessageDialog(v1, "No se puede calcular la raiz de un número negativo (En números reales).");
                        return " ";
                    } 
                }
                return "Falta ingresar un término.";
            case 7:
                if(m1.validarDouble(numA)&&m1.validarDouble(numB)){
                    resetVar();
                    return String.valueOf(m1.porcentaje(Double.parseDouble(numA), Double.parseDouble(numB)));
                }
                return "Falta ingresar un término.";
            default:
                break;
        }
        return "Operación No válida.";
    }
    
    public void resetAll(){
        valorA = "";
        valorB = "";
        operacion = 0;
        v1.jTF1.setText("0.00");
    }
    
    public void resetVar(){
        valorA = "";
        valorB = "";
        operacion = 0;
    }
    
    public String negar(Boolean term){
        if(term){
            this.valorA = String.valueOf(m1.negativo(Double.parseDouble(this.valorA)));
            return this.valorA;
        }else{
            this.valorB = String.valueOf(m1.negativo(Double.parseDouble(this.valorB)));
            return this.valorB;
        }
    }
    
    public boolean decimal(Boolean term){
        if(term){
            return !this.valorA.contains(".");
        }else{
            return !this.valorB.contains(".");
        }
    }

}
