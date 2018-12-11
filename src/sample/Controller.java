package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    private long result = 0, current = 0;
    private boolean inputSecondNumber = false;
    private ArithmeticSymbols Symb = ArithmeticSymbols.EQUALS;

    @FXML
    private Label screen;

    @FXML
    public void initialize(){
        changeAndShowCurrent(0);
    }

    @FXML
    private void onClick0(){
        changeAndShowCurrent(0);
    }

    @FXML
    private void onClick1(){
        changeAndShowCurrent(1);
    }

    @FXML
    private void onClick2(){
        changeAndShowCurrent(2);
    }

    @FXML
    private void onClick3(){
        changeAndShowCurrent(3);
    }

    @FXML
    private void onClick4(){
        changeAndShowCurrent(4);
    }

    @FXML
    private void onClick5(){
        changeAndShowCurrent(5);
    }

    @FXML
    private void onClick6(){
        changeAndShowCurrent(6);
    }

    @FXML
    private void onClick7(){
        changeAndShowCurrent(7);
    }

    @FXML
    private void onClick8(){
        changeAndShowCurrent(8);
    }

    @FXML
    private void onClick9(){
        changeAndShowCurrent(9);
    }

    @FXML
    private void onClickC(){
        current = 0;
        showCurrent();
    }

    @FXML
    private void onClickNegative(){
        if(inputSecondNumber) current = 0;
        inputSecondNumber = false;
        current *= -1;
        showCurrent();
    }

    @FXML
    private void onClickSum(){
        onSetSymbol(ArithmeticSymbols.SUM);
    }

    @FXML
    private void onClickDeduct(){
        onSetSymbol(ArithmeticSymbols.DEDUCT);
    }

    @FXML
    private void onClickMultiply(){
        onSetSymbol(ArithmeticSymbols.MULTIPLY);
    }

    @FXML
    private void onClickDivide(){
        onSetSymbol(ArithmeticSymbols.DIVIDE);
    }

    @FXML
    private void onClickEquals(){
        onSetSymbol(ArithmeticSymbols.EQUALS);
    }

    private void changeAndShowCurrent(int num){
        if(inputSecondNumber) current = 0;
        inputSecondNumber = false;
        current = current * 10 + (current<0 ? -num : num);
        screen.setText(Long.toString(current));
    }

    private void showCurrent(){
        screen.setText(Long.toString(current));
    }

    private void onSetSymbol(ArithmeticSymbols newSymbol){
        if(!inputSecondNumber){
            switch (Symb){
                case SUM: result += current;
                    current = result;
                    break;
                case DEDUCT: result -= current;
                    current = result;
                    break;
                case MULTIPLY: result *= current;
                    current = result;
                    break;
                case DIVIDE:
                    if(current == 0){
                        showError();
                        return;
                    }
                    else {
                        result /= current;
                        current = result;
                    }
                    break;
                case EQUALS: result = current;
                    break;
            }
        }

        inputSecondNumber = true;
        Symb = newSymbol;
        showCurrent();
    }

    private void showError(){
        result = current = 0;
        screen.setText("ERROR");
        inputSecondNumber = true;
        Symb = ArithmeticSymbols.EQUALS;
    }
}

enum ArithmeticSymbols{
    EQUALS,
    SUM,
    DEDUCT,
    MULTIPLY,
    DIVIDE
}
