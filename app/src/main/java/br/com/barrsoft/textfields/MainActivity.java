package br.com.barrsoft.textfields;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.editTextPass)
    TextView textViewPassword;
    @BindView(R.id.editTextEmail)
    TextView textViewEmail;
    @BindView(R.id.button)
    Button buttonValidate;

    @BindView(R.id.textInputMail)
    TextInputLayout textInputLayoutMail;
    @BindView(R.id.textInputPassword)
    TextInputLayout textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.button)
    public void submit() {
        // TODO submit data to server...
        validateFields();
    }

    private void validateFields() {


        if (textViewEmail.getText().toString().isEmpty()){
            textInputLayoutMail.setErrorEnabled(true);
            textInputLayoutMail.setError("Digite seu e-mail");
        }else{
            textInputLayoutMail.setErrorEnabled(false);
        }
        if (textViewPassword.getText().toString().isEmpty()){
            textInputLayoutPassword.setErrorEnabled(true);
            textInputLayoutPassword.setError("Digite sua senha");
        }else{
            textInputLayoutPassword.setErrorEnabled(false);
        }
        if(!textViewPassword.getText().toString().isEmpty() && !textViewEmail.getText().toString().isEmpty()){
            String mail = textViewEmail.getText().toString();
            String password = textViewPassword.getText().toString();
            Toast.makeText(this,"Mail: " + mail + "\n Password: " + password,Toast.LENGTH_LONG).show();
        }
    }

}
