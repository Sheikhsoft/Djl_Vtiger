package vtiger.djl.william.djl_vtiger.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vtiger.djl.william.djl_vtiger.API.API;
import vtiger.djl.william.djl_vtiger.API.APIServices.Services;
import vtiger.djl.william.djl_vtiger.Activities.Base.BaseActivity;
import vtiger.djl.william.djl_vtiger.Models.Users;
import vtiger.djl.william.djl_vtiger.R;
import vtiger.djl.william.djl_vtiger.Utils.Util;

public class LoginActivity extends BaseActivity {
    private Button mbtnLogin;
    private EditText metUsuario;
    private EditText metPassword;
    private CheckBox mcbRecordar;
    private Bundle datos;
    private ProgressBar mpbLogin;

    private Services services;
    private Call<Users> usersCall;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUI();
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        //setCredentialIfExist();
        services = API.getApi().create(Services.class);
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login();
                mpbLogin.setVisibility(View.VISIBLE);
                loginRetrofit();
            }
        });
    }

    private void setCredentialIfExist(){
        String recordar = Util.getChechBoxPrefs(prefs);
        String usuario = Util.getUserPrefs(prefs);
        String password = Util.getPassPrefs(prefs);

        if (recordar == "1"){
            mcbRecordar.setChecked(true);
        }

        if (!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(password)) {
            metUsuario.setText(usuario);
            metPassword.setText(password);
            mcbRecordar.setChecked(true);
        }
    }

    private void loginRetrofit(){
        if (!validate()){
            return;
        }
        String user = metUsuario.getText().toString();
        String pass = metPassword.getText().toString();

        usersCall = services.getLogin(user,pass);
        usersCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users users = response.body();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //saveOnPreferences(String.valueOf(users.getId()),user,pass,"1",users.getFirst_name() + " " + users.getLast_name());
                datos = new Bundle();
                //datos.putString("id",String.valueOf(users.getId()));
                datos.putString("nom",users.getFirst_name());
                datos.putString("ape", users.getLast_name());
                intent.putExtras(datos);
                mpbLogin.setVisibility(View.INVISIBLE);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                mpbLogin.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveOnPreferences(String id, String usuario, String password, String session, String nombre) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("sesion", session);

        if (mcbRecordar.isChecked()){
            editor.putString("id", id);
            editor.putString("user",usuario);
            editor.putString("pass", password);
            editor.putString("remember", "1");
            editor.putString("name",nombre);
        }else{
            editor.putString("remember", "0");
        }

    }

    private void bindUI(){
        mbtnLogin = findViewById(R.id.btnLogin);
        metPassword = findViewById(R.id.etPassword);
        metUsuario = findViewById(R.id.etUsuario);
        mcbRecordar = findViewById(R.id.cbRecordar);
        mpbLogin = findViewById(R.id.pbLogin);
    }

    //Valido las credenciales del usuario
    private boolean validate(){
        boolean isValid = true;
        String usuario = metUsuario.getText().toString();
        String pass = metPassword.getText().toString();
        //Valido usuario
        if(usuario.isEmpty() || usuario.length()<3){
            Toast.makeText(this,"Ingrese un usuario valido", Toast.LENGTH_SHORT).show();
            isValid = false;
        }else if (pass.isEmpty() || pass.length()<4 || pass.length()>16){
            Toast.makeText(this,"El password debe tener entre 4 y 15 caracteres", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }
}
