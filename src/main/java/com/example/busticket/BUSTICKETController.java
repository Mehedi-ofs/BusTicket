package com.example.busticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.print.attribute.standard.MediaSize;
import java.util.Objects;

public class BUSTICKETController
{
    @javafx.fxml.FXML
    private ComboBox<String> fromCB;
    @javafx.fxml.FXML
    private TextField uidTF;
    @javafx.fxml.FXML
    private TextField expTF;
    @javafx.fxml.FXML
    private ComboBox<String> toCB;
    @javafx.fxml.FXML
    private ComboBox<String> vipCB;
    @javafx.fxml.FXML
    private TextField seatTF;
    @javafx.fxml.FXML
    private ComboBox<String> GenderCB;
    @javafx.fxml.FXML
    private ComboBox<String> pGenderCB;
    @javafx.fxml.FXML
    private TextField customerTF;
    @javafx.fxml.FXML
    private TextField IssueDateTF;
    @javafx.fxml.FXML
    private TextField PhoneNumberTF;
    @javafx.fxml.FXML
    private TextField EmailTF;
    @javafx.fxml.FXML
    private Label outputTF;
    @javafx.fxml.FXML
    private TextField statusTF;
    @javafx.fxml.FXML
    private Button creatButtonOnClick;
    @javafx.fxml.FXML
    private Button infoClearOA;
    @javafx.fxml.FXML
    public void initialize() {
        GenderCB.getItems().addAll("Male", "Female","Others");
        GenderCB.setValue("--select--");
        pGenderCB.getItems().addAll("Male", "Female","Others","Any");
        pGenderCB.setValue("--select--");
        fromCB.getItems().addAll("Dhaka", "Rajshahi","Rongpur","Sylhet","chattagram","Borishal","khulna","Cumilla");
        fromCB.setValue("--select--");
        toCB.getItems().addAll("Dhaka", "Rajshahi","Rongpur","Sylhet","chattagram","Borishal","khulna","Cumilla");
        toCB.setValue("--select--");
        vipCB.getItems().addAll("YEs", "NO");
        vipCB.setValue("--select--");

    }
    @javafx.fxml.FXML
    private void createButtonOnClick() {
        String name ,pn,email,gender,preG,from,to,vip,seat_no;
        String validationtext="";

        boolean isvalid = true;


        name =  customerTF.getText();
        if(name.isEmpty()){
            isvalid = false;
            validationtext = "Customer Invalid";
        }
        pn =PhoneNumberTF.getText();
        if(pn.length()!=11){
            isvalid = false;
            validationtext = "Phone Number Invalid";
        }
        email = EmailTF.getText();
        gender = GenderCB.getValue();
        preG  = pGenderCB.getValue();
        from = fromCB.getValue();
        to = toCB.getValue();
        if(Objects.equals(from,to)){
            isvalid = false;
            validationtext = "Destination Invalid";
        }
        vip = vipCB.getValue();
        seat_no = seatTF.getText();
        if(isvalid){
             Ticket ticket=new Ticket(name,pn,email,gender,preG,vip,from,to,seat_no);

             ticket.generate_ticket_no();
             ticket.dates();
             uidTF.setText(ticket.getTicket_no());
             statusTF.setText(ticket.getStatus());
             expTF.setText(ticket.getExp_date());
             IssueDateTF.setText(ticket.getIssue_date());


        }
        else{
            outputTF.setText(validationtext+"Ticket creation unseccessful");
        }
    }
    @javafx.fxml.FXML
    public void infoClearOA(ActionEvent actionEvent) {
        uidTF.clear();
        customerTF.clear();
        PhoneNumberTF.clear();
        EmailTF.clear();
        seatTF.clear();
        statusTF.clear();
        IssueDateTF.clear();
        expTF.clear();
        GenderCB.setValue("--select--");
        pGenderCB.setValue("--select--");
        fromCB.setValue("--select--");
        toCB.setValue("--select--");
        vipCB.setValue("--select--");
        outputTF.setText("");

    }

}