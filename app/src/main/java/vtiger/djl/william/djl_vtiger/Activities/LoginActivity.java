package vtiger.djl.william.djl_vtiger.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vtiger.djl.william.djl_vtiger.API.API;
import vtiger.djl.william.djl_vtiger.API.APIServices.Services;
import vtiger.djl.william.djl_vtiger.Models.Users;
import vtiger.djl.william.djl_vtiger.R;
import vtiger.djl.william.djl_vtiger.Utils.Util;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private Button mbtnLogin;
    private EditText metUsuario;
    private EditText metPassword;
    private Bundle datos;

    private Services services;
    private Call<Users> usersCall;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUI();
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        services = API.getApi().create(Services.class);
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login();
                loginRetrofit();
            }
        });
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
                //saveOnPreferences();
                datos = new Bundle();
                datos.putInt("id",users.getId());
                datos.putString("nom",users.getFirst_name());
                datos.putString("ape", users.getLast_name());
                intent.putExtras(datos);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveOnPreferences() {
        if (TextUtils.isEmpty(Util.getSesionPrefs(prefs))) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("sesion", "1");
            editor.apply();
        }
    }

    /*private void mostrarProgress(){
        //agregamos el tiempo de la animacion a mostrar
        miprogress.setVisibility(View.VISIBLE);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        //iniciamos el progressbar
        anim.start();
    }*/

    /*private void login(){
        Log.d(TAG, "Login");
        //mostrarProgress();
        if (!validate()){
            //anim.cancel();
            return;
        }

        if (is_authenticated()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //saveOnPreferences();
            intent.putExtras(datos);
            startActivity(intent);
            //anim.cancel();
            //miprogress.setVisibility(View.INVISIBLE);
        }else{
            //anim.cancel();
            Toast.makeText(getApplicationContext(),"Usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
            //miprogress.setVisibility(View.INVISIBLE);
        }

    }*/

    /*private boolean is_authenticated(){
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Obtengo variables
        String usuario = metUsuario.getText().toString();
        String pass = metPassword.getText().toString();

        String ruta = Util.rutaWs_login+"?user="+usuario+"&pass="+pass;

        URL url = null;

        try {
            url = new URL(ruta);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));

            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            final ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
            if (jsonArray!= null){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                datos = new Bundle();
                datos.putString("id",jsonObject.getString("id"));
                datos.putString("nom",jsonObject.getString("first_name"));
                datos.putString("ape", jsonObject.getString("last_name"));
                return true;
            }else{
                return false;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    private void bindUI(){
        mbtnLogin = findViewById(R.id.btnLogin);
        metPassword = findViewById(R.id.etPassword);
        metUsuario = findViewById(R.id.etUsuario);
        //miprogress = findViewById(R.id.circularProgress);
        //anim = ObjectAnimator.ofInt(miprogress, "progress", 0, 100);
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
