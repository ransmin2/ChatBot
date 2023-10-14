package com.example.demo.model;

public class Chat {

    public Chat(String input, String output) {
        this.input = input;
        this.output = output;
    }


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    private String input;
        private String output;


    public Chat() {
    }
}
