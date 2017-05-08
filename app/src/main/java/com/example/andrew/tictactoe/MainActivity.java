package com.example.andrew.tictactoe;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.knetikcloud.api.AccessTokenApi;
import com.knetikcloud.api.UtilSecurityApi;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.model.OAuth2Resource;
import com.knetikcloud.model.TokenDetailsResource;

public class MainActivity extends AppCompatActivity {
    String adminToken;
    int userId;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates a token with admin privileges on startup
        new Thread(new Runnable() {
            @Override
            public void run() {
                AccessTokenApi apiInstance = new AccessTokenApi();
                apiInstance.setBasePath(getString(R.string.baseurl));
                try {
                    OAuth2Resource result = apiInstance.getOAuthToken(getString(R.string.grant_type), getString(R.string.client_id),
                            null, getString(R.string.username), getString(R.string.password));
                    adminToken = result.getAccessToken();
                    System.out.println("Admin token: " + adminToken);
                }
                catch (Exception e) {
                    System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //Called when "Sign in" button is clicked
    public void userLogin(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();

        //Attempts to retrieve token with username + password entered by user to confirm login
        new Thread(new Runnable() {
            @Override
            public void run() {
                AccessTokenApi apiInstance = new AccessTokenApi();
                apiInstance.setBasePath(getString(R.string.baseurl));
                try {
                    final OAuth2Resource result = apiInstance.getOAuthToken(getString(R.string.grant_type), getString(R.string.client_id),
                            null, username, password);
                    System.out.println("User token: " + result.getAccessToken());
                    getUserId(result.getAccessToken());

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginSuccess();
                        }
                    });
                }
                catch (Exception e) {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginError();
                        }
                    });
                    System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //Attempts to retrieve userId using the user's token
    public void getUserId(String userToken) {
        UtilSecurityApi apiInstance2 = new UtilSecurityApi();
        apiInstance2.setBasePath(getString(R.string.baseurl));
        apiInstance2.addHeader("Authorization", "bearer " + userToken);
        try {
            TokenDetailsResource result2 = apiInstance2.getUserTokenDetails();
            userId = result2.getUserId();
            System.out.println("UserId: " + userId);
        }
        catch (Exception e) {
            System.err.println("Exception when calling UtilSecurityApi#getUserTokenDetails");
            e.printStackTrace();
        }
    }

    public void loginSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void loginError() {
        Bundle bundle = new Bundle();
        bundle.putString("error", "login");
        ErrorDialog dialog = new ErrorDialog();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
    //Called when "Register" button is clicked
    public void openUserRegistration(View view) {
        Intent intent = new Intent(this, UserRegistration.class);
        intent.putExtra("adminToken", adminToken);
        startActivity(intent);
    }
}