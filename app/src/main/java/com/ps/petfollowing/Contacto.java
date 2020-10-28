package com.ps.petfollowing;

//import android.se.omapi.Session;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.mail.Authenticator;
import java.util.Properties;

public class Contacto extends AppCompatActivity {

    EditText etnombre;
    EditText etemail;
    EditText etMensaje;
    AppCompatButton btnenviar;

    String sEmail, sPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etnombre =findViewById(R.id.etnombre);
        etemail =findViewById(R.id.etemail);
        etMensaje=findViewById(R.id.etmensaje);
        btnenviar= findViewById(R.id.emailbutton);

        sEmail= "psalazardeveloper@gmail.com";
        sPassword="Psalazar88";

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //propiedades
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");


                //iniciar Session
                Session session= Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });



                try {
                    //iniciar contexto de email
                    Message message= new MimeMessage(session);
                    //Enviar email
                    message.setFrom(new InternetAddress(sEmail));
                    //REcipiente email
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(etemail.getText().toString().trim()));

                    // asunto
                    message.setSubject("Mensaje a PetFollowing");

                    message.setText(etMensaje.getText().toString().trim());

                    new SendMail().execute(message);



                } catch (MessagingException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
              progressDialog =ProgressDialog.show(Contacto.this, "Espere por favor",
                      "Enviando mensaje", true,false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Enviado";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("Enviado")) {
                AlertDialog.Builder builder= new AlertDialog.Builder(Contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setTitle("Email envado con exito.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        etemail.setText("");
                        etMensaje.setText("");
                        etnombre.setText("");

                    }
                });
                builder.show();
            }else {
                Toast.makeText(getApplicationContext(),"Algo salio mal",Toast.LENGTH_SHORT).show();
        }
    }
    }
}