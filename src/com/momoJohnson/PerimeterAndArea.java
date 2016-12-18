package com.momoJohnson;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.text.DecimalFormat;

/**
 * Created by Momo Johnson on 9/19/2016.
 */
public class PerimeterAndArea extends JFrame{
    private JTextField txtWidthInput;
    private JTextField txtAreaCalculated;
    private JTextField txtLengthInput;
    private JTextField txtPerimeterCalcualted;
    private JButton btnClear;
    private JButton btnExit;
    private JButton calculateButton;
    private JPanel rootPane;

    public  PerimeterAndArea(){
        super("Area and Perimeter");
        setContentPane(rootPane);
        setPreferredSize( new Dimension(380, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        rootPane.getRootPane().setDefaultButton(calculateButton);
        pack();
        setVisible(true);


        //An Listener that clears the text from the perimeter and area calculated box when the width is change
        txtWidthInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }
            //setting the area calculated area of an empty string
            @Override
            public void removeUpdate(DocumentEvent e) {
                txtAreaCalculated.setText("");
                txtPerimeterCalcualted.setText("");

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        // A listener that erase the string in the perimeter and area calcualted JtextField
        txtLengthInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                txtAreaCalculated.setText("");

            }
            //Setting of the variable in the various perimeter and area calculate JtextField

            @Override
            public void removeUpdate(DocumentEvent e) {
                txtPerimeterCalcualted.setText("");
                txtAreaCalculated.setText("");


            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        //A button that calculation the area and perimeter
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //A method that checks the for valid data being enter by the user
                if(isValidData()){
                    //Formating the numbers in three digit format
                    DecimalFormat df = new DecimalFormat("#,###");
                    //Converting the input of the length  to a double
                    double length = Double.parseDouble(txtLengthInput.getText());
                    //Coverting the input of the width to a double
                    double width = Double.parseDouble(txtWidthInput.getText());
                    //Calculation of the area
                    txtAreaCalculated.setText(df.format(length*width));
                    //Calculation of the perimeter
                    txtPerimeterCalcualted.setText(df.format((2*length)+(2*width)));
                }
            }
        });
        // An action that clears the clear text input from the textbox
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaCalculated.setText("");
                txtLengthInput.setText("");
                txtWidthInput.setText("");
                txtPerimeterCalcualted.setText("");

            }
        });
        //An action listener that exits the form when clicked by the user
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Are sure you want to exit?", "Confirm",dialogButton);
                if(result == JOptionPane.YES_OPTION){
                   System.exit(0);

                }
            }
        });


    }
    //A method that checks to see if the textbox is empty. If it is empty, prompt the user to enter a valid number
    private boolean isPresent(JTextField textField, String name){
        if(textField.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, name + " is a required field ", "Input Error", JOptionPane.ERROR_MESSAGE);
            textField.requestFocus();
            textField.setText("");
            return false;
        }
        return true;
    }
    //A method that checks to make sure the user enter an integer that is greater than zero
private boolean isValidInput(JTextField textField, String name){
    if(Double.parseDouble(textField.getText())>0){
        return true;
    }else {
        JOptionPane.showMessageDialog(rootPane, name + " must be greater than zero");
        textField.requestFocus();
        textField.setText("");
        return false;
    }
}
//A method that validates the inputs entered by the user to make sure the user enters valid input

private boolean isValidData(){
    if(!isPresent(txtLengthInput, "Length"))
    {
        return false;
    }
    else if(!isValidInput(txtLengthInput, "Length"))
    {
        return false;
    }
    else if(!isPresent(txtWidthInput, "Width"))
    {
        return false;
    }

    else  if(!isValidInput(txtWidthInput, "Width"))
    {
        return false;
    }

   return true;
    }



}
