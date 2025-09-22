package com.myproject;

public class NameFilter implements Runnable{

    private String[] names;
    //ArrayList<String> names = new ArrayList<>();

    public NameFilter(String[] names){
        this.names = names;
    }

    @Override
    public void run(){

        // // think of this like for each name in names
        // for (String name : names) {
        //     if (name.length() > 3) {
        //         String processed = name.toUpperCase();
        //         System.out.println(processed);
        //     }
        // }

        // names.length for array, length() for string length, size() for arraylist
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 3) {
                String processed = names[i].toUpperCase();
                System.out.println(processed);
            }
        }

        
    }
    public static void main(String[] args) {
        String names[] = {"Tom", "Jerry", "Amy", "Christopher", "Max", "John"};

        NameFilter filter = new NameFilter(names);
        Thread thread = new Thread(filter);

        thread.start();
    }
}