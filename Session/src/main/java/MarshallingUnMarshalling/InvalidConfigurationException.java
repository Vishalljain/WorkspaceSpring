/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarshallingUnMarshalling;

/**
 *
 * @author IXL1KOR
 */
public class InvalidConfigurationException extends Exception {

 
  public InvalidConfigurationException(final String message) {
      super("Invalid Configuration Error - " + message);
  }
    
}
