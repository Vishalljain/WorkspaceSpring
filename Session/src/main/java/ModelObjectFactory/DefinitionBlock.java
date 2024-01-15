/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

/**
 *
 * @author IXL1KOR
 */
public class DefinitionBlock {
    public IHistoryRowModelList getHistoryRowModelList(){
        return  new HistoryRowModelList();
    }
    
    public IVariantRowModelList getVariantRowModelList(){
        return  new VariantRowModelList();
    }
}
