import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class Calculator extends JFrame{
    //declarations
    private JTextField firstNum, secondNum;
    private JLabel operator, equal, result;
    private static char operation = '\0';
    JButton[] b = new JButton[5];
    public Calculator(){
        super("Easy Calculator");

        //创建整体布局，2行5列
        setLayout(new GridLayout(2,5,8,8));
        //第一行初始化
        firstNum = new JTextField("",JTextField.CENTER);
        secondNum = new JTextField("",JTextField.CENTER);
        operator = new JLabel("",JLabel.CENTER);
        equal = new JLabel("=",JLabel.CENTER);
        result = new JLabel("",JLabel.CENTER);
        //设置操作数居中
        firstNum.setHorizontalAlignment(JTextField.CENTER);
        secondNum.setHorizontalAlignment(JTextField.CENTER);
        add(firstNum);
        add(operator);
        add(secondNum);
        add(equal);
        add(result);
        //第2行5个button
        b[0] = new JButton("+");
        b[1] = new JButton("-");
        b[2] = new JButton("*");
        b[3] = new JButton("/");
        b[4] = new JButton("OK");
        //点击加减乘除对应的button，第一行中的operator显示对应的符号
        for(int i = 0; i < 4; i++) {
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton temp = (JButton)e.getSource();
                    //text[0].setText(temp.getLabel());

                    operator.setText(temp.getLabel());
                }
            });
        }
        //点击OK输出结果
        b[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculate();
            }

        });
        add(b[0]);
        add(b[1]);
        add(b[2]);
        add(b[3]);
        add(b[4]);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //设置大小及位置
        setSize(500,200);
        setLocation(100,200);
        setVisible(true);


    }
    public void Calculate(){
        try{
            double num1 = Double.parseDouble(firstNum.getText());
            double num2 = Double.parseDouble(secondNum.getText());
            if (operator.getText().equals("*")) {
                result.setText(num1 * num2 +"");
            }
            else if (operator.getText().equals("/")) {
                result.setText(num1 / num2 +"");
            }
            else if (operator.getText().equals("+")) {
                result.setText(num1 + num2 +"");
            }
            else if (operator.getText().equals("-")) {
                result.setText(num1 - num2 + "");
            }
            else {
                result.setText("");
            }
        }
        catch(Exception err) {
            result.setText("wrong input!");
        }
    }
    //main函数
    public static void main(String[] args) {
        new Calculator();
        return;
    }
}