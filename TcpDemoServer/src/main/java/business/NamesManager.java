/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author juanf
 */
public class NamesManager {
    
    public String generateMessage(String name, String lastName){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
            .append(" Last Name: ").append(lastName);
        return sb.toString();
    }
}
