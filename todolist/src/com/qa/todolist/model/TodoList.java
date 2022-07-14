package com.qa.todolist.model;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<Todo> todoItems = new ArrayList<>();
    private Long idCounter = (long) 1;

    public boolean add(Todo todo) {
        for (int i = 0; i < todoItems.size(); i++) {
            Todo current = todoItems.get(i); // get the current todo item in todoItems
            if (todo.getId() == current.getId()) {
                // rule of thumb for equality only use == for primitive types, and the .equals()
                // method for all reference types
                return false;
            } else if (todo.getName().equals(current.getName())) {
                // all reference types have a .equals() method on them
                // - this should be used for comparing them
                // - == compares the value in the variable, which with reference types is the
                // reference rather than the object itself
                return false;
            }
        }
        // if we get all the way through the loop the todo mustn't exist
        todo.setId(idCounter++);
        todoItems.add(todo);
        return true;
    }

}
