package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main() { // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args) {
        Main myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showCanvasDemo(); // и вызываемый метод showCanvasDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Canvas");  // инициализация фрэйма
        mainFrame.setSize(400, 500); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent) { // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(250, 50);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в Canvas
    private void showCanvasDemo(){
        headerLabel.setText("Контрол в действии: Canvas");

        // добавление объектов на форму
        controlPanel.add(new MyCanvas());
        mainFrame.setVisible(true); // видимость формы true
    }

    class MyCanvas extends Canvas { // наш класс наследуемый (параметры) холста

        public MyCanvas () { // конструктор холста
            setBackground (Color.GRAY); // цвет
            setSize(300, 400); // размеры
        }

        public void paint (Graphics gc) {
            Graphics2D g2; // точка
            g2 = (Graphics2D) gc;
            g2.drawString ("Текст на холсте", 70, 40); // наш текст
            gc.setColor(Color.GREEN); // заливка
            gc.fillOval(10,60,30,30); // заливка овала
            gc.drawOval(60,60,30,30); // границы овала
            gc.fillRoundRect(110,60,30,30,10,10); // заливка квадрата
            gc.drawRoundRect(160,60,30,30,10,10); // границы квадрата
            gc.fillArc(10, 110, 30, 30, 45, 240);// залитая открытая заливка,  круг
            gc.drawArc(60, 110, 30, 30, 45, 240);// граница открытая заливка,  круг
            g2.drawString ("и т.п.", 110, 130); // наш текст
        }
    }
}