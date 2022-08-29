package br.com.edu.ads_project_whatsapp_message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    
    private TextInputLayout inputLayoutPhone;
    private TextInputEditText inputEditTextPhone;

    private TextInputLayout inputLayoutMessage;
    private TextInputEditText inputEditTextMessage;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutPhone = findViewById(R.id.text_layout_phone);
        inputEditTextPhone = findViewById(R.id.text_edit_phone);

        inputLayoutMessage = findViewById(R.id.text_layout_message);
        inputEditTextMessage = findViewById(R.id.text_edit_message);

        buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String phone = inputEditTextPhone.getText().toString();
        String message_text = inputEditTextMessage.getText().toString();

        String message = message_text.replace(" ", "%20");

        if(phone.isEmpty()) {
            inputLayoutPhone.setError("Favor inserir número do telefone");
            return;
        }

        if(message_text.isEmpty()) {
            inputLayoutMessage.setError("Favor inserir uma mensagem");
            return;
        }

        Uri webpage = Uri.parse("https://wa.me/"+phone+"/?text="+message+"");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}