/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java8test;

/**
 *
 * @author slozic
 */
@FunctionalInterface
public interface TestInterface {
    void printMessage(Object message);
    default void test(){
        
    }
}
