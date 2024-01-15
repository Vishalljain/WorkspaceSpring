/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

/**
 *
 * @author IXL1KOR
 */
public class Main {
    public static void main(String[] args) {
       ModelObjectFactory modelObjectFactoryWrapper = ModelObjectFactoryWrapper.getInstance().getModelObjectFactory();
       IHistoryRowModelList historyRowModelList = modelObjectFactoryWrapper.getDefinitionBlock().getHistoryRowModelList();
       IVariantRowModelList variantRowModelList = modelObjectFactoryWrapper.getDefinitionBlock().getVariantRowModelList();
        historyRowModelList.addHistoryRow("data");
        variantRowModelList.addVariantRow("variant");
       
    }
    
}
