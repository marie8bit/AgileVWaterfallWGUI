package com.MarieErickson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yd7581ku on 10/25/2016.
 */
public class AVWSurvey extends JFrame
{
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
        btnRecommendation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p = getPositiveIntInput(txtProgrammers.getText());
                if (p<=30&& !cbxIntergration.isSelected() && !cbxModel.isSelected()&&
                        !cbxFixed.isSelected()&& cbxExperience.isSelected()&&cbxQuality.isSelected())
                {

                    lblResult.setText(txtName.getText()+" should use Agile methodology");
                }
                else if (p>=30&& cbxIntergration.isSelected() && cbxModel.isSelected()&&
                        cbxFixed.isSelected() &&!cbxExperience.isSelected() && !cbxQuality.isSelected())
                {

                    lblResult.setText(txtName.getText()+" should use Waterfall methodology");

                }
                else
                {

                    lblResult.setText(txtName.getText()+ " should use Waterfall with Iteration");


                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int getPositiveIntInput(String s) {
        while (true) {
            try {

                int intInput = Integer.parseInt(s);
                if (intInput >= 0) {
                    return intInput;
                } else {
                    System.out.println("Please enter a positive numeric value");
                    txtProgrammers.requestFocus();

                    continue;
                }
            } catch (NumberFormatException ime) {
                System.out.println("Please enter a valid Ticket ID#");
            }

        }

    }

}
