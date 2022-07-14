package com.qa.todolist;

import java.time.LocalDate;
import java.util.Scanner;

import com.qa.todolist.model.Todo;
import com.qa.todolist.model.TodoList;

public class TodoListApplication {
    private TodoList todoList;

    public void run() {
        // Todo list application starts here
        todoList = new TodoList();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        // setup REPL
        // read, eval, print, loop
        // 1. read in an instruction
        // 2. evaluate the instruction
        // 3. print the result
        // 4. repeat steps 1 -3
        do {
            System.out.println("=== TodoList Application Menu ===\n");
            System.out.println("(1) Add a new todo item");
            System.out.println("(2) Exit");

            // get input
            System.out.println("> ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    // get info for the todo item
                    System.out.println("Name: ");
                    String todoName = sc.nextLine();
                    System.out.println("Due (yyyy/mm/dd): ");
                    String date = sc.nextLine();

                    // add the todo item to the list
                    Todo todo = new Todo();
                    todo.setName(todoName);
                    todo.setDueDate(LocalDate.parse(date));
                    boolean didAdd = todoList.add(todo);

                    // confirm if this occurred or not to the user
                    if (didAdd)
                        System.out.println("New todo item added success");
                    else
                        System.out.println("new todo item could not be added, does it already exist?");

                    break;
                case "2":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nPlease enter a valid option! \n");
            }
        } while (isRunning == true);
    }
}
