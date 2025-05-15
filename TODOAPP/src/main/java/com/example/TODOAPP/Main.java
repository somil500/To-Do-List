package com.example.TODOAPP;
import  com.example.TODOAPP.Task;
public class Main
{
    public static void main(String[]args){
        System.out.println("Hello ,how are you , your welcome to in this lombok class");

        Task task=new Task();
       task.toString();
        System.out.println(task.getId());
    }
}
