
package modelo;

/**
 * @author Cortinez Juan José
 */
public class Modelo {
    
    public double porcentaje(double numA, double numB){
        return (numA*numB)/100;
    }
    
    public double raiz(double num){
        return Math.sqrt(num);
    }
    
    public double potencia(double numA, double numB){
        return Math.pow(numA, numB);
    }
    
    public double suma(double numA, double numB){
        return numA+numB;
    }
    
    public double resta(double numA, double numB){
        return numA-numB;
    }
    
    public double multiplicacion(double numA, double numB){
        return numA*numB;
    }
    
    public double division(double numA, double numB){
        return numA/numB;
    }
    public double negativo(double numA){
        return -numA;
    }
    
    
    public boolean validarDouble(String a){
        try{
            Double.parseDouble(a);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    public boolean validarCero(String a){ 
        return Double.parseDouble(a) != 0;
    }
    
   public boolean validarNegativo(String a){
        return Double.parseDouble(a) >= 0;
    }

}
