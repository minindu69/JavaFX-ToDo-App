package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AddToDoController {

    @FXML
    private JFXListCell listCell;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXListView<CheckBox> todoListView;

    @FXML
    private TextField txtToDo;

    ObservableList<String> todos = FXCollections.observableArrayList();
    ArrayList<String> todolist = new ArrayList<>();

    //add todos
    private void addToDo(String todo){
        if (!todo.isEmpty()){
            JFXCheckBox checkBox = new JFXCheckBox(todo);

            checkBox.setOnAction(e->{
                if (checkBox.isSelected()){
                    //add arrary
                    todolist.add(checkBox.getText());
                }else{
                    //remove from array
                    todolist.remove(checkBox.getText());
                }
            });

            todoListView.getItems().add(checkBox);

        }

        //print all completed todos
        for (String e : todolist) {
            System.out.println(e);
        }

    }

    public void addBtnOnAction(ActionEvent actionEvent) {
        addToDo(txtToDo.getText());
        txtToDo.clear();
    }


}

