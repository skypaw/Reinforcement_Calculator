package pl.pawz.zelbet.GUI;

import javafx.scene.control.TextField;

class Validator {

    //Take data from Text Fields, checking if data is correct (number) and pass data to Controller. If data is wrong -> set basic values

    double textToPositiveNumber(TextField textField, double basicValue) {
        String returnBasicValue = String.valueOf(basicValue);

        if (!returnBasicValue.substring(returnBasicValue.indexOf(".")).equals("0")) {
            returnBasicValue = String.valueOf((int) basicValue);  //Pass int data to GUI if decimal part equals 0
        }


        //Todo Add precision! And check statement above

        try {
            float value = Float.parseFloat(textField.getText().replaceAll(",", ".")); //Replacing comma, to dot

            if (value >= 0) {
                return value; // Value greater than 0 -> returning
            } else {
                AlertBox.display("Błąd", "Wartość powinna być liczbą dodatnią");
                textField.setText(returnBasicValue);
                return 0; // Value smaller than 0 -> returning 0
            }
        } catch (NumberFormatException e) {
            if (!textField.getText().isEmpty()) {
                textField.setText(returnBasicValue);
            }
            return 0; // Text Field is empty -> returning 0
        }

    }
}
