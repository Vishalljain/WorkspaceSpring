/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

// TestBlock class
class TestBlock {
    private ModelObjFactory parentFactory;
    private ComponentA ca;
    int b =20;
    // Constructor taking ModelObjFactory instance as a parameter
    public TestBlock(ModelObjFactory parentFactory) {
        this.parentFactory = parentFactory;
        ca=parentFactory.getComponentA();
        
    }

    // Method to display information
    public void displayInfo() {
      ca.displayInfo();
    }
}

// DefinitionBlock class
class DefinitionBlock {
    private ModelObjFactory parentFactory;

    // Constructor taking ModelObjFactory instance as a parameter
    public DefinitionBlock(ModelObjFactory parentFactory) {
        this.parentFactory = parentFactory;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("DefinitionBlock is associated with ModelObjFactory instance: " + parentFactory);
    }
}

// ComponentA class
class ComponentA {
    private TestBlock testBlock1;
    private ModelObjFactory parentFactory;

    // Constructor taking ModelObjFactory instance as a parameter
    public ComponentA(ModelObjFactory parentFactory) {
        this.parentFactory = parentFactory;
        testBlock1 = parentFactory.getTestBlock();
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("ComponentA is associated with ModelObjFactory instance: " + parentFactory);
    }
}

// ComponentB class
class ComponentB {
    private ModelObjFactory parentFactory;

    // Constructor taking ModelObjFactory instance as a parameter
    public ComponentB(ModelObjFactory parentFactory) {
        this.parentFactory = parentFactory;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("ComponentB is associated with ModelObjFactory instance: " + parentFactory);
    }
}

// ModelObjFactory class
public class ModelObjFactory {
    private TestBlock testBlock;

    public TestBlock getTestBlock() {
        return testBlock;
    }

    public DefinitionBlock getDefinitionBlock() {
        return definitionBlock;
    }

    public ComponentA getComponentA() {
        return componentA;
    }

    public ComponentB getComponentB() {
        return componentB;
    }
    private DefinitionBlock definitionBlock;
    private ComponentA componentA;
    private ComponentB componentB;
    
    int a =5;

    // Constructor
    public ModelObjFactory() {
        // Create instances of components using "this"
        setTestBlock(new TestBlock(this));
        setDefinitionBlock(new DefinitionBlock(this));
        setComponentA(new ComponentA(this));
        setComponentB(new ComponentB(this));
    }

    // Setter methods for components
    public final void setTestBlock(TestBlock testBlock) {
        this.testBlock = testBlock;
    }

    public void setDefinitionBlock(DefinitionBlock definitionBlock) {
        this.definitionBlock = definitionBlock;
    }

    public void setComponentA(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    // Method to display information for each component
    public void displayInfo() {
        System.out.println("ModelObjFactory instance: " + this);
        testBlock.displayInfo();
        definitionBlock.displayInfo();
        componentA.displayInfo();
        componentB.displayInfo();
    }

    public static void main(String[] args) {
        // Create an instance of ModelObjFactory
        ModelObjFactory factory = new ModelObjFactory();
        
        factory.testBlock.displayInfo();
        // Display information for each component
        factory.displayInfo();
    }
}

