package com.MarieErickson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yd7581ku on 10/25/2016.
 */
public class AVWSurvey extends JFrame {
    private JPanel rootPanel;
    private JTextField txtProgrammers;
    private JCheckBox cbxFixed;
    private JCheckBox cbxExperience;
    private JCheckBox cbxQuality;
    private JCheckBox cbxIntergration;
    private JCheckBox cbxModel;
    private JLabel lblResult;
    private JButton btnRecommendation;
    private JTextField txtName;


    AVWSurvey() {
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        //
        btnRecommendation.addActionListener(new ActionListener() {
            @Override
            //recommend button click event handler
            public void actionPerformed(ActionEvent e) {
                int p;
                //try catch block to validate user integer input
                try {
                    p = Integer.parseInt(txtProgrammers.getText());
                    if (p >= 0) {
                    } else {
                        //display dialog box to get valid data from user
                        JOptionPane.showMessageDialog(AVWSurvey.this,
                                "Please enter a positive numeric value");
                        //remove bad data from textfield
                        txtProgrammers.setText("");
                        //put cursor in textfield for user friendly design
                        txtProgrammers.requestFocus();
                        return;
                    }
                    //catch invalid data type
                } catch (NumberFormatException ime) {
                    JOptionPane.showMessageDialog(AVWSurvey.this,
                            "Please enter a numeric value");
                    txtProgrammers.setText("");
                    txtProgrammers.requestFocus();
                    return;
                }
                //if statements to identify recommendations given user input
                if (p <= 30 && !cbxIntergration.isSelected() && !cbxModel.isSelected() &&
                        !cbxFixed.isSelected() && cbxExperience.isSelected() && cbxQuality.isSelected()) {
                    //display recommendation in result label
                    lblResult.setText(txtName.getText() + " should use Agile methodology");
                } else if (p >= 30 && cbxIntergration.isSelected() && cbxModel.isSelected() &&
                        cbxFixed.isSelected() && !cbxExperience.isSelected() && !cbxQuality.isSelected()) {

                    lblResult.setText(txtName.getText() + " should use Waterfall methodology");

                } else {

                    lblResult.setText(txtName.getText() + " should use Waterfall with Iteration");

                }
            }

        });
        // set behavior for when the close buttong is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
