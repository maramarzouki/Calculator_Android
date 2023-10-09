package tn.m1pdam.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView opview;
    Double op1, op2, res;
    String operator = "";
    Button b_one, b_two, b_three, b_four, b_five, b_six, b_seven, b_eight, b_nine, b_zero, b_add, b_minus, b_multiply, b_divide, b_clear, b_point, b_equals, b_delete;
    Boolean rep=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_one = findViewById(R.id.one);
        b_two = findViewById(R.id.two);
        b_three = findViewById(R.id.three);
        b_four = findViewById(R.id.four);
        b_five = findViewById(R.id.five);
        b_six = findViewById(R.id.six);
        b_seven = findViewById(R.id.seven);
        b_eight = findViewById(R.id.eight);
        b_nine = findViewById(R.id.nine);
        b_zero = findViewById(R.id.zero);
        b_add = findViewById(R.id.plus);
        b_minus = findViewById(R.id.minus);
        b_multiply = findViewById(R.id.multiply);
        b_divide = findViewById(R.id.div);
        b_equals = findViewById(R.id.equals);
        b_point = findViewById(R.id.point);
        b_clear = findViewById(R.id.clear);
        b_delete = findViewById(R.id.deladigit);

        opview = findViewById(R.id.textView2);

        b_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("1");
            }
        });

        b_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("2");
            }
        });

        b_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("3");
            }
        });

        b_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("4");
            }
        });

        b_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("5");
            }
        });

        b_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("6");
            }
        });

        b_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("7");
            }
        });

        b_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("8");
            }
        });

        b_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("9");
            }
        });

        b_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis("0");
            }
        });

        b_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatNumberIsThis(".");
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatOperatorIsThis("+");
            }
        });

        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatOperatorIsThis("-");
            }
        });

        b_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatOperatorIsThis("*");
            }
        });

        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatOperatorIsThis("/");
            }
        });

        b_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Res = operatype();
                opview.setText(String.valueOf(Res));
            }
        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opview.setText("");
            }
        });

        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = opview.getText().toString();
                if (text.length() > 0) {
                    char removedChar = text.charAt(text.length() - 1);
                    if(removedChar == '+' || removedChar == '-' || removedChar == '*' || removedChar == '/'){
                        operator="";
                    }
                    String newText = text.substring(0, text.length() - 1);
                    opview.setText(newText);
                }
            }
        });
    }

    public void whatNumberIsThis (String s){
        opview.setText((opview.getText().toString())+s);
        if(rep && operator.equals("")){
            opview.setText("");
            opview.setText((opview.getText().toString())+s);
            rep=false;
        }
    }

    public void whatOperatorIsThis(String s) {
        if(operator.equals("")){
            opview.setText((opview.getText().toString())+s);
            operator = s;
        }else{
            double Res = operatype();
            operator = s;
            opview.setText(Res+s);
        }
    }

    public double operatype(){
        String text = opview.getText().toString();
        int find_op = text.indexOf(operator);
        String first = text.substring(0, find_op);
        op1 = Double.parseDouble(first);

        String second = text.substring(find_op + 1);
        op2 = Double.parseDouble(second);

        switch (operator) {
            case "+" : res = op1 + op2;break;
            case "-" : res = op1 - op2;break;
            case "*" : res = op1 * op2;break;
            case "/" : res = op1 / op2;break;
        }
        rep=true;
        operator="";
        return res;
    }
}