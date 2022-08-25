package com.zxclown.learning.ui;

import javax.swing.*;

/**
 * HelloWorldUI
 *
 * @author za-zhangxin002
 * @date 2020/11/26
 */
public class HelloWorldDialog extends JDialog{
    private JPanel panel;
    private JTextField className;

    public HelloWorldDialog() {
        setContentPane(panel);
        setModal(true);
    }
}
