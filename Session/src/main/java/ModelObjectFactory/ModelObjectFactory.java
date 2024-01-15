/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

/**
 *
 * @author IXL1KOR
 */
public class ModelObjectFactory {
    
    private static ModelObjectFactory instance;
    
    private  ModelObjectFactory(){
        
    }
    
    public static synchronized ModelObjectFactory getInstance(){
        if(instance == null){
            instance = new ModelObjectFactory();
        }
        return instance;
        
    }
    
    public DefinitionBlock getDefinitionBlock(){
        return new DefinitionBlock();
    }
}
