package sample;
//файл Controller.java - пишем действия, которые выполняем

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.*;

public class Controller {
    public TextArea mainTextArea;

    //метод для строки меню "Выйти из программы"
    public void clickOnExit(ActionEvent actionEvent) {
        System.exit(0);//закрыть приложение
    }

    //метод для строки меню "Новый документ"
    public void onClickFileNew(ActionEvent actionEvent) {
        mainTextArea.setText("");//очищаем текстовую область
    }

    //метод для строки меню "Открыть документ"
    public void onClickOpenFile(ActionEvent actionEvent) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            String s;//в строку s будем записывать считываемые из файла 1.txt данные
            mainTextArea.clear();
            //в цикле записывваем в s каждую текстовую строку, пока файл не закончится
            while((s = br.readLine()) != null){
                mainTextArea.appendText(s + "\n");//добавляем считанную строку из файла в текстовую область mainTextArea
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод для строки меню "Сохранить"
    public void onClickSaveFile(ActionEvent actionEvent) {
        //здесь try "с ресурсами"
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("2.txt"))) {
            bw.write(mainTextArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
