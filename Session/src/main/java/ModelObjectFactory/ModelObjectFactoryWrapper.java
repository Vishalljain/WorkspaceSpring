/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

/**
 *
 * @author IXL1KOR
 */
public class ModelObjectFactoryWrapper {
        private static final ModelObjectFactoryWrapper instance = new ModelObjectFactoryWrapper();
        
        private ModelObjectFactoryWrapper() {
        // Initialization logic if needed
    }

    // Method to get the singleton instance of ModelObjFactory
    public static ModelObjectFactoryWrapper getInstance() {
        return instance;
    }
    
    public ModelObjectFactory getModelObjectFactory(){
       return ModelObjectFactory.getInstance();
    }
}
