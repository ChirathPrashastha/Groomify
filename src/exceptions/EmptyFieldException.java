/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author Chirath
 */
public class EmptyFieldException extends Exception{
    public EmptyFieldException(){
        super("Please fill all the fields!");
    }
}
